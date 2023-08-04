package com.javathree.librarysystem;

import java.io.IOException;

import com.javathree.librarysystem.library_classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.security.InvalidParameterException;
import javafx.scene.text.Text;

public class NewMemberController {

    ObservableList<String> accountTypeList = FXCollections.observableArrayList("Student", "Professor", "External");
    
    @FXML
    private ChoiceBox<String> accountType = new ChoiceBox<>();
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
    private TextField id;
    @FXML
    private TextField school;
    @FXML
    private TextField major;
    @FXML
    private TextField studentid;
    @FXML
    private TextField department;

    @FXML
    private Text message;

    private int attempts = 0;

    @FXML
    private void initialize() {
        accountType.setItems(accountTypeList);
    }

    @FXML
    private void submitNewMember() throws IOException {
        try {
            String memberType = this.accountType.getValue();
            String name = this.name.getText();
            String address = this.address.getText();
            LocalDate dob = this.dob.getValue();
            String email = this.email.getText();
            int ssn = Integer.parseInt(this.ssn.getText());
            int memberID = Integer.parseInt(this.id.getText());
            String school = this.school.getText();
            String major = this.major.getText();
            int studentID = Integer.parseInt(this.studentid.getText());
            String department = this.department.getText();

            for (Member member : LibraryInfo.members)
                if (member.getSsn() == ssn || member.getMemberID() == memberID)
                    throw new IllegalStateException();

            Member mem;
            if (memberType.equals("Student")) {
                mem = new Student(name, address, dob, email, ssn, memberID, school, major, studentID);
                LibraryInfo.members.add(mem);
            } else if (memberType.equals("Professor")) {
                mem = new Professor(name, address, dob, email, ssn, memberID, department);
                LibraryInfo.members.add(mem);
            } else if (memberType.equals("External")) {
                mem = new External(name, address, dob, email, ssn, memberID);
                LibraryInfo.members.add(mem);
            } else {
                throw new InvalidParameterException();
            }

            message.setText(mem.toString());
            this.attempts = 0;
        } catch (Exception e) {
            this.attempts++;
            message.setText("Try again. Attempt " + this.attempts + '.');
        }
    }

    @FXML
    private void returnNewMember() throws IOException {
        App.setRoot("primary");
    }
}