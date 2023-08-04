package com.javathree.librarysystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.security.InvalidParameterException;

//import com.javathree.librarysystem.library_classes.LibraryInfo;
import com.javathree.librarysystem.library_classes.*;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
//import javafx.scene.control.TextField;

public class removeItemController {
    ObservableList<String> itemType = FXCollections.observableArrayList("DVD", "Book", "Journal", "Newspaper");

    @FXML
    private ChoiceBox<String> collection = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> type = new ChoiceBox<>();

    @FXML
    private TextField isbn;

    @FXML
    private TextField issn;

    @FXML
    private Label statusLabel;

    @FXML
    private void initialize() {
        collection.setItems(FXCollections.observableArrayList(LibraryInfo.getCollectionsList()));
        type.setItems(itemType);
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void removeItem() {
        try {
            LibraryCollection collection = null;
            String type = this.type.getValue();

            for (LibraryCollection collectionSearch : LibraryInfo.libraryCollections)
                if (this.collection.getValue().equals(collectionSearch.getName() + " - " + collectionSearch.getID())) {
                    collection = collectionSearch;
                    break;
                }

            if (collection == null) {
                statusLabel.setVisible(true);
                statusLabel.setText("Invalid collection.");
                throw new NoSuchElementException();
            }

            List<ISBNItem> isbnItems = new ArrayList<>();
            List<ISSNItem> issnItems = new ArrayList<>();

            if (type.equals("Book")) {
                long isbn = Long.parseLong(this.isbn.getText());
                isbnItems = collection.getItemsByISBN(isbn);
            } else if (type.equals("DVD")) {
                long isbn = Long.parseLong(this.isbn.getText());
                isbnItems = collection.getItemsByISBN(isbn);
            } else if (type.equals("Newspaper")) {
                int issn = Integer.parseInt(this.issn.getText());
                issnItems = collection.getItemsByISSN(issn);
            } else if (type.equals("Journal")) {
                int issn = Integer.parseInt(this.issn.getText());
                issnItems = collection.getItemsByISSN(issn);
            } else {
                statusLabel.setVisible(true);
                statusLabel.setText("Invalid type.");
                throw new InvalidParameterException();
            }

            statusLabel.setVisible(true);
            this.statusLabel.setText("Item(s) removed:\n");

            for (Item removedItem : isbnItems) {
                collection.removeItem(removedItem);
                this.statusLabel.setText(this.statusLabel.getText() + '\n' + removedItem.toString());
            }
            for (Item removedItem : issnItems) {
                collection.removeItem(removedItem);
                this.statusLabel.setText(this.statusLabel.getText() + '\n' + removedItem.toString());
            }

            this.collection.setValue(null);
            this.type.setValue(null);
            this.isbn.clear();
            this.issn.clear();
        } catch (Exception e) {
            statusLabel.setVisible(true);
            statusLabel.setText("Try again.");
        }
    }
}
