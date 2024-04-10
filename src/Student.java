import java.util.List;

public class Student {
    private String name;
    private String studentId;
    private int countOfCourses;
    private int countOfUnits;
    private List<Course> courses;
    private double allOfPoints = 0;
    private double thisSemesterPoints = 0;
    private double allTimeAverage = 0;
    private double thisSemesterAverage = 0;


    public Student (String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        Faculty.getStudents().add(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setCountOfCourses(int countOfCourses) {
        this.countOfCourses = countOfCourses;
    }

    public void setCountOfUnits(int countOfUnits) {
        this.countOfUnits = countOfUnits;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setAllTimeAverage(double allTimeAverage) {
        this.allTimeAverage = allTimeAverage;
    }

    public void setThisSemesterAverage(double thisSemesterAverage) {
        this.thisSemesterAverage = thisSemesterAverage;
    }

    public void setAllOfPoints(double allOfPoints) {
        this.allOfPoints = allOfPoints;
    }

    public void setThisSemesterPoints(double thisSemesterPoints) {
        this.thisSemesterPoints = thisSemesterPoints;
    }
    public String getName() {
        return name;
    }

    public String getStudentId() {
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

    public void printStudentCourses () {
        for (Course c : courses) {
            System.out.println(c.getCourseName());
        }
    }

    public void printStudentAllTimeAvg () {
        System.out.println(this.getAllTimeAverage());
    }

    public void printCountOfRegisteredUnits () {
        System.out.println(this.getCountOfUnits());
    }
}
