package com.javathree.librarysystem;

import java.io.IOException;

import com.javathree.librarysystem.library_classes.LibraryInfo;
import com.javathree.librarysystem.library_classes.Member;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class removeMemberController {
    
    @FXML
    private TextField memberID;

    @FXML
    private Label statusLabel;

    @FXML
    private Text message;

    // @FXML
    // private void switchToPrimary() throws IOException {
    //     App.setRoot("primary");
    // }

    @FXML
    private void removeMember() throws IOException {
        
        try {
            int id = Integer.parseInt(memberID.getText());

            Member removedMember = null;

            for (Member member : LibraryInfo.members) {
                if (member.getMemberID() == id) {
                    removedMember = member;
                    LibraryInfo.members.remove(removedMember);
                    break;
                }
            }

            if (removedMember == null) {
                message.setText("Member not found.");
            } else {
                message.setText("Member removed successfully.");
            }

        } catch (Exception e) {
            message.setText("Member ID cannot be empty. Try again.");
        }

    }

    @FXML
    private void returnRemoveMember() throws IOException {
        App.setRoot("primary");
    }
    
}
