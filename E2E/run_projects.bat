@echo off
echo Running the Maven project
cd C:\CypressAutomation\EDP_CypressAutomation_Old\E2E\JavaWinApp
call mvn clean test -Dtest=runners\CukesRunner.java
echo Maven project completed
cd ..
echo Running the Cypress project
cd C:\CypressAutomation\EDP_CypressAutomation_Old\E2E\ARFP-Stratasphere
call npx cypress run --browser chrome --headed --spec cypress/integration/step-definitions/agency-version-number/agency-version-number.feature,ENV="QA"
echo Cypress project completed
cd ..
