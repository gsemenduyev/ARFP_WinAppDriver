const fs = require('fs');

// Step 1: Read the source JSON file
const sourceFileName = 'C:\\CypressAutomation\\EDP_CypressAutomation_Old\\E2E\\ARFP-Stratasphere\\cypress\\reports\\cucumber-reports\\results.json';
const sourceData = JSON.parse(fs.readFileSync(sourceFileName, 'utf-8'));

// Step 2: Read the destination JSON file (if it exists)
const destinationFileName = 'C:\\CypressAutomation\\EDP_CypressAutomation_Old\\E2E/ARFP-Stratasphere\\cypress\\reports\\sbms-arfp-stratasphere-report\\sbms-arfp-stratasphere-report.json';
let destinationData = [];

if (fs.existsSync(destinationFileName)) {
  destinationData = JSON.parse(fs.readFileSync(destinationFileName, 'utf-8'));
}

// Step 3: Append data from the source to the destination
destinationData = destinationData.concat(sourceData);

// Step 4: Write the updated data back to the destination JSON file
fs.writeFileSync(destinationFileName, JSON.stringify(destinationData, null, 2));

console.log('Data copied and appended successfully.');
