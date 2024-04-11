import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class StudentTest {
    Faculty ce = new Faculty("ce", 2); // declares that the current semester is 2

    Student s1 = new Student("morph", "12344");
    Student s2 = new Student("ali", "12345");
    Student s3 = new Student("mahan", "12346");
    Student s4 = new Student("reza", "12347");
    Student s5 = new Student("sara", "12348");
    Student s6 = new Student("rya", "12349");
    Student s7 = new Student("mahak", "123410");

    Teacher sa = new Teacher("s", "a", 1);
    Teacher ys = new Teacher("y", "s", 1);
    Course AP = new Course("ap", sa, 3, "2024.6.24", 2, true);
    Course EC = new Course("ec", ys, 3, "2024.6.27", 3, true);


    @Test
    public void testPrintedCourseList () {
        sa.addStudentToACourse(s1, AP);
        ys.addStudentToACourse(s1, EC);
        String result = s1.getCourses().get(0).getCourseName() + " " + s1.getCourses().get(1).getCourseName();
        assertEquals("ap ec", result);
    }

    @Test
    public void testPrintedCountOfUnits () {
        s1.addCourseAndUnit(AP);
        s1.addCourseAndUnit(EC);
        assertEquals(6, s1.getCountOfUnits());
        ys.removeStudentFromACourse(s1, EC); // after being removed by a teacher, count of units should also reduce
        assertEquals(3, s1.getCountOfUnits());
    }

    @Test
    public void testAllTimeAverage () {
        sa.addCourseToThisTeacher(AP);
        sa.addStudentToACourse(s1, AP);
        sa.rateStudents("ap", "12344", 19.25);
        sa.rateStudents("ap", "12344", 18.75);
        assertEquals(19, s1.getAllTimeAverage(), 0.0001);
    }

    @Test
    public void testThisSemesterAverage () {
        sa.addCourseToThisTeacher(AP);
        ys.addCourseToThisTeacher(EC);
        sa.addStudentToACourse(s1, AP);
        ys.addStudentToACourse(s1, EC);
        sa.rateStudents("ap", "12344", 18);
        sa.rateStudents("ap", "12344", 18.4);
        sa.rateStudents("ap", "12344", 17.6);
        ys.rateStudents("ec", "12344", 16.7);
        assertEquals(18, s1.getThisSemesterAverage(), 0.0001);
    }

}
