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
 * Create Aircraft object
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
     * Gets Aircraft id value
     * @return return an int with the Aircraft id value
     */
    public int getId() {
        return id;
    }
    
    /**
     * Gets Aircraft make value
     * @return return a String with the Aircraft make value
     */
    public String getMake() {
        return make;
    }

    /**
     * Receives a String to set Aircraft make variable
     * @param make(String) 
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets Aircraft model value
     * @return return a String with the Aircraft model value
     */
    public String getModel() {
        return model;
    }

    /**
     * Receives a String to set Aircraft model variable
     * @param model(String)
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets Aircraft capacity value
     * @return return an int with the Aircraft capacity value
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Receives an int to set Aircraft capacity variable
     * @param capacity(int)
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public Pilot getPilot(){
        return this.pilot;
    }

    /**
     * Gets Aircraft pilot's name value
     * @return return a String with the Aircraft pilot's name value
     */
    public String getPilotName() {
        return pilot.getName();
    }

    /**
     * Receives a Pilot object to set Aircraft pilot variable
     * @param pilot(Pilot)
     */
    public void assignPilot(Pilot pilot){
        this.pilot = pilot;
    }
}
