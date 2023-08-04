package com.javathree.librarysystem.library_classes;

import java.time.LocalDate;

public final class Technician extends Employee {
    public Technician(String name, String address, LocalDate dob, String email, int ssn, int memberID) {
        super(name, address, dob, email, ssn, memberID);
    }

    @Override
    public String toString() {
        return "Technician " + super.toString();
    }
}

// pdf notes:
// The technicians tend to sort the
// returned books and re-shelve them in the correct location.