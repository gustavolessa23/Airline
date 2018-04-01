/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.flights;

import airline.aircrafts.Aircraft;

/**
 * Each instance of this class represents a flight of CCT Air airline company.
 * @author Gustavo Lessa
 */
public class Flight {
    private final int id;
    private static int lastId = 0;
    private Location origin;
    private Location destination;
    private String departureTime;
    private String arrivalTime;
    private String dateOfFlight;
    private Aircraft aircraftAssigned;
    
    /**
     * This constructor takes four arguments to create a Flight object, giving it 
     * an automatically generated unique ID.
     * @param origin (Location) - City of departure from Location enum.
     * @param destination (Location) - Destination city from Location enum.
     * @param dateOfFlight (String) - Date of flight (dd/mm/yyyy).
     * @param aircraftAssigned (Aircraft) - Aircraft to be assined to the flight.
     */
    public Flight(Location origin, Location destination, String dateOfFlight,
            Aircraft aircraftAssigned){
        this.origin = origin;
        this.destination = destination;
        this.dateOfFlight = dateOfFlight;
        this.aircraftAssigned = aircraftAssigned;
        this.id = ++lastId;
    }
    
    /**
     * This method updates the arrival time of the flight.
     * @param arrivalTime (String) representing the arrival time.
     */
    public void schedule (String arrivalTime){
        this.arrivalTime = arrivalTime;
    }
    
    /**
     * This method updates both arrival and departure times of the flight.
     * @param arrivalTime (String) representing the arrival time.
     * @param departureTime (String) representing the departure time.
     */
    public void schedule (String arrivalTime, String departureTime){
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }
    
    /**
     * This method overrides the default toString() to display the flight info
     * along with the airplane info.
     * @return A String to be displayed when printing the object to console.
     */
    @Override
    public String toString(){
        return
               "\n+-------------------------------+\n"+
               "| Flight Info                   |\n"+
               "+-------------------------------+\n"+
               " ID: "+this.id+"\n"+ 
               " Date: "+this.dateOfFlight+"\n"+                 
               " From: "+this.origin.getName()+" to "+this.destination.getName()+"\n"+ 
               " Flight time: "+flightTimes()+"\n"+
               "+-------------------------------+\n"+
               "| Airplane Info                 |\n"+
               "+-------------------------------+\n"+
               " Aircraft: "+this.aircraftAssigned.getMake()+" "+
                this.aircraftAssigned.getModel()+"\n"+ 
               " Capacity: "+this.aircraftAssigned.capacity()+" seats\n"+
               " Pilot Name: "+this.aircraftAssigned.getPilotName()+ "\n"+  
               "+-------------------------------+\n";
    }
    
    /**
     * This object retrieves the flight ID.
     * @return An Integer representing the flight ID.
     */
    public int getId() {
        return id;
    }

    /**
     * This method retrieves the origin of the flight.
     * @return A Location object from the Location enum.
     */
    public Location getOrigin() {
        return origin;
    }

    /**
     * This method retrieves the destination of the flight.
     * @return A Location object from the Location enum.
     */
    public Location getDestination() {
        return destination;
    }
    
    /**
     * This method retrieves the departure time of the flight.
     * @return A String representing the departure time of the flight in the 
     * format HH:mm.
     */
    public String getDepartureTime() {
        return departureTime;
    }
    
    /**
     * This method retrieves the arrival time of the flight.
     * @return A String representing the arrival time of the flight in the 
     * format HH:mm.
     */
    public String getArrivalTime() {
        return arrivalTime;
    }
    
    /**
     * This method retrieves the date of the flight.
     * @return A String representing the date of the flight.
     */
    public String getDateOfFlight() {
        return dateOfFlight;
    }

    /**
     * This method retrieves the assigned aircraft of the flight.
     * @return An Aircraft object.
     */
    public Aircraft getAircraftAssigned() {
        return aircraftAssigned;
    }

    /**
     * This method sets the origin of the flight.
     * @param origin (Location) Desired origin option from Location enum.
     */
    public void setOrigin(Location origin) {
        this.origin = origin;
    }
    
    /**
     * This method sets the destination of the flight.
     * @param destination (Location) Desired destination option from 
     * Location enum.
     */
    public void setDestination(Location destination) {
        this.destination = destination;
    }
    
    /**
     * This method sets the date of the flight.
     * @param dateOfFlight (String) Desired date of flight.
     */
    public void setDateOfFlight(String dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }
    
    /**
     * This method assigns an aircraft to the flight.
     * @param aircraftAssigned (Aircraft) Aircraft to be assigned.
     */
    public void setAircraftAssigned(Aircraft aircraftAssigned) {
        this.aircraftAssigned = aircraftAssigned;
    }
    
    /**
     * This method checks departure and arrival times and returns the text to be
     * displayed.
     * @return (String) departure and arrival times, or "Not Specified" in case 
     * any of them is null.
     */
    public String flightTimes(){
        if(this.departureTime == null|| this.arrivalTime == null){
            return "Not specified";
        } else {
            return (this.departureTime+" to "+this.arrivalTime);
        }
        
    }
    
}
