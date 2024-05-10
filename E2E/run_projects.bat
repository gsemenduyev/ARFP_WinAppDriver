@echo off
mkdir C:\CypressAutomation\EDP_CypressAutomation_Old\E2E\ARFP-Stratasphere\cypress\reports\sbms-arfp-stratasphere-report
echo [] > C:\CypressAutomation\EDP_CypressAutomation_Old\E2E\ARFP-Stratasphere\cypress\reports\sbms-arfp-stratasphere-report\sbms-arfp-stratasphere-report.json
echo Running the Maven project
cd C:\CypressAutomation\EDP_CypressAutomation_Old\E2E\JavaWinApp
call mvn clean test -Dcucumber.options="--tags @wip"
echo Maven project completed
cd ..
echo Running the Cypress project
cd C:\CypressAutomation\EDP_CypressAutomation_Old\E2E\ARFP-Stratasphere
call npx cypress run --browser chrome --headed --env tags="@WIP",ENV="Production"
echo Cypress project completed
cd ..
echo Running the Maven project
cd C:\CypressAutomation\EDP_CypressAutomation_Old\E2E\JavaWinApp
call mvn clean test -Dcucumber.options="--tags @wip1"
echo Maven project completed
cd ..
echo Running the Cypress project
cd C:\CypressAutomation\EDP_CypressAutomation_Old\E2E\ARFP-Stratasphere
call npx cypress run --browser chrome --headed --env tags="@WIP1",ENV="Production"
echo Cypress project completed
call node ./sbms-stratasphere-html-report.js
cd ..

