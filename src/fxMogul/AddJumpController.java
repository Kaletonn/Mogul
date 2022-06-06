package fxMogul;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddJumpController {

    @FXML
    private Button fxBack;

    @FXML
    private Button fxAdd;

    @FXML
    private Button fxClear;

    @FXML
    private TextField textDifficulty;

    @FXML
    private TextField textJumpname;

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
        Dialogs.showMessageDialog("Ei  toimi vielä!");
    }

}
