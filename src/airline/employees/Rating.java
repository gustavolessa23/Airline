package airline.employees;

/**
 *
 * @author rbsrafa
 */
public enum Rating {
    A(400), B(300), C(200), D(100);
        
    private final int passengers;

    /**
     * This constructor creates a new Rating.
     * @param passengers 
     */
    Rating(int passengers){
        this.passengers = passengers;
    }

    /**
     * @return This method returns the number of passengers allowance according to the rating label.
     */
    public int getPassengers(){
        return this.passengers;
    }
}
