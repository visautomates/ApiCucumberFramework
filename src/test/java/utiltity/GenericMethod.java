package utiltity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.stream.FileCacheImageInputStream;

import TestBase.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.builder.ResponseSpecBuilder;

public class GenericMethod {

	public static String getGlobalValue(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Vishnu\\eclipse-workspace\\NewApiAutomation\\APIAutomationBDDFrameWork\\src\\test\\java\\resources\\Global.properties");
		prop.load(fis);
		return prop.getProperty(key);

	}

	public static String Jspath(Response response, String path) {

		String res = response.asString();
		JsonPath js = new JsonPath(res);
		String value = js.get(path);
		return value.toString();

	}

}
