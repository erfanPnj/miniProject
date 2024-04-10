import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private final String name;
    private final String familyName;
    private int presentedCoursesCount;
    private List<Course> presentedCourses = new ArrayList<>();

    public Teacher(String name, String familyName, int presentedCoursesCount) {
        this.name = name;
        this.familyName = familyName;
        this.presentedCoursesCount = presentedCoursesCount;
        Faculty.getTeachers().add(this); // this teacher should be added to the faculty's teachers after initialization.
    }


    public void setPresentedCoursesCount(int presentedCoursesCount) {
        this.presentedCoursesCount = presentedCoursesCount;
    }

    public void setPresentedCourses(List<Course> presentedCourses) {
        this.presentedCourses = presentedCourses;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getPresentedCoursesCount() {
        return presentedCoursesCount;
    }

    public List<Course> getPresentedCourses() {
        return presentedCourses;
    }

    public void addStudentToACourse (Student student, Course course) {
        course.addStudent(student);
    }

    public void removeStudentFromACourse (Student student, Course course) {
        course.eliminateStudent(student);
    }

    public void defineNewAssignment (Course course, String assignmentName,
                                     boolean assignmentStatus, int deadline) {
        for (Course c : presentedCourses) {
            if (c.getCourseName().equals(course.getCourseName())) {
                c.getActiveProjects().add(new Assignment(assignmentName, deadline, assignmentStatus));
            }
        }
    }

    public void deleteAnAssignment (String courseName, String assignmentName) {
        for (Course c : presentedCourses) {
            if (c.getCourseName().equals(courseName)) {
                for (Assignment a : c.getActiveProjects()) {
                    if (a.getName().equals(assignmentName))
                        c.getActiveProjects().remove(a);
                }
                for (Assignment a : c.getDeactiveProjects()) {
                    if (a.getName().equals(assignmentName))
                        c.getDeactiveProjects().remove(a);
                }
            }
        }
    }

    public void rateStudents (String courseName, String studentId, double point) {
        for (Course c : presentedCourses) {
            if (c.getCourseName().equals(courseName)) {
                c.getScores().add(point);
                for (Student s : c.getStudentList()) {
                    if (s.getId().equals(studentId)) {
                        s.setCountOfAllOfGrades(s.getCountOfAllOfGrades() + 1); // A grade has been added.
                        s.setAllOfPoints(s.getAllOfPoints() + point);
                        if (c.getPresentedSemester() == Faculty.getSemester()) {
                            s.setCountOfThisSemesterGrades(s.getCountOfThisSemesterGrades() + 1); // A grade has been added.
                            s.setThisSemesterPoints(s.getThisSemesterPoints() + point);
                        }
                    }
                }
            }
        }
    }

    public void addCourseToThisTeacher (Course course) {
        presentedCourses.add(course);
    }

}
