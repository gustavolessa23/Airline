package airline.employees;

/**
 *
 * @author rbsrafa
 */
public enum Rating {
    A(400), B(300), C(200), D(100);
        
    private final int passengers;

    Rating(int passengers){
        this.passengers = passengers;
    }

    public int getPassengers(){
        return this.passengers;
    }
}
