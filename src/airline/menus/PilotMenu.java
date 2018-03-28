package airline.menus;


import airline.employees.Pilot;
import airline.data.Data;
import airline.employees.Rating;


/**
 *
 * @author rbsrafa
 */
public class PilotMenu extends Menu{
    
    public PilotMenu(Data data){
        super(data);
        while(!exit){
            this.displayMenu(this);
            this.optionSelector();
        }
    }

    @Override
    public void optionSelector() {
        int option = this.checkForInt();
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
    
    @Override
    public String toString(){
        return
            "\n+--------------------------+\n" +
            "| Pilots Menu              |\n" + 
            "+--------------------------+\n" +
            "| 1 - Show Pilots list     |\n" +
            "| 2 - Find Pilot by id     |\n" +
            "| 3 - Add new Pilot        |\n" +    
            "| 4 - Return to Main Menu  |\n" + 
            "| 5 - Exit Program         |\n" + 
            "+--------------------------+\n" +
            "Please select an option:   ";
    }
    
    public void addPilot(){
        Pilot p = null;
        input.nextLine();        
        System.out.println("Please type the pilot name:");
        String name = input.nextLine();
        System.out.println("Please type the pilot Rating:\nAvailable ratings: ");
        for(Rating r: Rating.values()){
            System.out.println(r+" (Max number of passengers: " + r.getPassengers() + ")");
        }
        String rating = input.nextLine();
        
        if(rating.startsWith("A") || rating.startsWith("a")){
            p = new Pilot(name, Rating.A);
        }else if(rating.startsWith("B") || rating.startsWith("b")){
            p = new Pilot(name, Rating.B);
        }else if(rating.startsWith("C") || rating.startsWith("c")){
            p = new Pilot(name, Rating.C);
        }else if(rating.startsWith("D") || rating.startsWith("d")){
            p = new Pilot(name, Rating.D);
        }else{
            System.out.println("sth wrong");
        }
        super.data.getPilots().add(p);
    }

    public void displayPilots(){
        for(Pilot p: this.data.getPilots()){
            System.out.println(p);
        }
    }
    
    public void searchPilot(){
        Pilot foundPilot = null;
        System.out.println("Please type the pilot Id:");
        int id = this.checkForInt();
        
        for(Pilot p: this.data.getPilots()){
            if(id == p.getId()) foundPilot = p;
        }
        if(foundPilot == null) System.out.println("\n*** Pilot not found! ***\n"); 
        else System.out.println(foundPilot.toString());
        
    }
}
