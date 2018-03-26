package airline;

import airline.employees.Pilot;
import airline.aircrafts.Airplane;
import airline.menus.MainMenu;
import airline.mockData.PilotData;
import airline.mockData.AirplaneData;
import java.util.ArrayList;

/**
 *
 * @author rbsrafa
 */
public class CCTAir {
    public static ArrayList<Pilot> pilots;
    public static ArrayList<Airplane> airplanes;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PilotData pilotData = new PilotData();
        pilots = pilotData.generatePilots();
        AirplaneData airplaneData = new AirplaneData(pilots);
        airplanes = airplaneData.generateAirplanes();

        new MainMenu();    
    }
    
}
