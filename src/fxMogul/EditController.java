package fxMogul;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class EditController {

    @FXML
    private Button fxBack;

    @FXML
    private Button fxJumps;

    @FXML
    private Button fxSlopes;

    @FXML
    void handleBack(ActionEvent event) {
        Stage stage = (Stage) fxBack.getScene().getWindow();
        stage.close();
    
    	}

    @FXML
    void handleJumps(ActionEvent event) {
    	try
    	{
    		Stage stage = new Stage();
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("Jumps.fxml"));
            final Pane root = ldr.load();  
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Jumps");
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

    @FXML
    void handleSlopes(ActionEvent event) {
    	try
    	{
    		Stage stage = new Stage();
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("Slopes.fxml"));
            final Pane root = ldr.load();
            //final MogulGUIController mogulCtrl = (MogulGUIController) ldr.getController();
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Slopes");
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

    
    //========================
    

}
