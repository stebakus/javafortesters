package com.andrey.addressbook.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "classpath:bdd", plugin = {"pretty:target/cucumber-htmlreport.text", "html:build/cucumber-report"})
public class GroupTests extends AbstractTestNGCucumberTests {
}
