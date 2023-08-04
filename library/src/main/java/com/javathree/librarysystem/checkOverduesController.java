package com.javathree.librarysystem;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class checkOverduesController {
    @FXML
    private TextArea overdues;
    
    @FXML
    private ListView<String> overdueItemsList;

    @FXML
    private Button fetchOverdueItemsBtn;
    
    @FXML
    private void initialize() {
        fetchOverdueItems();
    }

    @FXML
    private void fetchOverdueItems() {
        ObservableList<String> overdueItems = FXCollections.observableArrayList("Overdue Item 1", "Overdue Item 2");
        overdueItemsList.setItems(overdueItems);
    }
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}