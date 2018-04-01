
package airline.flights;

/**
 * This enum represents the cities where CCT Air operates and methods to retrieve
 * lists of options and values.
 * @author Gustavo Lessa
 */
public enum Location {
    RIO_DE_JANEIRO("Rio de Janeiro"), DUBLIN("Dublin"), LONDON("London"), PARIS("Paris"), NEW_YORK("New York"), SAO_PAULO("São Paulo"), AMSTERDAM("Amsterdam"), TOKYO("Tokyo");

    private static final Location[] cities = values();

    private final String city;

    /**
     * This constructor creates a new Location.
     * @param city (String) - name of the city.
     */
    Location(String city){
        this.city = city;
    }

    /**
     * This method is the accessor for the String city variable.
     * @return A String of the city's name.
     */
    public String getName(){
        return this.city;
    }
    
    /**
     * This static method is the accessor of the array of Location options. 
     * @return (Location[]) - An array of Location objects.
     */
    public static Location[] getAllOptions(){
        return cities;
    }
    
    /**
     * This method returns an array of city names.
     * @return (String[]) - An array of String objects.
     */
    public static String[] getAllNames(){
        String[] names = new String[cities.length];
        for(int x = 0; x < names.length; x++){
            names[x] = cities[x].getName();
        }
        return names;
    }
}
