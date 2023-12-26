package mediaRentalManager;

/**
 * The Album class represents a type of Media that is an album.
 * It extends the Media class and adds two additional fields: Artists and Songs.
 *
 * @author [Ali Siddique]
 * 
 */

public class Album extends Media{

   private String Artists;
   private String Songs;
   
   /**
    * Constructs an Album object with the given title, number of copies available, artist(s), and songs.
    *
    * @param title The title of the album.
    * @param copiesAvailable The number of copies of the album that are available to rent.
    * @param artist The artist(s) of the album.
    * @param songs The songs included in the album.
    */
   
   public Album(String title, int copiesAvailable, String artist, String songs){
   super(title, copiesAvailable);
   this.Artists = artist;
   this.Songs= songs;}
  
   /**
    * Returns the artist(s) of the album.
    *
    * @return The artist(s) of the album.
    */
   
   public String getArtist(){
   	return Artists;}
   
   /**
    * Sets the artist(s) of the album.
    *
    * @param artist The new artist(s) of the album.
    */

   public void setArtist(String artist){
	   	this.Artists = artist;}
   
   /**
    * Returns the songs included in the album.
    *
    * @return The songs included in the album.
    */
   
   public String getSongs(){
   	return Songs;}
   
   /**
    * Sets the songs included in the album.
    *
    * @param songs The new songs included in the album.
    */

   public void setSongs(String songs){
   	this.Songs = songs;}
   
   /**
    * Returns a string representation of the Album object, including the title, artist(s), and songs.
    *
    * @return A string representation of the Album object.
    */
  
   public String toString(){
   	return ", Artist: "+ Artists + ", Songs: " + Songs;}
   
   /**
    * Compares the Album object to another object for equality.
    * Two albums are considered equal if they have the same artist(s) and songs.
    *
    * @param obj The object to compare to this Album object.
    * @return true if the objects are equal, false otherwise.
    */
   
   @Override
   public boolean equals(Object obj){
	   
	Album alb = (Album) obj;  
	
   	if( obj == null){
   		return false;}
   	if( obj == this){
   		return true;}
   	if(!(obj instanceof Album)){
   		return false;}
   	
  
   	return this.Artists.equals(alb.Artists) && this.Songs.equals(alb.Songs);}
   
}
