package com.javathree.librarysystem;

import com.javathree.librarysystem.library_classes.*;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class newEmployeeController {
    ObservableList<String> employeeTypeList = FXCollections.observableArrayList("Librarian", "Technician");

    @FXML
    private ChoiceBox<String> employeeType = new ChoiceBox<>();

    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField email;

    @FXML
    private TextField ssn;

    @FXML
    private TextField empID;

    @FXML
    private Text message;

    private int attempts = 0;

    @FXML
    private void initialize() {
        employeeType.setItems(employeeTypeList);
    }

    @FXML
    private void submitNewEmployee() throws IOException {
        try {
            String empType = this.employeeType.getValue();
            String name = this.name.getText();
            String address = this.address.getText();
            LocalDate dob = this.dob.getValue();
            String email = this.email.getText();
            int ssn = Integer.parseInt(this.ssn.getText());
            int employeeID = Integer.parseInt(this.empID.getText());

            for (Employee employee : LibraryInfo.employees)
                if (employee.getSsn() == ssn || employee.getEmployeeID() == employeeID)
                    throw new IllegalStateException();

            Employee emp;
            if (empType.equals("Librarian")) {
                emp = new Librarian(name, address, dob, email, ssn, employeeID);
                LibraryInfo.employees.add(emp);
            } else if (empType.equals("Technician")) {
                emp = new Technician(name, address, dob, email, ssn, employeeID);
                LibraryInfo.employees.add(emp);
            } else {
                throw new InvalidParameterException();
            }
            message.setText(emp.toString());
            this.attempts = 0;
        } catch (Exception e) {
            this.attempts++;
            message.setText("Try again. Attempt " + this.attempts + '.');
        }
    }

    @FXML
    private void returnNewEmployee() throws IOException {
        App.setRoot("primary");
    }
}
