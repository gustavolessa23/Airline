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
public abstract class Aircraft {    
    protected final int id;
    protected static int lastId = 0;
    protected String make;
    protected String model;
    protected int capacity;
    protected Pilot pilot;

    /**
     * Aircraft constructor receives the arguments
     * and sets the following parameters
     * @param make
     * @param model
     * @param capacity
     * @param pilot 
     */
    public Aircraft(String make, String model, int capacity, Pilot pilot) {
        this.id = ++lastId;
        this.make = make;
        this.model = model;
        this.capacity = capacity;
        this.pilot = pilot;
    }
    
    /**
     * Getter and Setter methods for following parameters
     * make, model, capacity and pilot
     * @return make, model, capacity and pilot.name values
     */
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int capacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPilot() {
        return pilot.getName();
    }

    public void assignPilot(Pilot pilot){
        this.pilot = pilot;
    }
}
