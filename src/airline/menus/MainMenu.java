package airline.menus;



/**
 *
 * @author rbsrafa
 */
public class MainMenu extends Menu{
    
    public MainMenu(){
        while(!exit){
            this.displayMenu(this.toString());
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
                new FlightMenu();
                break;
            case 2:
                new AirplaneMenu();
                break;
            case 3:
                new PilotMenu();
                break;
            case 4:
                this.exitProgram();
            default:
                System.out.println("\n*** Invalid option. Please try again ***\n");
                break;
        }
    }
    
}
