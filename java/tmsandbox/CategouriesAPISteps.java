package tmsandbox;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class CategouriesAPISteps {

	private EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
	private Response response;

	@When("user sends a request to categories with given (.*)")
	public void sendRequestToCategoruiesAPI(String params) {

		response = RestAssured.given().queryParam(params).get(environmentVariables.getProperty("categoriesAPI"));
	}

	@Then("user validates response with parameters (.*), (.*), (.*), (.*)")
	public void validateResponse(String name, boolean canRelist, String promotionName, String description) {
		JsonPath jsonPath = JsonPath.from(response.asString());
		Assert.assertEquals(jsonPath.getString("Name"), name);
		Assert.assertEquals(jsonPath.getBoolean("CanRelist"), canRelist);

		List<Map<String, Object>> promotions = jsonPath.getList("Promotions");
		for (Map<String, Object> promo : promotions) {
			if (promo.get("Name").equals(canRelist)) {
				Assert.assertTrue(((String) promo.get("Description")).contains(description));
			}
		}
	}
}
