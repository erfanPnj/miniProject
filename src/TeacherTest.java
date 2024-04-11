import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class TeacherTest {
    Student s1 = new Student("morph", "12344");
    Student s2 = new Student("ali", "12345");
    Teacher sa = new Teacher("s", "a", 1);
    Course AP = new Course("ap", sa, 3, "2024.6.24", 2, true);


    @Before
    public void setUp () {
        sa.addCourseToThisTeacher(AP);
    }
    @Test
    public void testAddCourseTATeacher () {
        assertEquals(sa.getPresentedCourses().getFirst(), AP);
    }

    @Test
    public void testAddStudentToACourse () {
        sa.addStudentToACourse(s1, AP);
        sa.addStudentToACourse(s2, AP);
        assertTrue(AP.getStudentList().contains(s1) && AP.getStudentList().contains(s2));
        assertEquals(2, AP.getStudentList().toArray().length);
    }

    @Test
    public void testRemoveStudentFromACourse () {
        sa.addStudentToACourse(s1, AP); // we add a student
        sa.removeStudentFromACourse(s1, AP); // we delete a student
        assertFalse(AP.getStudentList().contains(s1));
    }

    @Test
    public void testDefineNewAssignment () {
        sa.defineNewAssignment(AP, "HW", true, 10);
        assertEquals("HW", sa.getPresentedCourses().get(0).getActiveProjects().get(0).getName());
    }

    @Test
    public void testDeleteAnAssignment () {
        Assignment assignment = new Assignment("HW", 10, true);
        List<Assignment> assignments = new ArrayList<>();
        assignments.add(assignment);
        AP.setActiveProjects(assignments);
        sa.deleteAnAssignment("ap", "HW");
        assertFalse(AP.getActiveProjects().contains(assignment));
    }

    @Test
    public void testRateStudent () {
        sa.addStudentToACourse(s1, AP);
        sa.rateStudents("ap", "12344", 18);
        assertEquals(18, s1.getAllOfPoints(), 0.0001);
    }

    @Test
    public void testChangeAssignmentDeadline () {
        sa.defineNewAssignment(AP, "HW", true, 10);
        sa.changeAssignmentDeadline("HW", 20);
        assertEquals(20, sa.getPresentedCourses().getFirst().getActiveProjects().getFirst().getDeadline());
    }

}
