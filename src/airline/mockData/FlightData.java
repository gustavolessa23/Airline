package airline.mockData;

import airline.aircrafts.Airplane;
import airline.flights.Flight;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lucivalsn
 */
public class FlightData {
    private ArrayList<Airplane> airplanes;
    private int flightsToCreate = 8;
    
    public FlightData(ArrayList airplanes){
        this.airplanes = airplanes;        
    }
    
    /**
     * Generates a random list of flights randomly
     * @return ArrayList<Flight> flights
     */
    public ArrayList<Flight> generateFlights(){
        ArrayList<Flight> flights = new ArrayList<>();
        String[] origins = {"Rio de Janeiro", "São Paulo", "Lisbon", "London"};
        String[] destinations = {"Dublin","Amsterdam","Miami","Tokyo"};
        String[] departureTimes = {"10:10", "09:40","08:20","07:00"};
        String[] arrivalTimes = {"13:10","14:05","15:45","19:55"};
        String[] dates = {"02/01/2018","23/09/2018","17/02/2018","25/12/2018"};

        Random rand = new Random(); 
        
        for(int i = 0; i < flightsToCreate; i++){
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
}
