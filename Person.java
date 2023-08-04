import java.util.Date;

abstract class Person {
    protected String name;
    protected String address;
    protected Date dob;
    protected String email;
    protected int ssn;

    // Methods go here
    public Person() {
        this.name = "";
        this.address = "";
        this.dob = null;
        this.email = "";
        this.ssn = 0;
    }

    public Person(String name, String address, Date dob, String email, int SSN) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.ssn = SSN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public Date getDob() {
        return this.dob;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }
    public void setSsn(int ssn) {
        this.ssn = ssn;
    }
    public int getSsn() {
        return this.ssn;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Address: %s, DOB: %t, Email: %s, SSN: %d", getName(), getAddress(), getDob(), getEmail(), getSsn());
    }
}
