package dk.easv.ticket_gui_only.GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController {
    @FXML
    private Label welcomeText;

    @FXML
    private void onHelloButtonClick() throws IOException {
        Stage stage = (Stage) welcomeText.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dk/easv/ticket_gui_only/CoordinatorView.fxml"));
        Scene scene = new Scene(loader.load());

        System.out.println("CSS = " + getClass().getResource("/dk/easv/ticket_gui_only/app.css"));

        // IMPORTANT: correct CSS path
        scene.getStylesheets().add(getClass().getResource("/dk.easv.ticket_gui_only/app.css").toExternalForm());

        stage.setScene(scene);
    }


}

