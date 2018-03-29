package airline.menus;


import airline.employees.Pilot;
import airline.data.Data;
import airline.employees.Rating;


/**
 *
 * @author rbsrafa
 */
public class PilotMenu extends Menu{
    
    /**
     * This constructor creates a new PilotMenu object.
     * @param data An object that contains three ArrayLists.
     */
    public PilotMenu(Data data){
        super(data);
        while(!exit){
            this.displayMenu(this);
            this.optionSelector();
        }
    }

    /**
     * This method implement the PilotMenu option selection logic.
     */
    @Override
    public void optionSelector() {
        int option = this.validate.checkForInt(input);
        switch (option) {
            case 1:
                this.displayPilots();
                break;
            case 2:
                this.searchPilot();
                break;
            case 3:
                this.addPilot();
                break;
            case 4:
                this.returnToMainMenu();
                break;
            case 5:
                this.exitProgram();
                break;
            default:
                System.out.println("\n*** Invalid option. Please try again ***\n");
                break;
        }
    }
    
    /**
     * This method returns the PilotMenu visualisation on CLI.
     * @return 
     */
    @Override
    public String toString(){
        return
            "\n+--------------------------+\n" +
            "| Pilots Menu              |\n" + 
            "+--------------------------+\n" +
            "| 1 - Show Pilot list      |\n" +
            "| 2 - Find Pilot by id     |\n" +
            "| 3 - Add new Pilot        |\n" +    
            "| 4 - Return to Main Menu  |\n" + 
            "| 5 - Exit Program         |\n" + 
            "+--------------------------+\n" +
            "Please select an option:   ";
    }
    
    /**
     * This method adds a new Pilot to the ArrayList of pilots.
     */
    public void addPilot(){
        input.nextLine();        
        System.out.println("Please type the pilot name:");
        String name = input.nextLine();
        selectRating(name);
    }
    
    /**
     * This method gets a user input for the Pilot's rating during its creation on addPilot method.
     * @param name
     * @param p 
     */
    public void selectRating(String name){
        System.out.println("Please type the pilot Rating:\nAvailable ratings: ");
        for(Rating r: Rating.values()){
            System.out.println(r+" (Max number of passengers: " + r.getPassengers() + ")");
        }
        String rating = input.nextLine();
        
        if(rating.startsWith("A") || rating.startsWith("a")){
            super.data.getPilots().add(new Pilot(name, Rating.A));
        }else if(rating.startsWith("B") || rating.startsWith("b")){
            super.data.getPilots().add(new Pilot(name, Rating.B));
        }else if(rating.startsWith("C") || rating.startsWith("c")){
            super.data.getPilots().add(new Pilot(name, Rating.C));
        }else if(rating.startsWith("D") || rating.startsWith("d")){
            super.data.getPilots().add(new Pilot(name, Rating.D));
        }else{
            System.out.println("\n*** Invalid option, please try again. ***\n");
            selectRating(name);
        } 
    }

    /**
     * This method displays a List of all Pilots.
     */
    public void displayPilots(){
        for(Pilot p: this.data.getPilots()){
            System.out.println(p);
        }
    }
    
    /**
     * This method searchs for a specific pilot and prints its details to CLI.
     */
    public void searchPilot(){
        Pilot foundPilot = null;
        System.out.println("Please type the pilot Id:");
        int id = this.validate.checkForInt(input);
        
        for(Pilot p: this.data.getPilots()){
            if(id == p.getId()) foundPilot = p;
        }
        if(foundPilot == null) System.out.println("\n*** Pilot not found! ***\n"); 
        else System.out.println(foundPilot);
        
    }
}
