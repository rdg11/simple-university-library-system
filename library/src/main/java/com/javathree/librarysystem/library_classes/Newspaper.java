package com.javathree.librarysystem.library_classes;

import java.security.InvalidParameterException;
import java.time.LocalDate;

public final class Newspaper extends ISSNItem {
    public Newspaper(int issn, String title, LocalDate publicationDate, String[] authors)
            throws InvalidParameterException {
        super(issn, title, publicationDate, authors);
    }

    @Override
    protected String getType() {
        return "Newspaper";
    }
}