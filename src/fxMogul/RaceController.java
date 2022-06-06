package fxMogul;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Mogul.Hyppy;
import Mogul.Mogul;
import Mogul.Racer;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.TextAreaOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Topi
 * @version 24.3.2022
 *
 */
public class RaceController implements Initializable {

    @FXML
    private Button fxAdd;

    @FXML
    private Button fxDelete;

    @FXML
    private Button fxEdit;

    @FXML
    private Button fxExit;

    @FXML
    private Button fxSave;
    
    @FXML
    private TextField hakuehto;
    
    @FXML
    private ListChooser<Racer> textListaus;
    
    @FXML
    private ListChooser<Hyppy> textHypyt;

    @FXML
    private ScrollPane panelRacer;
    
    
    @Override
    public void initialize(URL url, ResourceBundle bundle) {      
        alusta();
    }


    @FXML
    void handleValinta(MouseEvent event) {
    	naytaRacer();
    }
    
    
    @FXML
    void handleAdd(ActionEvent event) {    	
    	/*
        mogul.luoKilpailija(mogul.getKilpailunimi());
    	
    	*/
    	try
    	{
    		Stage stage = new Stage();
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("Addracer.fxml"));
            final Pane root = ldr.load();
            final AddracerController addRacerCtrl = (AddracerController) ldr.getController();
            
            addRacerCtrl.setMogul(mogul);
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Add racer");
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            /*
            primaryStage.setScene(scene);
            primaryStage.setTitle("Mogul");
            primaryStage.show();
            */
        } catch(Exception e) {
    		e.printStackTrace();
    	}
    	populate();
    }



    @FXML
    void handleDelete(ActionEvent event) {
        poistaRacer(textListaus.getSelectedObject());
    }

    
    @FXML
    void handleEdit(ActionEvent event) {
    	editoi(textListaus.getSelectedObject());
    	populate();
    }


	@FXML
    void handleExit(ActionEvent event) {
        Stage stage = (Stage) fxExit.getScene().getWindow();
        stage.close();
    }

    
    @FXML
    void handleSave(ActionEvent event) throws IOException{
    	tallenna();
    }
   


    @FXML private void handleHakuehto() {
        hae();
    }



// ===========================================================================
    
    private Mogul mogul;
    private Racer valittuRacer;
    private TextArea areaRacer = new TextArea();
    
    
    /**
     * Alustaa luetusta tiedostosta tiedot näyttöön.
     */
    protected void alusta() {
		panelRacer.setContent(areaRacer);
		areaRacer.setFont(new Font("Times New Roman", 20));
		
		textListaus.clear();
		textListaus.addSelectionListener(e -> naytaRacer());		
	}
    
    
    /**
     * Tallentaa halutun kilpailun.
     * @throws IOException
     */
    private void tallenna() throws IOException {
        mogul.tallenna();
        Dialogs.showMessageDialog("Tallennus OK!");
    }
    
    
    /**
     * @param mogul kilpailu
     */
    public void setMogul(Mogul mogul) {
        this.mogul = mogul;
        populateHypyt();
        populate();
    }
    
    
    private void populate() {
    	ArrayList<Racer> kilpailijat = mogul.getKilpailijat();
    	textListaus.clear();
    	for(Racer racer: kilpailijat) textListaus.add(racer);
//    	int lkm = mogul.getKilpailijaLkm();
//    	if (lkm < 1 ) return;
//    	textListaus.clear();
//    	for (int i = 0; i < lkm; i++) {
//    		textListaus.add(mogul.getKilpailija(i));
		//}		
	}
    
    
    /*
     * Alustaa hyppylistan ensimmÃ¤isen kerran
     */
    private void populateHypyt() {
        ArrayList<Hyppy> hypyt = mogul.getHypyt();
        textHypyt.clear();
        for (Hyppy hyppy : hypyt) textHypyt.add(hyppy);        
    }
    
    
    /*
     * pÃ¤ivittÃ¤Ã¤ hyppylistaa hakuehdon perusteella
     */
    private void hae() {
        ArrayList<Hyppy> hypyt = mogul.getHypyt();
        textHypyt.clear();
        for (Hyppy hyppy : hypyt) {
            String nimi = hyppy.getNimi();
            if(nimi.contains(hakuehto.getText())){
                textHypyt.add(hyppy);
            }
        }
    }
    
    
    /**
     * 
     * @param racer
     */
    private void editoi(Racer racer) {    	
    	if (racer == null) return;
    	Racer clone = racer.clone();
    	System.out.println(clone.print());
    	try
    	{
    		Stage stage = new Stage();
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("EditRacer.fxml"));
            final Pane root = ldr.load();
            final EditRacerController editCtrl = (EditRacerController) ldr.getController();            
            editCtrl.setMogul(mogul);
            editCtrl.setMuokattava(clone);
            editCtrl.alusta();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Edit racer");
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.APPLICATION_MODAL);         
            stage.showAndWait();
            /*primaryStage.setScene(scene);
            primaryStage.setTitle("Mogul");
            primaryStage.show();*/           
        } 
    	
    		catch(Exception e) {
    			e.printStackTrace();
    		}
	}
    
    
    /**
     * nï¿½yttï¿½ï¿½ listasya valitun laskijan tiedot ja tulostaa ne textfield kenttï¿½ï¿½n.
     */
    protected void naytaRacer() {
    	valittuRacer = textListaus.getSelectedObject();
    	if (valittuRacer == null) return;   	
    	areaRacer.setText("");
    	try (PrintStream os = TextAreaOutputStream.getTextPrintStream(areaRacer)) {
    		valittuRacer.tulosta(os);
    		System.out.println(valittuRacer.toString());
    	}
    }
    

    /**
     * Poistaa valitun kilpailijan listasta
     * @param racer poistettava kilpailija
     */
    protected void poistaRacer(Racer racer) {
		if (racer == null)
			return;
		if (Dialogs.showQuestionDialog("Varmista poisto", "Poistetaanko " + racer.getNimi(), "OK", "Ei")) {
			mogul.poista(racer);
		} else
			return;
		populate();
    }
    
    /**
     * Tulostaa racerin tiedot
     * @param os tietovirta johon tulostetaan  
     * @param racer valittu racer
     */
    public void tulosta(PrintStream os, final Racer racer) {
    	os.println("----------------------------------------------");
    	racer.tulosta(os);
    	os.println("----------------------------------------------");
    }
}


