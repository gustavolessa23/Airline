/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.aircrafts;

import airline.employees.Pilot;

/**
 * @author lucivalsn
 * 
 * Create Airplane objects
 */
public class Airplane extends Aircraft {
    
    /**
     * Builds an Airplane object calling the super constructor 
     * and send the following parameters
     * @param make(String)
     * @param model(String)
     * @param capacity(int)
     * @param pilot(Pilot)
     */
    public Airplane(String make, String model, int capacity, Pilot pilot){
        super(make, model, capacity, pilot);
    }
    
    /**
     * Display values stored on an Airplane object.
     * Attributes stored id, make, model, capacity and pilot name.
     * @return a String in a text box format 
     * representing the menu options for the user.
     */
    @Override
    public String toString(){
        return
               "+-------------------------------+\n" +
               "| Airplane Info                 |\n" +
               "+-------------------------------+\n" +
               " ID: " + this.id + "\n" + 
               " Aircraft: " + this.make + " " + this.model + "\n" + 
               " Capacity: " + this.capacity + " seats\n" +
               " Pilot Name: " + this.pilot.getName() + "\n" +  
               "+-------------------------------+\n\n" +
               "|||||||||||||||||||||||||||||||||\n";
    }
}
