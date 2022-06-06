package Mogul;

/**
 * Luokka laskijan yhden kierroksen tekniikkapisteitä varten
 */
public class Tekniikka{
    private double[][] tekniikka = new double[2][5];
    
    
    /**
     * Lisää yhden tuomarin tekniikkapisteet
     * @param tuomari mikä tuomari
     * @param pisteet tuomarin pisteet
     * @param vahennys tuomarin vähennykset
     */
    public void lisaaTekniikkapisteet(int tuomari, double pisteet, double vahennys) {
        tekniikka[0][tuomari-1] = pisteet;
        tekniikka[1][tuomari-1] = vahennys;
    }
    
    
    /**
     * Lasketaan tekniikkapisteiden summa. Pisteet lasketaan tiputtamalla paras ja huonoin tekniikka- ja vähennyspistemäärä, ja laskemalla nämä yhteen
     * @return tekniikkapisteiden summa
     */
    public double getTekniikanSumma() {
        double tekniikanIsoin=0;
        double tekniikanPienin=20;
        double tekniikanSumma = 0;
        
        double vahennystenIsoin = 0;
        double vahennystenPienin = -20;
        double vahennystenSumma = 0;
        
        
        // Lasketaan tekniikkapisteet
        for(int i = 0; i<tekniikka[0].length; i++) {
            tekniikanSumma += tekniikka[0][i];
            if(tekniikka[0][i] >= tekniikanIsoin) {
                tekniikanIsoin = tekniikka[0][i];
            }
            if(tekniikka[0][i] <= tekniikanPienin) {
                tekniikanPienin = tekniikka[0][i];
            }
        }
        // Lasketaan vähennykset
        for(int i = 0; i < tekniikka[1].length; i++) {
            double pisteet = tekniikka[1][i];
            vahennystenSumma += pisteet;
            if(pisteet >= vahennystenPienin) {
                vahennystenPienin = pisteet;
            }
            if(pisteet <= vahennystenIsoin) {
                vahennystenIsoin = pisteet;
            }
        }
        
        return ((tekniikanSumma-tekniikanPienin-tekniikanIsoin) + (vahennystenSumma - vahennystenIsoin - vahennystenPienin));
    }
    
    
    /**
     * Kilpailijan tekniikkapisteet String-muodossa
     * @return pisteet
     */
    public String tekniikkaToString() {
        StringBuilder vastaus = new StringBuilder("Tekniikkapisteet |");
        for(int i = 0; i < tekniikka[0].length; i++) {
            vastaus.append(tekniikka[0][i]+"|"+tekniikka[1][i]+"|");
        }
        return vastaus.toString();
    }

}
