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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

/**
 *
 * @author gustavolessadublin
 */
public class FlightMenu extends Menu{
    private DateFormat formatTime = new SimpleDateFormat("HH:mm");
    private DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public FlightMenu(Data data){
        super(data);
        while(!exit){
            displayMenu(this);
            optionSelector();
        }
    }

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
    
    private int checkFlightIdPosition(int id){
        for(int x = 0; x < super.data.getFlights().size(); x++){
            if(this.data.getFlights().get(x).getId() == id){
                return x;
            }
        }
        return -1;
    }

    private void displayFlights() {
        for(Flight f: super.data.getFlights()){
            System.out.println(f);
            System.out.println("|||||||||||||||||||||||||||||||||");
        }
    }
    
    private void setFlightTimes(int flightPosition) {
        Date newDeparture = printChooseDepartureTime();
        Date newArrival = printChooseArrivalTime();
        
        if(newArrival.after(newDeparture)){ //can throw exception instead
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
    
    private int printChooseFlightId(){
        System.out.println("\nFlights in the system:");
        for(Flight f: super.data.getFlights()){
            System.out.print(f.getId()+" ");
        }
        System.out.print("\nPlease select a Flight ID: ");
        int response = validate.checkForInt(input, 1, super.data.getFlights().size());
        return checkFlightIdPosition(response);
    }

    private Date printChooseDepartureTime() {
        System.out.println("\nType the desired departure time (HH:mm): ");
        Date response = validate.checkForTime(input);
        return response;
    }
    
    private Date printChooseArrivalTime() {
        System.out.println("\nType the desired arrival time (HH:mm): ");
        Date response = validate.checkForTime(input);
        return response;
    }

    private void displayFlightInfo(int flightPosition) {
        System.out.println(super.data.getFlights().get(flightPosition));
    }

    private void addFlight() {
        String origin = "";
        String destination = "";
        Date date = null;
        Aircraft aircraft = null;
        System.out.println("\nNew flight");
        System.out.println("\nType the desired origin: ");
        origin = validate.checkForString(input);
        System.out.println("Type the desired destination: ");
        destination = validate.checkForString(input);
        System.out.println("Type the desired departure date (DD/MM/YYYY): ");
        date = validate.checkForDate(input);
        aircraft = printChooseAircraft();
        super.data.getFlights().add(new Flight(origin,destination,formatDate.format(date),aircraft));
        System.out.println("Flight created");
        System.out.println(super.data.getFlights().get(super.data.getFlights().size()-1));
        if(addScheduleOption()){
            setFlightTimes((super.data.getFlights().size()-1));
        }
    }
    
    private Airplane printChooseAircraft(){
        System.out.println("\nAircrafts in the system:");
        for(int x = 0; x < super.data.getAirplanes().size(); x++){
            System.out.println((x+1)+" - "+super.data.getAirplanes().get(x).getMake()+" "+super.data.getAirplanes().get(x).getModel());
        }
        System.out.print("\nPlease select an option: ");       
        int option = validate.checkForInt(input, 1, super.data.getAirplanes().size());
        return super.data.getAirplanes().get(option-1);
    }
    
    private boolean addScheduleOption(){
        System.out.println("\nWould you like to set schedule information? (Y/N)");
        return validate.checkForYes(input);   
    }
   
}
