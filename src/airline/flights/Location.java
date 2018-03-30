/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.flights;

/**
 *
 * @author gustavolessa1
 */
public enum Location {
    RIO_DE_JANEIRO("Rio de Janeiro"), DUBLIN("Dublin"), LONDON("London"), PARIS("Paris"), NEW_YORK("New York"), SAO_PAULO("São Paulo"), AMSTERDAM("Amsterdam"), TOKYO("Tokyo");

    private static final Location[] cities = values();

    private final String city;

    /**
     * This constructor creates a new Location.
     * 
     * @param city 
     */
    Location(String city){
        this.city = city;
    }

    /**
     * @return This method returns the number of passengers allowance according to the rating label.
     */
    public String getName(){
        return this.city;
    }
    
    public static Location[] getAllOptions(){
        return cities;
    }
    
    public static String[] getAllNames(){
        String[] names = new String[cities.length];
        for(int x = 0; x < names.length; x++){
            names[x] = cities[x].getName();
        }
        return names;
    }
}
