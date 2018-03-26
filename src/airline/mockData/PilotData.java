package airline.mockData;

import airline.employees.Pilot;
import airline.employees.Rating;
import java.util.ArrayList;

/**
 *
 * @author rbsrafa
 */
public class PilotData {
    
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
}
