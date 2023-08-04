import java.security.InvalidParameterException;
import java.time.LocalDate;

public final class Journal extends ISSNItem {
    protected Journal(int issn, String title, LocalDate publicationDate, String[] authors) throws InvalidParameterException {
        super(issn, title, publicationDate,  authors);
    }

    @Override
    protected String getType() {
        return "Journal";
    }
}