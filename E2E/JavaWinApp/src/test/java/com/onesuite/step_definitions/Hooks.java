package com.onesuite.step_definitions;

import com.onesuite.test_rail.APIException;
import io.cucumber.java.Before;
import io.cucumber.plugin.event.Result;
import org.apache.commons.lang3.reflect.FieldUtils;
import io.cucumber.java.After;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.onesuite.test_rail.APIClient;
import com.onesuite.utilities.ChatGPTWinDriver;
import com.onesuite.utilities.ConfigurationsReader;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import static com.onesuite.test_rail.TestRailAccount.testRailApiClient;
import static com.onesuite.utilities.ChatGPTWinDriver.closeChatGPTWinDriver;
import static com.onesuite.utilities.ChatGPTWinDriver.stop;

public class Hooks {

    private static APIClient client = null;
    private static String runId = ConfigurationsReader.getProperty("runIdTestRail");
    private static final int FAIL_STATE = 5;
    private static final int SUCCESS_STATE = 1;
    private static final String SUCCESS_COMMENT = "This test passed with Selenium";
    private static final String FAILED_COMMENT = "This test failed with Selenium";

    // @Rule
    // public TestName testName = new TestName();
    //
    // public static WebDriver driver;
    //
    // @After
    // public void afterScenario() {
    // // Your code to be executed after all scenarios
    //
    // // public static void main(String[] args) {
    // ObjectMapper objectMapper = new ObjectMapper();
    // try {
    // // Step 1: Read data from the source JSON file
    // File sourceJsonFile = new File(
    // "C:\\CypressAutomation\\EDP_CypressAutomation_Old\\E2E\\JavaWinApp\\target\\cucumber.json");
    // JsonNode sourceData = objectMapper.readTree(sourceJsonFile);
    //
    // // Step 2: Read data from the destination JSON file (if it exists)
    // File destinationJsonFile = new File(
    // "C:\\CypressAutomation\\EDP_CypressAutomation_Old\\E2E\\SBMS\\destination.json");
    // JsonNode destinationData = objectMapper.createObjectNode();
    //
    // if (destinationJsonFile.exists()) {
    // destinationData = objectMapper.readTree(destinationJsonFile);
    // }
    //
    // // Step 3: Append data from the source to the destination
    // if (destinationData.isArray() && sourceData.isArray()) {
    // for (JsonNode item : sourceData) {
    // ((ArrayNode) destinationData).add(item);
    // }
    // } else {
    // // Handle other cases as needed
    // }
    //
    // // Step 4: Write the updated data back to the destination JSON file
    // ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
    // writer.writeValue(destinationJsonFile, destinationData);
    //
    // System.out.println("Data copied and appended successfully.");
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    // Add your code here

    // @AfterAll
    // public static void sendReport(){
    // ObjectMapper objectMapper = new ObjectMapper();
    // try {
    // // Step 1: Read data from the source JSON file
    // File sourceJsonFile = new File("target/cucumber.json");
    // JsonNode sourceData = objectMapper.readTree(sourceJsonFile);

    // // Step 2: Read data from the destination JSON file (if it exists)
    // File destinationJsonFile = new File(
    // "C:\\CypressAutomation\\EDP_CypressAutomation_Old\\E2E\\SBMS\\destination.json");
    // JsonNode destinationData = objectMapper.createObjectNode();

    // if (destinationJsonFile.exists()) {
    // destinationData = objectMapper.readTree(destinationJsonFile);
    // }

    // // Step 3: Append data from the source to the destination
    // if (destinationData.isArray() && sourceData.isArray()) {
    // for (JsonNode item : sourceData) {
    // ((ArrayNode) destinationData).add(item);
    // }
    // } else {
    // // Handle other cases as needed
    // }

    // // Step 4: Write the updated data back to the destination JSON file
    // ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
    // writer.writeValue(destinationJsonFile, destinationData);

    // System.out.println("Data copied and appended successfully.");
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    // @Before(order = 1)
    // public void launchRelQa(){
    // launchSteelCloud(3); envBVT
    // }
    //
    // @Before("@RelQa")
    // public void relQaHook() {
    // launchSteelCloud(3);
    // }
    //
    // @Before("@BVT")
    // public void envBVT() { launchBVT(10);}
    //
    // @Before("@RealPm")
    // public void realPm() {
    //
    // String url = ConfigurationsReader.getProperty("realPm");
    // String temUrl = url.replaceFirst(" ", System.getenv("username"));
    // String finalUrl = temUrl.replace(" ", System.getenv("password"));
    //
    // Driver.getDriver().get(finalUrl);
    // }
    //
    // @After()
    // public void tearDownScenario(Scenario scenario) {
    // System.out.println("Takes Screenshot");
    //
    //// if (!scenario.isFailed()) {
    // byte[] screenshot = ((TakesScreenshot)
    // WinDriver.getWinDriver()).getScreenshotAs(OutputType.BYTES);
    // scenario.attach(screenshot, "image/png", scenario.getName());
    //// }
    //// Driver.closeDriver();
    //// logResultToTestRail(scenario);
    // }

    // @AfterStep()
    //
    // public void takeScreenshots(Scenario scenario) throws InterruptedException {
    // if (!scenario.isFailed()) {
    // Thread.sleep(200);
    // byte[] screenshot = ((TakesScreenshot)
    // Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    // scenario.attach(screenshot, "image/png", scenario.getName());
    // }
    // }

    private void logResultToTestRail(Scenario scenario) {
        String caseId = "";
        System.out.println(scenario.getSourceTagNames());

        for (String s : scenario.getSourceTagNames()) {
            if (s.contains("TestRail")) {

                String[] res = s.split("(\\(.*?)");

                caseId = res[1].substring(0, res[1].length() - 1); // Removing the last parenthesis
            }
        }

        Map<String, Serializable> data = new HashMap<>();

        if (!scenario.isFailed()) {
            data.put("status_id", SUCCESS_STATE);
            data.put("comment", SUCCESS_COMMENT);

        } else {
            data.put("status_id", FAIL_STATE);
            data.put("comment", logError(scenario));
        }

        if (!caseId.equals("")) {
            try {

                if (System.getenv("runIdTestRail") != null && System.getenv("runTestRailId").equals("")) {
                    runId = System.getenv("runIdTestRail");
                }

                client = testRailApiClient();
                client.sendPost("add_result_for_case/" + runId + "/" + caseId, data);
            } catch (IOException | APIException e) {
                e.printStackTrace();
            }
        }
    }

    private static String logError(Scenario scenario) {
        try {
            Field fieldScenario = FieldUtils.getField(Scenario.class, "delegate", true);
            if (fieldScenario != null) {
                fieldScenario.setAccessible(true);
                Object objectScenario = fieldScenario.get(scenario);

                Field fieldStepResults = objectScenario.getClass().getDeclaredField("stepResults");
                fieldStepResults.setAccessible(true);

                ArrayList<Result> results = (ArrayList<Result>) fieldStepResults.get(objectScenario);
                for (Result result : results) {
                    if (result.getError() != null) {
                        return FAILED_COMMENT + "\n" + result.getError().getLocalizedMessage();
                    }
                }
            }

            return FAILED_COMMENT;

        } catch (IllegalAccessException | NoSuchFieldException e) {
            return FAILED_COMMENT;
        }
    }

    private Scenario scenario;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void tearDown() {
        System.out.println("Takes Screenshot");
        byte[] screenshot = ((TakesScreenshot) ChatGPTWinDriver.chatGPTWinDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
//        closeChatGPTWinDriver();
//        stop();
    }
}
