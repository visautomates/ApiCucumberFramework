package utiltity;

import java.util.ArrayList;
import java.util.List;

import TestBase.TestBase;
import pojo.AddplaceGoogle;
import pojo.Locdetails;

public class DataBuilder extends TestBase {

	public static AddplaceGoogle AddplaceLocation(String name, String language, String Address) {

		AddplaceGoogle place = new AddplaceGoogle();
		place.setAccuracy(50);
		place.setAddress(Address);
		place.setLanguage(language);
		place.setName(name);
		place.setWebsite("Vishnu.com");
		place.setPhone_number("8921312312");
		List<String> Mylist = new ArrayList<String>();
		Mylist.add("tyasd");
		Mylist.add("dra");
		place.setTypes(Mylist);

		Locdetails loc = new Locdetails();
		loc.setLat(-121332);
		loc.setLng(0.121322);
		place.setLocation(loc);

		return place;

	}

	public String deleteBody(String placeid) {

		return ("{\r\n\"place_id\":\"" + placeid + "\"\r\n}");
	}

}
