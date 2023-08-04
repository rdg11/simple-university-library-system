import java.util.Date;

final class External extends Member {

    public External(String name, String address, Date dob, String email, int ssn, int memberID) {
        super(name, address, dob, email, ssn, memberID);
    }

    // public void setCompanyName(String companyName) {
    // this.companyName = companyName;
    // }

    // public void setPurpose(String purpose) {
    // this.purpose = purpose;
    // }

    // public String getCompanyName() {
    // return this.companyName;
    // }

    // public String getPurpose() {
    // return this.purpose;
    // }
}
// pdf notes:
// The external members are usually people who want to become members of the
// library but are not affiliated with the university.