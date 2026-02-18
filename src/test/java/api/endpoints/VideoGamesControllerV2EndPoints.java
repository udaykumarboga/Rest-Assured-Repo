package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payload.VideoGamesControllerV1AndV2PayLoad;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.ResourceBundle;

public class VideoGamesControllerV2EndPoints {

	// method created for getting URL's from properties file
	static ResourceBundle getURL()
	{
		ResourceBundle routes= ResourceBundle.getBundle("routes"); // Load properties file  // name of the properties file
		return routes;
	}
	public  static Response getV2User()
	{
		String getV2Url = getURL().getString("getV2_url");
	  Response response=given()
			   .contentType(ContentType.JSON)
			   .accept(ContentType.JSON)
		       .when()
		       .get(getV2Url);
		return response;
	}

	public  static Response createV2User(VideoGamesControllerV1AndV2PayLoad payload)
	{
		
	  Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		      .post(Routes.postV2_url);
		
		return response;
	} 

	public  static Response getIdV2User(int id)
	{
	  Response response=given()
		       .pathParam("id",id)
		       .when()
		      .get(Routes.getV2Id_url);
		return response;
	}
	
	public  static Response updateV2User(int id, VideoGamesControllerV1AndV2PayLoad payload)
	{
	  Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("id", id)
		.body(payload)
		.when()
		      .put(Routes.putV2_url);
		return response;
	}
	
	public  static Response deleteV2User(int id)
	{
	  Response response=given()
		      .pathParam("id", id)
		      .when()
		      .delete(Routes.deleteV2_url);
		return response;
	}	
	
	
}
