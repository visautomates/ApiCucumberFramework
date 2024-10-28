package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utiltity.ApiEndPoints;
import utiltity.DataBuilder;
import utiltity.GenericMethod;
import utiltity.Specbuilder;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Addplace extends GenericMethod {

	RequestSpecification res;
	Response response;
	DataBuilder data = new DataBuilder();
	static String placeid;

	@Given("Add place Api with {string} {string} {string}")
	public void add_place_api_with(String Name, String Address, String Language) throws IOException, Exception {

		res = given().spec(Specbuilder.Addplaceapi(getGlobalValue("BaseUri"), "qaclick123")
				.body(data.AddplaceLocation(Name, Language, Address)));

	}

	@When("User calls {string} with {string} request")
	public void user_calls_with_request(String resource, String method) {

		ApiEndPoints endPoint = ApiEndPoints.valueOf(resource);
		System.out.println(endPoint.getResource());
		if (method.equalsIgnoreCase("POST")) {

			response = res.when().post(endPoint.getResource());
		} else {

			response = res.when().get(endPoint.getResource());

		}
	}

	@Then("The APi call is successsfull with status {int}")
	public void the_a_pi_call_is_successsfull_with_status(Integer Statuscode) {

		assertEquals(response.getStatusCode(), 200);

	}

	@Then("{string} in the body is {string}")
	public void in_the_body_is(String expecteValue, String actualValue) {

		assertEquals(Jspath(response, expecteValue), actualValue);
		System.out.println(actualValue);

	}

	@Then("Verify placeid generated match with {string} while calling {string}")
	public void verify_placeid_generated_match_with_while_calling(String actualName, String resource)
			throws IOException {
		 placeid = Jspath(response, "place_id");
		res = given()
				.spec(Specbuilder.Addplaceapi(getGlobalValue("BaseUri"), "qaclick123").queryParam("place_id", placeid));
		user_calls_with_request(resource, "GET");
		String expectedName = Jspath(response, "name");
		System.out.println(expectedName);
		assertEquals(expectedName, actualName);
	}

	@Given("Delete api payload")
	public void delete_api_payload() throws FileNotFoundException, IOException {
		
		res = given().spec(Specbuilder.Addplaceapi(getGlobalValue("BaseUri"), "qaclick123").body(data.deleteBody(placeid)));
		
	}

}
