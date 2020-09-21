package main.pack;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
    private PrintCMD printCMD;
    String query;
    String queryStudents = "SELECT * FROM STUDENT";
    String queryTrainers = "SELECT * FROM TRAINER";
    String queryCourses = "SELECT * FROM COURSE";
    String queryAssignments = "SELECT * FROM ASSIGNMENT";
    String queryAssignmentCourseStudent = "SELECT s.F_NAME as FIRST_NAME, s.L_NAME AS LAST_NAME, c.title AS COURSE, ass.TITLE AS ASSIGNMENT_TITLE , ass.ORAL_MARK, ass.TOTAL_MARK, asst.st_oral_mark, asst.st_total_mark, asst.id as ID   FROM student s\n" + "JOIN course_student as CS\n" + "ON S.STD_ID = CS.STD_ID\n" + "JOIN COURSE as C\n" + "ON CS.COURSE_ID = C.COURSE_ID\n" + "JOIN course_assignment as ca\n" + "on cs.course_id = ca.course_id\n" + "join assignment as ass \n" + "on ca.ass_id = ass.ass_id\n" + "join assignment_student as asst\n" + "on s.std_id = asst.std_id and\n" + "ca.ass_id = asst.ass_id and\n" + "cs.course_id = asst.course_id\n" + "order by s.l_name, c.title; ";

    public void printMenu() {

        System.out.print("Welcome to the Tables Submenu.");

        System.out.println("Type one of the following to print a table.");

        System.out.println("1. Print all Students");
        System.out.println("2. Print all Trainers");
        System.out.println("3. Print all Assignments");
        System.out.println("4. Print all Courses");
        System.out.println("5. Print all Students per Course");
        System.out.println("6. Print all Trainers per Course");
        System.out.println("7. Print all Assignments per Course");
        System.out.println("8. Print all Assignments per Course per Student");
        System.out.println("9. Print all Students who belong to more than 1 courses.");
        System.out.println("10. Back to the Main Menu");

        int actionPrintMenu = validation(10);

        switch (actionPrintMenu) {
            case 1:
                printCMD = new PrintCMD(queryStudents);
                printCMD.printStudent();
                printCMD.closeResultSetAndStatement();
                break;
            case 2:
                printCMD = new PrintCMD(queryTrainers); // ResultSet = ready
                printCMD.printTrainer();
                printCMD.closeResultSetAndStatement();
                break;
            case 3:
                printCMD = new PrintCMD(queryAssignments);
                printCMD.printAssignment();
                printCMD.closeResultSetAndStatement();
                break;
            case 4:
                query = "SELECT * FROM COURSE";
                printCMD = new PrintCMD(query);
                printCMD.printCourse();
                printCMD.closeResultSetAndStatement();
                break;
            case 5:
                query = "SELECT C.TITLE AS COURSE, S.F_NAME AS FIRST_NAME, S.L_NAME AS LAST_NAME  FROM student s\n" +
                        "JOIN course_student CS\n" +
                        "ON S.STD_ID = CS.STD_ID\n" +
                        "JOIN COURSE C\n" +
                        "ON CS.COURSE_ID = C.COURSE_ID\n" +
                        "ORDER BY LENGTH(C.TITLE) ASC";
                printCMD = new PrintCMD(query);
                printCMD.printStudentCourse();

                break;

            case 6:

                query = " SELECT c.TITLE as Course, t.F_NAME as FIRST_NAME, t.L_NAME AS LAST_NAME FROM trainer t\n" +
                        " join course_trainer ct on t.TRAINER_ID = ct.TRAINER_ID\n" +
                        " join course c on ct.COURSE_ID = c.COURSE_ID\n" +
                        " ORDER BY CT.COURSE_ID;";
                printCMD = new PrintCMD(query);
                printCMD.printTrainerCourse();

                break;

            case 7:
                query = ("SELECT c.title as Course, a.TITLE as Assignment_Title FROM assignment a\n" +
                        "JOIN course_assignment as ca ON ca.ass_id = a.ass_id\n" +
                        "JOIN course as c on ca.course_id = c.course_id\n" + "ORDER BY LENGTH(C.TITLE), C.TITLE ASC");
                printCMD = new PrintCMD(query);
                printCMD.printAssignmentCourse();
                printCMD.closeResultSetAndPrepStatement();
                break;
            case 8:

                printCMD = new PrintCMD(queryAssignmentCourseStudent);
                printCMD.printAssignmentCourseStudent();
                printCMD.closeResultSetAndPrepStatement();
                break;
            case 9:
                query = ("SELECT S.F_NAME AS FIRST_NAME, S.L_NAME AS LAST_NAME, COUNT(CS.STD_ID) AS COURSES_ENROLLED\n" +
                        "FROM STUDENT S\n" +
                        "JOIN COURSE_STUDENT CS\n" +
                        "ON S.STD_ID = CS.STD_ID \n" +
                        "GROUP BY CS.STD_ID\n" +
                        "HAVING COUNT(CS.STD_ID) > 1;");
                printCMD = new PrintCMD(query);
                printCMD.printStudentToManyCourses();
                break;
            case 10:
                break;
        }


    }




    public void insertMenu() {
        String query;
        InsertData insert;

        System.out.print("Welcome to the Input Data submenu\n");

        System.out.print("Choose one of the following options to input data\n");

        System.out.println("1. Create a new Student");
        System.out.println("2. Create a new Trainer");
        System.out.println("3. Create a new Assignment");
        System.out.println("4. Create a new Course");
        System.out.println("5. Add a Student to a Course");
        System.out.println("6. Add a Trainer to a Course");
        System.out.println("7. Add an Assignment to a Course");
        System.out.println("8. Add Marks to a Student");
        System.out.println("9. Back to the Main Menu");


        int actionInsertMenu = validation(8);

        switch (actionInsertMenu) {
            case 1:
                query = ("insert into student(f_name, l_name, birth_date, tuition_fees) values(?, ?, ?, ?); ");
                insert = new InsertData(query);
                insert.insertIntoStudent();
                insertMenu();
                break;
            case 2:
               query = ("insert into trainer(f_name, l_name, SUBJECT) values (?, ?, ?); ");
                insert = new InsertData(query);
                insert.insertIntoTrainer();
                insertMenu();
                break;
            case 3:
                query = ("insert into assignment(title, descr, oral_mark, total_mark) values (?, ?, ?, ?); ");
                insert = new InsertData(query);
                insert.insertIntoAssignment();
                insertMenu();
                break;
            case 4:
                query = ("insert into course(title, stream, typ, start_date, end_date) values (?, ?, ?, ?, ?); ");
                insert = new InsertData(query);
                insert.insertIntoCourse();
                insertMenu();
                break;

            case 5:
                // Adding a student to a Course
                printCMD = new PrintCMD(queryStudents);
                printCMD.printStudent();

                int idFromStudent = printCMD.getIdFromTable("Student ID");
                PrintCMD printCMD1 = new PrintCMD(queryCourses);
                printCMD1.printCourse();
                int idFromCourse = printCMD1.getIdFromTable("Course ID");

                query = ("insert into course_student (course_id, std_id) values (?, ?)" );
                InsertData insertStudent = new InsertData(query);
                insertStudent.insertIntoStudentCourse(idFromCourse, idFromStudent);

                // Adding new rows to the table Assignment_Student for INPUT = STUDENT_ID, COURSE_ID

                query = ("SELECT ca.course_id, ca.ass_id FROM assignment a\n" +
                        "JOIN course_assignment as ca ON ca.ass_id = a.ass_id\n" +
                        "JOIN course as c on ca.course_id = c.course_id\n" +
                        "HAVING CA.COURSE_ID = ?\n" +
                        "order by length(c.title), c.title asc; ");
                insert = new InsertData(query);
                ArrayList<Integer> assIds = insert.getAssIdsFromCourse(idFromCourse);

//                System.out.println(assIds.toString());

                insert.insertIntoAssignmentStudent(idFromStudent, idFromCourse, assIds);
                System.out.println("Assignments successfully added to Student for this course.");
                insertMenu();
                break;

            case 6:
                printCMD = new PrintCMD(queryTrainers);
                printCMD.printTrainer();
                int idFromTrainer = printCMD.getIdFromTable("Trainer ID");
                System.out.println(idFromTrainer);
                PrintCMD printCMD2 = new PrintCMD(queryCourses);
                printCMD2.printCourse();
                int iDFromCourse = printCMD2.getIdFromTable("Course ID");
                System.out.println(iDFromCourse);

                query = ("insert into course_trainer (course_id, trainer_id) values (?, ?); ");
                insert = new InsertData(query);
                insert.insertIntoTrainerCourse(iDFromCourse, idFromTrainer);
                insertMenu();
                break;
            case 7:
                // Adding an Assignment to a Course
                printCMD = new PrintCMD(queryAssignments);
                printCMD.printAssignment();
                int idFromAssignment = printCMD.getIdFromTable("Assignment ID");
                PrintCMD printCMD3 = new PrintCMD(queryCourses);
                printCMD3.printCourse();
                int idDFromCourse = printCMD3.getIdFromTable("Course ID");

                query = ("insert into course_assignment(course_id, ass_id) values (?, ?); ");
                insert = new InsertData(query);
                insert.insertIntoAssignmentCourse(idDFromCourse, idFromAssignment);

                // Adding new rows to the assignment_student table for INPUT = ASS_ID, COURSE_ID

                query = "SELECT DISTINCT s.std_id, c.course_id FROM student s\n" +
                        "JOIN course_student as CS\n" +
                        "ON S.STD_ID = CS.STD_ID\n" +
                        "JOIN COURSE as C\n" +
                        "ON CS.COURSE_ID = C.COURSE_ID\n" +
                        "JOIN course_assignment as ca\n" +
                        "on cs.course_id = ca.course_id\n" +
                        "join assignment as ass \n" +
                        "on ca.ass_id = ass.ass_id\n" +
                        "join assignment_student as asst\n" +
                        "on s.std_id = asst.std_id and\n" +
                        "ca.ass_id = asst.ass_id and\n" +
                        "cs.course_id = asst.course_id\n" +
                        "HAVING course_id = ?\n" +
                        "order by s.l_name, c.title; ";

                insert = new InsertData(query);
                ArrayList<Integer> stIds = insert.getStIdsFromAssignmentAndCourse(idDFromCourse);
                insert.insertAssignmentIntoAssignmentStudent(idFromAssignment, idDFromCourse, stIds);
                System.out.println("Assignment successfully added to the respective Students of the Course");
                insertMenu();
                break;

            case 8:
                query = "SELECT s.F_NAME as FIRST_NAME, s.L_NAME AS LAST_NAME, c.title AS COURSE, ass.TITLE AS ASSIGNMENT_TITLE , ass.ORAL_MARK, ass.TOTAL_MARK, asst.st_oral_mark, asst.st_total_mark, asst.id as ID   FROM student s\n" +
                        "JOIN course_student as CS\n" +
                        "ON S.STD_ID = CS.STD_ID\n" +
                        "JOIN COURSE as C\n" +
                        "ON CS.COURSE_ID = C.COURSE_ID\n" +
                        "JOIN course_assignment as ca\n" +
                        "on cs.course_id = ca.course_id\n" +
                        "join assignment as ass \n" +
                        "on ca.ass_id = ass.ass_id\n" +
                        "join assignment_student as asst\n" +
                        "on s.std_id = asst.std_id and\n" +
                        "ca.ass_id = asst.ass_id and\n" +
                        "cs.course_id = asst.course_id\n" +
                        "order by asst.id";
                printCMD = new PrintCMD(query);
                printCMD.printAssignmentCourseStudent();
                ArrayList<Integer> idFromAssignmentCourseStudent = printCMD.getIdAssignmentStudentTable("Table ID");
                int chosenID = idFromAssignmentCourseStudent.get(0);
                int maxOralMark = idFromAssignmentCourseStudent.get(1);
                int maxTotalMark = idFromAssignmentCourseStudent.get(2);

                query = ("update assignment_student set st_oral_mark = ?, st_total_mark = ? WHERE id = ? ");
                insert = new InsertData(query);
                insert.insertMarks(chosenID, maxOralMark, maxTotalMark);
                insertMenu();
                break;
            case 9:
                mainMenu();
                break;
        }

    mainMenu();

    }


    public void greetMessage() {
        System.out.println("Welcome to our Private School Database.");
        mainMenu();
    }

    public void mainMenu() {
        System.out.println("Type one of the starting integers to navigate through the Menu");

        System.out.println("1. Print Tables");
        System.out.println("2. Input Data");
        System.out.println("3. Exit");

        int actionMenu = validation(3);

        switch (actionMenu) {
            case 1:
                printMenu();
                break;
            case 2:
                insertMenu();
                break;
            case 3:
                MyDBConnection con = new MyDBConnection();
                con.destroy();
                System.exit(0);
                break;
        }
        mainMenu();
    }


    public static int validation(int maxInt) {
        // All menu options start from 1. We only care about the maxInt digit.
        Scanner sc = new Scanner(System.in);
        String input = "";
        int action = -1;
        boolean isIntValid = false;
        boolean isSecondTime = false;
        do {
            if (isSecondTime) {
                System.out.printf("\"%d\" is out of bounds  ", action);
            }
            System.out.print("Type your choice here: ");


            while (!sc.hasNextInt()) {
                input = sc.next();
                System.out.printf("\"%s\" is not a number. Validation works, doesn't it? \n Please enter a valid number! \n", input);
            }
            isSecondTime = true;
            action = sc.nextInt();
            for (int i = 1; i <= maxInt; i++) {
                if (action == i) {
                    isIntValid = true;
                    break;
                }
            }


        } while (!isIntValid);
        return action;
    }

}










