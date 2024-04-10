import java.util.List;

public class Course {
    private String courseName;
    private Teacher courseTeacher;
    private int countOfUnits;
    private List<Student> studentList;
    private boolean status;
    private List<Assignment> assignmentList;
    private int countOfAssignments;
    private String examDate;
    private List<Assignment> activeProjects;
    private List<Assignment> deactiveProjects;
    private int presentedSemester;
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseTeacher(Teacher courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public void setCountOfUnits(int countOfUnits) {
        this.countOfUnits = countOfUnits;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public void setCountOfAssignments(int countOfAssignments) {
        this.countOfAssignments = countOfAssignments;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public void setActiveProjects(List<Assignment> activeProjects) {
        this.activeProjects = activeProjects;
    }

    public void setDeactiveProjects(List<Assignment> deactiveProjects) {
        this.deactiveProjects = deactiveProjects;
    }

    public void setPresentedSemester(int presentedSemester) {
        this.presentedSemester = presentedSemester;
    }

    public String getCourseName() {
        return courseName;
    }

    public Teacher getCourseTeacher() {
        return courseTeacher;
    }

    public int getCountOfUnits() {
        return countOfUnits;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public boolean isStatus() {
        return status;
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public int getCountOfAssignments() {
        return countOfAssignments;
    }

    public String getExamDate() {
        return examDate;
    }

    public List<Assignment> getActiveProjects() {
        return activeProjects;
    }

    public List<Assignment> getDeactiveProjects() {
        return deactiveProjects;
    }

    public int getPresentedSemester() {
        return presentedSemester;
    }

    public void printStudentList () {
        for (Student s : studentList) {
            System.out.println(s.getName());
        }
    }

    public void addStudent (Student student) {
        studentList.add(student);
    }

    public void eliminateStudent (Student student) {
        for (Student s : studentList) {
            if (s.getName().equals(student.getName())) {
                studentList.remove(s);
            }
        }
    }





}
