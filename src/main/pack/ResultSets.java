package main.pack;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultSets {
    protected MyDBConnection con;
    protected Statement stmt;
    protected PreparedStatement prStmt;
    protected ResultSet rs;
    protected Scanner sc = new Scanner(System.in);

    public ResultSets() {
        this.con = new MyDBConnection();
        con.init();
        this.rs = null;

    }


    public ResultSet getResultFromStmt(String query) {
        try {
            stmt = con.getMyStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getResultFromPrStmt(String query) {
        try {
            prStmt = con.getMyPrepStatement(query);
            rs = prStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public PreparedStatement getPreparedStatement(String query) {

        prStmt = con.getMyPrepStatement(query);
        return prStmt;
    }

    public void closeResultSetAndStatement() {
        con.close(rs);
        System.out.println("\nResultSet successfully closed.");
        con.close(stmt);
        System.out.println("\nStatement successfully closed.\n");
    }

    public void closeResultSetAndPrepStatement() {
        con.close(rs);
        System.out.println("\nResultSet successfully closed.");
        con.close(prStmt);
        System.out.println("\nPrepared Statement successfully closed.\n");
    }

    public ArrayList<Integer> getIdFromTrainerCourse() {



        return null;
    }

    public String stringValidation (String columnName, int maxChars) {
        String input;
        boolean isStringNotValid;
        boolean isStringOutOfBounds = true;

        do {
            System.out.print("Please provide a valid " + columnName + ": " );
            input = sc.next();
            Pattern p = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(input);
            isStringNotValid = m.find();

            if (isStringNotValid) {
                System.out.println("Your input contains special charactes or numbers/space.");
            }
            else {
                if (input.length() > 0 && input.length() <= maxChars) {
                    isStringOutOfBounds = false;
                } else {
                    System.out.println("Your input contains either 0 characters or more than " + maxChars + ".");
                }

            }
        } while (isStringOutOfBounds);
        return input;

    }

    public LocalDate dateValidation (String columnName) {
        LocalDate date = null;
        String input;
        boolean isStringInvalid = true;


        do {
            System.out.print("Please provide the " + columnName + " in the following format: YYYY-MM-DD: ");
            input = sc.next();

            try {
                date = LocalDate.parse(input);
                isStringInvalid = false;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid Date Format");
            }
        } while (isStringInvalid);

        return date;

    }

}


