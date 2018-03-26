package airline;

import airline.employees.Pilot;
import airline.aircrafts.Airplane;
import airline.flights.Flight;
import airline.menus.MainMenu;
import airline.mockData.PilotData;
import airline.mockData.AirplaneData;
import airline.mockData.FlightData;
import java.util.ArrayList;

/**
 *
 * @author rbsrafa
 */
public class CCTAir {
    public static ArrayList<Pilot> pilots;
    public static ArrayList<Airplane> airplanes;
    public static ArrayList<Flight> flights;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PilotData pilotData = new PilotData();
        pilots = pilotData.generatePilots();
        AirplaneData airplaneData = new AirplaneData(pilots);
        airplanes = airplaneData.generateAirplanes();
        FlightData flightData = new FlightData(airplanes);
        flights = flightData.generateFlights();

        new MainMenu();    
    }
    
}
