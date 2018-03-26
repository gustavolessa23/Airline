package airline.employees;

/**
 * 
 * @author rbsrafa
 */
public class Pilot extends Employee{
    private Rating rating;
    private boolean assigned;
    
    /**
     * Constructor that initialises a new Pilot
     * @param name The name of the Pilot
     * @param rating The rating (licence) that the pilot have
     */
    public Pilot(String name, Rating rating){
        super(name);
        this.rating = rating;
        this.assigned = false;
    }
    
    
    @Override
    public String toString(){
        return
              "+-------------------------------+\n" +
               "| Pilot Info                    |\n" +
               "+-------------------------------+\n" +
               " ID: " + this.id + "\n" + 
               " Name: " + this.name + "\n" + 
               " Licence type: " + this.rating + "\n" +
               "+-------------------------------+\n\n" +
               "|||||||||||||||||||||||||||||||||\n";
    }

    public Enum getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
    
}
