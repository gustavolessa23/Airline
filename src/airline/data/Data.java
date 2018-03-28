/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.data;

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
    
    /**
     * This constructor creates a new Data object that contains the ArrayLists of pilots, airplanes and flights.
     */
    public Data(){
        this.pilots = this.generatePilots();
        this.airplanes = this.generateAirplanes();
        this.flights = this.generateFlights();
    }
    
    /**
     * This method generates and returns new ArrayList of pilots.
     * @return 
     */
    public ArrayList<Pilot> generatePilots(){
        ArrayList<Pilot> pilots = new ArrayList<>();
        String[] names = {"Rafael Barros", "Lucival Nascimento", "Gustavo Lessa", "Mark Dontknow"};
        Rating[] ratings = {Rating.A, Rating.B, Rating.C, Rating.D};
        
        for(int i = 0; i < names.length; i++){
            Pilot p = new Pilot(names[i], ratings[i]);
            pilots.add(p);
        }
        return pilots;
    }
    
    /**
     * This method generates and returns a new ArrayList of airplanes.
     * @return 
     */
    public ArrayList<Airplane> generateAirplanes(){
        ArrayList<Airplane> airplanes = new ArrayList<>();
        String[] make = {"Boeing", "Embraer", "Airbus", "Bombardier"};
        String[] model = {"737", "747", "A318", "A380", 
            "Challenger 300", "Challenger 600", "E-175", "E-195"};
        int[] capacity = {400, 300, 200, 100};
        Random rand = new Random(); 
        
        for(int i = 0; i < pilots.size(); i++){
            Airplane a = new Airplane(make[rand.nextInt(make.length)], 
                    model[rand.nextInt(model.length)],
                    capacity[rand.nextInt(capacity.length)], 
                    pilots.get(i));
            airplanes.add(a);
        }
        return airplanes;
    }
    
    /**
     * This method generates and returns a new ArrayList of flights.
     * @return 
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
     * @return 
     */
    public ArrayList<Pilot> getPilots() {
        return pilots;
    }

    /**
     * This method sets the Data's ArrayList of Pilots.
     * @param pilots 
     */
    public void setPilots(ArrayList<Pilot> pilots) {
        this.pilots = pilots;
    }

    /**
     * This method returns a ArrayList of Airplanes.
     * @return 
     */
    public ArrayList<Airplane> getAirplanes() {
        return airplanes;
    }

    /**
     * This method sets the Data's ArrayList of Airplanes.
     * @param airplanes 
     */
    public void setAirplanes(ArrayList<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    /**
     * This method returns a ArrayList of Flights.
     * @return 
     */
    public ArrayList<Flight> getFlights() {
        return flights;
    }

    /**
     * This method sets the Data's ArrayList of Flights.
     * @param flights 
     */
    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
    
    
}
