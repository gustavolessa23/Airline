package airline.menus;

import airline.CCTAir;
import airline.employees.Pilot;
import java.util.ArrayList;

/**
 *
 * @author rbsrafa
 */
public class PilotMenu extends Menu{
    ArrayList<Pilot> pilots;
    
    public PilotMenu(){
        pilots = CCTAir.pilots;
        while(!exit){
            this.displayMenu(this.toString());
            this.optionSelector();
        }
    }

    @Override
    public void optionSelector() {
        int option = this.checkForInt();
        switch (option) {
            case 1:
                this.displayPilots();
                break;
            case 2:
                this.searchPilot();
                break;
            case 3:
                this.returnToMainMenu();
                break;
            case 4:
                this.exitProgram();
                break;
            default:
                System.out.println("\n*** Invalid option. Please try again ***\n");
                break;
        }
    }
    
    @Override
    public String toString(){
        return
            "+--------------------------+\n" +
            "| Pilots Menu              |\n" + 
            "+--------------------------+\n" +
            "| Please select an option: |\n" +
            "|                          |\n" +
            "| 1 - Show Pilots list     |\n" +
            "| 2 - Find Pilot by id     |\n" +
            "| 3 - Return to Main Menu  |\n" + 
            "| 4 - Exit Program         |\n" + 
            "+--------------------------+\n";
    }

    public void displayPilots(){
        for(Pilot p: CCTAir.pilots){
            System.out.println(p.toString());
        }
    }
    
    public void searchPilot(){
        Pilot foundPilot = null;
        System.out.println("Please type the pilot Id:");
        int id = this.checkForInt();
        
        for(Pilot p: pilots){
            if(id == p.getId()) foundPilot = p;
        }
        if(foundPilot == null) System.out.println("\n*** Pilot not found! ***\n"); 
        else System.out.println(foundPilot.toString());
        
    }
    
    public void returnToMainMenu(){
        new MainMenu();
    }
}
