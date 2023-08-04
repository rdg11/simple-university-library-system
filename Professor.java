import java.util.ArrayList;
import java.util.Date;

class Professor extends Member {
    private String department;
    private ArrayList<String> courseList;
    private ArrayList<Student> students;

    public Professor() {
        super();
        this.courseList = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public Professor(String name, String address, Date dob, String email, int ssn, int memberID, String department) {
        super(name, address, dob, email, ssn, memberID);
        this.department = department;
        this.courseList = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    // getters and setters for department and courseList

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
        if (student != null && !students.contains(student)) {
            this.students.add(student);
        }
    }

    public void removeStudent(Student student) {
        if (student != null && students.contains(student)) {
            this.students.remove(student);
        }
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCourseList(ArrayList<String> courseList) {
        this.courseList = courseList;
    }

    public void addCourse(String course) {
        this.courseList.add(course);
    }

    public void removeCourse(String course) {
        this.courseList.remove(course);
    }

    public String getDepartment() {
        return this.department;
    }

    public ArrayList<String> getCourseList() {
        return this.courseList;
    }
}