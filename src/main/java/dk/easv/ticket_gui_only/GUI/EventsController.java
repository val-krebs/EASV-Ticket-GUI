package dk.easv.ticket_gui_only.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EventsController {

    @FXML
    private VBox eventsList;

    @FXML
    private void onDeleteClicked(ActionEvent event) {
        // The delete button is inside the event "card" (an HBox with styleClass="card")
        Node source = (Node) event.getSource();

        // Walk up until we find the HBox card
        Node current = source;
        while (current != null && !(current instanceof HBox)) {
            current = current.getParent();
        }

        if (current instanceof HBox card && eventsList != null) {
            eventsList.getChildren().remove(card); // GUI-only "delete"
        }
    }
}
