package mediaRentalManager;
import java.util.ArrayList;
import java.util.Collections;

/**
 * MediaRentalManager is a class that implements the MediaRentalManagerInt interface.
 * This class represents a media rental manager system that allows customers to rent movies and albums.
 * It manages a list of customers and a list of media items available for rent.
 * It also has a limited plan limit, which is used to restrict the number of media items that can be rented by customers with a limited plan.
 * 
 * @author [Ali Siddique]
 * @version 1.0
 */


public class MediaRentalManager implements MediaRentalManagerInt{
	
   private ArrayList<Customer> customerList = new ArrayList<Customer>();
   private ArrayList<Media> mediaList = new ArrayList<Media>();
   private int limited_plan_limit = 2;
   
   /**
    * Adds a new customer to the customer list.
    *
    * @param name The name of the customer.
    * @param address The address of the customer.
    * @param plan The rental plan of the customer.
    */
   
   @Override
   public void addCustomer(String name, String address, String plan){
   	
	Customer newCustomer = new Customer(name, address, plan);
   	customerList.add(newCustomer);}
   
   /**
    * Adds a new movie to the media list.
    *
    * @param title The title of the movie.
    * @param copiesAvailable The number of copies of the movie available for rent.
    * @param rating The rating of the movie.
    */
   
   @Override
   public void addMovie(String title, int copiesAvailable, String rating){
   	
	Media newMovie = new Movie(title, copiesAvailable, rating);
   	mediaList.add(newMovie);}
   
   /**
    * Adds a new album to the media list.
    *
    * @param title The title of the album.
    * @param copiesAvailable The number of copies of the album available for rent.
    * @param artist The artist of the album.
    * @param songs The list of songs in the album.
    */
   
   @Override
   public void addAlbum(String title, int copiesAvailable, String artist, String songs){
   	
    Media newAlbum = new Album(title, copiesAvailable, artist, songs);
   	mediaList.add(newAlbum);}
   
   /**
    * Sets the limit for the limited plan.
    *
    * @param value the value to set the limit to
    */
   
   @Override
   public void setLimitedPlanLimit(int value){
   	
	   this.limited_plan_limit = value;}
   
   /**
    * Returns a string containing information about all the customers.
    *
    * @return a string containing information about all the customers
    */
   
   @Override
   public String getAllCustomersInfo(){
   	
	Collections.sort(customerList);
   	String result = "***** Customers' Information *****" + '\n';
   	for (int i = 0; i < customerList.size(); i++) {
   	    Customer customer = customerList.get(i);
   	    result += customer.toString() + '\n';
   	    result += "Rented: " + customer.getRented() + '\n';
   	    result += "Queue: " + customer.getQueued() + '\n';}

   	return result;
   }
   
   /**
    * Returns a string containing information about all the media.
    *
    * @return a string containing information about all the media
    */
   
   @Override
   public String getAllMediaInfo(){
	   
	   Collections.sort(mediaList);
	   String result = "***** Media Information *****" + '\n';
	   for (int i = 0; i < mediaList.size(); i++) {
	       Media media = mediaList.get(i);
	       
	       if (media.getClass() == Movie.class) {
	    	   result += "Title: " + media.getTitle() + ", Copies Available: " + media.getNumOfCopies() + media.toString() + '\n';}
	       
	        else if (media.getClass() == Album.class) {
	           result += "Title: " + media.getTitle() + ", Copies Available: " + media.getNumOfCopies() + media.toString() + '\n';}
	   }
	 
	   return result;

   }
   
   /**
    * Adds a media title to a customer's queue.
    *
    * @param customerName the name of the customer to add the media title to
    * @param mediaTitle   the title of the media to add to the customer's queue
    * @return true if the media title was added successfully, false otherwise
    */
   
   @Override
   public boolean addToQueue(String customerName, String mediaTitle){
	   
	   for (int i = 0; i < customerList.size(); i++) {
		    Customer customer = customerList.get(i);
		    
		    if (customerName.equals(customer.getName())) {
		    	
		        if (!(customer.getQueued().contains(mediaTitle))) {
		            customer.getQueued().add(mediaTitle);
		            return true;}
		    }
		}
		return false;

   }
   
