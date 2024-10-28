package utiltity;

public enum ApiEndPoints {
//Enum class is a collection of constant or method
// best to use constant values as collection easy to call back

	// these are methods

	AddApi("/maps/api/place/add/json"), Deleteapi("/maps/api/place/delete/json"), Getapi("/maps/api/place/get/json");

	private String Resource;

//created constructor of the class 
// call the constructor anywhere to pass the string value and get values stored in method
	ApiEndPoints(String Resource) {
		this.Resource = Resource;

	}
// creating a method to get the resource detail saved in constructor 

	public String getResource() {

		return Resource;
	}

}
