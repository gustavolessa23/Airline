package airline.menus;

import airline.data.Data;

/**
 *
 * @author rbsrafa
 */
public class MainMenu extends Menu{
    
    /**
     * This method initialises a new MainMenu instance.
     * @param data (Data)
     */
    public MainMenu(Data data){
        super(data);       
        while(!exit){
            this.displayMenu(this);
            this.optionSelector();
        }
    }
    
    /**
     * This method prints the MainMenu options on CLI.
     * @return A formatted String with the menu options
     */
    @Override
    public String toString() {
        return
            "\n+--------------------------+\n" +
            "| Welcome to CCT Air       |\n" +
            "|--------------------------|\n" +  
            "| 1 - Flights              |\n" +
            "| 2 - Airplanes            |\n" +
            "| 3 - Pilots               |\n" + 
            "| 4 - Exit Program         |\n" +        
            "+--------------------------+\n" +
            "Please select an option: ";
    }

    /**
     * This method implements the MainMenu's options logic.
     */
    @Override
    public void optionSelector() {
        int option = this.validate.checkForInt(input);
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
