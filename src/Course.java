import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String courseName;
    private final Teacher courseTeacher;
    private final int countOfUnits;
    private List<Student> studentList = new ArrayList<>();
    private boolean status;
    private int countOfAssignments;
    private final String examDate; // it must be in the format of Year.Month.Day: 2024.4.10;
    private List<Assignment> activeProjects = new ArrayList<>();
    private List<Assignment> deactiveProjects = new ArrayList<>();
    private int presentedSemester;
    private List<Double> scores = new ArrayList<>();

    public Course(String courseName, Teacher courseTeacher, int countOfUnits, String examDate, int presentedSemester) {
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
        this.countOfUnits = countOfUnits;
        this.examDate = examDate;
        this.presentedSemester = presentedSemester;
        Faculty.getCourses().add(this);
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCountOfAssignments(int countOfAssignments) {
        this.countOfAssignments = countOfAssignments;
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

    public void setScores(List<Double> scores) {
        this.scores = scores;
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

    public List<Double> getScores() {
        return scores;
    }

    public void printStudentList () {
        for (Student s : studentList) {
            System.out.println(s.getId());
        }
    }

    public void addStudent (Student student) {
        studentList.add(student);
    }

    public void eliminateStudent (Student student) {
        studentList.removeIf(s -> s.getId().equals(student.getId()));
    }

    public double highestScore () {
        scores.sort((Double::compareTo));
        return scores.getLast();
    }


}
