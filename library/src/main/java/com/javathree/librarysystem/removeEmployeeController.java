package com.javathree.librarysystem;

import java.io.IOException;

import com.javathree.librarysystem.library_classes.LibraryInfo;
import com.javathree.librarysystem.library_classes.Employee;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class removeEmployeeController {

    @FXML
    private TextField employeeID;

    @FXML
    private Label statusLabel;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void removeEmployee(){
        try {
            int id = Integer.parseInt(employeeID.getText());

            boolean removedEmployee = false;

            for (Employee employee : LibraryInfo.employees) {
                if (employee.getEmployeeID() == id) {
                    LibraryInfo.employees.remove(employee);
                    removedEmployee = true;
                    break;
                }
            }

            if (!removedEmployee) {
                statusLabel.setVisible(true);
                statusLabel.setText("Employee not found.");
            } else {
                statusLabel.setVisible(true);
                statusLabel.setText("Employee removed successfully.");
            }

        } catch (Exception e) {
            statusLabel.setVisible(true);
            statusLabel.setText("Employee ID cannot be empty. Try again.");
        }
    }
}