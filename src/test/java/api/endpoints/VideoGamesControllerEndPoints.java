package api.endpoints;

import api.payload.AuthenticatePayLoad;
import api.payload.VideoGamesControllerV1AndV2PayLoad;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class VideoGamesControllerEndPoints {

	static AuthenticatePayLoad authenticatePayload;

	public  static Response getUser()
	{
	  Response response=given()
			   .contentType(ContentType.JSON)
			   .accept(ContentType.JSON)
		       .when()
		       .get(Routes.get_url);
		return response;
	}

	public  static Response createControllerUser(VideoGamesControllerV1AndV2PayLoad payload) throws IOException
	{
		authenticatePayload=new AuthenticatePayLoad();
		authenticatePayload.getUsername();
		authenticatePayload.getPassword();
		Response responses = AuthenticateEndPoints.createUser(authenticatePayload);
		JsonPath jsonPathEvaluator = responses.jsonPath();
		 String token = jsonPathEvaluator.get("token");

		 String authorizationHeader = "Bearer " + token;

	Response response= given()
			.header("Authorization", authorizationHeader)
		    .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
		    .body(payload)
		    .when()
		      .post(Routes.post1_url);

		return response;
	}

	public  static Response readUser(int id)
	{
	  Response response=given()
		       .pathParam("id",id)
		       .when()
		      .get(Routes.getWithId_url);

		return response;
	}

	public  static Response updateUser(int id, VideoGamesControllerV1AndV2PayLoad payload) throws IOException {
		authenticatePayload=new AuthenticatePayLoad();
		authenticatePayload.getUsername();
		authenticatePayload.getPassword();
		Response responses = AuthenticateEndPoints.createUser(authenticatePayload);
		JsonPath jsonPathEvaluator = responses.jsonPath();
		 String token = jsonPathEvaluator.get("token");

		 String authorizationHeader = "Bearer " + token;

	Response response= given()
			.header("Authorization", authorizationHeader)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("id", id)
		.body(payload)
		.when()
		      .put(Routes.put_url);

		return response;
	}

		public static Response deleteUser ( int id) throws IOException
		{
		authenticatePayload=new AuthenticatePayLoad();
		authenticatePayload.getUsername();
		authenticatePayload.getPassword();
		Response responses = AuthenticateEndPoints.createUser(authenticatePayload);


		JsonPath jsonPathEvaluator = responses.jsonPath();
		 String token = jsonPathEvaluator.get("token");

		 String authorizationHeader = "Bearer " + token;
	Response response3= given()
			.header("Authorization", authorizationHeader)
		      .pathParam("id", id)
		      .when()
		      .delete(Routes.delete_url);
		return response3;
	}
	}
