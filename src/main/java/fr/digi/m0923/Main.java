package fr.digi.m0923;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TestConnexionJdbc {
    private static final String DB_URL ="jdbc:mariadb://127.0.0.1:3306/digi";
    private static final String DB_USER ="root";
    private static final String DB_PWD ="say";
    public static void main (String[] args){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            System.out.println(connection);
        } catch (SQLException e){
            System.out.println("Attention:" + e.getMessage());
        }
        finally {
            if (null != connection){
                try {
                    connection.close();
                }
                catch (SQLException e){
                    System.out.println("Attention :" + e.getMessage());
                }
            }
        }
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)){
            System.out.println(cnx);
        }
        catch (SQLException e){
            System.out.println("Attention :" + e.getMessage());
        }
        System.out.println("Fin du programme ...");
    }
}