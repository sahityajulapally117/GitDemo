import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void sumOfCourses() {
		int sum=0;
	int	purchaseAmount=910;
		
		JsonPath js=new JsonPath(PayLoad.CoursePrice());
		
		int count=js.getInt("courses.size()");
		
		for(int i=0;i<count;i++) {
			
		int price=js.getInt("courses["+i+"].price");
		int copies=js.getInt("courses["+i+"].copies");
		int amount=price*copies;
		sum=amount+sum;

	}
		System.out.println(sum);
		Assert.assertEquals(purchaseAmount, sum);
		
}
}
