package com.javathree.librarysystem.library_classes;

import java.util.*;

public final class LibraryInfo {
    public static List<Employee> employees = new ArrayList<>();
    public static List<Member> members = new ArrayList<>();
    public static List<LibraryCollection> libraryCollections = new ArrayList<>();
    public static final int holdTime = 14;

    public static List<ISBNItem> findISBN(long isbn) {
        List<ISBNItem> foundItems = new ArrayList<>();

        for (LibraryCollection collection : libraryCollections) {
            foundItems.addAll(collection.getItemsByISBN(isbn));
        }

        return foundItems;
    }

    public static List<ISSNItem> findISSN(int issn) {
        List<ISSNItem> foundItems = new ArrayList<>();

        for (LibraryCollection collection : libraryCollections) {
            foundItems.addAll(collection.getItemsByISSN(issn));
        }

        return foundItems;
    }

    public static LibraryCollection removeCollection(String id) {
        for (Iterator<LibraryCollection> iterator = libraryCollections.iterator(); iterator.hasNext();) {
            LibraryCollection collection = iterator.next();
            if (collection.getID().equals(id)) {
                iterator.remove();
                return collection;
            }
        }
        return null; // Return null if the collection with the specified ID is not found
    }

    public static List<String> getCollectionsList() {
        List<String> collectionsList = new ArrayList<>();
        for (LibraryCollection collection : libraryCollections) {
            collectionsList.add(collection.getName() + " - " + collection.getID());
        }
        return collectionsList;
    }
    
}