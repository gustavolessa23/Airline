/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.flights;

import airline.aircrafts.Aircraft;

/**
 *
 * @author gustavolessadublin
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
    
    public Flight(Location origin, Location destination, String dateOfFlight,
            Aircraft aircraftAssigned){
        this.origin = origin;
        this.destination = destination;
        this.dateOfFlight = dateOfFlight;
        this.aircraftAssigned = aircraftAssigned;
        this.id = ++lastId;
    }
    
    public void schedule (String arrivalTime){
        this.arrivalTime = arrivalTime;
//        System.out.println("Flight "+id+" updated. Arrival time now is "+
//                arrivalTime+".");
    }
    
    public void schedule (String arrivalTime, String departureTime){
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
//        System.out.println("Flight "+id+" updated. Arrival time now is "+
//                arrivalTime+" and departure time is now "+departureTime+".");
    }
    
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
    
    public int getId() {
        return id;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDateOfFlight() {
        return dateOfFlight;
    }

    public Aircraft getAircraftAssigned() {
        return aircraftAssigned;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public void setDateOfFlight(String dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public void setAircraftAssigned(Aircraft aircraftAssigned) {
        this.aircraftAssigned = aircraftAssigned;
    }
    
    public String flightTimes(){
        if(this.departureTime == null|| this.arrivalTime == null){
            return "Not specified";
        } else {
            return (this.departureTime+" to "+this.arrivalTime);
        }
        
    }
    
}
