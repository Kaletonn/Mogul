package fxMogul;
import fi.jyu.mit.fxgui.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class JumpsController {

    @FXML
    private Button fxAdd;

    @FXML
    private Button fxDelete;

    @FXML
    private Button fxEdit;

    @FXML
    private Button fxExit;

    @FXML
    private TableColumn<?, ?> fxLength;

    @FXML
    private TableColumn<?, ?> fxSlope;

    @FXML
    void handleAdd(ActionEvent event) {
    	try
    	{
    		Stage stage = new Stage();
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("AddJump.fxml"));
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
    void handleDelete(ActionEvent event) {
        Dialogs.showMessageDialog("Ei  osata vielä tehdä!");
    }

    @FXML
    void handleEdit(ActionEvent event) {
    	try
    	{
    		Stage stage = new Stage();
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("AddJump.fxml"));
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
    void handleExit(ActionEvent event) {
        Stage stage = (Stage) fxExit.getScene().getWindow();
        stage.close();
    }

}