   /**

   Overrides the superclass method to remove a media title from a customer's queue.

   @param customerName the name of the customer whose queue will be modified

   @param mediaTitle the title of the media to remove from the customer's queue

   @return true if the media title was successfully removed from the customer's queue, false otherwise
   */
   
   
   @Override
   public boolean removeFromQueue(String customerName, String mediaTitle){
	   
	   for (int i = 0; i < customerList.size(); i++) {
		    Customer customer = customerList.get(i);
		    
		    if (customerName.equals(customer.getName())) {
		        if (customer.getQueued().contains(mediaTitle)) {
		            customer.getQueued().remove(mediaTitle);
		            return true;}
		    }
		}
		return false;

   }
   
   /**

   Overrides the superclass method to process media rental requests for each customer in the store.

   @return a string representing the processed rental requests, listing each rental transaction that took place
   */
   
   @Override
   public String processRequests() {
	    String result = "";
	    Collections.sort(customerList);
	    for (int i = 0; i < customerList.size(); i++) {
	        Customer c1 = customerList.get(i);
	        
	        ArrayList<String> rented = c1.getRented();
	        ArrayList<String> queued = c1.getQueued();
	        
	        if (c1.getPlan().equals("UNLIMITED")) {
	            for (int j = 0; j < queued.size(); j++) {
	                String que = queued.get(j);
	                
	                for (int k = 0; k < mediaList.size(); k++) {
	                    Media med = mediaList.get(k);
	                    
	                    if (que.equals(med.getTitle()) && med.getNumOfCopies() > 0) {
	                        if (!(rented.contains(med.getTitle()))) {
	                            result += "Sending " + med.getTitle() + " to " + c1.getName() + '\n';
	                            rented.add(med.getTitle());
	                            med.takenCopies();
	        }
	        }
	        }  
	        }
	        }
	        if (c1.getPlan().equals("LIMITED")) {
	        	
	            for (int j = 0; j < queued.size(); j++) {
	                String que = queued.get(j);
	                
	                for (int k = 0; k < mediaList.size(); k++) {
	                    Media med = mediaList.get(k);
	                    
	                    if (que.equals(med.getTitle()) && rented.size() < limited_plan_limit && med.getNumOfCopies() > 0) {
	                        if (!(rented.contains(med.getTitle()))) {
	                            result += "Sending " + med.getTitle() + " to " + c1.getName() + '\n';
	                            rented.add(med.getTitle());
	                            med.takenCopies();
	        }
	        }
	        }
	        }
	        }
	        for (int j = 0; j < rented.size(); j++) {
	            String string = rented.get(j);
	            queued.remove(string);
	        }
	    }
	    return result;
	}
   
   /**

   Returns a media item with a specified title for a customer with a specified name.

   @param customerName the name of the customer who is returning the media item

   @param mediaTitle the title of the media item to be returned

   @return true if the media item was successfully returned, false otherwise
   */


   @Override
   public boolean returnMedia(String customerName, String mediaTitle) {
       for (int i = 0; i < customerList.size(); i++) {
           Customer customer = customerList.get(i);
           
           ArrayList<String> rented = customer.getRented();
           
           if (customer.getName().equals(customerName)) {
               for (int j = 0; j < mediaList.size(); j++) {
                   Media m = mediaList.get(j);
                   
                   if (m.getTitle().equals(mediaTitle)) {
                       rented.remove(mediaTitle);
                       m.returnedCopies();
                       return true;
       }
       }
       }
       }
       return false;
   }
   
   /**

   Searches for media based on given search criteria.

   @param title the title of the media to search for, can be null.

   @param rating the rating of the media to search for, can be null.

   @param artist the artist of the media to search for, can be null.

   @param songs the song of the media to search for, can be null.

   @return an ArrayList of Strings containing the titles of all the media that match the search criteria.
   */

