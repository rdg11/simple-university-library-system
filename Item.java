import java.security.InvalidParameterException;
import java.time.LocalDate;

/**
 * An item in the library.
 */
public abstract class Item {
    /**
     * The title of the item.
     */
    private String title;

    /**
     * The date the item was published.
     */
    private LocalDate publicationDate;

    /**
     * The authors of the item.
     */
    private String[] authors;

    private LocalDate borrowedDate = null;

    /**
     * Create a new Item.
     *
     * @param title           the title of the item
     * @param publicationDate the date the item was published
     * @param authors         the authors of the item
     * @throws NullPointerException If any of the parameters are null.
     */
    protected Item(String title, LocalDate publicationDate, String[] authors) throws NullPointerException {
        try {
            this.setTitle(title);
            this.setPublicationDate(publicationDate);
            this.setAuthors(authors);
        } catch (NullPointerException e) {
            throw e;
        }
    }

    protected void setTitle(String title) throws NullPointerException {
        if (title == null)
            throw new NullPointerException("Error: Attempted to set null item title");

        this.title = title;
    }

    protected void setPublicationDate(LocalDate publicationDate) throws InvalidParameterException {
        if (publicationDate.compareTo(LocalDate.now()) > 0)
            throw new InvalidParameterException("Error: Attempted to set invalid journal publication date");

        this.publicationDate = publicationDate;
    }

    protected void setAuthors(String[] authors) throws NullPointerException {
        this.authors = authors.clone();
    }

    protected void setBorrowedDate(LocalDate date) {
        this.borrowedDate = date;
    }

    protected String getTitle() {
        return this.title;
    }

    protected LocalDate getPublicationDate() {
        return this.publicationDate;
    }

    protected String[] getAuthors() {
        return this.authors.clone();
    }

    protected LocalDate getBorrowedDate() {
        return this.borrowedDate;
    }

    protected void print() {
        System.out.println("Title: " + this.getTitle());
        System.out.print("Authors: ");
        for (String author : this.getAuthors()) {
            System.out.print(author + ", ");
        }
        System.out.println();
        System.out.println("Publication date: " + this.getPublicationDate().toString());
    }

    protected boolean isOverdue(int holdTime) {
        if (!this.isBorrowed())
            return false;

        return this.getBorrowedDate().plusDays(holdTime).compareTo(LocalDate.now()) < 0;
    }

    protected void printOverdueInfo(int holdTime) {
        System.out.println("Borrowed: " + this.getBorrowedDate().toString());
        System.out.println("Due: " + this.getBorrowedDate().plusDays(holdTime));
    }

    protected boolean isBorrowed() {
        return this.getBorrowedDate() != null;
    }

    protected abstract String getType();
}