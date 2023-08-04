package com.javathree.librarysystem.library_classes;

import java.time.LocalDate;

public final class Librarian extends Employee {
    public Librarian(String name, String address, LocalDate dob, String email, int ssn, int memberID) {
        super(name, address, dob, email, ssn, memberID);
    }

    @Override
    public String toString() {
        return "Librarian " + super.toString();
    }
}

// pdf notes:
// The librarians are responsible for managing the collections and helping
// customers with the resources. Librarians also manage the memberships.