package airline.menus;

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
    
    public abstract void optionSelector();
    
    public void displayMenu(String menu){
        System.out.println(menu);
    }
    
    public void exitProgram(){
        System.exit(0);
    }
}
