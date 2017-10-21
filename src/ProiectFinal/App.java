package ProiectFinal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    public static void main(String [] args){
        String dbUrl= "jdbc:oracle:thin:@//localhost:1521/orcl";
        String user="Viktoria";
        String password="Oktober2017";

              try {
                  Connection myConn = DriverManager.getConnection(dbUrl, user, password);
                  Statement myStmt = myConn.createStatement();
                  new Welcome(myStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

