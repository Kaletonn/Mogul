package fxMogul;


import fi.jyu.mit.fxgui.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SearchresultsController {

    @FXML
    private Button fxExit;

    @FXML
    private Button fxPrint;

    @FXML
    void handleExit(ActionEvent event) {
        Stage stage = (Stage) fxExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void handlePrint(ActionEvent event) {
        Dialogs.showMessageDialog("Ei  osata vielä lisätä!");
    }

}
