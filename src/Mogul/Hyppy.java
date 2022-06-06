package Mogul;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Topi
 * @version 1.4.2022
 *
 */
public class Hyppy {
    
    private int hyppy_id = 0;
    private String nimi = "";
    private double kerroin = 0.0;
    
    
    /**
     * Alustetaan hyppy
     */
    public Hyppy() {}
    
    
    /**
     * Hypyn alustus, pelkkä id
     * @param id hypyn id
     */
    public Hyppy(int id) {
        this.hyppy_id = id;
    }
    
    
    /**
     * Hypyn alustus
     * @param hyppy_id id
     * @param nimi nimi
     * @param kerroin kerroin
     */
    public Hyppy(int hyppy_id, String nimi, double kerroin) {
        this.hyppy_id = hyppy_id;
        this.nimi = nimi;
        this.kerroin = kerroin;
    }
    
    
    /**
     * Tulostetaan hypyn tiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println(hyppy_id + "|" + nimi + "|" + kerroin);
    }
    
    /**
     * Palauttaa hypyn tiedot merkkijonona
     * @return hyppy tolppaeroteltuna merkkijonona
     * @example
     * <pre name="test">
     *  Hyppy hyppy = new Hyppy(2, "testihyppy", 0.5);
     *  hyppy.toString() === "2|testihyppy|0.5";
     * </pre>
     */
    @Override
    public String toString() {
        return hyppy_id + "|" + nimi + "|" + kerroin;
    }
    
    
    /**
     * Tulostetaan hypyn tiedot
     * @param os tietovirta johon tulostetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    

    /**
     * Palauttaa hypyn id:n
     * @return hypyn id
     */
    public int getId() {
        return this.hyppy_id;
    }
    
    
    /**
     * Palauttaa hypyn kertoimen
     * @return hypyn kerroin
     */
    public double getKerroin() {
        return this.kerroin;
    }
    
    
    /**
     * Asettaa hypylle kertoimen
     * @param kerroin hypyn kerroin
     */
    public void setKerroin(double kerroin) {
        this.kerroin = kerroin;
    }
    
    
    /**
     * Palauttaa hypyn nimen
     * @return hypyn nimi
     */
    public String getNimi() {
        return this.nimi;
    }
       
    
    
    /**
     * Asettaa hypylle nimen
     * @param nimi hypyn nimi
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    
    /**
     * Testiohjelma Hypylle.
     * @param args ei käytössä
     */
     public static void main(String[] args) {
         Hyppy testi = new Hyppy(1, "testihyppy", 0.8);
         testi.tulosta(System.out);
     }
}
