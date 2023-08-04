package com.javathree.librarysystem.library_classes;

import java.time.LocalDate;

abstract class Person {
    private String name;
    private String address;
    private LocalDate dob;
    private String email;
    private int ssn;

    public Person(String name, String address, LocalDate dob, String email, int SSN) {
        this.setName(name);
        this.setAddress(address);
        this.setDob(dob);
        this.setEmail(email);
        this.setSsn(SSN);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    private void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    private void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public int getSsn() {
        return this.ssn;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAddress: %s\nDOB: %tF\nEmail: %s\nSSN: %d", this.getName(), this.getAddress(),
                this.getDob(),
                this.getEmail(), this.getSsn());
    }
}
