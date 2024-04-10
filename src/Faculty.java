import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private final String name;
    private static int semester;
    private static List<Student> students = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();

    public Faculty (String name) {
        this.name = name;
    }
    public void setSemester(int semester) {
        Faculty.semester = semester;
    }

    public void setStudents(List<Student> students) {
        Faculty.students = students;
    }

    public void setTeachers(List<Teacher> teachers) {
        Faculty.teachers = teachers;
    }

    public void setCourses(List<Course> courses) {
        Faculty.courses = courses;
    }

    public static int getSemester() {
        return semester;
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static List<Teacher> getTeachers() {
        return teachers;
    }

    public String getName() {
        return name;
    }

    public static List<Course> getCourses() {
        return courses;
    }



}
