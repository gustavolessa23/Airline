/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.aircrafts;

import airline.employees.Pilot;

/**
 *
 * @author lucivalsn
 */
public class Airplane extends Aircraft {
    
    public Airplane(String make, String model, int capacity, Pilot pilot){
        super(make, model, capacity, pilot);        
    }
    
    /**
     * Display detailed Airplane information
     * @return 
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
