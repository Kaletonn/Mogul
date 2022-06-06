package Mogul;

import java.io.PrintStream;
import java.util.Locale;


/**
 * 
 * @author Topi
 * @version 7.3.2022
 *
 */
public class Racer {
    
    private int tunnusNro;
    private int Bib = 0;
    private int fis_code = 0;
    private String sukunimi = "";
    private String etunimi = "";
    private double aika = 0;
    private int hyppyId;
    //private int rinteenPituus = 0;
    private double tekniikkapisteet;
    private double tekniikka1;
    private double tekniikka2;
    private double tekniikka3;
    private double hyppypisteet;
    private double hyppy1;
    private double hypp2;
    private double aikapisteet;
    private double kokonaispisteet = tekniikkapisteet + hyppypisteet + aikapisteet;
    // 0 nainen, mies 1


    private static int seuraava_numero = 1;
    

    
    /**
     * Alustaa laskijan tiedot tyhjiksi
     */
    public Racer() {
        //
    }
    
    
    /**
     * Alustaa laskijan tiedot tyhjiksi
     * @param tnro kilpailiajn tunnus
     * @param bib kilpailijan kisanumero
     * @param fiscode kilpailijan fis-koodi
     * @param suku kipailijan sukunimi
     * @param etu kilpailijan etunimi
     */
    public Racer(int tnro, int bib, int fiscode, String suku, String etu) {
        this.tunnusNro = tnro;
        this.Bib = bib;
        this.fis_code = fiscode;
        this.sukunimi = suku;
        this.etunimi = etu;
    }   
    
        
    /**
     * Alustetaan laskijan teidot
     * @param bib kisanumero 
     * @param fis kilpailijan fis-koodi
     * @param suku sukunimi
     * @param etu etunimi
     * @param aika aika
     * @param aikap aikapisteet
     * @param hyppyp hyppypisteet
     * @param hyppyID hypyn id
     * @param teknik tekniikka pisteet
     * @param kok kokonaispisteet
     */
    public Racer(int bib, int fis, String suku, String etu, double aika, double aikap, double hyppyp, int hyppyID,
			double teknik, double kok) {
		this.Bib = bib;
		this.fis_code = fis;
		this.sukunimi = suku;
		this.etunimi = etu;
		this.aika = aika;
		this.aikapisteet = aikap;
		this.hyppypisteet = hyppyp;
		this.hyppyId = hyppyID;
		this.tekniikkapisteet = teknik;
		this.kokonaispisteet = kok;
	}
    
    
    /**
     * Alustetaan laskijan tiedot.
     * @param bib
     * @param fis
     * @param suku
     * @param etu
     * @param aika
     * @param aikap
     * @param hyppyp
     * @param ht1
     * @param ht2
     * @param hyppyID
     * @param t1
     * @param t2
     * @param t3
     * @param teknik
     * @param kok
     */
    public Racer(int tnum, int bib, int fis, String suku, String etu, double aika, double aikap, double hyppyp, 
    		double ht1, double ht2, int hyppyID, double t1, double t2, double t3,
			double teknik, double kok) {
    	this.tunnusNro = tnum;
		this.Bib = bib;
		this.fis_code = fis;
		this.sukunimi = suku;
		this.etunimi = etu;
		this.aika = aika;
		this.aikapisteet = aikap;
		this.hyppypisteet = hyppyp;
		this.hyppy1 = ht1;
		this.hypp2 = ht2;
		this.hyppyId = hyppyID;
		this.tekniikkapisteet = teknik;
		this.tekniikka1 = t1;
		this.tekniikka2 = t2;
		this.tekniikka3 = t3;
		this.kokonaispisteet = kok;
	}


	/**
     * 
     */
    public void setTunnusnumero(int i) {
    	this.tunnusNro = i;
    }
    
    
    
