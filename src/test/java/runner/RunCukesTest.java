package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.Test;


@CucumberOptions(plugin = {"html:target/cucumber-html-report", "junit:target/cucumber-junit.xml",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json"},
        glue = {"cucumberSteps", "runner"},
        features = "src/test/Features/",
        strict = true,
        monochrome = true)


public class RunCukesTest {

    @Test(description = "Example of using TestNGCucumberRunner to invoke Cucumber")
    public void runCukes() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }

}
