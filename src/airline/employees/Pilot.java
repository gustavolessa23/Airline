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
     * @return This method prints the Pilot's instance details on CLI.
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
     * @return This method returns the Pilot's rating.
     */
    public Enum getRating() {
        return rating;
    }

    /**
     * @param rating This method sets the Pilot's rating.
     */
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    /**
     * @return This method returns if the Pilot is assigned to an Airplane.
     */
    public boolean isAssigned() {
        return assigned;
    }

    /**
     * @param assigned This method sets the Pilot's assignment state.
     */
    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
    
}
