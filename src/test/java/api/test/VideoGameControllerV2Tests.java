package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.VideoGamesControllerV2EndPoints;
import api.payload.VideoGamesControllerV1AndV2PayLoad;
import io.restassured.response.Response;

public class VideoGameControllerV2Tests {

    VideoGamesControllerV1AndV2PayLoad videoGamesControllerV1AndV2PayLoads;

    public Logger logger; // for logs

    @BeforeClass
    public void setupdata() {

        videoGamesControllerV1AndV2PayLoads = new VideoGamesControllerV1AndV2PayLoad();

        videoGamesControllerV1AndV2PayLoads.getCategory();
        videoGamesControllerV1AndV2PayLoads.getName();
        videoGamesControllerV1AndV2PayLoads.getRating();
        videoGamesControllerV1AndV2PayLoads.getReleaseDate();
        videoGamesControllerV1AndV2PayLoads.getReviewScore();

        //logs
        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void getV2() {

        logger.info("********** all list  ***************");
        Response response = VideoGamesControllerV2EndPoints.getV2User();
        response.then().log().all();
        AssertJUnit.assertEquals(response.getStatusCode(), 200);
        AssertJUnit.assertEquals(1, 1);
        AssertJUnit.assertEquals(6, 6);
        AssertJUnit.assertEquals(7, 7);
        AssertJUnit.assertEquals(10, 10);
        AssertJUnit.assertEquals("reviewScore", 91, 91);
        String jsonString = response.asString();
        Assert.assertEquals(jsonString.contains("rating"), true);
    }

    @Test(priority = 2)
    public void postV2() {
        logger.info("********** create list  ***************");

        Response response = VideoGamesControllerV2EndPoints.createV2User(videoGamesControllerV1AndV2PayLoads);
        response.then().log().all();
        AssertJUnit.assertEquals(response.getStatusCode(), 200);
        AssertJUnit.assertEquals("rating", "Mature", "Mature");
        String jsonString = response.asString();
        Assert.assertEquals(jsonString.contains("reviewScore"), true);
    }

    @Test(priority = 3)
    public void GetwithIdV2() {

        logger.info("********** read list  ***************");

        Response response = VideoGamesControllerV2EndPoints.getIdV2User(7);
        response.then().log().all();
        AssertJUnit.assertEquals(response.getStatusCode(), 200);
        AssertJUnit.assertEquals(7, 7);
        AssertJUnit.assertEquals("reviewScore", 77, 77);
        String jsonString = response.asString();
        Assert.assertEquals(jsonString.contains("Minecraft"), true);
    }

    @Test(priority = 4)
    public void updateV2() {

        logger.info("********** update list  ***************");

        videoGamesControllerV1AndV2PayLoads.setName("Rambabu s/w mutyam");

        Response response = VideoGamesControllerV2EndPoints.updateV2User(5, videoGamesControllerV1AndV2PayLoads);
        response.then().log().all();

        AssertJUnit.assertEquals(response.getStatusCode(), 200);
        AssertJUnit.assertEquals("name", "Rambabu s/w mutyam", "Rambabu s/w mutyam");
        String jsonString = response.asString();
        Assert.assertEquals(jsonString.contains("reviewScore"), true);
    }


    @Test(priority = 5)
    public void deleteV2() {
        logger.info("********** delete list  ***************");

        Response response = VideoGamesControllerV2EndPoints.deleteV2User(2);
        response.then().log().all();
        AssertJUnit.assertEquals(response.getStatusCode(), 200);
        String jsonString = response.asString();
        Assert.assertEquals(jsonString.contains("Video game deleted"), true);
    }

}
