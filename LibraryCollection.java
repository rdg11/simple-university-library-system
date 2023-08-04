import java.rmi.NoSuchObjectException;
import java.security.InvalidParameterException;
import java.util.*;

/**
 * A collection of items in the library.
 */
public final class LibraryCollection {
    /**
     * The name of the collection.
     */
    private String name;

    /**
     * Unique 6-character alphanumeric identification number.
     */
    private String id;

    /**
     * ISBN items contained.
     */
    private List<ISBNItem> isbnItems = new ArrayList<>();

    /**
     * ISSN items contained.
     */
    private List<ISSNItem> issnItems = new ArrayList<>();

    /**
     * Create a new LibraryCollection with a 6-character alphanumeric identification
     * number.
     * 
     * @param name Name of the new LibraryCollection
     * @param id   ID of the new LibraryCollection
     * @throws InvalidParameterException If the ID is not a 6-character alphanumeric
     *                                   identification number.
     */
    protected LibraryCollection(String name, String id) throws InvalidParameterException {
        try {
            this.setName(name);
            this.setID(id);
        } catch (InvalidParameterException e) {
            throw e;
        }
    }

    /**
     * Set the name of the LibraryCollection.
     * 
     * @param name the new name
     * @throws InvalidParameterException If the name is {@code null}.
     */
    private void setName(String name) throws InvalidParameterException {
        if (name == null)
            throw new InvalidParameterException();

        this.name = name;
    }

    /**
     * Set the ID of the LibraryCollection.
     * 
     * @param id the new ID
     * @throws InvalidParameterException If the ID is not a 6-character alphanumeric
     *                                   identification number.
     */
    private void setID(String id) throws InvalidParameterException {
        if (id == null || id.length() != 6 || !id.matches("^[a-zA-Z0-9]*$"))
            throw new InvalidParameterException("Error: Attempted to set invalid LibraryCollection ID");

        this.id = id;
    }

    protected String getName() {
        return this.name;
    }

    /**
     * Get the ID of the LibraryCollection.
     * 
     * @return The ID
     */
    protected String getID() {
        return this.id;
    }

    /**
     * Add a new item to the LibraryCollection.
     * 
     * @param item the item to add
     * @throws NullPointerException If the item does not exist.
     */
    protected void addItem(Item item) throws NullPointerException {
        if (item == null)
            throw new NullPointerException("Error: Attempted to add null item to LibraryCollection");

        if (item instanceof ISBNItem)
            this.isbnItems.add((ISBNItem) item);
        else if (item instanceof ISSNItem)
            this.issnItems.add((ISSNItem) item);
    }

    /**
     * Get a list of items matching an ISBN.
     * 
     * @param isbn the ISBN to search for
     * @return A List of matching ISBNItems (empty if there are no matches).
     */
    protected List<ISBNItem> getItemsByISBN(long isbn) {
        List<ISBNItem> foundItems = new ArrayList<>();

        for (ISBNItem searchItem : this.isbnItems)
            if (searchItem.getISBN() == isbn)
                foundItems.add(searchItem);

        return foundItems;
    }

    /**
     * Get a list of items matching an ISSN.
     * 
     * @param issn the ISSN to search for
     * @return A List of matching ISSNItems (empty if there are no matches).
     */
    protected List<ISSNItem> getItemsByISSN(int issn) {
        List<ISSNItem> foundItems = new ArrayList<>();

        for (ISSNItem searchItem : this.issnItems)
            if (searchItem.getISSN() == issn)
                foundItems.add(searchItem);

        return foundItems;
    }

    /**
     * Remove a given object from the LibraryCollection.
     * 
     * @param item the Item to remove
     * @throws NullPointerException  If the Item to remove is null.
     * @throws NoSuchObjectException If the Item does not exist in the
     *                               LibraryCollection.
     */
    protected void removeItem(Item item) throws NullPointerException, NoSuchObjectException {
        if (item == null)
            throw new NullPointerException("Error: Attempted to remove a null Item from a LibraryCollection");

        if (item instanceof ISBNItem && !this.isbnItems.remove(item))
            throw new NoSuchObjectException(
                    "Error: Attempted to remove a nonexistent ISBNItem from a LibraryCollection");
        else if (item instanceof ISSNItem && !this.issnItems.remove(item))
            throw new NoSuchObjectException(
                    "Error: Attempted to remove a nonexistent ISSNItem from a LibraryCollection");
    }

    protected void printOverdues(int holdTime) {
        System.out.println(this.getName() + " Collection:");
        System.out.println();

        for (Item item : isbnItems) {
            if (item.isOverdue(holdTime)) {
                System.out.println(item.getType());
                item.print();
                item.printOverdueInfo(holdTime);
                System.out.println();
            }
        }

        for (Item item : issnItems) {
            if (item.isOverdue(holdTime)) {
                item.print();
                item.printOverdueInfo(holdTime);
                System.out.println();
            }
        }
    }
}