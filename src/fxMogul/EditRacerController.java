package fxMogul;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;
import Mogul.*;

/**
 * @author Topi
 * @version 18.2.2022
 *
 */
public class EditRacerController implements Initializable {


    @FXML
    private TextField fxBid;

    @FXML
    private Button fxClose;

    @FXML
    private TextField fxFirstname;

    @FXML
    private TextField fxFis;

    @FXML
    private TextField fxJudge1;

    @FXML
    private TextField fxJudge2;

    @FXML
    private TextField fxJudge3;

    @FXML
    private TextField fxJump1;

    @FXML
    private TextField fxJump2;

    @FXML
    private TextField fxJumpID;

    @FXML
    private Button fxSubmit;

    @FXML
    private TextField fxSurname;

    @FXML
    private TextField fxTime;
        
    
    @Override
    public void initialize(URL url, ResourceBundle bundle) {      
        //alusta();
    }

    @FXML
    void handleClose() {
        Stage stage = (Stage) fxClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    void handleSubmit() {
		try {
			muokkaaKilpailija(muokattavaRacer);
//        lisaaKilpailija(fxFirstname.getText(), fxSurname.getText(), fxBid.getText(), fxFis.getText());

			ModalController.closeStage(fxSubmit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Dialogs.showMessageDialog("Virheellisesti t�ytetyt tiedot");  
    	}
        //Dialogs.showMessageDialog("Ei  osata vielä lisätä!");
    }
    
    
    /* =================================================================== */
    
    private Mogul mogul;
    private Racer muokattavaRacer;
     
    /**
     * @param mogul alustetaan mogul
     */
    public void setMogul(Mogul mogul) {
        this.mogul = mogul;
    }
    
    
    public void setMuokattava(Racer racer) {
    	this.muokattavaRacer = racer;
    }
    
    
    protected void alusta() {
    	//System.out.println(muokattavaRacer.print());
		fxBid.setText(Integer.toString(muokattavaRacer.getBib()));
		fxFirstname.setText(muokattavaRacer.getEtunimi());
		fxSurname.setText(muokattavaRacer.getSukunimi());
		fxFis.setText(Integer.toString(muokattavaRacer.getFiscode()));
		fxTime.setText(Double.toString(muokattavaRacer.getAika()));
		fxJudge1.setText(Double.toString(muokattavaRacer.getTekniikka1()));
	    fxJudge2.setText(Double.toString(muokattavaRacer.getTekniikka2()));
	    fxJudge3.setText(Double.toString(muokattavaRacer.getTekniikka3()));
	    fxJump1.setText(Double.toString(muokattavaRacer.getHyppy1()));
	    fxJump2.setText(Double.toString(muokattavaRacer.getHyppy2()));
	    fxJumpID.setText(Integer.toString(muokattavaRacer.getHyppyId()));
	    fxTime.setText(Double.toString(muokattavaRacer.getAika()));	    
	}
    
    
    /**
     * Luo ja lisää kilpailijan listaan
     * @param etu etunimi
     * @param suku sukunimi
     * @param bib kisanumero
     * @param fis fis-koodi
     */
    public void lisaaKilpailija(String etu, String suku, String bib, String fis) {
        mogul.lisaaKilpailija(etu, suku, Integer.parseInt(bib), Integer.parseInt(fis));
    }
    
    
    /**
     * Muokkaa halutun laskijan tietoja.
     * @param tunnusn
     */
    public void muokkaaKilpailija(Racer muokattava) {
    	muokattava.setEtunimi(fxFirstname.getText());
    	muokattava.setSukunimi(fxSurname.getText());
    	muokattava.setBib(Integer.parseInt(fxBid.getText()));
    	muokattava.setFis(Integer.parseInt(fxFis.getText()));
    	muokattava.setAika(Double.parseDouble(fxTime.getText()));
    	muokattava.setTekniikkapiste1(Double.parseDouble(fxJudge1.getText()));
    	muokattava.setTekniikkapiste2(Double.parseDouble(fxJudge2.getText()));
    	muokattava.setTekniikkapiste3(Double.parseDouble(fxJudge3.getText()));
    	muokattava.setHyppytuomari1(Double.parseDouble(fxJump1.getText()));
    	muokattava.setHyppytuomari2(Double.parseDouble(fxJump2.getText()));
    	muokattava.setHyppyid(Integer.parseInt(fxJumpID.getText()));
    	double kerroin = mogul.getKerroin(Integer.parseInt(fxJumpID.getText()));
    	int pituus = mogul.getKilpailu().getRinne();
    	//lisaaKilpailija(fxFirstname.getText(), fxSurname.getText(), fxBid.getText(), fxFis.getText());
        muokattava.asetaHyppypisteet(kerroin, Double.parseDouble(fxJump1.getText()), Double.parseDouble(fxJump2.getText()));
        muokattava.asetaTekniikkapisteet(Double.parseDouble(fxJudge1.getText()),Double.parseDouble(fxJudge2.getText()), Double.parseDouble(fxJudge3.getText()));
        muokattava.asetaAikapisteet(pituus, Double.parseDouble(fxTime.getText()));
        
        mogul.muokkaaKilpailija(muokattava);
    }
    
    
    /**
     * Lisää kilpailijalle hyppypisteet
     * @param fis kilpailijan fis-koodi
     * @param jumpId hypyn id
     * @param jump1 tuomarin 1 pisteet
     * @param jump2 tuomarin 2 pisteet
     */
    public void laskeHyppypisteet(String fis, String jumpId, String jump1, String jump2) {
        mogul.laskeHyppypisteet(mogul.getTunnusNro(Integer.parseInt(fis)), Integer.parseInt(jumpId), Double.parseDouble(jump1), Double.parseDouble(jump2));
    }
    
    
    /**
     * Lsää laskijan tekniikkapisteet
     * @param fis kilpailijan fis-koodi
     * @param judge1 tuomarin 1 pisteet
     * @param judge2 tuomarin 2 pisteet
     * @param judge3 tuomarin 3 pisteet
     */
    public void laskeTekniikkapisteet(String fis, String judge1, String judge2, String judge3) {
        mogul.laskeTekniikkapisteet(mogul.getTunnusNro(Integer.parseInt(fis)), Double.parseDouble(judge1), Double.parseDouble(judge2), Double.parseDouble(judge3));
    }
    
    
    /**
     * Lakee kilpailijan aikapisteet
     * @param fis kilpialijn fis-koodi
     * @param aika kilpailijan aika
     */
    public void laskeAikapisteet(String fis, String aika) {
        mogul.laskeAikapisteet(mogul.getTunnusNro(Integer.parseInt(fis)), Double.parseDouble(aika), mogul.getKilpailu().getRinne());
    }

}
