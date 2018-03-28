package airline.menus;

import airline.data.Data;




/**
 *
 * @author rbsrafa
 */
public class MainMenu extends Menu{
    
    public MainMenu(Data data){
        super(data); 
        
        while(!exit){
            this.displayMenu(this);
            this.optionSelector();
        }
    }
    
    @Override
    public String toString() {
        return
            "+--------------------------+\n" +
            "| Welcome to CCT Air       |\n" +
            "|--------------------------|\n" +
            "| Please select an option: |\n" +
            "|                          |\n" +        
            "| 1 - Flights              |\n" +
            "| 2 - Airplanes            |\n" +
            "| 3 - Pilots               |\n" + 
            "| 4 - Exit Program         |\n" +        
            "+--------------------------+";
    }

    @Override
    public void optionSelector() {
        int option = this.checkForInt();
        switch (option) {
            case 1:
                new FlightMenu(this.data);
                break;
            case 2:
                new AirplaneMenu(this.data);
                break;
            case 3:
                new PilotMenu(this.data);
                break;
            case 4:
                this.exitProgram();
            default:
                System.out.println("\n*** Invalid option. Please try again ***\n");
                break;
        }
    }
    
}
