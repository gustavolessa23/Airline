/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.menus;

import airline.CCTAir;
import airline.aircrafts.Airplane;
import java.util.ArrayList;

/**
 *
 * @author lucivalsn
 */
public class AirplaneMenu extends Menu{
    ArrayList<Airplane> airplanes;
    
    public AirplaneMenu(){
        airplanes = CCTAir.airplanes;
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
                this.displayAirplanes();
                break;
            case 2:
                this.searchAirplane();
                break;
            case 3:
                this.assignPilot();
                break;
            case 4:
                this.returnToMainMenu();
                break;
            case 5:
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
            "| Airplanes Menu           |\n" + 
            "+--------------------------+\n" +
            "| Please select an option: |\n" +
            "|                          |\n" +
            "| 1 - Show Airplanes list  |\n" +
            "| 2 - Find Airplane by id  |\n" +
            "| 3 - Assign Pilot         |\n" +
            "| 4 - Return to Main Menu  |\n" + 
            "| 5 - Exit Program         |\n" + 
            "+--------------------------+\n";
    }

    private void displayAirplanes() {
        for(Airplane a: CCTAir.airplanes){
            System.out.println(a.toString());
        }
    }

    private void searchAirplane() {
        
    }

    private void assignPilot() {
        
    }
    
    public void returnToMainMenu(){
        new MainMenu();
    }
}
