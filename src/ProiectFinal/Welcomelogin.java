package ProiectFinal;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;

public class Welcomelogin extends JFrame {
    JButton exit,start;
    JLabel nume;
    JTextField numeField;
    Statement myStmt;
    BufferedImage img;

    public Welcomelogin(Statement myStmt) {
        this.myStmt=myStmt;
        this.setTitle("Escape from the island");
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        //this.setBackground(Color.green);

        //Jlabel
        JLabel mainLabel = new JLabel();
        mainLabel.setSize(900,600);
        mainLabel.setLayout(new BorderLayout());

        img = null;//njh
        try {
            img = ImageIO.read(new File("C:\\Users\\Vikic\\Desktop\\Imagini\\insula.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setContentPane(new JLabel(new ImageIcon(img)));

        Image dimg = img.getScaledInstance(mainLabel.getWidth(), mainLabel.getHeight(),Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(dimg);
        //Adauga imaginea de fond la mainLabel
        mainLabel.setIcon(imageIcon);
        this.setContentPane(mainLabel);


        //panel
        JPanel text = new JPanel();
        text.setLayout(new BoxLayout(text,BoxLayout.PAGE_AXIS));
        text.add(Box.createRigidArea(new Dimension(0,20)));
        //text.add(Box.createVerticalGlue());
        //JPanel mainPanel = new JPanel();
        //this.setBackground(Color.green);
        //mainPanel.setLayout(new BorderLayout());

        //buttonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,45,35));


        //Welcomelabel
        JLabel welcome = new JLabel("Welcome to");
        //welcome.setOpaque(true);
        welcome.setFont(new Font("Arial", Font.BOLD, 28));

        //
        JLabel welcometo = new JLabel("Escape from the island");
        //welcometo.setOpaque(true);
        welcometo.setFont(new Font("Arial", Font.BOLD, 28));


        //nameLabel
        JLabel nameLabel =new JLabel("Name");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 28));

        //numeField
        JTextField numeField= new JTextField(20);

        //button
        exit = new JButton("EXIT");
        exit.setPreferredSize(new Dimension(180,40));
        exit.setFont(new Font("Arial" ,Font.PLAIN, 18));

        //button
        start = new JButton("START");
        start.setPreferredSize(new Dimension(180,40));
        start.setFont(new Font("Arial" ,Font.PLAIN, 18));

        //listener
        ListenforButton listenforButton= new ListenforButton();
        exit.addActionListener(listenforButton);
        start.addActionListener(listenforButton);


        text.add(welcome);
        text.add(welcometo);
        text.add(nameLabel);
        text.add(numeField);
        text.add(start);

        buttonPanel.add(exit);
      //  buttonPanel.add(start);
        mainLabel.add(text,BorderLayout.NORTH);
        //mainLabel.add(welcome);
        //mainLabel.add(img);
        //mainLabel.add(welcome);
        mainLabel.add(buttonPanel,BorderLayout.SOUTH);
        //this.add(mainLabel);
        // this.setContentPane(mainLabel);

        //this.add(mainPanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    private class ListenforButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == start) {
                new Joc();
                dispose();
            } else if (e.getSource() == exit){
                System.exit(0);

            }

        }
    }
}