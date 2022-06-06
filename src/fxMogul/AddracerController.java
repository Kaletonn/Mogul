package fxMogul;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Mogul.*;

/**
 * @author Topi
 * @version 18.2.2022
 *
 */
public class AddracerController {


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

    @FXML
    void handleClose() {
        Stage stage = (Stage) fxClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    void handleSubmit() {
    
        try {
			lisaaKilpailija(fxFirstname.getText(), fxSurname.getText(), fxBid.getText(), fxFis.getText());
			laskeHyppypisteet(fxFis.getText(), fxJumpID.getText(), fxJump1.getText(), fxJump2.getText());
			laskeTekniikkapisteet(fxFis.getText(), fxJudge1.getText(), fxJudge2.getText(), fxJudge3.getText());
			laskeAikapisteet(fxFis.getText(), fxTime.getText());
			ModalController.closeStage(fxSubmit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
            Dialogs.showMessageDialog("Virheellisesti t�ytetyt tiedot");  
		}
        //Dialogs.showMessageDialog("Ei  osata vielä lisätä!");
    }
    
    
    /* =================================================================== */
    
    private Mogul mogul;
    
    
    /**
     * @param mogul alustetaan mogul
     */
    public void setMogul(Mogul mogul) {
        this.mogul = mogul;
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
