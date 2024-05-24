package com.WebElements.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "C:\\Users\\lenovo\\git\\repository\\ProjectWebElements\\src\\test\\java\\com\\WebElements\\features\\WebElements.feature",
glue={"com.WebElements.stepDefinitions"},
monochrome=true,
plugin={"html:target/Cucumber-reports.html"}

//tags = "@FullRegression"
)


public class TestRunner {

}
