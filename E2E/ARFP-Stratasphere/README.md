NODE.js
JAVA >= 8 

cd E2E/ARFP-Stratasphere

npm install
npm update

npx cypress open --env tags="@WIP",VERSION="v 8.4.0"
npm test
npm run test-Stratasphere
npm run test-ARFP
npm run test-WIP

allure open 'cypress/reports/allure-report'

node ./cucumber-html-report.js

node ./cypress.config.js
node ./copyAndAppend.js

node sbms-arfp-stratasphere-report.json
node ./sbms-stratasphere-html-report.js

npx cypress open  --env ENV="QA",VERSION="v 8.4.1.39508"

npx cypress run --browser chrome --headed --env tags="@WIP",ENV="QA",VERSION="v 8.4.0"

echo [] > C:\CypressAutomation\EDP_CypressAutomation_Old\E2E\ARFP-Stratasphere\cypress\reports\test-command.json
del C:\CypressAutomation\EDP_CypressAutomation_Old\E2E\ARFP-Stratasphere\cypress\reports\test-command.json



run_projects.bat