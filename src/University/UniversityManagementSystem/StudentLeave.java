package University.UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLeave extends JFrame implements ActionListener{
    Choice crollno,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;

    StudentLeave(){
        setTitle("Student Leave");
        setSize(500,550);
        setResizable(false);
        setLocation(600,100);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Apply Leave(Student)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setBounds(60,100,200,20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblrollno);

        // scroll bar
        crollno = new Choice();
        crollno.setBounds(60,130,200,20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,200,25);
        add(dcdate);

        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60,260,200,20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbltime);

        // scroll bar
        ctime = new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        // buttons
        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.darkGray);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.darkGray);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit) {
            String rollno = crollno.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            String query = "insert into studentleave values ('"+rollno+"','"+date+"','"+duration+"')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentLeave();
        
    }
}