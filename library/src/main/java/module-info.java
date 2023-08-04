module com.javathree.librarysystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.javathree.librarysystem to javafx.fxml;
    exports com.javathree.librarysystem;
}
