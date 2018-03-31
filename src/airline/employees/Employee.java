package airline.employees;

/**
 *
 * @author rbsrafa
 */
public abstract class Employee {
    protected final int id;
    protected static int lastId = 0;
    protected String name;
    
    /**
     * This constructor initialises a new Employee object.
     * @param name The name of the Employee.
     */
    public Employee(String name){
        this.id = ++lastId;
        this.name = name;
    }

    /**
     * This method returns the Employee's id field.
     * @return The employee's id.
     */
    public int getId() {
        return id;
    }

    /**
     * This method returns the Employee's name.
     * @return The employee's name.
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the Employee's name.
     * @param name (String)
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
}
