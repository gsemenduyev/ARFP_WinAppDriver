mvn clean install -DskipTests
mvn install
mvn test
@wip
mvn test -Dcucumber.options="--tags @wip"

mvn test -Dcucumber.filter.tags="@ValidCredentials"
mvn clean install

mvn clean install
mvn clean test -Dcucumber.feature="resources/features" -Dcucumber.filter.tags="@wip"
mvn test -Dcucumber.filter.tags="@wip"

mvn clean test -Dcucumber.filter.tags="@wip"

mvn clean test -Dcucumber.options="--tags @@wip"


mvn test -Dtest=runners\CukesRunner.java

E2E\JavaWinApp\src\test\java\com\onesuite\runners\CukesRunner.java

C:\CypressAutomation\EDP_CypressAutomation_Old\E2E
mvn clean test -Dtest=runners\CukesRunner.java