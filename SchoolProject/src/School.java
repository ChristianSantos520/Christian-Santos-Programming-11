import java.util.ArrayList;

/**
 * This class is to make a school with a ArrayList of teachers, students, and courses.  There are methods that add and
 * delete a teacher from the teachers ArrayList and same for the students ArrayList.  All fo the fields have getter and
 * setters.
 */
public class School {
    private String name = new String();
    private int age;
    private boolean isPublic;

    //ArrayLists
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();


    //Constructor to initialize fields
    School(String name, int age, boolean isPublic){
        this.name = name;
        this.age = age;
        this.isPublic = isPublic;
    }


    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    public void deleteTeacher(String subject){
        for(int i = 0; i < teachers.size(); i++){
            if(teachers.get(i).getSubject().equals(subject)){
                teachers.remove(i);
                break;
            }
        }
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public void deleteStudent(int studentNumber){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getStudentNumber() == studentNumber){
                students.remove(i);
                break;
            }
        }
    }

    public void printTeachers(){
        for(int i = 0; i < teachers.size(); i++){
            System.out.println(teachers.get(i).toString());
        }
    }
    public void printStudents(){
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).toString());
        }
    }


    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public boolean isPublic() {
        return isPublic;
    }
    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
