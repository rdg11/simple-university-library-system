package com.javathree.librarysystem.library_classes;

import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Member extends Person {
    private int memberID;
    private ArrayList<Item> items = new ArrayList<>();

    // constructor
    public Member(String name, String address, LocalDate dob, String email, int ssn, int memberID) {
        super(name, address, dob, email, ssn);
        this.setMemberID(memberID);
    }

    // methods
    private void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getMemberID() {
        return this.memberID;
    }

    protected int getItemsAmount() {
        return items.size();
    }

    public void addItem(Item item) throws NullPointerException {
        if (item == null)
            throw new NullPointerException("Error: Attempted to add null item to Member");

        this.items.add(item);
    }

    // Returns item if found, Returns null if item was not found.
    public Item getBookItem(long isbn) {
        for (Item item : items)
            if (item.getClass().getName().contentEquals("Book") && ((Book) item).getISBN() == isbn
                    || item.getClass().getName().contentEquals("DVD") && ((DVD) item).getISBN() == isbn)
                return item;

        return null;
    }

    // Returns item if found, Returns null if item was not found.
    public Item getSerialItem(int issn) {
        for (Item item : items)
            if (item.getClass().getName().contentEquals("Newspaper") && ((Newspaper) item).getISSN() == issn
                    || item.getClass().getName().contentEquals("Journal") && ((Journal) item).getISSN() == issn)
                return item;

        return null;
    }

    // Returns item if successfully removed, Returns null if item was not found.
    public Item removeBookItem(long isbn) {
        for (Item item : items)
            if (item.getClass().getName().contentEquals("Book") && ((Book) item).getISBN() == isbn
                    || item.getClass().getName().contentEquals("DVD") && ((DVD) item).getISBN() == isbn) {
                this.items.remove(item);
                return item;
            }

        return null;
    }

    // Returns item if successfully removed, Returns null if item was not found.
    public Item removeSerialItem(int issn) {
        for (Item item : items)
            if (item.getClass().getName().contentEquals("Newspaper") && ((Newspaper) item).getISSN() == issn
                    || item.getClass().getName().contentEquals("Journal") && ((Journal) item).getISSN() == issn) {
                this.items.remove(item);
                return item;
            }

        return null;
    }
}