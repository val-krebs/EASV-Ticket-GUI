package dk.easv.ticket_gui_only;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("LoginView.fxml"));
        Scene scene = new Scene(loader.load());

        scene.getStylesheets().add(MainApplication.class.getResource("app.css").toExternalForm());

        stage.setResizable(false);
        stage.setTitle("EASV Ticket GUI");
        stage.setScene(scene);
        stage.show();

    }
}