    public void setSeuraavanumero (int i) {
    	seuraava_numero = i + 1;
    }
    
    
    /**
     * Asetetaan laskijalle oikea hyppyID.
     * @param i hypyn indeksi hyppytiedostossa
     * @example
     * <pre name="test">
     *  Racer testi = new Racer();
     *  testi.setHyppyid(1);
     *  testi.getHyppyId() === 1;
     * </pre>
     */
    public void setHyppyid(int i) {
    	this.hyppyId= i;
    }
   
    
    /**
     * Asettaa laskijalle laskuajan
     * @param aika laskijan aika
     */
    public void setAika(double aika) {
		this.aika = aika;
	}
    
    
    /**
     * Hakee laskijan tallennetun ajan
     * @return laskijan aika
     */
    public double getAika() {
       // return aika.getAika();
        return this.aika;
    }
    
    
    /**
     * Asettaa tuomarin 1 antamat tuomaripisteet
     * @param piste tuomarin antama piste
     */
    public void setTekniikkapiste1(double piste) {
    	this.tekniikka1 = piste;
    }
    
    
    /**
     * Asettaa tuomarin 2 antamat tuomaripisteet
     * @param piste tuomarin antama piste
     */
    public void setTekniikkapiste2(double piste) {
    	this.tekniikka2 = piste;
    }    
    
    
    /**
     * Asettaa tuomarin 3 antamat tuomaripisteet
     * @param piste tuomarin antama piste
     */
    public void setTekniikkapiste3(double piste) {
    	this.tekniikka3 = piste;
    }

    
    /**
     * Asettaa hyppytuomarin1 pisteet
     * @param t tuomarin antama piste
     */
    public void setHyppytuomari1 (double t) {
    	this.hyppy1 = t;
    }
    
    
    /**
     * Asettaa hyppytuomarin2 pisteet
     * @param t tuomarin antama piste
     */
    public void setHyppytuomari2 (double t) {
    	this.hypp2 = t;
    }
    
    
    /**
     * Hakee tuomaripisteet
     * @return Tuomarin 1 pisteet
     */
    public double getHyppytuomari1 () {
    	return this.hyppy1;
    }
    
    
    /**
     * Hakee tuomaripisteet
     * @return Tuomarin 2 pisteet
     */
    public double getHyppytuomari2 () {
    	return this.hypp2;
    }
    
    
    /**
     * hakee kilpailijan tekem�n tempun ID:n
     * @return tempun ID
     */
    public int getHyppyID () {
		return this.hyppyId;    	
    }
    
    
    /**
     * Hakee tuomarin 1 antamat tekniikkapisteet
     * @return 
     */
    public double getTekniikka1 () {
    	return this.tekniikka1;
    }
    
    
    /**
     * Hakee tuomarin 2 antamat tekniikkapisteet
     * @return
     */
    public double getTekniikka2 () {
    	return this.tekniikka2;
    }
    
    
    /**
     * Hakee tuomarin 3 antamat tekniikkapisteet
     * @return
     */
    public double getTekniikka3 () {
    	return this.tekniikka3;
    }
    
    
    /**
     * Hakee tuomarin 1 antamat hyppypisteet
     * @return
     */
    public double getHyppy1 () {
    	return this.hyppy1;
    }
    
    
    /**
     * Hakee tuomarin 2 antamat hyppypisteet
     * @return
     */
    public double getHyppy2 () {
    	return this.hypp2;
    }
       
    
    /**
     * Hakee laskijan aikapisteet
     * @return laskijan aikapisteet
     */
    public double getAikapisteet() {
       return this.aikapisteet;
    }
    
    
    /**
     * Rekisteröi laskijan
     * @param etu etunimi
     * @param suku sukunimi
     * @param nro kilpailunumero
     * @param fis kilpailijan fis-koodi
     */
    public void lisaa(String etu, String suku, int nro, int fis ) {
        this.etunimi = etu;
        this.sukunimi = suku;
        this.Bib = nro;
        this.fis_code = fis;
        rekisteroi();
    }
    
    
    /**
     * Antaa kilpailijalle seuraavan rekisterinumeron
     * @return tunnusnumero
     * @example
     * <pre name="test">
     *  Racer testi = new Racer();
     *  testi.rekisteroi();
     *  Racer testi2 = new Racer();
     *  testi2.rekisteroi();
     *  int n1 = testi.getTunnusNro();
     *  int n2 = testi2.getTunnusNro();
     *  n1 === n2-1
     * </pre>
     */
    public int rekisteroi() {
        this.tunnusNro = seuraava_numero;
        seuraava_numero++;
        return this.tunnusNro;
    }
    
    
    
    /**
     * Hakee laskijan rekisterinumeron
     * @return rekisterinumero
     */
    public int getTunnusNro() {
        return this.tunnusNro;
    }
    
    
    /**
     * Hakee laskijan liivinumeron
     * @return Liivinumero
     */
    public int getBib() {
        return this.Bib;
    }
    
    
    /**
     * Hakee laskijan FIS-koodin
     * @return FIS-code
     */
    public int getFiscode() {
        return this.fis_code;
    }
    
    
    /**
     * Hakee laskijan sukunimen
     * @return Sukunimi
     */
    public String getSukunimi() {
        return this.sukunimi;
    }
    
