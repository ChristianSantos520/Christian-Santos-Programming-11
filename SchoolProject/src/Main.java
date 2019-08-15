import java.lang.reflect.Array;
/**
 * This class runs the whole program.  This class creates ten students and three teachers.  Later that class then
 * deletes two students and one teacher.  Then the class prints all of the the students and teachers again.
 */
public class Main {
    public static void main(String[] args) {
        School school = new School("VLN", 30, true);

        school.addStudent(new Student("Christian", "Santos", 10));
        school.addStudent(new Student("Hu", "Mungus", 9));
        school.addStudent(new Student("Luke", "Skywalker", 8));
        school.addStudent(new Student("He", "Man", 11));
        school.addStudent(new Student("Optimus", "Prime", 12));
        school.addStudent(new Student("Cookie", "Monst", 8));
        school.addStudent(new Student("Mino", "Taur", 9));
        school.addStudent(new Student("Tu", "Morrow", 10));
        school.addStudent(new Student("Sas", "Quatch", 11));
        school.addStudent(new Student("Loch", "Ness", 12));

        school.addTeacher(new Teacher("Paul", "Zaremba", "Programming 11"));
        school.addTeacher(new Teacher("John", "Smith", "Physics 12"));
        school.addTeacher(new Teacher("Simon", "Jones", "English 11"));

        //Prints all of the teacher objects created
        System.out.println("Teachers in the school");
        school.printTeachers();

        System.out.println("----------------------------------------------");

        //Prints all of the students objects created
        System.out.println("Students in the school");
        school.printStudents();

        //Deletes  two students and one teacher
        school.deleteStudent(1000);
        school.deleteStudent(1003);
        school.deleteTeacher("English 11");

        System.out.println("**********************************************");

        //Prints all of the teacher objects created after deleting two students
        System.out.println("Teachers in the school after one teacher left");
        school.printTeachers();

        System.out.println("----------------------------------------------");

        //Prints all of the students objects created after deleting one teacher
        System.out.println("Students in the school after two students left");
        school.printStudents();
    }
}
