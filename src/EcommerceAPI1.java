import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.LogInRequest;
import pojo.LogInRequest1;
import pojo.LogInResponse1;
import pojo.LoginResponse;

public class EcommerceAPI1 {
	

	public static void main(String[] args) {

	RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();			
		
	LogInRequest1 loginrequest1 =new LogInRequest1();
	loginrequest1.setUserEmail("sahityajulapally9@gmail.com");
	loginrequest1.setUserPassword("Yerragunta@1");

	RequestSpecification reqLogin=given().relaxedHTTPSValidation().spec(req).body(loginrequest1);
	
	LogInResponse1 loginresponse=reqLogin.when().post("/api/ecom/auth/login").then().extract().response().as(LogInResponse1.class);
	loginresponse.getToken();
	loginresponse.getUserId();
	
	System.out.println("token   "+loginresponse.getToken());
	String token = loginresponse.getToken();
	System.out.println("userid  "  +loginresponse.getUserId());
	String userId =loginresponse.getUserId();
	
	}
}
