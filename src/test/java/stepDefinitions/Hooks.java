package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforedeleteplace() throws IOException, Exception {

		Addplace cm = new Addplace();
		if (Addplace.placeid == null) {
			System.out.println("running Hook scenario");
			cm.add_place_api_with("vishnu", "chennai", "malyalam");
			cm.user_calls_with_request("AddApi", "POST");
			cm.verify_placeid_generated_match_with_while_calling("vishnu", "Getapi");
		}

	}

}
