/**
 * This class represents a Student with fields that tell you what the student's first name, last name, grade, and
 * student number are.  The studentNumber gets assigned idNumber which increments.  All fo the fields have getters and
 * setters.
 */
public class Student {
    private String firstName;
    private String lastName;
    private int grade;
    private int studentNumber;
    private static int idNumber = 1000;

    //Constructor to initialize fields
    Student(String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.studentNumber = idNumber;
        idNumber++;
    }

    /**
     * @return the string that describes that object
     */
    @Override
    public String toString() {
        return "Name:\t" + firstName + " " + lastName + "\n" +
                "Grade:\t" + grade + "\n" +
                "Student Number:\t" + studentNumber;
    }

    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentNumber() {
        return studentNumber;
    }
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
}
