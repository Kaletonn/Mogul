package Mogul;

/**
 * Kilpailijan aika-luokka
 * @author Topi
 * @version 20.3.2022
 *
 */
public class Aika {
    
    private double aika = 0;
    private double aikapisteet = 0;
    
    
    /**
     * Lisää laskijalle ajan
     * @param aika laskijan aika
     * @param rinteenPituus rinteen pituus
     */
    public void setAika(double aika, int rinteenPituus) {
        this.aika = aika;
        laskeAikapisteet(rinteenPituus);
    }
    
    
    /**
     * Palauttaa laskijalle tallennetun ajan
     * @return laskijan aika
     */
    public double getAika() {
        return aika;
    }
    
    
    /**
     * Palauttaa laskijan aikapisteet
     * @return aikapisteet
     */
    public double getAikapisteet() {
        return aikapisteet;
    }
    
    /**
     * Lasketaa laskijan aikapisteet
     * @param rinteenPituus rinteen pituus
     */
    public void laskeAikapisteet(int rinteenPituus) {
        /*double rinnepituus = NewRaceController.textSlope;
        double pisteet;
        if (this.sukupuoli == 1) {
            pisteet = rinnepituus / 10.30;
        }
        
        //TODO: tee laske aikapisteet, luo kaava, ota rinne huomioon;
        /*
         * The Pace Times for ladies� and men�s Moguls are set according to the standards
         *  determined by the FIS Sub-Committee Moguls / Aerials. To calculate the Pace
         *  Time for a specific course, take the length of the course in metres and divide by
         *  the Pace Time in metres/sec.
         *  Men�s Pace Time: 10.30 metres / per second
         *  Ladies Pace Time: 8.80 metres / per second
         *
         */
        
        double maksimi = 20;
        double pace_time = (rinteenPituus/10.30);
        if(aika< pace_time) aikapisteet = maksimi;
        double pisteet = maksimi * (pace_time/aika);
        aikapisteet = pisteet;;
        
    }
    
}
