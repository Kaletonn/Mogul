package Mogul;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;



/**
 * @author Topi
 * @version 20.3.2022
 *
 */
public class Kilpailu {

	private String kilpailun_nimi = "";
	private static int rinteenPituus = 0;
	//private List<Racer> kilpailijat = new ArrayList<Racer>();
	//private String kilpailutiedosto = "";
	
	private int lkm = 0;
	private static int MAX_JASENIA = 5;
	private Racer[] alkiot;
	
	
	/**
	 * Alustetaan kilpailijataulukko
	 */
	public Kilpailu() {
	    alkiot = new Racer[MAX_JASENIA];
	}
	
	
	/**
	 * Lisää uuden kilpailijan tietorakenteeseen
	 * @param kilpailija lisättävä kilpailija
	 */
	public void lisaa (Racer kilpailija) {
	    if (lkm >= alkiot.length) alkiot = Arrays.copyOf(alkiot, MAX_JASENIA + 20);
	    alkiot[lkm] = kilpailija;
	    lkm++;   
	}
	
	
	/**
	 * Poistaa kilpailusta valitun kilpailijan tiedot.
	 * @param fiscode kilpailijan fis-kloodi
	 */
	public void poista(int fiscode) {
		int viimeinen = 0;
		for (int i = 0; i < lkm; i++) {
			if(fiscode == alkiot[i].getFiscode())
				{
				alkiot[i] = null;
				lkm--;
				viimeinen = i;
				}
		}		
		for (int i = viimeinen; i < lkm; i++) {
			alkiot[i] = alkiot[i + 1];
			alkiot[i + 1] = null;
		}
	}
	
	
	/**
	 * Palauttaa viitteen i:teen kilpailijaan
	 * @param i monennenko kilpailijan viite halutaan
	 * @return viite kilpailijaan, jonka indeksi on i
	 * @example
	 * <pre name="test">
	 *  Kilpailu kilpailu = new Kilpailu();
	 *  Racer testi1 = new Racer(); Racer testi2 = new Racer();
	 *  testi1.rekisteroi(); testi2.rekisteroi();
	 *  kilpailu.lisaa(testi1); kilpailu.lisaa(testi2);
	 *  kilpailu.anna(0).getTunnusNro() === 2;
	 *  kilpailu.anna(1).getTunnusNro() === 3;
	 * </pre>
	 */
	public Racer anna(int i) {
	    return alkiot[i];
	}
	
	
	/**
	 * Palauttaa kilpailijataulukon kilpailijoiden lukumäärän
	 * @return kilpailijoiden lukumäärä
	 * @example
	 * <pre name="test">
	 *  Kilpailu kilpailu = new Kilpailu();
	 *  Racer testi1 = new Racer(); Racer testi2 = new Racer(); Racer testi3 = new Racer();
	 *  kilpailu.lisaa(testi1); kilpailu.lisaa(testi2); kilpailu.lisaa(testi3);
	 *  kilpailu.getLkm() === 3;
	 * </pre>
	 */
	public int getLkm() {
	    return lkm;
	}
	

    /**
     * Tuo listan i-indeksist� kilpailijan tiedot
     */
    //private Racer getRacer(int i) {
      //  return this.kilpailijat.get(i);
    //}


    /**
     * 
     * @param racer lis�tt�v� kilpailija
     */
    //private void add(Racer racer) {
    //    this.alkiot;        
    //}
    
	
	/**
	 * Alustetaan rinteen pituus
	 * @param pituus rinteen pituus
	 */
    public void setPituus(int pituus) {
        rinteenPituus = pituus;
    }
	
	
    /**
     * Asettaa kilpailun nimen.
     * @param s kilpailun nimi
     */
    public void setKilpailunimi(String s) {
        this.kilpailun_nimi = s;
    }
    
    
    /**
     * Haetaan kilpailun nimi
     * @return kilpailun nimi
     * @example
     * <pre name="test">
     *  Kilpailu uusi = new Kilpailu();
     *  uusi.setKilpailunimi("Megaluokan testikisa");
     *  uusi.getNimi() === "Megaluokan testikisa";
     * </pre>
     */
    public String getNimi() {
        return kilpailun_nimi;
    }
    
    
    /**
     * Haetaan rinteen pituus
     * @return rinteen pituus
     * @example
     * <pre name="test">
     *  Kilpailu uusi = new Kilpailu();
     *  uusi.setPituus(250);
     *  uusi.getRinne() === 250;
     * </pre>
     */
    public int getRinne() {
        return rinteenPituus;
    }
    
    
    /**
     * Lisaa laskijan
     * @param etu etunimi
     * @param suku sukunimi
     * @param bib bib-numero
     * @param fis fis-numero
     * <pre name="test">
     *  Racer testi = new Racer();
     *  testi.lisaa("Testietu", "Testisuku", 1, 12);
     *  testi.getEtunimi() === "Testietu";
     * </pre>
     */
    public void lisaa(String etu, String suku, int bib, int fis) {
        Racer laskija = new Racer();
        laskija.lisaa(etu, suku, bib, fis);
        this.lisaa(laskija);  
    }
    

