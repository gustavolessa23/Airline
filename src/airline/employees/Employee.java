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
     * @return This method returns the Employee's id field.
     */
    public int getId() {
        return id;
    }

    /**
     * @return This method returns the Employee's name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name This method sets the Employee's name.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
}
