package com.javathree.librarysystem;

import com.javathree.librarysystem.library_classes.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class newCollectionController {
    @FXML
    private TextField name;
    @FXML
    private TextField id;

    @FXML
    private Text message;

    private int attempts = 0;

    @FXML
    private void submitNewCollection() throws IOException {
        try {
            String name = this.name.getText();
            String id = this.id.getText();

            for (LibraryCollection collection : LibraryInfo.libraryCollections)
                if (name.equals(collection.getName()) || id.equals(collection.getID()))
                    throw new IllegalStateException();

            LibraryCollection collection = new LibraryCollection(name, id);
            LibraryInfo.libraryCollections.add(collection);
            message.setText(collection.toString());
            this.attempts = 0;
        } catch (Exception e) {
            this.attempts++;
            message.setText("Try again. Attempt " + this.attempts + '.');
            e.printStackTrace();
        }
    }

    @FXML
    private void returnNewCollection() throws IOException {
        App.setRoot("primary");
    }
}
