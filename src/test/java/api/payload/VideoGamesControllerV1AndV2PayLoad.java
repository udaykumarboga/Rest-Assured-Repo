package api.payload;

import java.util.Date;

public class VideoGamesControllerV1AndV2PayLoad {

//	String category;
//	String name = "rambabu";
//	String rating;
//	String releaseDate;
//	int reviewScore;
	
	int id= 0;
	String category = "Platform";
	String name = "Mario";
	String  rating= "Mature";
	String releaseDate = "2012-05-04";
	int reviewScore= 85;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	
	
	
	
			
}
