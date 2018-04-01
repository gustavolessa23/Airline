package airline.data;

import airline.aircrafts.Airplane;
import airline.employees.Pilot;
import airline.employees.Rating;
import airline.flights.Flight;
import airline.flights.Location;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class stores information about pilots, airplanes and flights in ArrayList 
 * and generates initial data.
 * @author rbsrafa
 * @author Gustavo Lessa
 */
public class Data {    
    private ArrayList<Pilot> pilots;   
    private ArrayList<Airplane> airplanes;
    private ArrayList<Flight> flights;
    private DataValidation validation;
    
    /**
     * This constructor creates a new Data object that contains ArrayLists of pilots, airplanes and flights objects.
     */
    public Data(){
        this.validation = new DataValidation();
        this.pilots = this.generatePilots();
        this.airplanes = this.generateAirplanes();
        this.flights = this.generateFlights();
    }
    
    /**
     * This method generates and returns new ArrayList of pilots.
     * @return An ArrayList of pilots objects.
     */
    private ArrayList<Pilot> generatePilots(){
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
     * @return An ArrayList of airplane objects.
     */
    private ArrayList<Airplane> generateAirplanes(){
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
     * @return An ArrayList of flight objects.
     */
    private ArrayList<Flight> generateFlights(){
        ArrayList<Flight> flights = new ArrayList<>();
        String[] departureTimes = {"10:10", "09:40","08:20","07:00"};
        String[] arrivalTimes = {"13:10","14:05","15:45","19:55"};
        String[] dates = {"02/01/2018","23/09/2018","17/02/2018","25/12/2018"};

        Random rand = new Random(); 
        Location[] locations = Location.getAllOptions();
        
        for(int i = 0; i < 5; i++){
            Flight f = new Flight(locations[rand.nextInt(locations.length)], 
                    locations[rand.nextInt(locations.length)],
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
     * @return An ArrayList of pilot objects.
     */
    public ArrayList<Pilot> getPilots() {
        return pilots;
    }

    /**
     * This method sets the Data's ArrayList of Pilots.
     * @param pilots (ArrayList)
     */
    public void setPilots(ArrayList<Pilot> pilots) {
        this.pilots = pilots;
    }

    /**
     * This method returns a ArrayList of Airplanes.
     * @return An ArrayList of airplane objects.
     */
    public ArrayList<Airplane> getAirplanes() {
        return airplanes;
    }

    /**
     * This method sets the Data's ArrayList of Airplanes.
     * @param airplanes (ArrayList)
     */
    public void setAirplanes(ArrayList<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    /**
     * This method returns a ArrayList of Flights.
     * @return An ArrayList of flight objects.
     */
    public ArrayList<Flight> getFlights() {
        return flights;
    }

    /**
     * This method sets the Data's ArrayList of Flights.
     * @param flights (ArrayList)
     */
    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
    
    
}
