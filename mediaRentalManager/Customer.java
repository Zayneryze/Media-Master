package mediaRentalManager;
import java.util.ArrayList;

/**
 * The Customer class represents a customer who can rent media from a rental store.
 * Each customer has a name, address, rental plan, and lists of rented and queued media.
 * The class implements the Comparable interface, allowing customers to be sorted by name.
 *
 * @author [Ali Siddique]
 *
 */

public class Customer implements Comparable<Customer>{

   private ArrayList<String>rented;
   private ArrayList<String>queued;
	   
   private String name;
   private String address;
   private String plan;
   
   /**
    * Constructs a Customer object with the given name, address, and rental plan.
    * The rented and queued media lists are initially empty.
    *
    * @param name The name of the customer.
    * @param address The address of the customer.
    * @param plan The rental plan of the customer.
    */
  
   public Customer(String name, String address,String plan){
   	rented= new ArrayList<String>();
   	queued= new ArrayList<String>();
   	this.name = name;
   	this.address = address;
   	this.plan = plan;}
   
   /**
    * Returns the name of the customer.
    *
    * @return The name of the customer.
    */

   public String getName(){
   	return name;
   }
   
   /**
    * Sets the name of the customer.
    *
    * @param name The new name of the customer.
    */

   public void setName(String name){
	   	this.name = name;}
   
   /**
    * Returns the address of the customer.
    *
    * @return The address of the customer.
    */
   
   public String getAddress(){
   	return address;
   }
   
   /**
    * Sets the address of the customer.
    *
    * @param address The new address of the customer.
    */
 
   public void setAddress(String address){
   	this.address = address;}
   
   /**
    * Returns the rental plan of the customer.
    *
    * @return The rental plan of the customer.
    */
   
   public String getPlan(){
   	return plan;
   }
   
   /**
    * Sets the rental plan of the customer.
    *
    * @param plan The new rental plan of the customer.
    */
   
   public void setPlan(String plan){
	   	this.plan = plan;}
   
   /**
    * Returns the list of media that the customer has queued to rent.
    *
    * @return The list of media that the customer has queued to rent.
    */
  
   public ArrayList<String> getQueued(){
	   	return queued;}
   
   /**
    * Returns the list of media that the customer has rented.
    *
    * @return The list of media that the customer has rented.
    */
   
   public ArrayList<String> getRented(){
   	return rented;}
   
   /**
    * Returns a string representation of the Customer object, including the name, address, and rental plan.
    *
    * @return A string representation of the Customer object.
    */
   
   public String toString(){
   	return "Name: "+ this.name + ", Address: " + this.address + ", Plan: " + this.plan;
   }
   
   /**
    * Compares the name of the current customer object with another customer object and returns an integer that indicates the order of the two objects.
    *
    * @param obj the customer object to be compared to
    * @return an integer that is negative, zero, or positive, indicating whether the name of the current customer object is less than, equal to, or greater than the name of the given customer object, respectively.
    */
   
   @Override
   public int compareTo(Customer obj){
   	return name.compareTo(obj.name);
   }
   
   /**
    * Checks if two customer objects are equal based on their name, address, and plan.
    *
    * @param obj the customer object to be compared to
    * @return a boolean value indicating whether the two objects are equal or not
    */
   
   @Override
   public boolean equals(Object obj){
	  
    Customer customer = (Customer) obj; 
	   
	if( obj == this){
	   return true;}
	   	
   	if( obj == null || (!(obj instanceof Customer))){
   		return false;}
   
   
   	return this.name.equals(customer.name) && this.address.equals(customer.address) && this.plan.equals(customer.plan);}
      
   
}

