import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CourseTest {
    Teacher teacher = new Teacher("ali", "rezaei", 2);
    Course course1 = new Course("EC", teacher, 3, "2024.5.30", 2, true);

    Assignment a1 = new Assignment("HW1", 14, true);
    Assignment a2 = new Assignment("HW2", 21, true);

    Student s1 = new Student("shayan", "112233");
    Student s2 = new Student("Ali", "112244");
    Student s3 = new Student("mahsa", "112255");
    @Test
    public void testAddStudent () {
        course1.addStudent(s1);
        assertTrue(course1.getStudentList().contains(s1));
    }

    @Test
    public void testEliminateStudent () {
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        course1.setStudentList(students);
        course1.eliminateStudent(s1);
        assertTrue(course1.getStudentList().contains(s2) && !course1.getStudentList().contains(s1));
    }

    @Test
    public void testHighestScore () {
        teacher.addCourseToThisTeacher(course1);
        teacher.addStudentToACourse(s1, course1);
        teacher.addStudentToACourse(s2, course1);
        teacher.addStudentToACourse(s3, course1);
        teacher.rateStudents("EC", "112233", 15.98);
        teacher.rateStudents("EC", "112244", 19.32);
        teacher.rateStudents("EC", "112255", 18.27);
        teacher.rateStudents("EC", "112255", 19.77);

        assertEquals(19.77, course1.highestScore(), 0.0001);
        //if a student is being deleted, the related grade should also be deleted.
        teacher.removeStudentFromACourse(s3, course1);
        teacher.rateStudents("EC", "112244", 20);
        assertEquals(20, course1.highestScore(), 0.0001);
    }


}
