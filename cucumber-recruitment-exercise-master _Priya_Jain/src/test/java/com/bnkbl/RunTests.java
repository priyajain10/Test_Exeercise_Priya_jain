package com.bnkbl;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.bnkbl.stepdefs"},
        features = {"classpath:features"}
)
public class RunTests {
}
