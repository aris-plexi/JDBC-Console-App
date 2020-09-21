package main.pack;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertData extends ResultSets {
    private String query;
    int action;
    ArrayList<Integer> assIdsForCourse = new ArrayList<>();
    ArrayList<Integer> stIdsForCourseAssignment = new ArrayList<>();


    public InsertData(String query) {
        super();
        this.query = query;
        prStmt = super.getPreparedStatement(query);

    }




    public void insertIntoStudent() {

        String fName = stringValidation("First Name",15);
        String lName = stringValidation("Last Name",20);
        LocalDate birthDate = dateValidation("Birth Date");

        System.out.println("Please provide the Tuition Fees of the Student in Euros.");
        int tuitionFees = Menu.validation(4000);

        try {
            prStmt = con.getMyPrepStatement(query);
            prStmt.setString(1, fName);
            prStmt.setString(2, lName);
            prStmt.setObject(3, birthDate);
            prStmt.setInt(4, tuitionFees);
            int i = prStmt.executeUpdate();
            System.out.println("\nStudent successfully added to the Table. \n");
            System.out.println(i + " row(s) affected");

            System.out.println("\nType \"1\" if you wish to add another Student or \"2\" for the InsertMenu.");
            action = Menu.validation(2);
            if (action == 1) {
                insertIntoStudent();
            }

        } catch (SQLException e) {
            System.err.println("Row couldn't be inserted to Table");
        } finally {
            closeResultSetAndPrepStatement();
        }

    }

    public void insertIntoTrainer() {
        String fName = stringValidation("First Name",15);
        String lName = stringValidation("Last Name",20);
        String subject = stringValidation("Subject",31);



        try {
            prStmt = con.getMyPrepStatement(query);
            prStmt.setString(1, fName);
            prStmt.setString(2, lName);
            prStmt.setString(3, subject);
            int i = prStmt.executeUpdate();
            System.out.println("\nTrainer successfully added to the Table. \n");
            System.out.println(i + " row(s) affected");

            System.out.println("\nType \"1\" if you wish to add another Trainer or \"2\" for the InsertMenu.");
            action = Menu.validation(2);
            if (action == 1) {
                insertIntoTrainer();
            }

        } catch (SQLException e) {
            System.err.println("Row couldn't be inserted to Table");
        } finally {
            closeResultSetAndPrepStatement();
        }

    }


    public void insertIntoAssignment() {
        String title = stringValidation("Title",15);
        String descr = stringValidation("Description",20);

        System.out.println("Please provide the Oral Mark of the Assignment");
        int oralMark = Menu.validation(50);

        System.out.println("Please provide the Total Mark of the Assignment");
        int totalMark = Menu.validation(150);



        try {
            prStmt = con.getMyPrepStatement(query);
            prStmt.setString(1, title);
            prStmt.setString(2, descr);
            prStmt.setInt(3, oralMark);
            prStmt.setInt(4, totalMark);
            int i = prStmt.executeUpdate();
            System.out.println("\nAssignment successfully added to the Table. \n");
            System.out.println(i + " row(s) affected");

            System.out.println("\nType \"1\" if you wish to add another Assignment or \"2\" for the InsertMenu.");
            action = Menu.validation(2);
            if (action == 1) {
                insertIntoAssignment();
            }

        } catch (SQLException e) {
            System.err.println("Row couldn't be inserted to Table");
        } finally {
            closeResultSetAndPrepStatement();
        }

    }

    public void insertIntoCourse() {
        String title = stringValidation("Title",15);
        String stream = stringValidation("Stream",20);
        String typ = stringValidation("Type of the Course", 25);
        LocalDate startDate = dateValidation("Start Date");
        LocalDate endDate = dateValidation("End Date");



        try {
            prStmt = con.getMyPrepStatement(query);
            prStmt.setString(1, title);
            prStmt.setString(2, stream);
            prStmt.setString(3, typ);
            prStmt.setObject(4, startDate);
            prStmt.setObject(5, endDate);
            int i = prStmt.executeUpdate();
            System.out.println("\nCourse successfully added to the Table. \n");
            System.out.println(i + " row(s) affected");

            System.out.println("\nType \"1\" if you wish to add another Course or \"2\" for the InsertMenu.");
            action = Menu.validation(2);
            if (action == 1) {
                insertIntoCourse();
            }

        } catch (SQLException e) {
            System.err.println("Row couldn't be inserted to Table");
        } finally {
            closeResultSetAndPrepStatement();
        }

    }

    public void insertIntoTrainerCourse (int idCourse, int idTrainer) {
        try {
            prStmt = con.getMyPrepStatement(query);
            prStmt.setInt(1, idCourse);
            prStmt.setInt(2, idTrainer);

            int i = prStmt.executeUpdate();
            System.out.println("\nTrainer successfully added to the course. \n");
            System.out.println(i + " row(s) affected");

        } catch (SQLException e) {
            System.err.println("Row couldn't be inserted to Table. Duplicated entry.");

        } finally {
            closeResultSetAndPrepStatement();
        }

    }

    public void insertIntoStudentCourse (int idCourse, int idStudent) {
        try {
            prStmt = con.getMyPrepStatement(query);
            prStmt.setInt(1, idCourse);
            prStmt.setInt(2, idStudent);

            int i = prStmt.executeUpdate();
            System.out.println("\nStudent successfully added to the course. \n");
            System.out.println(i + " row(s) affected");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Row couldn't be inserted to Table. Duplicated entry.");
            Menu menu = new Menu();
            menu.mainMenu();
        } finally {
            closeResultSetAndPrepStatement();
        }

    }

    public void insertIntoAssignmentCourse (int idCourse, int idAssignment) {
        try {
            prStmt = con.getMyPrepStatement(query);
            prStmt.setInt(1, idCourse);
            prStmt.setInt(2, idAssignment);

            int i = prStmt.executeUpdate();
            System.out.println("\nAssignment successfully added to the course. \n");
            System.out.println(i + " row(s) affected");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Row couldn't be inserted to Table. Duplicated entry.");
            Menu menu = new Menu();
            menu.mainMenu();
        } finally {
            closeResultSetAndPrepStatement();
        }

    }

    public void insertMarks (int idTable, int maxOralMark, int maxTotalMark) {
        try {
            System.out.println("Please provide the Oral Mark for the Student");
            int oralMark = Menu.validation(maxOralMark);

            System.out.println("Please provide the Total Mark for the Student");
            int totalMark = Menu.validation(maxTotalMark);



            prStmt = con.getMyPrepStatement(query);
            prStmt.setInt(1, oralMark);
            prStmt.setInt(2, totalMark);
            prStmt.setInt(3, idTable);

            int i = prStmt.executeUpdate();
            System.out.println("\nMarks successfully added to the Student. \n");
            System.out.println(i + " row(s) affected");

        } catch (SQLException e) {
            e.printStackTrace();
            //System.err.println("Row couldn't be inserted to Table. Duplicated entry.");
            Menu menu = new Menu();
            menu.mainMenu();
        } finally {
            closeResultSetAndPrepStatement();
        }

    }






    public ArrayList<Integer> getAssIdsFromCourse(int courseId) {


        try {
            prStmt.setInt(1, courseId);
            rs = prStmt.executeQuery();

            while (rs.next()) {
                assIdsForCourse.add(rs.getInt(2));
            }

        } catch (SQLException e) {e.printStackTrace();}
        finally {
            closeResultSetAndPrepStatement();
        }



        return assIdsForCourse;
    }

    public ArrayList<Integer> getStIdsFromAssignmentAndCourse(int courseId) {


        try {
            prStmt.setInt(1, courseId);

            rs = prStmt.executeQuery();

            while (rs.next()) {
                stIdsForCourseAssignment.add(rs.getInt(1));
            }

        } catch (SQLException e) {e.printStackTrace();}
        finally {
            closeResultSetAndPrepStatement();
        }



        return stIdsForCourseAssignment;
    }





    public void insertIntoAssignmentStudent (int studentID, int courseId, ArrayList<Integer> assIds) {
       String queryLocal = "insert into assignment_student values(null, ?, ?, ?, -1, -1); ";
       int i = 0;
       try {


           prStmt = con.getMyPrepStatement(queryLocal);

           for (Integer assignments : assIds) {
               prStmt.setInt(1, assignments);
               prStmt.setInt(2, studentID);
               prStmt.setInt(3, courseId);
               prStmt.executeUpdate();
               i++;
           }
           System.out.println(i + " row(s) affected");
       } catch (SQLException e) {e.printStackTrace();}
       finally {
           closeResultSetAndPrepStatement();
       }

    }


    public void insertAssignmentIntoAssignmentStudent (int assID, int courseId, ArrayList<Integer> stIds) {
        String queryLocal = "insert into assignment_student values(null, ?, ?, ?, -1, -1); ";
        int i = 0;
        try {


            prStmt = con.getMyPrepStatement(queryLocal);

            for (Integer students : stIds) {
                prStmt.setInt(1, assID);
                prStmt.setInt(2, students);
                prStmt.setInt(3, courseId);
                prStmt.executeUpdate();
                i++;
            }
            System.out.println(i + " row(s) affected");
        } catch (SQLException e) {e.printStackTrace();}
        finally {
            closeResultSetAndPrepStatement();
        }

    }












}
