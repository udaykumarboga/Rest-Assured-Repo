package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.AuthenticatePayLoad;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// here we will keep Authenticate module EndPoints
// created for create

public class AuthenticateEndPoints {

	public  static Response createUser(AuthenticatePayLoad payload)
	{

	  Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		      .post(Routes.post_url);
		return response;

	}
	
}
