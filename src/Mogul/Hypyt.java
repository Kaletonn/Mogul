package Mogul;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Topi
 * @version 1.4.2022
 *
 */
public class Hypyt implements Iterable<Hyppy>{
    
    private String tiedostonNimi ="";
    
    /** Taulukko hypyistä */
    private static Collection<Hyppy> hypyt = new ArrayList<Hyppy>();

  
    
    /**
     * Hypyn lisäys listaan
     * @param hyppy lisättävä hyppy
     */
    public void lisaa(Hyppy hyppy) {
        hypyt.add(hyppy);
    }
    
    
    /**
     * Palauttaa hyppyjen lukumäärän
     * @return hyppyjen lukumäärä
     */
    public int getLkm() {
        return hypyt.size();
    }
    


    /**
     * Iteraattori kaikkien hyppyjen läpikäymiseen
     * @return hyppyiteraattori
     * @example
     * <pre name="test">
     * #PACKAGEIMPORT
     * #import java.util.*;
     * 
     * Hypyt testit = new Hypyt();
     * Hyppy testi1 = new Hyppy(1); testit.lisaa(testi1);
     * Hyppy testi2 = new Hyppy(2); testit.lisaa(testi2);
     * Hyppy testi3 = new Hyppy(3); testit.lisaa(testi3);
     * Hyppy testi4 = new Hyppy(4); testit.lisaa(testi4);
     * Hyppy testi5 = new Hyppy(5); testit.lisaa(testi5);
     * 
     * Iterator<Hyppy> i2 = testit.iterator();
     * i2.next() === testi1;
     * i2.next() === testi2;
     * i2.next() === testi3;
     * i2.next() === testi4;
     * i2.next() === testi5;
     * 
     * int n = 0;
     * 
     * for (Hyppy hyp : testit){
     *      hyp.getId();
     *      n++;
     * }
     * 
     * n === 5;
     *  
     * 
     * </pre>
     */
    @Override
    public Iterator<Hyppy> iterator() {
        return hypyt.iterator();
    }

    
    /**
     * @param hyppyid hypyn id nro
     * @return hyppy
     */
    public Hyppy getHyppy(int hyppyid) {
        for ( Hyppy hyp : hypyt) {
            if ( hyp.getId() == hyppyid) return hyp;
        }
        return null;
    }
    
    

    /**
     * @return lista hypyistä
     */
    public ArrayList<Hyppy> getHypyt() {
        ArrayList<Hyppy> lista = new ArrayList<Hyppy>();
        for (Hyppy hyppy : hypyt) {
            lista.add(hyppy);
        }
        System.out.println(hypyt.size());
        return lista;
    }
    
    
    /**
     * Tulostaa hyppyjen tiedot
     * @param out tietocirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        for (Hyppy hyp : hypyt) {
            hyp.tulosta(out);
        }
    }
    
    
    /**
     * Lukee tiedostosta hyppyjä ja lisää ne hyppyolioina taulukkoon
     * @param tiedosto luettava tiedosto
     */
    @SuppressWarnings("resource")
    public void lueTiedostosta(String tiedosto) {
        Scanner fi;
        hypyt = new ArrayList<Hyppy>();
        
        try {fi = new Scanner(new FileInputStream(new File(tiedosto)));
        while (fi.hasNext()) {
            String s = fi.nextLine();
            String[] rivi = s.split("\\|");
            int id  = Integer.parseInt(rivi[0]);
            String nimi = rivi[1];
            Double kerroin = Double.parseDouble(rivi[2]);
            this.lisaa(new Hyppy(id, nimi, kerroin));  
        }
        fi.close();
       } catch (FileNotFoundException ex) {
        System.err.println("Tiedosto ei aukea! " + ex.getMessage());
        return;
       }
    }
    
    
    /**
     * Tallentaa hyppyoliot tiedostoon omille riveilleen
     * @param tiedosto tiedosto johon tallennetaan
     * @throws IOException error
     */
    public void tallenna(String tiedosto) throws IOException {
        
        try ( PrintWriter fo = new PrintWriter(new FileWriter(tiedosto))){
            for (Hyppy hyp : hypyt) {
                fo.println(hyp.toString());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Tiedosto ei aukea! " + ex.getMessage());
        }
    }
    
    
    
    
    /**
     * Testipääohjelma hypyille
     * @param args ei käytössä
     */
    public static void main(String args[]) {
        
        Hypyt testi = new Hypyt();
        
        String tiedosto = "Tiedostot/hypyt.dat";
        
        testi.lueTiedostosta(tiedosto);
        
        System.out.println(testi.getLkm());
        testi.tulosta(System.out);
        
        try {
            testi.tallenna(tiedosto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
}
