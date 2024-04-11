import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FacultyTest {
    @Test
    public void testCourseDeletion () {
        new Faculty("ce", 2);
        Teacher sa = new Teacher("s", "a", 1);
        Course AP = new Course("ap", sa, 3, "2024.6.24", 2, true);
        Student s1 = new Student("morph", "12344");

        Faculty.getCourses().add(AP);
        Faculty.getTeachers().add(sa);

        assertTrue(Faculty.getCourses().getFirst().isStatus()); // at first the course is active and teacher can add student to that course:
        sa.addStudentToACourse(s1, AP);
        assertTrue(AP.getStudentList().contains(s1));

        Faculty.changeCourseStatus(AP); // deactivate the course from faculty, now teacher cannot add a new student:
        Student s2 = new Student("anon", "12355");
        sa.addStudentToACourse(s2, AP);
        assertTrue(AP.getStudentList().contains(s2));
    }

}
