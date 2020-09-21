/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pack;

import org.apache.commons.lang3.StringUtils;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author arisp
 */

    public class PrintCMD extends ResultSets {
    private String query;


    public PrintCMD(String query) {
        super();
        this.query = query;
        if (query.contains("?") || query.contains("WHERE") || query.contains("JOIN")) {
            this.rs = super.getResultFromPrStmt(query);
        } else {
            this.rs = super.getResultFromStmt(query);
        }

    }


    public void printStudent() {
        try {
            ResultSetMetaData meta = rs.getMetaData();
            System.out.println("Querying: SELECT * FROM STUDENT \n");

            String stdIdFormat = "| %1$-10d  |";
            String firstNameFormat = " %2$-15s |";
            String lastNameFormat = " %3$-20s | ";
            String birthDateFormat = " %4$td %4$tb, %4$tY   |";
            String tuitionFeesFormat = " %5$-15d|%n";
            String format = stdIdFormat.concat(firstNameFormat).concat(lastNameFormat).concat(birthDateFormat).concat(tuitionFeesFormat);

            String line = new String(new char[91]).replace('\0', '-');
            System.out.println(line);

            System.out.printf("|%s|%s|%s|%s|%s|%n",
                    StringUtils.center(meta.getColumnName(1), 13),
                    StringUtils.center(meta.getColumnName(2), 17),
                    StringUtils.center(meta.getColumnName(3), 22),
                    StringUtils.center(meta.getColumnName(4), 17),
                    StringUtils.center(meta.getColumnName(5), 16));
            System.out.println(line);


            while (rs.next()) {
                int stdId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                LocalDate birthDate = rs.getDate(4).toLocalDate();
                int tuitionFees = rs.getInt(5);

                System.out.printf(format, stdId, firstName, lastName, birthDate, tuitionFees);

            }
            System.out.println(line);

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            closeResultSetAndStatement();
//        }
    }


    public void printTrainer() {
        try {

            ResultSetMetaData meta = rs.getMetaData();
            System.out.println("Querying: SELECT * FROM TRAINER \n");

            String trainerIdFormat = "| %1$-15d |";
            String nameFormat = " %2$-20s | ";
            String LastNameFormat = " %3$-10s    |";
            String subjectFormat = " %4$-31s|%n";
            String format = trainerIdFormat.concat(nameFormat).concat(LastNameFormat).concat(subjectFormat);

            String line = new String(new char[92]).replace('\0', '-');
            System.out.println(line);

            System.out.printf("|%s|%s|%s|%s|%n",
                    StringUtils.center(meta.getColumnName(1), 17),
                    StringUtils.center(meta.getColumnName(2), 22),
                    StringUtils.center(meta.getColumnName(3), 16),
                    StringUtils.center(meta.getColumnName(4), 32));
            System.out.println(line);

            while (rs.next()) {
                int trainerID = rs.getInt("TRAINER_ID");
                String firstName = rs.getString("F_NAME");
                String lastName = rs.getString("L_NAME");
                String subject = rs.getString("SUBJECT");
                System.out.printf(format, trainerID, firstName, lastName, subject);

            }

            System.out.println(line);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
////            closeResultSetAndStatement();
//        }
    }

    public void printAssignment() {
        try {

            ResultSetMetaData meta = rs.getMetaData();
            System.out.println("Querying: " + query + "\n");

            String assIdFormat = "| %1$-15d |";
            String titleFormat = " %2$-43s | ";
            String descFormat = " %3$-63s |";
            String oralMarkFormat = " %4$-9d|";
            String totalMarkFormat = " %5$-9d|%n";
            String format = assIdFormat.concat(titleFormat).concat(descFormat).concat(oralMarkFormat).concat(totalMarkFormat);

            String line = new String(new char[154]).replace('\0', '-');
            System.out.println(line);

            System.out.printf("|%s|%s|%s|%s|%s|%n",
                    StringUtils.center(meta.getColumnName(1), 17),
                    StringUtils.center(meta.getColumnName(2), 45),
                    StringUtils.center(meta.getColumnName(3), 66),
                    StringUtils.center(meta.getColumnName(4), 10),
                    StringUtils.center(meta.getColumnName(5), 10));
            System.out.println(line);

            while (rs.next()) {
                int assId = rs.getInt(1);
                String title = rs.getString(2);
                String descr = rs.getString(3);
                int oralMark = rs.getInt(4);
                int totalMark = rs.getInt(5);
                System.out.printf(format, assId, title, descr, oralMark, totalMark);

            }

            System.out.println(line);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            closeResultSetAndStatement();
//        }
    }

    public void printCourse() {
        try {

            ResultSetMetaData meta = rs.getMetaData();
            System.out.println("Querying: " + query + "\n");


            String courseIdFormat = "| %1$-12d |";
            String titleFormat = " %2$-15s | ";
            String streamFormat = " %3$-19s |";
            String typeFormat = " %4$-15s|";
            String startDateFormat = " %5$td %5$tb, %5$tY  |";
            String endDateFormat = " %6$td %6$tb, %6$tY  |%n";
            String format = courseIdFormat.concat(titleFormat).concat(streamFormat).concat(typeFormat).concat(startDateFormat).concat(endDateFormat);

            String line = new String(new char[106]).replace('\0', '-');
            System.out.println(line);

            System.out.printf("|%s|%s|%s|%s|%s|%s|%n",
                    StringUtils.center(meta.getColumnName(1), 14),
                    StringUtils.center(meta.getColumnName(2), 17),
                    StringUtils.center(meta.getColumnName(3), 20),
                    StringUtils.center(meta.getColumnName(4), 18),
                    StringUtils.center(meta.getColumnName(5), 15),
                    StringUtils.center(meta.getColumnName(6), 15));
            System.out.println(line);

            while (rs.next()) {
                int courseId = rs.getInt(1);
                String title = rs.getString(2);
                String stream = rs.getString(3);
                String type = rs.getString(4);
                LocalDate startDate = rs.getDate(5).toLocalDate();
                LocalDate endDate = rs.getDate(6).toLocalDate();
                System.out.printf(format, courseId, title, stream, type, startDate, endDate);
            }

            System.out.println(line);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printStudentCourse() {
        try {

            ResultSetMetaData meta = rs.getMetaData();
            System.out.println("Querying: " + query + "\n");


            String courseF = "| %1$-12s |";
            String firstNameF = " %2$-20s |";
            String lastNameF = " %3$-25s |%n";

            String format = courseF.concat(firstNameF).concat(lastNameF);

            String line = new String(new char[67]).replace('\0', '-');
            System.out.println(line);

            System.out.printf("|%s|%s|%s|%n",
                    StringUtils.center(meta.getColumnLabel(1), 14),
                    StringUtils.center(meta.getColumnLabel(2), 22),
                    StringUtils.center(meta.getColumnLabel(3), 27));
            System.out.println(line);

            while (rs.next()) {
                String course = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);

                System.out.printf(format, course, firstName, lastName);
            }

            System.out.println(line);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSetAndPrepStatement();
        }
    }


    public void printTrainerCourse() {
        try {

            ResultSetMetaData meta = rs.getMetaData();
            System.out.println("Querying: " + query + "\n");


            String courseF = "| %1$-12s |";
            String firstNameF = " %2$-20s |";
            String lastNameF = " %3$-25s |%n";

            String format = courseF.concat(firstNameF).concat(lastNameF);

            String line = new String(new char[67]).replace('\0', '-');
            System.out.println(line);

            System.out.printf("|%s|%s|%s|%n",
                    StringUtils.center(meta.getColumnLabel(1), 14),
                    StringUtils.center(meta.getColumnLabel(2), 22),
                    StringUtils.center(meta.getColumnLabel(3), 27));
            System.out.println(line);

            while (rs.next()) {
                String course = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);

                System.out.printf(format, course, firstName, lastName);
            }

            System.out.println(line);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSetAndPrepStatement();
        }
    }


    public void printAssignmentCourse() {
        try {

            ResultSetMetaData meta = rs.getMetaData();
            System.out.println("Querying: " + query + "\n");


            String cTitleFormat = "| %1$-12s |";
            String aTitleFormat = " %2$-43s |%n";

            String format = cTitleFormat.concat(aTitleFormat);

            String line = new String(new char[62]).replace('\0', '-');
            System.out.println(line);

            System.out.printf("|%s|%s|%n",
                    StringUtils.center(meta.getColumnLabel(1), 14),
                    StringUtils.center(meta.getColumnLabel(2), 45));
            System.out.println(line);

            while (rs.next()) {
                String cTitle = rs.getString(1);
                String aTitle = rs.getString(2);

                System.out.printf(format, cTitle, aTitle);
            }

            System.out.println(line);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAssignmentCourseStudent() {
        try {
            ResultSetMetaData meta = rs.getMetaData();
            System.out.println("Querying: " + query + "\n");


            String fNameFormat = "| %1$-12s |";
            String lNameFormat = " %2$-25s |";
            String courseFormat = " %3$-12s |";
            String assTitleFormat = " %4$-45s |";
            String asOralMarkFormat = " %5$-12d |";
            String asTotalMarkFormat = " %6$-12d |";
            String stOralMarkFormat = " %7$-18s |";
            String stTotalmarkFormat = " %8$-18s |";
            String assignmentStudentIdFormat = " %9$-13d |%n";

            String format = fNameFormat.concat(lNameFormat).concat(courseFormat).concat(assTitleFormat).concat(asOralMarkFormat).concat(asTotalMarkFormat).concat(stOralMarkFormat).concat(stTotalmarkFormat).concat(assignmentStudentIdFormat);

            String line = new String(new char[195]).replace('\0', '-');
            System.out.println(line);

            System.out.printf("|%s|%s|%s|%s|%s|%s|%s|%s|%s|%n",
                    StringUtils.center(meta.getColumnLabel(1), 14),
                    StringUtils.center(meta.getColumnLabel(2), 27),
                    StringUtils.center(meta.getColumnLabel(3), 14),
                    StringUtils.center(meta.getColumnLabel(4), 47),
                    StringUtils.center(meta.getColumnLabel(5), 14),
                    StringUtils.center(meta.getColumnLabel(6), 14),
                    StringUtils.center(meta.getColumnLabel(7), 20),
                    StringUtils.center(meta.getColumnLabel(8), 20),
                    StringUtils.center(meta.getColumnLabel(9), 15));
            System.out.println(line);

            while (rs.next()) {
                String fName = rs.getString(1);
                String lName = rs.getString(2);
                String course = rs.getString(3);
                String assTitle = rs.getString(4);
                int asOral = rs.getInt(5);
                int asTotal = rs.getInt(6);
                String stOral = rs.getString(7);
                String stTotal = rs.getString(8);
                int assignmentStudentId = rs.getInt(9);

                String check = "-1";

                if (stOral.equals(check)) {
                    stOral = "Not Applicable yet";
                }

                if (stTotal.equals(check)) {
                    stTotal = "Not Applicable yet";
                }

                System.out.printf(format, fName, lName, course, assTitle, asOral, asTotal, stOral, stTotal, assignmentStudentId);
            }

            System.out.println(line);

//            while (rs.next()) {
//                String a = rs.getString(1);
//                String b = rs.getString(2);
//                String c = rs.getString(3);
//                String d = rs.getString(4);
//                String e = rs.getString(5);
//                String check = "-1";
//                if (d.equals(check)) {
//                    d = "Not Applicable yet.";
//
//                }
//                if (e.equals(check)) {
//                    e = "Not Applicable yet.";
//                }
//
//                System.out.print(a + b + c + d + e);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            closeResultSetAndPrepStatement();
//        }
    }


    public void printStudentToManyCourses() {
        try {

            ResultSetMetaData meta = rs.getMetaData();
            System.out.println("Querying: " + query + "\n");


            String courseF = "| %1$-12s |";
            String firstNameF = " %2$-20s |";
            String lastNameF = " %3$-17d |%n";

            String format = courseF.concat(firstNameF).concat(lastNameF);

            String line = new String(new char[59]).replace('\0', '-');
            System.out.println(line);

            System.out.printf("|%s|%s|%s|%n",
                    StringUtils.center(meta.getColumnLabel(1), 14),
                    StringUtils.center(meta.getColumnLabel(2), 22),
                    StringUtils.center(meta.getColumnLabel(3), 19));
            System.out.println(line);

            while (rs.next()) {
                String course = rs.getString(1);
                String firstName = rs.getString(2);
                int lastName = rs.getInt(3);

                System.out.printf(format, course, firstName, lastName);
            }

            System.out.println(line);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSetAndPrepStatement();
        }


    }



    public int getIdFromTable(String columnName) {
        int columnIdPicked = -1;
        boolean idInvalid = true;
        int lastId;

        try {
            // Find the last column id
            rs.last();
            lastId = rs.getInt(1);
            // User picks an Id with proper validation

            while(idInvalid) {
                System.out.println("Provide the " + columnName + " you wish to add.");
                columnIdPicked = Menu.validation(lastId);

                rs.beforeFirst();
                while (rs.next()) {
                    if (rs.getInt(1) == columnIdPicked) {
                        idInvalid = false;

                        break;
                    }
                }
                if (idInvalid) {
                    System.out.println("The id you provided doesn't exist");
                }

            }
        } catch(SQLException e){ e.printStackTrace();}
        finally {
            closeResultSetAndStatement();
        }
        return columnIdPicked;
    }

    public ArrayList<Integer> getIdAssignmentStudentTable(String columnName) {
        int columnIdPicked = -1;
        boolean idInvalid = true;
        int lastId;
        ArrayList<Integer> idOralTotalList = new ArrayList<>();

        try {
            // Find the last column id
            rs.last();
            lastId = rs.getInt(9);
            // User picks an Id with proper validation

            while(idInvalid) {
                System.out.println("Provide the " + columnName + " you wish to add.");
                columnIdPicked = Menu.validation(lastId);

                rs.beforeFirst();
                while (rs.next()) {
                    if (rs.getInt(9) == columnIdPicked) {
                        idOralTotalList.add(columnIdPicked);
                        idOralTotalList.add(rs.getInt(5));
                        idOralTotalList.add(rs.getInt(6));
                        idInvalid = false;

                        break;
                    }
                }
                if (idInvalid) {
                    System.out.println("The id you provided doesn't exist");
                }

            }
        } catch(SQLException e){ e.printStackTrace();}
        finally {
            closeResultSetAndStatement();
        }
        return idOralTotalList;
    }




}







    

    

