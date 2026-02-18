package api.endpoints;

	/*
	Swagger URI-https://www.videogamedb.uk:443
	Create:
	 */

	public class Routes {
	    public static String base_url="https://www.videogamedb.uk:443";
	    

	    //Api Authentication Controller
	    
	    public static String post_url=base_url+"/api/authenticate";
	    
	    
	  //Api Video Games Controller
	    
	    public static String get_url=base_url+"/api/videogame"; 
	    public static String post1_url=base_url+"/api/videogame";	
	    public static String getWithId_url=base_url+"/api/videogame/{id}"; 
	    public static String put_url=base_url+"/api/videogame/{id}";
	    public static String delete_url=base_url+"/api/videogame/{id}";
	    
	    
	  //Api Video Games Controller V2
	    
	    public static String getV2_url=base_url+"/api/v2/videogame"; 
	    public static String postV2_url=base_url+"/api/v2/videogame";
	    public static String getV2Id_url=base_url+"/api/v2/videogame/{id}";
	    public static String putV2_url=base_url+"/api/v2/videogame/{id}";
	    public static String deleteV2_url=base_url+"/api/v2/videogame/{id}";

	}

