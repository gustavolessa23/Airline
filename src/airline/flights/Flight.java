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
    private String origin;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private String dateOfFlight;
    private String dateOfArrival;
    private Aircraft aircraftAssigned;
    
    public Flight(String origin, String destination, String dateOfFlight,
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
               " From: "+this.origin+" to "+this.destination+"\n"+ 
               " Flight Time: "+this.departureTime+" to "+this.arrivalTime+"\n"+
               "+-------------------------------+\n"+
               "| Airplane Info                 |\n"+
               "+-------------------------------+\n"+
               " Aircraft: "+this.aircraftAssigned.getMake()+" "+
                this.aircraftAssigned.getModel()+"\n"+ 
               " Capacity: "+this.aircraftAssigned.capacity()+" seats\n"+
               " Pilot Name: "+this.aircraftAssigned.getPilot()+ "\n"+  
               "+-------------------------------+\n";
    }
    
    public int getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
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

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public Aircraft getAircraftAssigned() {
        return aircraftAssigned;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

//    public void setDepartureTime(String departureTime) {
//        this.departureTime = departureTime;
//    }
//
//    public void setArrivalTime(String arrivalTime) {
//        this.arrivalTime = arrivalTime;
//    }

    public void setDateOfFlight(String dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public void setAircraftAssigned(Aircraft aircraftAssigned) {
        this.aircraftAssigned = aircraftAssigned;
    }
    
    
}
