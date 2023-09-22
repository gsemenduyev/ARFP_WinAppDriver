package com.onesuite.utilities;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class TransferReport {
    public static void main(String[] args) {

        // Your code to be executed after all scenarios

        // public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Step 1: Read data from the source JSON file
            File sourceJsonFile = new File(
                    "C:\\CypressAutomation\\EDP_CypressAutomation_Old\\E2E\\JavaWinApp\\target\\cucumber.json");
            JsonNode sourceData = objectMapper.readTree(sourceJsonFile);

            // Step 2: Read data from the destination JSON file (if it exists)
            File destinationJsonFile = new File(
                    "C:\\CypressAutomation\\EDP_CypressAutomation_Old\\E2E\\SBMS\\destination.json");
            JsonNode destinationData = objectMapper.createObjectNode();

            if (destinationJsonFile.exists()) {
                destinationData = objectMapper.readTree(destinationJsonFile);
            }

            // Step 3: Append data from the source to the destination
            if (destinationData.isArray() && sourceData.isArray()) {
                for (JsonNode item : sourceData) {
                    ((ArrayNode) destinationData).add(item);
                }
            } else {
                // Handle other cases as needed
            }

            // Step 4: Write the updated data back to the destination JSON file
            ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
            writer.writeValue(destinationJsonFile, destinationData);

            System.out.println("Data copied and appended successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}