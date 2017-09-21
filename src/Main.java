import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.driver.OracleDriver;
import oracle.*;//

public class Main {

    public static void main(String[] args) {
        String dbUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String user = "Viktoria";
        String parola = "Marcius2017";

        try {
            Connection myconn = DriverManager.getConnection(dbUrl, user, parola);
            System.out.println("Ce fain!!");
            Statement myStatement = myconn.createStatement();
           String selectTable = "insert into angajat values (1)";
            System.out.println(selectTable);

           myStatement.execute(selectTable);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nu a mers");
        }


    }
}
