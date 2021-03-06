package cucumberSteps;

import common.APIPage;
import common.Constant;
import common.PropertyReader;
import common.StateHelper;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyStepdefs {
    private Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^Call GET API with (.*) key and (.*) value\\.$")
    public void test(List<String> key, List<String> value) throws Throwable {
        //Put the list of keys and list of values on Map
        Map<String,String> params = new HashMap<>();
        for (int i=0; i<key.size();i++)
            params.put(key.get(i),value.get(i));

        //Get the environment URL from the property files
        String host = PropertyReader.shared().getProperty("GET_POSITIONS");

        //Call the (GET) method
        APIPage.get(host,params,scenario);
    }

    @Then("^Verify that the response statusCode is (\\d+)\\.$")
    public void verifyThatTheResponseStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, StateHelper.getStepState(Constant.STATUSCODE));
        APIPage.lenientAssert("");
        APIPage.strictAssert("{t:y;");
    }

//    @Given("Call GET API with <keys> key and <values> value.")
//    public void callGETAPIWithKeysKeyAndValuesValue() {
//    }

//    @Given("Call GET API with {string} key and {string} value.")
//    public void callGETAPIWithKeyAndValue(String arg0, String arg1) {
//    }
}
