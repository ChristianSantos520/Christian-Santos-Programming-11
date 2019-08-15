/**
 * This class represents a teacher.  The fields say what the teacher's first name, last name are, and which subject the
 * teacher teaches.  The printTeacher function prints the name and subject of the class.  All of the fields have getters
 * and setters.
 */
public class Teacher {
    private String firstName;
    private String lastName;
    private String subject;


    //Constructor to initialize fields
    Teacher(String firstName, String lastName, String subject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    /**
     * @return the string that describes that object
     */
    @Override
    public String toString() {
        return "Name:\t" + firstName + " " + lastName + "\n" +
         "Subject:\t" + subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
