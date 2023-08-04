package com.javathree.librarysystem;

import java.io.IOException;

import com.javathree.librarysystem.library_classes.*;
// import java.io.IOException;
import java.security.InvalidParameterException;
// import java.time.LocalDate;
import java.util.NoSuchElementException;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class returnController {
    ObservableList<String> itemType = FXCollections.observableArrayList("DVD", "Book", "Journal", "Newspaper");
    @FXML
    private TextField memberId;
    @FXML
    private ChoiceBox<String> type = new ChoiceBox<>();
    @FXML
    private TextField isbn;
    @FXML
    private TextField issn;

    @FXML
    private Text message;

    private int attempts = 0;
    
    @FXML
    private void initialize() {
        type.setItems(itemType);
    }

    @FXML
    private void returnReturn() throws IOException {
        App.setRoot("primary");
    }


    @FXML
    private void submitReturn() throws IOException {
        message.setText(null);
        try {
            int memberID = Integer.parseInt(memberId.getText());
            Member memberSignedIn = null;

            for (Member member : LibraryInfo.members) {
                if (member.getMemberID() == memberID) {
                    memberSignedIn = member;
                    break;
                }
            }

            if (memberSignedIn == null) {
                message.setText("Member not found.");
                throw new NoSuchElementException();
            }

            Item itemToReturn = null;

            String itemType = type.getValue();

            if (itemType.equals("Book") || itemType.equals("DVD")) {
                long isbn = Long.parseLong(this.isbn.getText());
                itemToReturn = memberSignedIn.removeBookItem(isbn);
            } else if (itemType.equals("Journal") || itemType.equals("Newspaper")) {
                int issn = Integer.parseInt(this.issn.getText());
                itemToReturn = memberSignedIn.removeSerialItem(issn);
            } else {
                message.setText("Invalid item type.");
                throw new InvalidParameterException();
            }
            if (itemToReturn == null) {
                message.setText("Item does not exist.");
                throw new NoSuchElementException();
            }
            message.setText(itemToReturn.toString());
            this.attempts = 0;
            this.type.setValue(null);
            this.isbn.clear();
            this.issn.clear();
        } catch (Exception e) {
            this.attempts++;
            message.setText(message.getText() + ("\nTry again. Attempt " + this.attempts + '.'));
        }
    }


}
