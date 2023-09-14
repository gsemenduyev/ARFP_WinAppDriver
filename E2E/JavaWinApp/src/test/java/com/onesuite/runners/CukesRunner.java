package com.onesuite.runners;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

//import org.springframework.context.annotation.Configuration;
//import javax.security.auth.login.Configuration;
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
                "pretty",
                // "html:target/cucumber-report.html",
                "json:target/cucumber.json",
// "rerun:target/rerun.txt"
}, features = "src/test/resources/features", glue = "com/onesuite/step_definitions", dryRun = false, tags = "@wip", monochrome = true)

public class CukesRunner {
        @AfterClass
        public static void generateReport() {

                File reportOutputDirectory = new File("target");

                List<String> jsonFiles = new ArrayList<>();
                jsonFiles.add("target/cucumber.json"); // Path to the JSON report file

                // Configure the report
                Configuration configuration = new Configuration(reportOutputDirectory, "JavaWinApp");
                configuration.setBuildNumber("3.0");

                // Generate the report
                ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
                reportBuilder.generateReports();
        }

//        public static void main(String[] args) {
//                ObjectMapper objectMapper = new ObjectMapper();
//                try {
//                        // Step 1: Read data from the source JSON file
//                        File sourceJsonFile = new File("E2E\\JavaWinApp\\target\\cucumber.json");
//                        JsonNode sourceData = objectMapper.readTree(sourceJsonFile);
//
//                        // Step 2: Read data from the destination JSON file (if it exists)
//                        File destinationJsonFile = new File(
//                                        "C:\\CypressAutomation\\EDP_CypressAutomation\\E2E\\SBMS\\destination.json");
//                        JsonNode destinationData = objectMapper.createObjectNode();
//
//                        if (destinationJsonFile.exists()) {
//                                destinationData = objectMapper.readTree(destinationJsonFile);
//                        }
//
//                        // Step 3: Append data from the source to the destination
//                        if (destinationData.isArray() && sourceData.isArray()) {
//                                for (JsonNode item : sourceData) {
//                                        ((ArrayNode) destinationData).add(item);
//                                }
//                        } else {
//                                // Handle other cases as needed
//                        }
//
//                        // Step 4: Write the updated data back to the destination JSON file
//                        ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
//                        writer.writeValue(destinationJsonFile, destinationData);
//
//                        System.out.println("Data copied and appended successfully.");
//                } catch (IOException e) {
//                        e.printStackTrace();
//                }
//        }
}