    /**
     * Palauttaa kilpailijan kokonimen
     * @return palauttaa kilpailijan kokonimen
     */
    public String getNimi() {
        return this.etunimi + this.sukunimi;
    }
    
    
    /**
     * Asetta laskijalle etunimen
     * @param etu laskijan etunimi
     */
    public void setEtunimi(String etu) {
        etunimi = etu;
    }
    
    
    /**
     * Asettaa laskijalle sukunimen
     * @param suku	laskijan sukunimi
     */
	public void setSukunimi(String suku) {
		sukunimi = suku;		
	}

	
	/**
	 * Asettaa laskijalle laskunumeron
	 * @param bib laskunumero
	 */
	public void setBib(int bib) {
		Bib = bib;		
	}
	
	
	/**
	 * Asettaa laskijalle FIS-koodin
	 * @param fis fis-koodi
	 */
	public void setFis(int fis) {
		fis_code = fis;	
	}

    
	
    /**
     * Hakee laskijan etunimen
     * @return Etunimi
     * @example
     * <pre name="test">
     *  Racer testi = new Racer();
     *  testi.setEtunimi("Testiukko");
     *  testi.getEtunimi() === "Testiukko";
     * </pre>
     */
    public String getEtunimi() {
        return this.etunimi;
    }
    
    
    /**
     * @return laskijan hyppypisteet
     * <pre name="test">
     *  Racer testi = new Racer();
     *  testi.setHyppypisteet(10.0);
     *  testi.getHyppypisteet() ~~~ 10.0;
     * </pre>
     */
    public double getHyppypisteet() {
        return this.hyppypisteet;
    }
    
    
    /**
     * @return laskijan hyppy id
     */
    public int getHyppyId() {
        return this.hyppyId;
    }
    
    
    /**
     * @return laskijan tekniikkapisteet
     */
    public double getTekniikkapisteet() {
        return this.tekniikkapisteet;
    }
    
    
    /**
     * @return laskijan kokonaispisteet
     * <pre name="test">
     *  Racer testi = new Racer();
     *  testi.setTekniikkapisteet(10.0);
     *  testi.setAikapisteet(15.0);
     *  testi.setHyppypisteet(23.0);
     *  testi.getKokonaispisteet() ~~~ 48.0;
     * </pre>
     */
    public double getKokonaispisteet() {
        return this.kokonaispisteet;
    }
    
    

    /**
     * Lisätään laskijalle hyppypisteet
     * @param pisteet hyppypisteet
     */
    public void setHyppypisteet(double pisteet) {
        this.hyppypisteet = pisteet;
        laskeKokonaispisteet();
    } 
    
    
    /**
     * Asettaa hyppytuomarin pisteet muokkausta varten
     * @param h1 hyppytyomarin1 pisteet
     * @param h2 hyppytuomarin 2 pisteet
     */
    public void asetaHyppypisteet(double kerroin, double h1, double h2) {
    	this.hyppypisteet = kerroin*h1 + kerroin*h2;
    	laskeKokonaispisteet();
    }
    
    
    /**
     * Asettaa tekniikkatuomarin pisteet muokkausta varten
     * @param t1 tuomarin 1 pisteet
     * @param t2 tuomarin 2 pisteet
     * @param t3 tuomarin 3 pisteet
     */
    public void asetaTekniikkapisteet(double t1, double t2, double t3) {
    	this.tekniikkapisteet = t1 + t2 + t3;
    	laskeKokonaispisteet();
    }
    
    
    /**
     * Asettaa laskijalle aikapisteet
     * @param pituus rinteen pituus
     * @param aika laskuaika
     */
    public void asetaAikapisteet(int pituus, double aika) {
        double maksimi = 20;
        double pace_time = (pituus/10.30);
        if(aika< pace_time) this.aikapisteet = maksimi;
        else {
            double pisteet = maksimi * (pace_time/aika);
            this.aikapisteet = pisteet;
        } 
        laskeKokonaispisteet();
    }
    
    
    /**
     * Lisätään laskijalle aikapisteet
     * @param pisteet aikapisteet
     */
    public void setAikapisteet(double pisteet) {
        this.aikapisteet = pisteet;
        laskeKokonaispisteet();
    }
    
    
    /**
     * Lisätään laskijalle tekniikkapisteet
     * @param tekniikka laskijalle annetut tekniikkapisteet
     */
    public void setTekniikkapisteet(double tekniikka) {
        this.tekniikkapisteet = tekniikka;
        laskeKokonaispisteet();  
    }
    
    
    /**
     * P�ivitt�� laskijan kokonaispisteet
     */
    public void laskeKokonaispisteet() {
    	this.kokonaispisteet = hyppypisteet + aikapisteet + tekniikkapisteet;
    }
    
    /**
     * Tulostetaan laskijan tiedot
     * @param os tietovirta johon tulostetaan
     
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    **/
    
  
    