    /**
     * Haetaan haluttu kilpailija
     * @param i halutun kilpailijan tunnusNro
     * @return kilpailija
     * @example
     * <pre name="test">
     *  Kilpailu testikisa = new Kilpailu();
     *  testikisa.lisaa("Testi", "Testinen", 99,98);
     *  testikisa.getKilpailija(1).getSukunimi() === "Testinen";
     * </pre>
     */
    public Racer getKilpailija(int i) {
        for (Racer racer: alkiot) {
            if (racer != null && racer.getTunnusNro() == i) return racer;
        }
        return null;
    }
    
    
    
	public void muokkaaKilpailija(Racer muokattava) {
		for(int i = 0; i < alkiot.length; i++) {
			if (alkiot[i].getTunnusNro() == muokattava.getTunnusNro())
			{
				alkiot[i] = muokattava;
				break;
			}
		}
		
	}
    
    
    /**
     * Haetaan laksijan tunnusNro fis-koodin perusteella
     * @param fis fis-koodi
     * @return laskijan tunnusNro
     */
    public int getTunnusNro(int fis) {
        for ( Racer rac : alkiot) {
            if (rac.getFiscode() == fis) return rac.getTunnusNro();
        }
        return 0;
    }
	
	
    /** Tulostaa kisan tiedot tiedostoon.
     * @param tiedosto kirjoitettava tiedosto
     * @throws IOException error
     * 
     */
	public void kirjotaTiedosto(String tiedosto) throws IOException {
		try ( PrintWriter fo = new PrintWriter(new FileWriter(tiedosto))){
			for (Racer racer : alkiot) {
				if (racer != null)
				fo.println(racer.print());
			}			
		}
		catch (FileNotFoundException ex) {
	        System.err.println("Tiedosto ei aukea! " + ex.getMessage());
	        return;
	       }		
	}
   
   
	/**
	 * @param tiedosto tiedosto mistä luetaan
	 * @return boolean onnistuiko
	 */
	@SuppressWarnings("resource")
    public boolean lueTiedostosta(String tiedosto) {
        Scanner fi;
        try {fi = new Scanner(new FileInputStream(new File(tiedosto)));
        while (fi.hasNext()) {
            String s = fi.nextLine();
            String[] rivi = s.split("\\|");
            int tunnusn = Integer.parseInt(rivi[0]);
            int bib  = Integer.parseInt(rivi[1]);
            int fis = Integer.parseInt(rivi[2]);
            String suku = rivi[3];
            String etu = rivi[4];
            double aika = Double.parseDouble(rivi[5]);
            double aikap = Double.parseDouble(rivi[6]);
            double hyp1 = Double.parseDouble(rivi[7]);
            double hyp2 = Double.parseDouble(rivi[8]);
            int hyppyID = Integer.parseInt(rivi[9]);
            double hyppyp = Double.parseDouble(rivi[10]);
            double t1 = Double.parseDouble(rivi[11]);
            double t2 = Double.parseDouble(rivi[12]);
            double t3 = Double.parseDouble(rivi[13]);
            double teknik = Double.parseDouble(rivi[14]);
            double kok = Double.parseDouble(rivi[15]);            
            Racer racer =new Racer(tunnusn, bib, fis, suku, etu, aika, aikap, hyppyp,
            					   hyp1, hyp2, hyppyID, t1, t2, t3, teknik, kok);
            this.lisaa(racer); 

        }
        fi.close();
		if (lkm > 0) {
			int i = alkiot[lkm - 1].getTunnusNro();
			alkiot[lkm - 1].setSeuraavanumero(i);
		}
        return true;
       } catch (FileNotFoundException ex) {
        System.err.println("Tiedosto ei aukea! " + ex.getMessage());
        return false;
       }
    }


	/**
	 * @return lista kilpailijoista
	 */
	public ArrayList<Racer> getKilpailijat() {
		ArrayList<Racer> lista = new ArrayList<>(); 
		for (int i = 0; i < lkm; i++) {			
			lista.add(alkiot[i]);			
		}
		return lista;
	}
	
	
	/**
	 * @param args ei käytössä
	 */
	public static void main(String[] args) {
		//Racers kilpailijat = new Racers();  //luon racers olion, johon tallennetaan osallistujia
		
		//Racer niko = new Racer();
        //niko.lisaa("Niko", "Kaleton", 69, 1111111);
		//kilpailijat.add(niko);  // tuon kilpailijan tiedot kilpailijat listaan
		//.getRacer(0).tulosta(null);
		
		Kilpailu kilpailu = new Kilpailu();
		kilpailu.setKilpailunimi("Ruka21");
		kilpailu.setPituus(200);
		Racer niko = new Racer();
		niko.lisaa("Niko", "Kaleton", 69, 1111111);

        
        try {
            kilpailu.lisaa(niko);
            kilpailu.lisaa(niko);
            kilpailu.lisaa(niko);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        System.out.println("================== Kilapilijat testi ===================" + "\n");
        System.out.println("Kilapilu: " + kilpailu.getNimi() + ", pituus: " + kilpailu.getRinne() + "\n");
        for (int i = 0; i < kilpailu.getLkm(); i++) {
            Racer racer  = kilpailu.anna(i);
            System.out.println("Kilpailijan indeksi: " + i + "\n");
            racer.tulosta(System.out);
        }
		
	}


}