   @Override
   public ArrayList<String> searchMedia(String title, String rating, String artist, String songs){
   
	ArrayList<String> media = new ArrayList<String>();
   	Collections.sort(mediaList);
   	
   	if (title != null) {
   	    for (int i = 0; i < mediaList.size(); i++) {
   	        Media med = mediaList.get(i);
   	        if (med instanceof Movie) {
   	        	
   	            if (songs == null && artist == null) {
   	                if (rating == null) {
   	                    if (!media.contains(title)) {
   	                        if (title.equals(med.getTitle())) {
   	                            media.add(med.getTitle());
   	                        }
   	                    }
   	                }
   	                if (rating != null) {
   	                	
   	                    Movie movie = (Movie) med;
   	                    if (movie.getRating().equals(rating)) {
   	                        if (!media.contains(title)) {
   	                            if (title.equals(med.getTitle())) {
   	                                media.add(med.getTitle());}
   	       }
   	       }
   	       }
   	       }
   	       }
   	        if (med instanceof Album) {
   	        	
   	            if (rating == null) {
   	                if (artist == null) {
   	                    if (songs == null) {
   	                        if (!media.contains(title)) {
   	                            if (title.equals(med.getTitle())) {
   	                                media.add(med.getTitle());}
   	                    }
   	                    }
   	                    if (songs != null) {
   	                    	
   	                        Album album = (Album) med;
   	                        if (album.getSongs().contains(songs)) {
   	                            if (!media.contains(title)) {
   	                                if (title.equals(med.getTitle())) {
   	                                    media.add(med.getTitle());}
   	                }
   	                }
   	                }
   	                }
   	                if (artist != null) {
   	                	
   	                    Album album = (Album) med;
   	                    if (songs == null) {
   	                        if (album.getArtist().equals(artist)) {
   	                        	
   	                            if (!media.contains(title)) {
   	                                if (title.equals(med.getTitle())) {
   	                                    media.add(med.getTitle());}
   	                    }
   	                    }
   	                    }
   	                    if (songs != null) {
   	                    	
   	                        if (album.getSongs().contains(songs) && album.getArtist().equals(artist)) {
   	                            
   	                        	if (!media.contains(title)) {
   	                                if (title.equals(med.getTitle())) {
   	                                    media.add(med.getTitle()); }
   	}
   	}
   	}
   	}
   	}
   	}
   	}
   	}
   	
   	else if (title == null) {
   		
   	   for (int i = 0; i < mediaList.size(); i++) {
   	      Media med = mediaList.get(i);
   	      
   	      if (med instanceof Movie) {
   	    	  
   	         if (songs == null && artist == null) {
   	            if (rating == null) {
   	               if (!media.contains(title)) {
   	                  media.add(med.getTitle());}
   	            }
   	            if (rating != null) {
   	               Movie movie = (Movie) med;
   	               if (movie.getRating().equals(rating)) {
   	                  if (!media.contains(title)) {
   	                     media.add(med.getTitle());}
   	      }
   	      }
   	      }
   	      }
   	      if (med instanceof Album) {
   	    	  
   	         if (rating == null) {
   	            if (artist == null) {
   	               if (songs == null) {
   	            	   
   	                  if (!media.contains(title)) {
   	                     media.add(med.getTitle());}
   	               }
   	               if (songs != null) {
   	                  Album album = (Album) med;
   	                  
   	                  if (album.getSongs().contains(songs)) {
   	                     if (!media.contains(title)) {
   	                        media.add(med.getTitle());
   	            }
   	            }
   	            }
   	            }
   	            if (artist != null) {
   	            	
   	               Album album = (Album) med;
   	               if (songs == null) {
   	            	   
   	                  if (album.getArtist().equals(artist)) {
   	                	  
   	                     if (!media.contains(title)) {
   	                        media.add(med.getTitle());}
   	                     
   	               }
   	               }
   	               if (songs != null) {
   	            	   
   	                  if (album.getSongs().contains(songs) && album.getArtist().equals(artist)) {
   	                     
   	                	  if (!media.contains(title)) {
   	                        media.add(med.getTitle());}
   	}
   	}
   	}
   	}
   	}
   	}
   	}

   	
   	
   	return media;
}
   
}

