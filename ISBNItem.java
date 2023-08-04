import java.security.InvalidParameterException;
import java.time.LocalDate;

public abstract class ISBNItem extends Item {
    // 13-digit ISBN
    private long isbn;

    protected ISBNItem(long isbn, String title, LocalDate publicationDate, String[] authors) {
        super(title, publicationDate, authors);

        try {
            this.setISBN(isbn);
        } catch (InvalidParameterException e) {
            throw e;
        }
    }

    private void setISBN(long isbn) throws InvalidParameterException {
        if (isbn < 0 || isbn > 9999999999999L)
            throw new InvalidParameterException();

        this.isbn = isbn;
    }

    protected long getISBN() {
        return this.isbn;
    }

    @Override
    protected void print() {
        System.out.println("ISBN: " + Long.toString(this.getISBN()));
        super.print();
    }
}
