package ProiectFinal;


import javax.swing.*;
//import java.awt.*;
import java.awt.*;
import java.sql.*;

public class Joc extends JFrame {
    Statement myStmt;
    Connection myConn;
    JLabel welcome, welcome2;
    String selectQ;
    PreparedStatement PS;
    ResultSet rst;
    String intrebare;


    public Joc() {

        // this.myStmt=myStmt;
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        //this.setBackground(Color.green);
        //this.myConn=myConn;

        welcome = new JLabel(getQuestion());
        welcome2 = new JLabel("we");


        //questionPanel
        JPanel questionPanel = new JPanel();


        questionPanel.add(welcome);
        questionPanel.add(welcome2);
        this.add(questionPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public String getQuestion() {

        selectQ = "select * from dialoguri";
        try {
            PS = myConn.prepareStatement(selectQ);
            //welcome.setText(rst.getString(1));
            rst = myStmt.executeQuery("select * from dialoguri");
            while (rst.next()) {
                intrebare = rst.getString("dialog");
                System.out.println(intrebare);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return intrebare;
    }
}


