package com.javathree.librarysystem;

import java.io.IOException;

import com.javathree.librarysystem.library_classes.LibraryInfo;
import com.javathree.librarysystem.library_classes.LibraryCollection;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class removeCollectionController {

    @FXML
    private TextField collectionID;

    @FXML
    private Label statusLabel;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void removeCollection() {
        String id = this.collectionID.getText().trim();

        if (id.isEmpty()) {
            statusLabel.setVisible(true);
            statusLabel.setText("Collection ID cannot be empty.");
            return;
        }

        LibraryCollection removedCollection = LibraryInfo.removeCollection(id);

        if (removedCollection == null) {
            statusLabel.setVisible(true);
            statusLabel.setText("Collection not found.");
        } else {
            statusLabel.setVisible(true);
            statusLabel.setText("Collection removed successfully.");
        }
    }
}