var reporter = require('cucumber-html-reporter');

var options = {
    theme: 'bootstrap',
    jsonFile: 'cypress/reports/sbms-arfp-stratasphere-report/sbms-arfp-stratasphere-report.json',
    output: 'cypress/reports/sbms-arfp-stratasphere-report/sbms-arfp-stratasphere-report.html',
    reportSuiteAsScenarios: true,
    scenarioTimestamp: true,
    launchReport: true,
    metadata: {
        "App Version": "0.3.2",
        "Test Environment": "STAGING",
        "Browser": "Chrome  54.0.2840.98",
        "Platform": "Windows 10",
        "Parallel": "Scenarios",
        "Executed": "Remote",
        "Hello": "me"
    },
    failedSummaryReport: true,
};

reporter.generate(options);