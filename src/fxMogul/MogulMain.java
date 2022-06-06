package fxMogul;

import Mogul.Mogul;
import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author Topi
 * @version 19.1.2022
 *
 */
public class MogulMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
        	

            FXMLLoader ldr = new FXMLLoader(getClass().getResource("MogulGUIView.fxml"));
            final Pane root = ldr.load();
            final MogulGUIController mogulCtrl = (MogulGUIController) ldr.getController();
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("mogul.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Mogul");
            
            
            Mogul mogul = new Mogul();
            mogul.lueTiedostot();
            //TODO: alusta mogul eli käy lukemassa tiedostosta tiedot kilpailu- ja hypytolioihin
            mogulCtrl.setMogul(mogul);
            
           // primaryStage.setOnCloseRequest((event) -> {
            //    if (!mogulCtrl.voikoSulkea() ) event.consume();
           // });
            
            primaryStage.show();
           // if (!mogulCtrl.avaa() ) Platform.exit();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args Ei kï¿½ytï¿½ssï¿½
     */
    public static void main(String[] args) {
        launch(args);
    }
}