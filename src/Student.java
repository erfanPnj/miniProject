import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final String studentId;
    private int countOfCourses;
    private int countOfUnits;
    private List<Course> courses = new ArrayList<>();
    private double allOfPoints = 0;
    private double thisSemesterPoints = 0;
    private double allTimeAverage = 0;
    private double thisSemesterAverage = 0;
    private double countOfAllOfGrades = 0;
    private double countOfThisSemesterGrades = 0;


    public Student (String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        Faculty.getStudents().add(this);
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setAllOfPoints(double allOfPoints) {
        this.allOfPoints = allOfPoints;
    }

    public void setThisSemesterPoints(double thisSemesterPoints) {
        this.thisSemesterPoints = thisSemesterPoints;
    }

    public void setCountOfAllOfGrades(double countOfAllOfGrades) {
        this.countOfAllOfGrades = countOfAllOfGrades;
    }

    public double getCountOfAllOfGrades() {
        return countOfAllOfGrades;
    }

    public double getCountOfThisSemesterGrades() {
        return countOfThisSemesterGrades;
    }

    public void setCountOfThisSemesterGrades(double countOfGrades) {
        this.countOfThisSemesterGrades = countOfGrades;
    }
    public String getId() {
        return studentId;
    }

    public int getCountOfCourses() {
        return countOfCourses;
    }

    public int getCountOfUnits() {
        return countOfUnits;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public double getAllTimeAverage() {
        return allTimeAverage;
    }

    public double getThisSemesterAverage() {
        return thisSemesterAverage;
    }

    public double getAllOfPoints() {
        return allOfPoints;
    }

    public double getThisSemesterPoints() {
        return thisSemesterPoints;
    }

    public void addCourseAndUnit (Course course) {
        this.courses.add(course);
        this.countOfUnits += course.getCountOfUnits();
    }
    public void printStudentCourses () {
        for (Course c : courses) {
            System.out.println(c.getCourseName());
        }
    }

    public void printStudentAllTimeAvg () {
        System.out.println(allOfPoints / countOfAllOfGrades);
    }

    public void printRegisteredAvg () {
        System.out.println(thisSemesterPoints / countOfThisSemesterGrades);
    }

    public void printCountOfUnits () {
        System.out.println(this.getCountOfUnits());
    }


}
