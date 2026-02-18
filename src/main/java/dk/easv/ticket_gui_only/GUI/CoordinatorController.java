package dk.easv.ticket_gui_only.GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class CoordinatorController {

    @FXML
    private VBox eventsContainer;

    // Dummy data (GUI-only)
    private final List<EventCardData> demoEvents = List.of(
            new EventCardData("Spring Party 2026", "20 Feb 2026 19:00", "Bar Hall"),
            new EventCardData("Wine Tasting", "22 Feb 2026 18:30", "Room C3"),
            new EventCardData("Board Game Night", "25 Feb 2026 17:00", "Lounge")
    );

    @FXML
    public void initialize() {
        eventsContainer.getChildren().clear(); // won't crash now
    }

    private void renderEvents() {
        eventsContainer.getChildren().clear();

        for (EventCardData e : demoEvents) {
            eventsContainer.getChildren().add(createEventCard(e));
        }
    }

    private HBox createEventCard(EventCardData e) {
        // Left text
        VBox left = new VBox(4);
        Label title = new Label(e.title());
        title.getStyleClass().add("card-title");

        Label time = new Label(e.time());
        time.getStyleClass().add("card-sub");

        Label location = new Label(e.location());
        location.getStyleClass().add("card-sub");

        left.getChildren().addAll(title, time, location);

        // Right button
        Button openBtn = new Button("Open");
        openBtn.getStyleClass().add("primary");
        openBtn.setOnAction(evt -> {
            // GUI-only: later you can open detail window; for now do nothing / add placeholder
            System.out.println("Open: " + e.title());
        });

        HBox card = new HBox(10, left, openBtn);
        card.getStyleClass().add("event-card");
        card.setMinHeight(70);

        // Push button to right
        HBox.setHgrow(left, javafx.scene.layout.Priority.ALWAYS);

        return card;
    }

    @FXML
    private void onCreateEvent() {
        // GUI-only placeholder
        System.out.println("Create event clicked");
    }

    @FXML
    private void onLogout() throws IOException {
        switchScene("LoginView.fxml");
    }

    private void switchScene(String fxml) throws IOException {
        Stage stage = (Stage) eventsContainer.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dk.easv.ticket_gui_only/" + fxml));
        Scene scene = new Scene(loader.load());

        // attach same CSS
        scene.getStylesheets().add(getClass().getResource("/dk.easv.ticket_gui_only/app.css").toExternalForm());

        stage.setScene(scene);
    }

    // tiny record for dummy event data
    private record EventCardData(String title, String time, String location) {}
}
