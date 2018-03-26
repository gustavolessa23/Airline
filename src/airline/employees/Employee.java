package airline.employees;

/**
 *
 * @author rbsrafa
 */
public abstract class Employee {
    protected final int id;
    protected static int lastId = 0;
    protected String name;
    
    public Employee(String name){
        this.id = ++lastId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
