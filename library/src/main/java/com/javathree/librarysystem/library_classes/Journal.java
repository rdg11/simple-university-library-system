package com.javathree.librarysystem.library_classes;

import java.security.InvalidParameterException;
import java.time.LocalDate;

public final class Journal extends ISSNItem {
    public Journal(int issn, String title, LocalDate publicationDate, String[] authors)
            throws InvalidParameterException {
        super(issn, title, publicationDate, authors);
    }

    @Override
    protected String getType() {
        return "Journal";
    }
}