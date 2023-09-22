@echo off
echo Running Maven Project
cd C:\CypressAutomation\EDP_CypressAutomation_Old\E2E\JavaWinApp
mvn clean test -Dtest=runners\CukesRunner.java
cd ..