    /**
     * @return tekniikkapisteet string-muodossa
     */
    public String tekniikkaToString() {
       // return tekniikka.tekniikkaToString();
        return "";
    }
    
    
    /**
     * Kloonaa halutun kilpailijan
     */
    @Override
    public Racer clone() {
        Racer tempRacer = new Racer();
        tempRacer.tunnusNro = this.tunnusNro;
        tempRacer.Bib = this.Bib;
        tempRacer.fis_code = this.fis_code;
        tempRacer.sukunimi = this.sukunimi;
        tempRacer.etunimi = this.etunimi;
        tempRacer.aika = this.aika;
        tempRacer.hyppyId = this.hyppyId;
        tempRacer.tekniikka1 = this.tekniikka1;
        tempRacer.tekniikka2 = this.tekniikka2;
        tempRacer.tekniikka3 = this.tekniikka3;
        tempRacer.tekniikkapisteet = this.tekniikkapisteet;
        tempRacer.hyppy1 = this.hyppy1;
        tempRacer.hypp2 = this.hypp2;
        tempRacer.hyppypisteet = this.hyppypisteet;
        tempRacer.aikapisteet = this.aikapisteet;
        tempRacer.kokonaispisteet = this.kokonaispisteet;       
        return tempRacer;
    }


    
    /**
     * Tulostetaan kilpailijan tiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println("|" + String.format("%d", tunnusNro) + "|" + Bib + "|" + fis_code +  "|" + sukunimi + "|" + etunimi + "|" + String.format(Locale.US, "%.02f", getAika()) + "|" + String.format(Locale.US, "%.02f", getAikapisteet()) + "|"
                       + String.format(Locale.US, "%.02f", getHyppypisteet()) + "|" + getHyppyId() + "|" + String.format(Locale.US, "%.02f", getTekniikkapisteet()) + "|" + String.format(Locale.US, "%.02f", getKokonaispisteet()));      
    }
    
    
    /**
     *     private int tunnusNro;
    private int Bib = 0;
    private int fis_code = 0;
    private String sukunimi = "";
    private String etunimi = "";
    private double aika = 0;
    private int hyppyId;
    //private int rinteenPituus = 0;
    private double tekniikkapisteet;
    private double tekniikka1;
    private double tekniikka2;
    private double tekniikka3;
    private double hyppypisteet;
    private double hyppy1;
    private double hypp2;
    private double aikapisteet;
    private double kokonaispisteet = tekniikkapisteet + hyppypisteet + aikapisteet;
     * @return laskijan tiedot string-muodossa
     */
    public String print() {
    	String t = 	this.tunnusNro + "|" +
    				this.Bib + "|" + 
    				this.fis_code + "|" + 
    				this.sukunimi + "|" + 
    				this.etunimi + "|" + 
    				String.format(Locale.US, "%.02f", getAika()) + "|"+ 
    				String.format(Locale.US, "%.02f", getAikapisteet()) + "|" + 
    				String.format(Locale.US, "%.02f", getHyppy1()) +"|" +
    				String.format(Locale.US, "%.02f", getHyppy2()) +"|" +
    				this.hyppyId + "|" + 
    				String.format(Locale.US, "%.02f", getHyppypisteet()) + "|" + 
    				String.format(Locale.US, "%.02f", getTekniikka1()) +"|" + 
    				String.format(Locale.US, "%.02f", getTekniikka2()) +"|" +
    				String.format(Locale.US, "%.02f", getTekniikka3()) +"|" +
    				String.format(Locale.US, "%.02f", getTekniikkapisteet()) +"|" + 
    				String.format(Locale.US, "%.02f", getKokonaispisteet());
    	return t;
    }
	
	
	/**
	 * Oletuskilpailijan luonti
	 * @return oletuskilpailija
	 */
	public Racer oletusVastaus() {
		Racer niko = new Racer();
        niko.lisaa("Niko", "Kaleton", 69, 1111111);
        niko.setAika(21.20);
        return niko;
	}
	
	@Override
	/**Palauttaa laskijan nimen etu - suku formaatissa.
	 *  @return Laskijan nimi
	 */ 
	public String toString() {
		return this.etunimi + " " + this.sukunimi;
	}
    
    
    /**
     * @param args ei käytössä
     */
    public static void main(String args[]) {
        Racer niko = new Racer();
        Racer topi = new Racer();
        niko.lisaa("Niko", "Kaleton", 69, 1111111);
        topi.lisaa("Topi", "Kanninen", 96, 2222222);
        //niko.tulosta(System.out);
        niko.setHyppyid(1);
        //topi.vastaaAkuAnkka();        
        niko.tulosta(System.out);
        topi.tulosta(System.out);
        Racer testi = new Racer();
        testi.lisaa("Testi", "Testinen", 8, 888888);
        testi.tulosta(System.out);
        System.out.println(niko.print());
        //topi.vastaaAkuAnkka();
        //topi.tulosta(System.out);
    }

   
}
