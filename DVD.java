import java.security.InvalidParameterException;
import java.time.LocalDate;

public final class DVD extends ISBNItem {
    protected DVD(long isbn, String title, LocalDate publicationDate, String[] authors) throws InvalidParameterException {
        super(isbn, title, publicationDate, authors);
    }

    @Override
    protected String getType() {
        return "DVD";
    }
}
