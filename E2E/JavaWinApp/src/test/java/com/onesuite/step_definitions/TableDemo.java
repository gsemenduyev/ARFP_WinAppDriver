package com.onesuite.step_definitions;

import io.cucumber.java.en.Given;

import java.util.List;

public class TableDemo {
    @Given("User enter {string}")
    public void user_enter(String string) {
        System.out.println("User enter <email>" + string);

    }
    @Given("User set {string}")
    public void user_set(String string) {
        System.out.println("User set <password>" + string);

    }
    @Given("User enter {string} and {string}")
    public void user_enter_and(String string, String string2) {
        System.out.println("* User enter <email> and <password>" + string + string2);

    }

    @Given("User enter tex in the search bar")
    public void user_enter_tex_in_the_search_bar(List<String> list) {
        list.forEach(System.out::println);

    }

}
