package fxMogul;

import Mogul.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Topi
 * @version 19.1.2022
 *
 */
public class MogulGUIController{
    @FXML
    private Button fxEdit;

    @FXML
    private Button fxExit;

    @FXML
    private Button fxNewRace;

    @FXML
    private Button fxStatistics;
    
    @FXML
    void handleExit() {
            exit();
    }
    
    


    @FXML
    void handleEdit(ActionEvent event) {
    	
    	try {

    		Stage stage = new Stage();
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("Edit.fxml"));
            final Pane root = ldr.load();
            //final MogulGUIController mogulCtrl = (MogulGUIController) ldr.getController();
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Edit");
            stage.showAndWait();
            /*primaryStage.setScene(scene);
            primaryStage.setTitle("Mogul");
            primaryStage.show();*/
        } catch(Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    void handleNewRace() {
    	try {

    		Stage stage = new Stage();
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("NewRace.fxml"));
            final Pane root = ldr.load();
            final NewRaceController mogulCtrl = (NewRaceController) ldr.getController();
            
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
    
    
    @FXML
    void handleStatistics(ActionEvent event) {
    
    	try {

    		Stage stage = new Stage();
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("Statistics.fxml"));
            final Pane root = ldr.load();
            //final MogulGUIController mogulCtrl = (MogulGUIController) ldr.getController();
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Statistics");
            stage.showAndWait();
            /*primaryStage.setScene(scene);
            primaryStage.setTitle("Mogul");
            primaryStage.show();*/
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     */
    // ================================================================================================================
    
    private Mogul mogul;
    
    
    
    
    public void exit() {
        Platform.exit();
    }


    /**
     * Tarkistetaan onko tallennys tehty
     * @return true jos saa sulkea sovelluksen, false jos ei
     */
    public boolean voikoSulkea() {
        return true;
    }
    

    /**
     * @param mogul kilpailu jota käytetään tässä käyttöliittymässä
     */
    public void setMogul(Mogul mogul) {
        this.mogul= mogul;
        
    }
    
    
    
    
}