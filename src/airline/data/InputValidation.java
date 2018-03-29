/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author gustavolessa1
 */
public class InputValidation {
    
    public InputValidation(){
        
    }
    
    public int checkForInt(Scanner input){
        try{return input.nextInt();}
        catch(InputMismatchException e){
            input.next();
            System.out.println("\n*** Input is not a integer. Please try again. ***\n");
            return -1;
        }
    }
 
    public boolean checkForYes(Scanner input){
        String answer = "";
        try{
            while(answer.isEmpty()){
                answer = input.nextLine();
            }
            if(answer.startsWith("y") || answer.startsWith("Y")){
                return true;
            } else {
                return false;
            }
            } catch(InputMismatchException e){
            System.out.println("\n*** Input is not a integer. Please try again. ***\n");
            return checkForYes(input);
        }
    }
    
    public String checkForString(Scanner input){
        String answer = "";
        try{
            while(answer.isEmpty()){
                answer = input.nextLine();
            }
            return answer;
            } catch(InputMismatchException e){
            System.out.println("\n*** Input is not valid. Please try again. ***\n");
            return checkForString(input);
        }
    }
    
    public int checkForInt(Scanner input, int lowerBondary, int upperBondary){
        int typedInt = 0;
        try{
            while(typedInt == 0){
                typedInt = input.nextInt();
            }
            if(typedInt>=lowerBondary && typedInt<=upperBondary){
                return typedInt;
            }else{
                System.out.println("\n*** The option should be and integer between "+
                        lowerBondary+" and "+upperBondary+". ***\n");
                System.out.println("Please try again:");
                return checkForInt(input, lowerBondary,upperBondary);
            }
        } catch(InputMismatchException e){
            System.out.println("\n*** Input is not an integer. ***\nPlease try again.\n");
            input.nextLine();
            return checkForInt(input, lowerBondary,upperBondary);
        }
    }
    
    public Date checkForDate(Scanner input){ 
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        fmt.setLenient(false);
        
        try {
            String typedDate = input.nextLine();
            Date correctDate = fmt.parse(typedDate);
            return correctDate;
        } catch (ParseException e) {
            System.out.println("Date format should be DD/MM/YYYY. Try again.");
            return checkForDate(input);
        }
    }
    
    /**
     * Checks input line for a date formatted as HH:mm.
     * If not correct, the method calls itself until the user input is accepted
     * @return String correctDate
     */
    public Date checkForTime(Scanner input){ //maybe mudar esse método pra aceitar argumento (precisei quase da mesma coisa na classe FlightMenu)
        DateFormat fmt = new SimpleDateFormat("HH:mm");
        fmt.setLenient(false);
        String typedTime = "";
        
        try {
            while(typedTime.isEmpty()){
                typedTime = input.nextLine();
            }
            Date correctDate = fmt.parse(typedTime);
            return correctDate;
        } catch (ParseException e) {
            System.out.println("The time format should be (HH:mm).\nPlease try again:");
            return checkForTime(input);
        }
    }

}
