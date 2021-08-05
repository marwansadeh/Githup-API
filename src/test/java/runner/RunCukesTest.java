package runner;


//import cucumber.api.CucumberOptions;
//import cucumber.api.testng.TestNGCucumberRunner;
//import org.testng.annotations.Test;
//
//
//@CucumberOptions(plugin = {"html:target/cucumber-html-report", "junit:target/cucumber-junit.xml",
//        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
//        "usage:target/cucumber-usage.json"}
//        ,glue = {"cucumberSteps", "runner"}
//        ,features = "src/test/Features/"
//        ,strict = true
//        ,monochrome = true
////        ,tags = {"@Negative"}
//)
//
//
//public class RunCukesTest {
//
//    @Test(description = "Example of using TestNGCucumberRunner to invoke Cucumber")
//    public void runCukes() {
//        new TestNGCucumberRunner(getClass()).runCukes();
//    }
//
//}


import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.CucumberOptions;
import courgette.api.testng.TestNGCourgette;
import org.testng.annotations.Test;


@Test
@CourgetteOptions(
        threads = 10,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = true,
        showTestOutput = true,
        reportTargetDir = "build/chrome",
        environmentInfo = "browser=chrome; project_info=Courgette-JVM is awesome!",
        cucumberOptions = @CucumberOptions(
                features = "src/test/Features/",
                glue = {"cucumberSteps", "runner"},
//                tags = {"@regression"},
                publish = true,
                plugin = {"pretty",
                        "json:build/chrome/cucumber-report/cucumber.json",
                        "html:build/chrome/cucumber-report/cucumber.html",
                        "html:target/cucumber-html-report",
                        "junit:target/cucumber-junit.xml",
                        "json:target/cucumber.json",
                        "pretty:target/cucumber-pretty.txt",
                        "usage:target/cucumber-usage.json"}
        ))
public class RunCukesTest extends TestNGCourgette {
}