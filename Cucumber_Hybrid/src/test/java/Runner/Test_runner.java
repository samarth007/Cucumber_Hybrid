package Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;




@CucumberOptions(features="src/test/java/Features/HomePage.feature",glue={"Steps","Hooks"}
                  ,plugin={"pretty","rerun:target/FailedTest.txt"}
                  ,tags="~@Customer"		  
                 ,monochrome=true)
public class Test_runner extends AbstractTestNGCucumberTests {



}
