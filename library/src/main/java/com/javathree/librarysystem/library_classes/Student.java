package com.javathree.librarysystem.library_classes;

import java.time.LocalDate;

public final class Student extends Member {
    private String school;
    private String major;
    private int studentID;

    public Student(String name, String address, LocalDate dob, String email, int ssn, int memberID, String school,
            String major, int studentID) {
        super(name, address, dob, email, ssn, memberID);
        this.school = school;
        this.major = major;
        this.studentID = studentID;
    }

    // getters and setters
    public void setSchool(String school) {
        this.school = school;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getSchool() {
        return this.school;
    }

    public String getMajor() {
        return this.major;
    }

    public int getStudentID() {
        return this.studentID;
    }
}