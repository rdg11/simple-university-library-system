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

public class newItemController {
    ObservableList<String> itemType = FXCollections.observableArrayList("DVD", "Book", "Journal", "Newspaper");

    @FXML
    private ChoiceBox<String> collection = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> type = new ChoiceBox<>();

    @FXML
    private TextField title;

    @FXML
    private DatePicker pub_date;

    @FXML
    private TextField authors;

    @FXML
    private TextField isbn;

    @FXML
    private TextField issn;

    @FXML
    private Text message;

    private int attempts = 0;

    @FXML
    private void initialize() {
        collection.setItems(FXCollections.observableArrayList(LibraryInfo.getCollectionsList()));
        type.setItems(itemType);
    }

    @FXML
    private void returnNewItem() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void submitNewItem() {
        this.message.setText(null);
        try {
            String title = this.title.getText();
            LocalDate pubDate = this.pub_date.getValue();
            String[] authors = this.authors.getText().split(", ");
            String type = this.type.getValue();

            if (authors.length <= 0)
            {
                this.message.setText("Author required.");
                throw new InvalidParameterException();
            }

            LibraryCollection collection = null;
            for (LibraryCollection collectionSearch : LibraryInfo.libraryCollections)
                if (this.collection.getValue().equals(collectionSearch.getName() + " - " + collectionSearch.getID())) {
                    collection = collectionSearch;
                    break;
                }

            if (collection == null) {
                this.message.setText("Invalid collection.");
                throw new NoSuchElementException();
            }

            Item item;
            if (type.equals("Book")) {
                long isbn = Long.parseLong(this.isbn.getText());
                item = new Book(isbn, title, pubDate, authors);
            } else if (type.equals("DVD")) {
                long isbn = Long.parseLong(this.isbn.getText());
                item = new DVD(isbn, title, pubDate, authors);
            } else if (type.equals("Newspaper")) {
                int issn = Integer.parseInt(this.issn.getText());
                item = new Newspaper(issn, title, pubDate, authors);
            } else if (type.equals("Journal")) {
                int issn = Integer.parseInt(this.issn.getText());
                item = new Journal(issn, title, pubDate, authors);
            } else {
                this.message.setText("Invalid type.");
                throw new InvalidParameterException();
            }

            collection.addItem(item);
            this.message.setText(item.toString());
            this.attempts = 0;
            this.title.clear();
            this.pub_date.setValue(null);
            this.authors.clear();
            this.isbn.clear();
            this.issn.clear();
        } catch (Exception e) {
            this.attempts++;
            this.message.setText(message.getText() + ("\nTry again. Attempt " + this.attempts + '.'));
            e.printStackTrace();
        }
    }
}
