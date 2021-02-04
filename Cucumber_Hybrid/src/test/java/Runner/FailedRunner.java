package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="@target/FailedTest.txt", glue= {"Steps","Hooks"}
                 ,monochrome=true,
                 plugin="pretty")
public class FailedRunner extends AbstractTestNGCucumberTests {

}
