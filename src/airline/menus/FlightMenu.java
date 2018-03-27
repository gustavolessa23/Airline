/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.menus;

import airline.CCTAir;
import airline.flights.Flight;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gustavolessadublin
 */
public class FlightMenu extends Menu{
    ArrayList<Flight> flights;
    DateFormat fmt = new SimpleDateFormat("HH:mm");
    
    public FlightMenu(){
        flights = CCTAir.flights;
        while(!exit){
            displayMenu(this);
            optionSelector();
        }
    }

    @Override
    public void optionSelector() {
        int option = checkForInt();
        switch (option) {
            case 1:
                displayFlights();
                break;
            case 2:
                displayFlightInfo(printChooseFlightId());
                break;
            case 3:
                setFlightArrivalTime(printChooseFlightId());
                break;
            case 4:
                setFlightTimes(printChooseFlightId());
                break;
            case 5:
                returnToMainMenu();
                break;         
            case 6:
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
//            "\n+-----------------------------------------------+\n" +
//            "| Flights Menu                                   |\n" + 
//            "+-----------------------------------------------+\n" +
//            "| Please select an option:                      |\n" +
//            "|                                               |\n" +
//            "| 1 - Show flights list                         |\n" +
//            "| 2 - Show specific flight info                 |\n" +
//            "| 3 - Update flight arrival time                |\n" +
//            "| 4 - Update flight departure and arrival times |\n" + 
//            "| 5 - Go back to main menu                      |\n" + 
//            "| 6 - Exit Program                              |\n" + 
//            "+-----------------------------------------------+";
            "\n+-----------------------------------------------+\n" +
            "| Flights Menu                                   |\n" + 
            "+-----------------------------------------------+\n" +
            "| 1 - Show flights list                         |\n" +
            "| 2 - Show specific flight info                 |\n" +
            "| 3 - Update flight arrival time                |\n" +
            "| 4 - Update flight departure and arrival times |\n" + 
            "| 5 - Go back to main menu                      |\n" + 
            "| 6 - Exit Program                              |\n" + 
            "+-----------------------------------------------+\n" +
            "Please choose an option: ";
    }
    
    private int checkFlightIdPosition(int id){
        for(int x = 0; x < flights.size(); x++){
            if(flights.get(x).getId() == id){
                return x;
            }
        }
        return -1;
    }

    private void displayFlights() {
        for(Flight f: CCTAir.flights){
            System.out.println(f);
            System.out.println("|||||||||||||||||||||||||||||||||");
        }
    }
    
    
    private void setFlightTimes(int flightPosition) {
        Date newDeparture = printChooseDepartureTime();
        Date newArrival = printChooseArrivalTime();
        
        if(newArrival.after(newDeparture)){ //can throw exception instead
            flights.get(flightPosition).schedule(fmt.format(newArrival),fmt.format(newDeparture));
            System.out.println("\nFlight "+flights.get(flightPosition).getId()+
                    " schedule updated.");
            System.out.println("Departure: "+flights.get(flightPosition).getDepartureTime());
            System.out.println("Arrival: "+flights.get(flightPosition).getArrivalTime());
        } else {
            System.out.println("The arrival time should be after the departure"
                    + "time.");
            setFlightTimes(flightPosition);
        }
    }

    private void setFlightArrivalTime(int flightPosition) {
        Date newArrival = printChooseArrivalTime();
        Date departure = null;
        
        try{
            departure = fmt.parse(flights.get(flightPosition).getDepartureTime());
        } catch (ParseException e) {
            System.out.println("Incorrect format, the date should be HH:mm "
                + "(this means hours (00-23) and minutes (00-59)!");
        }
       
        if(newArrival.after(departure)){
            flights.get(flightPosition).schedule(fmt.format(newArrival));
            System.out.println("\nFlight "+flights.get(flightPosition).getId()+
                " arrival time updated to "+flights.get(flightPosition).getArrivalTime());
        } else {
            System.out.println("The arrival time should be after the departure"
                + "time.");
            setFlightArrivalTime(flightPosition);
        }

    }
    
    private int printChooseFlightId(){
        System.out.println("\nFlights in the system:");
        for(Flight f: CCTAir.flights){
            System.out.print(f.getId()+" ");
        }
        System.out.print("\nPlease choose a Flight ID: ");
        int response = checkForInt();
        return checkFlightIdPosition(response);
    }

    private Date printChooseDepartureTime() {
        System.out.println("\nType the desired departure time: ");
        Date response = checkForTime();
        return response;
    }
    
    private Date printChooseArrivalTime() {
        System.out.println("\nType the desired arrival time: ");
        Date response = checkForTime();
        return response;
    }
    
    //falar sobre data (deixar ano 1970?)

    private void displayFlightInfo(int flightPosition) {
        System.out.println(flights.get(flightPosition));
    }
   
}
