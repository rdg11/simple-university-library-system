package com.javathree.librarysystem.library_classes;

import java.security.InvalidParameterException;
import java.time.LocalDate;

public abstract class ISSNItem extends Item {
    // 8-digit ISSN
    private int issn;

    protected ISSNItem(int issn, String title, LocalDate publicationDate, String[] authors) {
        super(title, publicationDate, authors);

        try {
            this.setISSN(issn);
        } catch (InvalidParameterException e) {
            throw e;
        }
    }

    private void setISSN(int issn) throws InvalidParameterException {
        if (issn < 0 || issn > 99999999)
            throw new InvalidParameterException("Error: Attempted to set invalid journal ISSN");

        this.issn = issn;
    }

    protected int getISSN() {
        return this.issn;
    }

    @Override
    public String toString() {
        return String.format("ISSN: %08d", this.getISSN()) + '\n' + super.toString();
    }
}
