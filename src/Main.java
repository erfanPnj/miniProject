public class Main {
    public static void main(String[] args) {
        Faculty computerEngineering = new Faculty("computerEngineering");
        computerEngineering.setSemester(2);


        Teacher sa = new Teacher("s", "a", 1);
        Teacher ys = new Teacher("y", "s", 1);
        Course AP = new Course("ap", sa, 3, "2024.6.24", 2);
        Course EC = new Course("ec", ys, 3, "2024.6.27", 3);
        sa.addCourseToThisTeacher(AP);
        ys.addCourseToThisTeacher(EC);

        Student s1 = new Student("morph", "12344");
        Student s2 = new Student("ali", "12345");
        Student s3 = new Student("mahan", "12346");
        Student s4 = new Student("reza", "12347");
        Student s5 = new Student("sara", "12348");
        Student s6 = new Student("rya", "12349");

        sa.defineNewAssignment(AP, "final", true, 70);
        sa.defineNewAssignment(AP, "Mini", true, 14);
        ys.defineNewAssignment(EC, "pspise", true, 30);
        //sa.deleteAnAssignment("ap", "final");

        AP.addStudent(s1);
        AP.addStudent(s2);
        AP.addStudent(s3);
        AP.addStudent(s4);
        AP.addStudent(s5);
        AP.addStudent(s6);
        EC.addStudent(s6);

        s1.addCourseAndUnit(AP);
        s2.addCourseAndUnit(AP);
        s3.addCourseAndUnit(AP);
        s4.addCourseAndUnit(AP);
        s5.addCourseAndUnit(AP);
        s6.addCourseAndUnit(AP);
        s6.addCourseAndUnit(EC);

        sa.rateStudents("ap", "12349", 14.64);
        sa.rateStudents("ap", "12348", 18.97);
        sa.rateStudents("ap", "12347", 14.12);
        sa.rateStudents("ap", "12346", 16.6);
        sa.rateStudents("ap", "12345", 17.78);
        sa.rateStudents("ap", "12344", 19.65);
        ys.rateStudents("ec", "12349", 19);

        s6.printCountOfUnits();
        s6.printRegisteredAvg();
        s6.printStudentAllTimeAvg();
        s6.printStudentCourses();
        for (Course a : sa.getPresentedCourses()) {
            for (Assignment aa : a.getActiveProjects()) {
                System.out.println(aa.getName());
            }
        }

        System.out.println(AP.highestScore());

    }
}
