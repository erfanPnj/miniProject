import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private final String name;
    private final String familyName;
    private final int presentedCoursesCount;
    private List<Course> presentedCourses = new ArrayList<>();

    public Teacher(String name, String familyName, int presentedCoursesCount) {
        this.name = name;
        this.familyName = familyName;
        this.presentedCoursesCount = presentedCoursesCount;
        Faculty.getTeachers().add(this); // this teacher should be added to the faculty's teachers after initialization.
    }

    public void setPresentedCourses(List<Course> presentedCourses) { // we can use this instead of addCourseToThisTeacher for adding a list of courses
        this.presentedCourses = presentedCourses;
    }

    public void addCourseToThisTeacher (Course course) {
        presentedCourses.add(course);
    }

    public List<Course> getPresentedCourses() {
        return presentedCourses;
    }

    public void addStudentToACourse (Student student, Course course) {
        if (course.isStatus()) {
            course.addStudent(student);
            student.addCourseAndUnit(course); // when a teacher adds a student to a course, units and the course should be attached to student
        }
    }

    public void removeStudentFromACourse (Student student, Course course) {
        course.eliminateStudent(student);
    }

    public void defineNewAssignment (Course course, String assignmentName,
                                     boolean assignmentStatus, int deadline) {
        for (Course c : presentedCourses) {
            if (c.getCourseName().equals(course.getCourseName())) {
                c.getActiveProjects().add(new Assignment(assignmentName, deadline, assignmentStatus));
                c.setCountOfAssignments(c.getCountOfAssignments() + 1);
            }
        }
    }

    public void deleteAnAssignment (String courseName, String assignmentName) {
        for (int i = 0; i < presentedCoursesCount; i++) { // using enhanced for loop causes ConcurrentModificationException
            if (presentedCourses.get(i).getCourseName().equals(courseName)) {
                // after finding the proper course, we check whether it is an active ot a deactivated project.
                for (int j = 0; j < presentedCourses.get(i).getActiveProjects().toArray().length; j++) {
                    if (presentedCourses.get(i).getActiveProjects().get(j).getName().equals(assignmentName)) { // matching the assignment using its name:
                        presentedCourses.get(i).getActiveProjects().remove(presentedCourses.get(i).getActiveProjects().get(j));
                        presentedCourses.get(i).setCountOfAssignments(presentedCourses.get(i).getCountOfAssignments() - 1); // decrease count of assignments after deletion
                    }
                }
                for (int j = 0; j < presentedCourses.get(i).getDeactiveProjects().toArray().length; j++) {
                    if (presentedCourses.get(i).getDeactiveProjects().get(j).getName().equals(assignmentName)) {
                        presentedCourses.get(i).getDeactiveProjects().remove(presentedCourses.get(i).getActiveProjects().get(j));
                        presentedCourses.get(i).setCountOfAssignments(presentedCourses.get(i).getCountOfAssignments() - 1);// decrease count of assignments after deletion
                    }
                }
            }
        }
    }

    public void rateStudents (String courseName, String studentId, double point) {
        for (Course c : presentedCourses) {
            if (c.getCourseName().equals(courseName)) {
                // given grade is added to scores of this course to use for finding higher score (highestScore() in Course.java):
                c.getScores().add(point);
                for (Student s : c.getStudentList()) {
                    if (s.getId().equals(studentId)) {
                        s.setCountOfAllOfGrades(s.getCountOfAllOfGrades() + 1); // A grade has been added.
                        s.setAllOfPoints(s.getAllOfPoints() + point);
                        if (c.getPresentedSemester() == Faculty.getSemester()) {
                            s.setCountOfThisSemesterGrades(s.getCountOfThisSemesterGrades() + 1); // A grade has been added for this semester.
                            s.setThisSemesterPoints(s.getThisSemesterPoints() + point);
                        }
                    }
                }
            }
        }
    }

    public void changeAssignmentDeadline (String assignmentName, int newDeadline) {
        for (Course c : presentedCourses) {
            for (Assignment a : c.getActiveProjects()) {
                if (a.getName().equals(assignmentName)) {
                    a.setDeadline(newDeadline);
                }
            }
        }
    }

}
