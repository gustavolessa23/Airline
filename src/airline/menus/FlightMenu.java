/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.menus;


import airline.aircrafts.Aircraft;
import airline.aircrafts.Airplane;
import airline.flights.Flight;
import airline.data.Data;
import airline.flights.Location;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * This class is responsible for the Flight menu object, containing the methods
 *  to perform the required actions regarding the company's flights.
 * @author gustavolessadublin
 */
public class FlightMenu extends Menu{
    private DateFormat formatTime = new SimpleDateFormat("HH:mm");
    private DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * This constructor takes a Data object as argument to create a new Flight menu.
     * @param data (Data) - information about Pilots, Airplanes and Flights.
     */
    public FlightMenu(Data data){
        super(data);
        while(!exit){
            displayMenu(this);
            optionSelector();
        }
    }

    /**
     * This method implements inherited optionSelector() method signature in
     *  order to correctly execute the desired functions after validating the
     *  user input.
     */
    @Override
    public void optionSelector() {
        int option = validate.checkForInt(input);
        switch (option) {
            case 1:
                displayFlights();
                break;
            case 2:
                displayFlightInfo(printChooseFlightId());
                break;
            case 3:
                addFlight();
                break;
            case 4:
                setFlightArrivalTime(printChooseFlightId());
                break;
            case 5:
                setFlightTimes(printChooseFlightId());
                break;
            case 6:
                returnToMainMenu();
                break;         
            case 7:
                exitProgram();
                break;
            default:
                System.out.println("\n*** Invalid option. Please try again ***\n");
                break;
        }
    }
    
    /**
     * This method overrides the default toString() in order to display a menu
     *  when printed to the console.
     * @return A String representing a Flights menu.
     */
    @Override
    public String toString(){
        return
            "\n+-----------------------------------------------+\n" +
            "| Flights Menu                                  |\n" + 
            "+-----------------------------------------------+\n" +
            "| 1 - Show flight list                          |\n" +
            "| 2 - Show specific flight info                 |\n" +
            "| 3 - Add a flight                              |\n" +
            "| 4 - Update flight arrival time                |\n" +
            "| 5 - Update flight departure and arrival times |\n" + 
            "| 6 - Go back to main menu                      |\n" + 
            "| 7 - Exit Program                              |\n" + 
            "+-----------------------------------------------+\n" +
            "Please choose an option: ";
    }
    
    /**
     * This method takes a flight ID and returns the flight's position on the 
     * ArrayList that stores the Flights.
     * @param id (Integer) - a Flight ID.
     * @return An Integer representing the position of the flight on the ArrayList.
     */
    private int checkFlightIdPosition(int id){
        for(int x = 0; x < super.data.getFlights().size(); x++){
            if(this.data.getFlights().get(x).getId() == id){
                return x;
            }
        }
        return -1;
    }

    /**
     * This method uses a for-each loop to display all flights.
     */
    private void displayFlights() {
        for(Flight f: super.data.getFlights()){
            System.out.println(f);
            System.out.println("|||||||||||||||||||||||||||||||||");
        }
    }
    
    /**
     * This method sets a flight's schedule times by calling printChooseDepartureTime()
     *  and printChooseArrivalTime() methods, checking if the arrival time is 
     *  after the departure time and calling the Flight method schedule(String, String).
     * @param flightPosition 
     */
    private void setFlightTimes(int flightPosition) {
        Date newDeparture = printChooseDepartureTime();
        Date newArrival = printChooseArrivalTime();
        
        if(newArrival.after(newDeparture)){ 
            this.data.getFlights().get(flightPosition).schedule(formatTime.format(newArrival),formatTime.format(newDeparture));
            System.out.println("\nFlight "+super.data.getFlights().get(flightPosition).getId()+
                    " schedule updated.");
            System.out.println("Departure: "+super.data.getFlights().get(flightPosition).getDepartureTime());
            System.out.println("Arrival: "+super.data.getFlights().get(flightPosition).getArrivalTime());
        } else {
            System.out.println("The arrival time should be after the departure"
                    + " time.");
            setFlightTimes(flightPosition);
        }
    }

    /**
     * This method sets the arrival time of a flight according to the user input
     * by calling the printChooseArrivalTime() method to retrieve the desired time,
     *  parsing it to String and calling the Flight method schedule(String),
     *  after checking if the departure time was already
     *  set and if the arrival time is after the departure time.
     * @param flightPosition (Integer) - Position in the ArrayList of the desired
     *  flight.
     */
    private void setFlightArrivalTime(int flightPosition) {
        if(super.data.getFlights().get(flightPosition).getDepartureTime() != null){
            Date newArrival = printChooseArrivalTime();
            Date departure = null;
            try{
                departure = formatTime.parse(super.data.getFlights().get(flightPosition).getDepartureTime());
            } catch (ParseException e) {
                System.out.println("Incorrect format, the date should be HH:mm");
            }

            if(newArrival.after(departure)){
                super.data.getFlights().get(flightPosition).schedule(formatTime.format(newArrival));
                System.out.println("\nFlight "+super.data.getFlights().get(flightPosition).getId()+
                    " arrival time updated to "+super.data.getFlights().get(flightPosition).getArrivalTime());
            } else {
                System.out.println("The arrival time should be after the departure "
                    + "time.");
                setFlightArrivalTime(flightPosition);
            }
        }else{
            System.out.println("\nDeparture time must be set before arrival time.");
        }
    }
    
