package fxMogul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StatisticsController {

    @FXML
    private Button fxSearch;

    @FXML
    private TextField textRaces;

    @FXML
    private TextField textSkiers;

    @FXML
    void handleSearch(ActionEvent event) {
    	try
    	{
    		Stage stage = new Stage();
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("Searchresults.fxml"));
            final Pane root = ldr.load();
            //final MogulGUIController mogulCtrl = (MogulGUIController) ldr.getController();
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Search results");
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

}
