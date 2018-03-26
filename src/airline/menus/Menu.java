package airline.menus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rbsrafa
 */
public abstract class Menu {
    protected Scanner input;
    protected boolean exit;
    
    public Menu(){
        input = new Scanner(System.in);
        exit = false;
    }
    
    public int checkForInt(){
        try{return input.nextInt();}
        catch(InputMismatchException e){
            input.next();
            System.out.println("\n*** Input is not a integer. Please try again. ***\n");
            return -1;
        }
    }
    
    /**
     * Checks input line for a date formatted as HH:mm.
     * If not correct, the method calls itself until the user input is accepted
     * @return String correctDate
     */
    public Date checkForTime(){ //maybe mudar esse método pra aceitar argumento (precisei quase da mesma coisa na classe FlightMenu)
        DateFormat fmt = new SimpleDateFormat("HH:mm");
        fmt.setLenient(false);
        
        try {
            String typedTime = input.nextLine();
            Date correctDate = fmt.parse(typedTime);
            return correctDate;
        } catch (ParseException e) {
//1         + "(this means hours (00-23) and minutes (00-59)!");
            return checkForTime();
        }
    }
    
    public abstract void optionSelector();
    
    //perguntar da necessidade desse método
    public void displayMenu(String menu){
        System.out.println(menu);
    }
    
    public void exitProgram(){
        System.exit(0);
    }
}
