/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.menus;

import airline.CCTAir;
import airline.aircrafts.Airplane;
import airline.employees.Pilot;
import java.util.ArrayList;

/**
 *
 * @author lucivalsn
 */
public class AirplaneMenu extends Menu{
    ArrayList<Airplane> airplanes;
    ArrayList<Pilot> pilots;
    
    /**
     * Build a Menu with options to manage Airplane objects
     */
    public AirplaneMenu(){
        airplanes = CCTAir.airplanes;
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
                this.displayAirplanes();
                break;
            case 2:
                Airplane aId = this.searchAirplane();
                System.out.println(aId.toString());
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
    
    /**
     * Display an option Menu to manage Airplane object.
     * @return a String in a text box format 
     * representing the menu options for the user.
     */
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
            "| 3 - Assign Pilot by id   |\n" +
            "| 4 - Return to Main Menu  |\n" + 
            "| 5 - Exit Program         |\n" + 
            "+--------------------------+\n";
    }

    /**
     * Display all the Airplane objects stored in the list
     */
    private void displayAirplanes() {
        for(Airplane a: CCTAir.airplanes){
            System.out.println(a);
        }
    }

    /**
     * Search an Airplane object using the id reference.
     * A valid id must be input by the user
     * @return Returns an Airplane object
     */
    private Airplane searchAirplane() {
        Airplane searchAirplaneId = null;
        System.out.println("Please type the airplane Id:");
        int id = this.checkForInt();
        
        for(Airplane a: airplanes){
            if(id == a.getId()) searchAirplaneId = a;
        }
        if(searchAirplaneId == null) System.out.println("\n*** Airplane not found! ***\n"); 
        //else System.out.println(searchAirplaneId.toString());
        return searchAirplaneId;
    }

    /**
     * Search a Pilot object using the id reference.
     * Search an Airplane object using the id reference.
     * A valid id must be input by the user in both cases.
     * The designed Pilot is then assigned to the designed Airplane.
     * Any previous Pilot assigned will be lost.
     */
    private void assignPilot() {
        Pilot pilotToAssign = null;
        Airplane airplaneToAssign = null;
        System.out.println("Please type the pilot Id:");
        int pilotId = this.checkForInt();
        
        for(Pilot p: pilots){
            if(pilotId == p.getId()) pilotToAssign = p;
        }
        if(pilotToAssign == null) System.out.println("\n*** Pilot not found! ***\n");
        
        airplaneToAssign = this.searchAirplane();
        airplaneToAssign.assignPilot(pilotToAssign);
        System.out.println(airplaneToAssign.toString());
    }
    
    /**
     * Returns to main menu screen
     */
    public void returnToMainMenu(){
        new MainMenu();
    }
}
