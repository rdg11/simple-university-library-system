package com.javathree.librarysystem;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToNewMember() throws IOException {
        App.setRoot("newMember");
    }

    @FXML
    private void switchToRemoveMember() throws IOException {
        App.setRoot("removeMember");
    }

    @FXML
    private void switchToNewEmployee() throws IOException {
        App.setRoot("newEmployee");
    }

    @FXML
    private void switchToRemoveEmployee() throws IOException {
        App.setRoot("removeEmployee");
    }

    @FXML
    private void switchToNewCollection() throws IOException {
        App.setRoot("newCollection");
    }

    @FXML
    private void switchToRemoveCollection() throws IOException {
        App.setRoot("removeCollection");
    }

    @FXML
    private void switchToNewItem() throws IOException {
        App.setRoot("newItem");
    }

    @FXML
    private void switchToRemoveItem() throws IOException {
        App.setRoot("removeItem");
    }

    @FXML
    private void switchToBorrow() throws IOException {
        App.setRoot("borrow");
    }

    @FXML
    private void switchToReturn() throws IOException {
        App.setRoot("return");
    }

    @FXML
    private void switchToCheckOverdues() throws IOException {
        App.setRoot("checkOverdues");
    }
}
