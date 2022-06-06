package fxMogul;


import Mogul.*;
import fi.jyu.mit.fxgui.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Topi
 * @version 16.2.2022
 *
 */
public class NewRaceController{

    @FXML
    private Button fxBack;

    @FXML
    private Button fxSubmit;

    @FXML
    private TextField textCompName;

    @FXML
    private TextField textSlope;

    
    @FXML
    // Ei toimi?
    void handleBack(ActionEvent event) {
        Stage stage = (Stage) fxBack.getScene().getWindow();
        stage.close();
    }
    
    
    
    @FXML
    void handleSubmit() {
        uusi();
}


/**
==================================================================================**/
    private Mogul mogul;
 
    
    /**
     * @param mogul kilpailu
     */
    public void setMogul(Mogul mogul) {
        this.mogul = mogul;
    }
    
    
    /**
     * 
     */
    public void uusiKilpailu() {
        String pituus = textSlope.getText();
        String nimi = textCompName.getText().toString();
        this.mogul.luoKilpailu(nimi, Integer.valueOf(pituus));
    }
    
    
    /**
     * Testataan annettujen tietojen oikeellisuus, ja luodaan uusi kilpailu hyväksytyillä tiedoilla
     */
    private void uusi() {
        String nimi = textCompName.getText();
        String pituus = textSlope.getText();
        
        mogul = new Mogul();
        
        try {  
            Integer.parseInt(pituus);
            if (nimi.equals("") || pituus.equals("")) {
                Dialogs.showMessageDialog("Kilpailun tiedot virheelliset!");
             } else {
                 try
                 {
                     uusiKilpailu();
                     mogul.setTiedostonimi(nimi);
                     
                     if(!mogul.lueTiedostot()) {
                         if (Dialogs.showQuestionDialog("Uusikilpailu",
                                 "Haluatko luoda uuden kilpailun " 
                                 + nimi ,"Kylla", "Ei")) {
                             mogul.setTiedostonimi(nimi);
                             mogul.luoTiedosto();
                             uusi();
                             return;
                          }
                             return;
                         }
                     
                     System.out.println(nimi);

                     Stage stage = new Stage();
                     FXMLLoader ldr = new FXMLLoader(getClass().getResource("Race.fxml"));
                     final Pane root = ldr.load();
                     final RaceController mogulCtrl = (RaceController) ldr.getController();
                     
                     mogulCtrl.setMogul(mogul);
                     
                     Scene scene = new Scene(root);
                     stage.setScene(scene);
                     stage.setTitle("New Race");
                     stage.showAndWait();
                     /*primaryStage.setScene(scene);
                     primaryStage.setTitle("Mogul");
                     primaryStage.show();*/
                 } catch(Exception e) {
                     e.printStackTrace();
                 }
               }
          } catch(NumberFormatException e){  
              Dialogs.showMessageDialog("Kilpailun tiedot virheelliset!\n-Ei tyhjiä kenttiä\n-Pituus kokonaislukuna");  
          }  
     }
}
