package airline.mockData;

import airline.aircrafts.Airplane;
import airline.employees.Pilot;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lucivalsn
 */
public class AirplaneData {
    private ArrayList<Airplane> airplanes;
    private ArrayList<Pilot> pilots;
    
    public AirplaneData(ArrayList p){
        this.pilots = p;        
    }
    
    /**
     * Generates a random list of airplanes from the 
     * provided list details
     * @return airplanes
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
}
