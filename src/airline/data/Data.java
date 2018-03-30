/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.data;

import airline.data.InputValidation;
import airline.aircrafts.Airplane;
import airline.employees.Pilot;
import airline.employees.Rating;
import airline.flights.Flight;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rbsrafa
 */
public class Data {    
    private ArrayList<Pilot> pilots;   
    private ArrayList<Airplane> airplanes;
    private ArrayList<Flight> flights;
    private InputValidation validation;
    
    /**
     * This constructor creates a new Data object that contains the ArrayLists of pilots, airplanes and flights.
     */
    public Data(){
        this.validation = new InputValidation();
        this.pilots = this.generatePilots();
        this.airplanes = this.generateAirplanes();
        this.flights = this.generateFlights();
    }
    
    /**
     * This method generates and returns new ArrayList of pilots.
     * @return pilots
     */
    public ArrayList<Pilot> generatePilots(){
        ArrayList<Pilot> pilots = new ArrayList<>();
        String[] names = {"Rafael Barros", "Lucival Nascimento", "Gustavo Lessa", "Mark Morrissey"};
        Rating[] ratings = {Rating.A, Rating.B, Rating.C, Rating.D};
        
        for(int i = 0; i < names.length; i++){
            Pilot p = new Pilot(names[i], ratings[i]);
            pilots.add(p);
        }
        return pilots;
    }
    
    /**
     * This method generates and returns a new ArrayList of airplanes.
     * @return airplanes
     */
    public ArrayList<Airplane> generateAirplanes(){
        ArrayList<Airplane> airplanes = new ArrayList<>();
        String[] make = {"Boeing", "Embraer", "Airbus", "Bombardier"};
        String[] model = {"737", "747", "A318", "A380", 
            "Challenger 300", "Challenger 600", "E-175", "E-195"};
        int[] capacities = {400, 300, 200, 100};
        Random rand = new Random(); 
        
        for(int i = 0; i < pilots.size(); i++){
            Pilot p = pilots.get(rand.nextInt(pilots.size()));
            int capacity = capacities[rand.nextInt(capacities.length)];
            
            if(this.validation.isAllowed(p, capacity)){
                Airplane a = new Airplane(make[rand.nextInt(make.length)], 
                                      model[rand.nextInt(model.length)],
                                      capacity, p);
                p.setAssigned(true);
                airplanes.add(a);
            }else i--;  
        }
        return airplanes;
    }
    
    /**
     * This method generates and returns a new ArrayList of flights.
     * @return flights
     */
    public ArrayList<Flight> generateFlights(){
        ArrayList<Flight> flights = new ArrayList<>();
        String[] origins = {"Rio de Janeiro", "São Paulo", "Lisbon", "London"};
        String[] destinations = {"Dublin","Amsterdam","Miami","Tokyo"};
        String[] departureTimes = {"10:10", "09:40","08:20","07:00"};
        String[] arrivalTimes = {"13:10","14:05","15:45","19:55"};
        String[] dates = {"02/01/2018","23/09/2018","17/02/2018","25/12/2018"};

        Random rand = new Random(); 
        
        for(int i = 0; i < 5; i++){
            Flight f = new Flight(origins[rand.nextInt(origins.length-1)], 
                    destinations[rand.nextInt(destinations.length-1)],
                    dates[rand.nextInt(dates.length-1)], 
                    airplanes.get(rand.nextInt(airplanes.size()-1)));
            
            f.schedule(arrivalTimes[rand.nextInt(arrivalTimes.length-1)],
                    departureTimes[rand.nextInt(departureTimes.length-1)]);
            
            flights.add(f);
        }
        return flights;
    }

    /**
     * This method returns a ArrayList of Pilots.
     * @return pilots
     */
    public ArrayList<Pilot> getPilots() {
        return pilots;
    }

    /**
     * 
     * @param pilots This method sets the Data's ArrayList of Pilots.
     */
    public void setPilots(ArrayList<Pilot> pilots) {
        this.pilots = pilots;
    }

    /**
     * 
     * @return This method returns a ArrayList of Airplanes.
     */
    public ArrayList<Airplane> getAirplanes() {
        return airplanes;
    }

    /**
     * 
     * @param airplanes This method sets the Data's ArrayList of Airplanes.
     */
    public void setAirplanes(ArrayList<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    /**
     * 
     * @return This method returns a ArrayList of Flights.
     */
    public ArrayList<Flight> getFlights() {
        return flights;
    }

    /**
     * 
     * @param flights This method sets the Data's ArrayList of Flights.
     */
    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
    
    
}
