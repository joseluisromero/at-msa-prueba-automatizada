package com.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/java/com/bdd/features",
        glue = {"com/bdd/steps"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@Test",
        publish = true
)
public class TestRunner {
    @AfterClass
    public static void closeBrowser() {
        //BasePage.closeBrowser();
    }
}
