import java.util.Date;

final class Technician extends Employee {
    // fields?

    // constructors
    protected Technician() {
        super();

    }

    protected Technician(String name, String address, Date dob, String email, int ssn, int memberID) {
        super(name, address, dob, email, ssn, memberID);
        
    }
    
    // methods

}

// pdf notes:
// The technicians tend to sort the
// returned books and re-shelve them in the correct location.