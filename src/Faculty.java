import java.util.List;
import java.util.Map;

public class Faculty {
    private final String name;
    private static int semester;
    private static List<Student> students;
    private static List<Teacher> teachers;
    private static List<Course> courses;

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
