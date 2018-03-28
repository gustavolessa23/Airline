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
    
    /**
     * This method prints the Pilot's instance details on CLI.
     * @return 
     */
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

    /**
     * This method returns the Pilot's rating.
     * @return 
     */
    public Enum getRating() {
        return rating;
    }

    /**
     * This method sets the Pilot's rating.
     * @param rating 
     */
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    /**
     * This method returns if the Pilot is assigned to an Airplane.
     * @return 
     */
    public boolean isAssigned() {
        return assigned;
    }

    /**
     * This method sets the Pilot's assignment state.
     * @param assigned 
     */
    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
    
}
