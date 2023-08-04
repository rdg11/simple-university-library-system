import java.util.ArrayList;
import java.util.Date;

abstract class Member extends Person {
    private int memberID;
    private ArrayList<Item> items = new ArrayList<>();

    // constructors
    protected Member() {
        super();
        this.memberID = 0;
    }

    protected Member(String name, String address, Date dob, String email, int ssn, int memberID) {
        super(name, address, dob, email, ssn);
        this.memberID = memberID;
    }

    // methods
    protected void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    protected int getMemberID() {
        return this.memberID;
    }

    protected int getItemsAmount() {
        return items.size();
    }

    protected void addItem(Item item) throws NullPointerException {
        if (item == null)
            throw new NullPointerException("Error: Attempted to add null item to Member");

        this.items.add(item);
    }

    // Returns item if found, Returns null if item was not found.
    protected Item getBookItem(long isbn) {
        for (Item item : items)
            if (item.getClass().getName().contentEquals("Book") && ((Book) item).getISBN() == isbn || item.getClass().getName().contentEquals("DVD") && ((DVD) item).getISBN() == isbn )
                return item;

        return null;
    }

    // Returns item if found, Returns null if item was not found.
    protected Item getSerialItem(int issn) {
        for (Item item : items)
            if (item.getClass().getName().contentEquals("Newspaper") && ((Newspaper) item).getISSN() == issn || item.getClass().getName().contentEquals("Journal") && ((Journal) item).getISSN() == issn )
                return item;

        return null;
    }

    // Returns item if successfully removed, Returns null if item was not found.
    protected Item removeBookItem(long isbn) {
        for (Item item : items)
            if (item.getClass().getName().contentEquals("Book") && ((Book) item).getISBN() == isbn || item.getClass().getName().contentEquals("DVD") && ((DVD) item).getISBN() == isbn ) {
                this.items.remove(item);
                return item;
            }

        return null;
    }

    // Returns item if successfully removed, Returns null if item was not found.
    protected Item removeSerialItem(int issn) {
        for (Item item : items)
            if (item.getClass().getName().contentEquals("Newspaper") && ((Newspaper) item).getISSN() == issn || item.getClass().getName().contentEquals("Journal") && ((Journal) item).getISSN() == issn ) {
                this.items.remove(item);
                return item;
            }

        return null;
    }
}