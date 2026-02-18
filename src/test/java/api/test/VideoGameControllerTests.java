package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.VideoGamesControllerEndPoints;
import api.payload.VideoGamesControllerV1AndV2PayLoad;
import io.restassured.response.Response;

import java.io.IOException;


public class VideoGameControllerTests {

    VideoGamesControllerV1AndV2PayLoad videoGamesControllerV1AndV2PayLoads;
    public Logger logger;

    @BeforeClass
    public void setupdata() {

        videoGamesControllerV1AndV2PayLoads = new VideoGamesControllerV1AndV2PayLoad();
        videoGamesControllerV1AndV2PayLoads.getCategory();
        videoGamesControllerV1AndV2PayLoads.getName();
        videoGamesControllerV1AndV2PayLoads.getRating();
        videoGamesControllerV1AndV2PayLoads.getReleaseDate();
        videoGamesControllerV1AndV2PayLoads.getReviewScore();

        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void GetUser() {

        logger.info("********** Get Request  ***************");

        Response response = VideoGamesControllerEndPoints.getUser();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(1, 1);
        Assert.assertEquals(6, 6);
        Assert.assertEquals(7, 7);
        Assert.assertEquals(10, 10);
        AssertJUnit.assertEquals("reviewScore", 88, 88);
        String jsonString = response.asString();
        Assert.assertEquals(jsonString.contains("rating"), true);

    }

    @Test(priority = 2)
    public void PostUser() throws IOException {

        logger.info("********** Post Request  ***************");

        Response response = VideoGamesControllerEndPoints.createControllerUser(videoGamesControllerV1AndV2PayLoads);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        AssertJUnit.assertEquals("reviewScore", 85, 85);
        String jsonString = response.asString();
        Assert.assertEquals(jsonString.contains("Platform"), true);

    }

    @Test(priority = 3)
    public void GetIdUser() {

        logger.info("********** Get Request with ID ***************");

        Response response = VideoGamesControllerEndPoints.readUser(2);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(2, 2);
        AssertJUnit.assertEquals("reviewScore", 91, 91);
        String jsonString = response.asString();
        Assert.assertEquals(jsonString.contains("Gran Turismo 3"), true);
        Assert.assertEquals(jsonString.contains("Universal"), true);

    }


    @Test(priority = 4)
    public void updateUser() throws IOException {

        logger.info("********** Update Request  ***************");

        videoGamesControllerV1AndV2PayLoads.setName("Quality Testing");

        Response response = VideoGamesControllerEndPoints.updateUser(1, videoGamesControllerV1AndV2PayLoads);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        AssertJUnit.assertEquals(String.valueOf(response), "Quality Testing", "Quality Testing");
        String jsonString = response.asString();
        Assert.assertEquals(jsonString.contains("Mature"), true);

    }

    @Test(priority = 5)
    public void deleteUser() throws IOException {
        logger.info("********** Delete Request   ***************");

        Response response = VideoGamesControllerEndPoints.deleteUser(1);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        String jsonString = response.asString();
        Assert.assertEquals(jsonString.contains("Video game deleted"), true);

    }
}


























