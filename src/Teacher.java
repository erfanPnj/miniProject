import java.util.List;

public class Teacher {
    private String name;
    private String familyName;
    private int presentedCoursesCount;
    private List<Course> presentedCourses;

    public Teacher(String name, String familyName, int presentedCoursesCount) {
        this.name = name;
        this.familyName = familyName;
        this.presentedCoursesCount = presentedCoursesCount;
        Faculty.getTeachers().add(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
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
                                     int assignmentStatus, boolean deadline) {
        for (Course c : presentedCourses) {
            if (c.getCourseName().equals(course.getCourseName())) {
                c.getAssignmentList().add(new Assignment(assignmentName, assignmentStatus, deadline));
            }
        }
    }

    public void deleteAnAssignment (String courseName, Assignment assignment) {
        for (Course c : presentedCourses) {
            if (c.getCourseName().equals(courseName)) {
                c.getAssignmentList().remove(assignment);
            }
        }
    }

    public void rateStudents (String courseName, String studentName, double point) {
        for (Course c : presentedCourses) {
            if (c.getCourseName().equals(courseName)) {
                for (Student s : c.getStudentList()) {
                    if (s.getName().equals(studentName)) {
                        s.setAllOfPoints(s.getAllOfPoints() + point);
                        if (c.getPresentedSemester() == Faculty.getSemester()) {
                            s.setThisSemesterPoints(s.getThisSemesterPoints() + point);
                        }
                    }
                }
            }
        }
    }

}
