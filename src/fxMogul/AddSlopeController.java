package fxMogul;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddSlopeController {

    @FXML
    private Button fxBack;

    @FXML
    private Button fxAdd;

    @FXML
    private Button fxClear;

    @FXML
    private TextField textLength;

    @FXML
    private TextField textSlopename;

    @FXML
    void handleAdd(ActionEvent event) {
        Dialogs.showMessageDialog("Ei  osata vielä lisätä!");
    }

    @FXML
    void handleBack(ActionEvent event) {
        Stage stage = (Stage) fxBack.getScene().getWindow();
        stage.close();
    }

    @FXML
    void handleClear(ActionEvent event) {
        Dialogs.showMessageDialog("Ei  osata vielä tehdä!");
    }

}
