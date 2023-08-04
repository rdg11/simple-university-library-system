package com.javathree.librarysystem.library_classes;

import java.time.LocalDate;

public abstract class Employee extends Person {
    private int employeeID;

    public Employee(String name, String address, LocalDate dob, String email, int ssn, int employeeID) {
        super(name, address, dob, email, ssn);
        setID(employeeID);
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    private void setID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Employee\n" + super.toString() + String.format("\nEmployee ID: %d", this.getEmployeeID());
    }
}
