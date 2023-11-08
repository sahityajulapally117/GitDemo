import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.PayLoad;
import files.ReusableMethods;
public class Base {

	public static void main(String[] args) {

		RestAssured.baseURI="https://rahulshettyacademy.com";

		String response=given().log().all()
				.queryParam("key", "qaclick123")
				.header("Content-Type","application/json")
				.body(PayLoad.AddPlace())
				.when().post("/maps/api/place/add/json")
				.then().log().all()
				.assertThat().statusCode(200)
				.header("Content-Type", "application/json;charset=UTF-8")
				.extract().response().asString();

		// System.out.println(response);

		JsonPath js=new JsonPath(response);
		String placeId=js.getString("place_id");
		//  System.out.println(js.getString("place_id"));
		String newAddress="Yerragunta";

		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200)
		.body("msg", equalTo("Address successfully updated"));


		String response1= given().log().all().queryParam("key", "qaclick123").queryParam("place_id", ""+placeId+"")
				.when().get("/maps/api/place/get/json")
				.then().log().all()
				.assertThat().statusCode(200)
				.extract().response().asString();
		
		JsonPath js1=ReusableMethods.rawToJson(response1);

		//JsonPath js1=new JsonPath(response1);
		String updatedAddress=js1.getString("address");

		 System.out.println(updatedAddress);
		 
		 Assert.assertEquals(newAddress, updatedAddress);


	}

}