    /**
     * This method displays a list of existing flight IDs, calls a method to check
     *  the position of the flight on the ArrayList and returns the validated 
     *  input.
     * @return An Integer representing the position on the ArrayList of the
     *  flight ID chosen.
     */
    private int printChooseFlightId(){
        System.out.println("\nFlights in the system:");
        for(Flight f: super.data.getFlights()){
            System.out.print(f.getId()+" ");
        }
        System.out.print("\nPlease select a Flight ID: ");
        int response = validate.checkForInt(input, 1, super.data.getFlights().size());
        return checkFlightIdPosition(response);
    }
    /**
     * This method asks the user to input the departure time, calls a time validation
     * method on the input and returns it as a Date object.
     * @return A Date object representing the typed departure time.
     */
    private Date printChooseDepartureTime() {
        System.out.println("\nType the desired departure time (HH:mm): ");
        Date response = validate.checkForTime(input);
        return response;
    }
    
    /**
     * This method asks the user to input the arrival time, calls a time validation
     * method on the input and returns it as a Date object.
     * @return A Date object representing the typed arrival time.
     */
    private Date printChooseArrivalTime() {
        System.out.println("\nType the desired arrival time (HH:mm): ");
        Date response = validate.checkForTime(input);
        return response;
    }

    /**
     * This method displays a flight's information (specified in it's toString() 
     *  method.
     * @param flightPosition (Integer) - An option from the flights list.
     */
    private void displayFlightInfo(int flightPosition) {
        System.out.println(super.data.getFlights().get(flightPosition));
    }

    /**
     * This method creates and adds a new flight to the system calling other 
     * methods that ask for user input and validate them in order to fulfill the needed arguments 
     * for the Flight constructor, and finally gives the user the choice of adding
     *  schedule times for the newly created flight.
     */
    private void addFlight() {
        Location origin = null;
        Location destination = null;
        Date date = null;
        Aircraft aircraft = null;
        System.out.println("\n---NEW FLIGHT CREATION---");
        System.out.println("\nSelect the desired origin: ");
        origin = printChooseLocation();
        destination = printChooseDestination(origin);
        System.out.println("\nType the desired departure date (DD/MM/YYYY): ");
        date = validate.checkForDate(input);
        aircraft = printChooseAircraft();
        super.data.getFlights().add(new Flight(origin,destination,formatDate.format(date),aircraft));
        System.out.println("Flight created!");
        System.out.println(super.data.getFlights().get(super.data.getFlights().size()-1));
        if(addScheduleOption()){
            setFlightTimes((super.data.getFlights().size()-1));
        }
    }
    
    /**
     * This method allows the user to choose an Airplane from a displayed list of 
     * aircrafts and returns the chosen option.
     * @return An Airplane object chosen by the user.
     */
    private Airplane printChooseAircraft(){
        System.out.println("\nAircrafts in the system:");
        for(int x = 0; x < super.data.getAirplanes().size(); x++){
            System.out.println((x+1)+" - "+super.data.getAirplanes().get(x).getMake()+" "+super.data.getAirplanes().get(x).getModel());
        }
        System.out.print("\nPlease select an option: ");       
        int option = validate.checkForInt(input, 1, super.data.getAirplanes().size());
        return super.data.getAirplanes().get(option-1);
    }
    
    /**
     * This method asks the user if he/she wants to set schedule times for a new
     *  flights that is being created, validates the answer through checkForYes()
     *  method and returns the chosen option as a boolean.
     * @return True if user wants to set the schedule, false otherwise.
     */
    private boolean addScheduleOption(){
        System.out.println("\nWould you like to set schedule information? (Y/N)");
        return validate.checkForYes(input);   
    }
    
    /**
     * This method allows the user to choose a location from a list by retrieving
     *  all Location enum options and names (values), displaying them on console,
     * retrieving the input option and returning the chosen Location.
     * @return A Location representing the location chosen by the user.
     */
    private Location printChooseLocation(){
        String[] cities = Location.getAllNames();
        Location[] locations = Location.getAllOptions();
        System.out.println("");
        for(int x = 0; x < cities.length; x++){
            System.out.println((x+1)+" - "+cities[x]);
        }
        System.out.print("\nPlease choose an option: ");
        int response = validate.checkForInt(input, 1, locations.length);
        return locations[response-1];
    }

    /**
     * This method takes a Location representing the origin of a flight, calls 
     * the printChooseLocation() method, stores the returned Location, calls the
     *  validation method isDiferentLocation() to verify if the origin and destination
     *  locations are the same and, if they are different, it returns the chosen destination.
     * @param origin (Location) - The flight's origin.
     * @return A location chosen by the user as destination.
     */
    private Location printChooseDestination(Location origin) {
        System.out.println("\nSelect the desired destination: ");
        Location destination = printChooseLocation();
        if(validate.isDiferentLocation(origin, destination)){
            return destination;
        } else {
            System.out.println("\n ---Origin and destination cannot be the same.---"
                    + "\nPlease try again.");
            return printChooseDestination(origin);
        }
    }
    
    
   
}
