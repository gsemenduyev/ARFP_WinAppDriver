
package com.onesuite.test_rail;

import com.onesuite.utilities.ConfigurationsReader;

public class TestRailAccount {

    public static APIClient testRailApiClient() {

        String baseUrl = ConfigurationsReader.getProperty("baseUrl");
        String usernameTestRail = System.getenv("username");
        String passwordTestRail = System.getenv("password");

        APIClient client = new APIClient(baseUrl);
        client.setUser(usernameTestRail);
        client.setPassword(passwordTestRail);

        return client;
    }

}
