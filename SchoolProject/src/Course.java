/**
 * This class represents a course. It has the name of the course.
 *
 * Note to the teacher:
 * In the requirements, there was no Course class specified, but I felt I needed to create one.
 */
public class Course {
    private String name;

    //Constructor to initialize fields
    Course(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
