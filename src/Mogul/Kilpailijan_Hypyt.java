package Mogul;

/**
 * Luokka laskijan yhden kierroksen hyppypisteitä varten
 */
public class Kilpailijan_Hypyt {
    
    private double[][] hypyt = new double [2][2];
        
    /**
     * Lisää yhden tuomarin hyppypisteet
     * @param tuomari mikä tuomari
     * @param hyppy1 hyppy1
     * @param hyppy2 hyppy2
     */
    public void lisaaHyppypisteet(int tuomari, double hyppy1, double hyppy2) {
        hypyt[tuomari-1][0] = hyppy1;
        hypyt[tuomari-1][1] = hyppy2;
    }
    
    
    /**
     * Kilpailijan hyppypisteet String-muodossa
     * @return pisteet
     */
    public String hypytToString() {
        StringBuilder vastaus = new StringBuilder("Hyppytuomari 1 |");
        for(int i = 0; i < hypyt[0].length; i++) {
            vastaus.append(hypyt[0][i]+"|"+hypyt[1][i]+"|");
            if(i == 1) continue;
            vastaus.append(" Hyppytuomari 2 |");
        }
        return vastaus.toString();
    }   
    
}
