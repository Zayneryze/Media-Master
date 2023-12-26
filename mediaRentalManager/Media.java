package mediaRentalManager;

/**
 * Media class represents a single piece of media that can be rented out from the rental store.
 * It implements the Comparable interface for comparing two Media objects based on their title.
 */

public class Media implements Comparable<Media>{
  
   private String title;
   private int numOfCopies;
   
   /**
    * Constructs a Media object with the specified title and number of copies.
    *
    * @param title The title of the media.
    * @param numOfCopies The number of copies of the media available in the rental store.
    */

   public Media (String title, int numOfCopies) {
   	this.title = title;
   	this.numOfCopies = numOfCopies;}
   
   /**
    * Returns the title of the media.
    *
    * @return The title of the media.
    */
   

   public String getTitle(){
   	return title;}
   
   /**
    * Sets the title of the media.
    *
    * @param title The new title of the media.
    */
   
 
   public void setTitle(String title){
	   	this.title = title;}
   
   /**
    * Returns the number of copies of the media available in the rental store.
    *
    * @return The number of copies of the media.
    */
	   
	  
   public int getNumOfCopies(){
   	return numOfCopies;}
   
   /**
    * Sets the number of copies of the media available in the rental store.
    *
    * @param numOfCopies The new number of copies of the media.
    */
   
   public void setNumOfCopies(int numOfCopies){
	this.numOfCopies = numOfCopies;}
   
   /**
    * Decrements the number of available copies of the media when it is rented out.
    */
	   
   public void takenCopies(){
   	numOfCopies --;}
   
   /**
    * Increments the number of available copies of the media when it is returned.
    */
   
   public void returnedCopies(){
   	numOfCopies++;}
   
   /**
    * Compares this Media object to the specified Media object based on their title.
    *
    * @param obj The Media object to be compared.
    * @return A negative integer, zero, or a positive integer as this Media object is less than, equal to, or greater than the specified Media object.
    */
   
   @Override
   public int compareTo(Media obj){
   	return title.compareTo(obj.title);}
   
   /**
    * Compares this Media object to the specified object for equality. 
    * Two Media objects are equal if they have the same title and number of copies.
    *
    * @param obj The object to be compared for equality with this Media object.
    * @return True if the specified object is equal to this Media object, false otherwise.
    */
  
   @Override
   public boolean equals(Object obj){
	   
    Media med = (Media) obj;  
	   
   	if( obj == null || (!(obj instanceof Media))){
   		return false;}
   	
   	if( obj == this){
   		return true;}
   	
   
   	return this.title.equals(med.title) && this.numOfCopies == med.numOfCopies;
   }
}
