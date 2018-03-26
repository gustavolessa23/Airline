package airline.mockData;

import airline.employees.Pilot;
import airline.employees.Rating;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rbsrafa
 */
public class PilotData {
    private ArrayList<Pilot> pilots;
    
    public ArrayList<Pilot> generatePilots(){
        ArrayList<Pilot> pilots = new ArrayList<>();
        String[] names = {"Rafael Barros", "Lucival Nascimento", "Gustavo Lessa", "Mark Dontknow"};
        Rating[] ratings = {Rating.A, Rating.B, Rating.C, Rating.D};
        Random rand = new Random();
        
        for(int i = 0; i < names.length; i++){
            Pilot p = new Pilot(names[i], ratings[i]);
            pilots.add(p);
        }
        return pilots;
    }
}
