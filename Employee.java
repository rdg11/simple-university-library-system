import java.util.Date;

abstract class Employee extends Person{
    protected int employeeID;

    public Employee() {
        super();
        this.employeeID = 0;
    }
    
    public Employee(String name, String address, Date dob, String email, int ssn, int employeeID) {
        super(name, address, dob, email, ssn);
        this.employeeID = employeeID;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public void setID(int employeeID) {
        this.employeeID = employeeID;
    }
}
