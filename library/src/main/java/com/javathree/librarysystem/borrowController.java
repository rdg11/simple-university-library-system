package com.javathree.librarysystem;

import com.javathree.librarysystem.library_classes.*;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class borrowController {
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
    private void returnBorrow() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void submitBorrow() throws IOException {
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

            Item itemToBorrow = null;

            String itemType = type.getValue();
            if (itemType.equals("Book") || itemType.equals("DVD")) {
                long isbn = Long.parseLong(this.isbn.getText());
                for (ISBNItem item : LibraryInfo.findISBN(isbn)) {
                    if (!item.isBorrowed()) {
                        itemToBorrow = item;
                        break;
                    }
                }
            } else if (itemType.equals("Journal") || itemType.equals("Newspaper")) {
                int issn = Integer.parseInt(this.issn.getText());
                for (ISSNItem item : LibraryInfo.findISSN(issn)) {
                    if (!item.isBorrowed()) {
                        itemToBorrow = item;
                        break;
                    }
                }
            } else {
                message.setText("Invalid item type.");
                throw new InvalidParameterException();
            }
            if (itemToBorrow == null) {
                message.setText("Item unavailable.");
                throw new NoSuchElementException();
            }
            memberSignedIn.addItem(itemToBorrow);
            itemToBorrow.setBorrowedDate(LocalDate.now());
            message.setText(itemToBorrow.toString());
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
