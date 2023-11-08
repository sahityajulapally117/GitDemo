import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJasonParse {

	public static void main(String[] args) {

		JsonPath js=new JsonPath(PayLoad.CoursePrice());


		int count=js.getInt("courses.size()");
		//System.out.println(count);

		int price=js.getInt("dashboard.purchaseAmount");
		//System.out.println(price);

		String firstTitle=js.getString("courses[0].title");
		//System.out.println(firstTitle);


		for(int i=0;i<count;i++) {
			String TitleNames=js.getString("courses["+i+"].title");
			//System.out.println(TitleNames);

			int pricesOfEachCourse=js.getInt("courses["+i+"].price");
			//System.out.println(pricesOfEachCourse);

		}

		for(int i=0;i<count;i++) {
			String TitleNames=js.getString("courses["+i+"].title");

			if(TitleNames.equalsIgnoreCase("RPA")) {

				int noOfCopies=js.getInt("courses["+i+"].copies");
				System.out.println(noOfCopies);
				break;
			}



		}



	}
}