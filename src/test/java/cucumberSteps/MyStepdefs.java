package cucumberSteps;

import common.APIPage;
import common.PropertyReader;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyStepdefs {
    private Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @When("Call GET API with (.*) key and (.*) value\\.")
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

}
