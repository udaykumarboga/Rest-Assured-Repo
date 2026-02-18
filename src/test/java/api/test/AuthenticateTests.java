package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.AuthenticateEndPoints;
import api.payload.AuthenticatePayLoad;
import io.restassured.response.Response;

import java.io.IOException;

public class AuthenticateTests {

	AuthenticatePayLoad authenticatePayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setupdata() throws IOException
	{
		
		authenticatePayload=new AuthenticatePayLoad();
		
		
		authenticatePayload.getUsername();
		authenticatePayload.getPassword();
		
		//logs
		logger= LogManager.getLogger(this.getClass());
			
	}
	
	
	@Test(priority=1)
	public void testPostAuthenticate() {
		logger.info("********** login with admin  ***************");
		Response responses = AuthenticateEndPoints.createUser(authenticatePayload);
		responses.then().log().all();
		Assert.assertEquals(responses.getStatusCode(), 200);
		Assert.assertEquals("token", "token");
		Assert.assertNotNull(responses, "token");
		String jsonString = responses.asString();
		Assert.assertEquals(jsonString.contains("token"), true);
	}
}
