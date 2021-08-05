package common;

import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.util.Map;

public class APIPage {

    private static Response last_response;
    private static RestAssured client = new RestAssured();

    /** This method to call GET api
     *
     * @param url
     *          String URL value to call on it
     *
     * @param parameters
     *          parameters to be added to the url
     *
     * @return JSONObject response
     */
    public static JSONArray get(String url, Map<String,String> parameters, Scenario scenario) {
        System.out.println("\n[Service Request-URL]: " + url + parameters);
        last_response = client.given()
                .header(Constant.CONTENT_TYPE, "application/json")
                .queryParams(parameters)

                .get(url).then().extract().response();
        System.out.println("\n[Service Response-status]: " + last_response.statusCode());
        System.out.println("\n[Service Response-Body]: " + last_response.asString());
        StateHelper.setStepState(Constant.STATUSCODE,last_response.statusCode());
        JSONArray jsonResponse = new JSONArray(last_response.asString());
        scenario.log(url + parameters);
        scenario.log(jsonResponse.toString());
        return jsonResponse;
    }

    public static void lenientAssert(String expected) {
        JSONAssert.assertEquals(expected, last_response.asString(), JSONCompareMode.LENIENT);
    }

    public static void strictAssert(String expected) {
        JSONAssert.assertEquals(expected, last_response.asString(), JSONCompareMode.STRICT);
    }
}

