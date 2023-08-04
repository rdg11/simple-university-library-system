import java.util.Date;

final class Librarian extends Employee {
    // fields?

    // constructors
    protected Librarian() {
        super();

    }

    protected Librarian(String name, String address, Date dob, String email, int ssn, int memberID) {
        super(name, address, dob, email, ssn, memberID);
        
    }
    
    // methods

}


// pdf notes:
// The librarians are responsible for managing the collections and helping
// customers with the resources. Librarians also manage the memberships.