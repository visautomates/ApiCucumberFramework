package utiltity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import TestBase.TestBase;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specbuilder {

	public static RequestSpecification addapi;

	public static RequestSpecification Addplaceapi(String BaseUri, String ParaValue) throws FileNotFoundException {

		if (addapi == null) {
			// https://rahulshettyacademy.com
			PrintStream log = new PrintStream(new FileOutputStream("Logs.txt"));
			addapi = new RequestSpecBuilder().setBaseUri(BaseUri).setContentType(ContentType.JSON)
					.addQueryParam("key", ParaValue).addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).

					build();

			return addapi;
		}
		return addapi;

	}

}