package mediaRentalManager;

/**
 * A class representing a movie.
 * Inherits from the {@link Media} class and adds a rating field.
 */

public class Movie extends Media{
    private String rating;
    
    /**
     * Constructs a movie with the given title, number of copies available, and rating.
     * @param title the title of the movie
     * @param copiesAvailable the number of copies available for rental
     * @param rating the rating of the movie
     */
 
    public Movie (String title, int copiesAvailable,String rating){
   	 super(title, copiesAvailable);
   	 this.rating = rating;}
    
    /**
     * Returns the rating of the movie.
     * @return the rating of the movie
     */
   
    public String getRating(){
   	 return rating;}
    
    /**
     * Sets the rating of the movie.
     * @param rating the rating of the movie
     */
   
    public void setRating(String rating){
   	 this.rating = rating;}
    
    /**
     * Checks if two movies are equal based on their rating.
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
 
    @Override
    public boolean equals(Object o){
    	
     Movie m = (Movie) o;	
    	
   	 if( o == null || (!(o instanceof Movie))){
   		return false;}
   	 
   	 if( o == this){
   		 return true;}
 
   	 
   	 return this.rating.equals(m.rating);
   	 
    }
    
    /**
     * Returns a string representation of the movie, including its title and rating.
     * @return a string representation of the movie
     */
     
    public String toString(){
      	 return ", Rating: " + rating;
       }
}
