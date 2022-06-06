package Mogul;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Topi
 * @version 23.3.2022
 *
 */
public class Mogul {

	private Kilpailu kilpailu = new Kilpailu();
	private Hypyt hypyt = new Hypyt();
	private String tiedostonimi = "Tiedostot/kilpailu.dat";
	//rivate int rinnepituus = 0;
	private List<Kilpailu> kilpailulista = new ArrayList<Kilpailu>();
	//private int id_lkm = 0;
	
	
	
	/**
	 * Alustaa kilpailun ja lukee hypyt tiedostosta
	 */
	public Mogul() {
	   hypyt.lueTiedostosta("Tiedostot/hypyt.dat");
	}
	
	
	/**
	 * Luo kilpailun
	 * @param nimi kisan nimi
	 * @param pituus kisan pituus
	 * @return kilpailu
	 * @example
	 */
	public Kilpailu luoKilpailu(String nimi, int pituus) {
		Kilpailu kilpailu2 = new Kilpailu();
		kilpailulista.add(kilpailu2);
		kilpailu2.setKilpailunimi(nimi);
		kilpailu2.setPituus(pituus);
		return kilpailu2;
	}
	
	
	/**
	 * Palauttaa halutun kilpailu-olion
	 * @return kilpailu-olio
	 */
	public Kilpailu getKilpailu() {
	    return kilpailu;
	}
	
	
	/**
	 * Luo oletuskilpailijan.
	 * 
	 * @param kilpailunimi kilpailun nimi
	 */
	public void luoKilpailija(String kilpailunimi) {
//		try {
//			for (int i = 0; i < kilpailulista.size(); i++) {
//				if (kilpailulista.get(i).getNimi().equals(kilpailunimi)) {
//					kilpailu = kilpailulista.get(i);
					Racer racer = new Racer();
					kilpailu.lisaa(racer.oletusVastaus());
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	
	/**
	 * Haetaan viimeiseksi avatun kilpailun nimi uuden kilpailuikkunan avaamista varten.
	 * return Antaa viimeisen kilpailun nimen
	 * @return palauttaa kilpailun nimen
	 */
	public String getKilpailunimi() {
		return kilpailulista.get(kilpailulista.size() - 1).getNimi();
	}
	
	
	/**
	 * Haetaan haluttu kilpailija
	 * @param i kilpailijan tunnusNro
	 * @return kilpailija
	 */
	public Racer getKilpailija (int i) {
		return kilpailu.getKilpailija(i);
	}
		
	
	/**
	 * @return todo
	 */
	public int getKilpailijaLkm() {
		return kilpailulista.get(kilpailulista.size() - 1).getLkm();
	}
	
	
	/**
	 * Poistaa valitun kilpailijan listasta
	 * @param racer poistettava kilpailija
	 */
	public void poista(Racer racer) {
        if (racer == null) return;
        kilpailu.poista(racer.getFiscode());
    }
	
	
    /**
     * Haetaan kilpailijan tunnusnro fis-koodilla
     * @param fis laskijan fis-koodi
     * @return laskijan tunnusNro
     */
    public int getTunnusNro(int fis) {
        return kilpailu.getTunnusNro(fis);
    }
    
    
    
    public double getKerroin (int Id) {
    	return hypyt.getHyppy(Id).getKerroin();
    }
    
	
	/**
	 * Lisätään laskijan hyppypisteet
     * @param tunnusNro laskijan id
     * @param hyppyid hypyn id
     * @param tuomari1 tuomarin 1 pisteet
     * @param tuomari2 tuomarin 2 pisteet
     */
    public void laskeHyppypisteet(int tunnusNro,int hyppyid, double tuomari1, double tuomari2) {
        getKilpailija(tunnusNro).setHyppyid(hyppyid);
        double pisteet1 = tuomari1*hypyt.getHyppy(hyppyid).getKerroin();
        double pisteet2 = tuomari2*hypyt.getHyppy(hyppyid).getKerroin();
        getKilpailija(tunnusNro).setHyppypisteet(pisteet1 + pisteet2);
        getKilpailija(tunnusNro).setHyppytuomari1(tuomari1);
        getKilpailija(tunnusNro).setHyppytuomari2(tuomari2);
        getKilpailija(tunnusNro).setHyppyid(hyppyid);

    }


    /**
     * Lisätään laskijan tekniikkapisteet
     * @param tunnusNro laskijan tunnusnumero
     * @param t1 tuomari 1 pisteet
     * @param t2 tuomari 2 pisteet
     * @param t3 tuomari 3 pisteet
     */
    public void laskeTekniikkapisteet(int tunnusNro, double t1, double t2, double t3) {
        double tekniikka = t1 + t2 + t3;
        getKilpailija(tunnusNro).setTekniikkapisteet(tekniikka);
        getKilpailija(tunnusNro).setTekniikkapiste1(t1);
        getKilpailija(tunnusNro).setTekniikkapiste2(t2);
        getKilpailija(tunnusNro).setTekniikkapiste3(t3);
        
    }
    
    
    /**
     * Lisätään laskijan aikapisteet
     * @param tunnusNro laskijan id
     * @param aika laskijan aika
     * @param pituus rinteen pituus
     */
    public void laskeAikapisteet(int tunnusNro, double aika, int pituus) {
        getKilpailija(tunnusNro).setAika(aika);
        double maksimi = 20;
        double pace_time = (pituus/10.30);
        if(aika< pace_time) getKilpailija(tunnusNro).setAikapisteet(maksimi);
        else {
            double pisteet = maksimi * (pace_time/aika);
            getKilpailija(tunnusNro).setAikapisteet(pisteet);
        }  
    }
    
    
    /**
     * Uuden kilpailutiedoston nimen asetus.
     * @param tied halutun tiedoston nimi
     */
    public void setTiedostonimi (String tied){
        this.tiedostonimi = "Tiedostot/" + tied + ".dat";       
    }

    
    
    /**
     * luo tiedoston kilpailun nimellä
     */
    public void luoTiedosto () {
        File f = new File(tiedostonimi);
        try {
            f.createNewFile();
        } catch (IOException e) {
            System.err.println("Tiedoston luonti ei onnistu");
            e.printStackTrace();
        }
    }

    
    
    /**
     * lue tiedostosta
     * @return onnistuiko
     */
    public boolean lueTiedostot() {
    	hypyt.lueTiedostosta("Tiedostot/hypyt.dat");
    	return kilpailu.lueTiedostosta(tiedostonimi);
    }
    
    
    
    /**
     * @throws IOException error
     */
    public void tallenna() throws IOException {
    	kilpailu.kirjotaTiedosto(tiedostonimi);
    } 
    

    /**
     * @return palauttaa listan kilpailijoista
     */
    public ArrayList<Racer> getKilpailijat() {
        return kilpailu.getKilpailijat();
        
    }
    
    
    /**
     * @return palauttaa lisyan hypyistä
     */
    public ArrayList<Hyppy> getHypyt() {
        return hypyt.getHypyt();
    }
    
    
    
    /**
     * Tulostaa kaikki hypyt
     */
    public void tulostaHypyt() {
        hypyt.tulosta(System.out);    
    }

	
    
    /**
     * Lisää kilpailijan kilpailuun
     * @param etu etunimi
     * @param suku sukunimi
     * @param bib bib-numero
     * @param fis fis-koodi
     */
    public void lisaaKilpailija(String etu, String suku, int bib, int fis) {
        kilpailu.lisaa(etu, suku, bib, fis);      
    }
	
    
    /**
     * 
     * @param tunnusn
     */
	public void muokkaaKilpailija(Racer muokattava) {
		kilpailu.muokkaaKilpailija(muokattava);
	}
    


	/**
	 * @param args ei käytössä
	 */
	public static void main(String[] args) {
		Mogul mogul = new Mogul();
		
		try {			
			mogul.kilpailu = mogul.luoKilpailu("Ruka", 200); //luo kilpailun
	        mogul.tulostaHypyt();
			mogul.lisaaKilpailija("Niko", "Skrton", 1, 112); 
			mogul.lisaaKilpailija("Topi", "Ranninen", 2, 113);
			mogul.lisaaKilpailija("vege", "taristi", 3, 213);
			System.out.println("!  !  " +mogul.kilpailu.getLkm());
			mogul.laskeHyppypisteet(mogul.getTunnusNro(112), 1, 8.0, 6.0);
			mogul.laskeAikapisteet(mogul.getTunnusNro(112), 20, mogul.kilpailu.getRinne());
			mogul.laskeTekniikkapisteet(mogul.getTunnusNro(112), 13, 14, 15);
			mogul.kilpailu.kirjotaTiedosto("Tiedostot/kilpailu.dat");
			mogul.tallenna();
			

						
			// yritet��n printata topin ja nikon tiedot.
			System.out.println("-------------------------- Testi ----------------------");			
			for (int i = 0; i < mogul.kilpailu.getLkm(); i++) {
				Racer racer = mogul.kilpailu.anna(i);
				System.out.println("Laskija paikassa: " + i  );
				System.out.println("-------------------------------------");
				racer.tulosta(System.out);

			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}	
		
		System.out.println("-------------------------- Testi ----------------------");
		
		
	}
	
	
}
