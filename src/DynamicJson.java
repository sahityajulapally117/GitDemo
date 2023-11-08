import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.PayLoad;

public class DynamicJson {

	

		@Test(dataProvider="BooksData")
		public void addBook(String isbn,String aisle) {
			
		RestAssured.baseURI="http://216.10.245.166";

		String response=given().log().all().header("Content-Type","application/json")
				.body(PayLoad.AddBook(isbn, aisle))
				.when().post("/Library/Addbook.php")
				.then().assertThat().statusCode(200)
				.extract().response().asString();

		JsonPath js=new JsonPath(response);
		String id=js.get("ID");
		System.out.println(id);

	}
	
	
	@DataProvider(name="BooksData")
	public Object getData() {
		
	//return	new Object[] {"fhrfhv","kkgfh","hjfs"};
	return	new Object[][] {{"fhrfhv","4658635"},{"kkgfh","564587"},{"hjfs","755"}};

	}
}
