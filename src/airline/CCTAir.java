package airline;

import airline.menus.MainMenu;

import airline.data.Data;

/**
 *
 * @author rbsrafa
 * 
 */
public class CCTAir {   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Data data = new Data();
        new MainMenu(data);    
    }
    
}
