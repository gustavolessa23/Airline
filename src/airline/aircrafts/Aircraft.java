/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.aircrafts;

import airline.employees.Pilot;

/**
 * Creates an Aircraft object
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
     * @param make (String)
     * @param model (String)
     * @param capacity (int)
     * @param pilot (Pilot)
     */
    public Aircraft(String make, String model, int capacity, Pilot pilot) {
        this.id = ++lastId;
        this.make = make;
        this.model = model;
        this.capacity = capacity;
        this.pilot = pilot;
    }
    /**
     * This method gets Aircraft id value
     * @return An int with the Aircraft id value
     */
    public int getId() {
        return id;
    }
    
    /**
     * This method gets Aircraft make value
     * @return A String with the Aircraft make value
     */
    public String getMake() {
        return make;
    }

    /**
     * This method receives a String to set Aircraft make variable
     * @param make(String) 
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * This method gets Aircraft model value
     * @return A String with the Aircraft model value
     */
    public String getModel() {
        return model;
    }

    /**
     * This method receives a String to set Aircraft model variable
     * @param model(String)
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * This method gets Aircraft capacity value
     * @return An int with the Aircraft capacity value
     */
    public int capacity() {
        return capacity;
    }

    /**
     * This method receives an int to set Aircraft capacity variable
     * @param capacity(int)
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    /**
     * This method get the assign Pilot object for the aircraft. 
     * @return The aircraft's assigned pilot.
     */
    public Pilot getPilot(){
        return this.pilot;
    }

    /**
     * This method gets Aircraft pilot's name value
     * @return A String with the Aircraft pilot's name value
     */
    public String getPilotName() {
        return pilot.getName();
    }

    /**
     * Receives a Pilot object to set Aircraft pilot variable
     * @param pilot (Pilot)
     */
    public void assignPilot(Pilot pilot){
        this.pilot = pilot;
    }
}
