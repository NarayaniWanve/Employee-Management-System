
package employee_management_system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;  
import java.sql.Connection;
import java.sql.*;
public class UpdateEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tfeducation,tffname,tfaddress,tfphone,tfaadhar,tfemail,tfsalary,tfdesignation;
    JLabel lblempId;
    JButton add,back;
    String EMPID;
     UpdateEmployee(String EMPID) {
         this.EMPID = EMPID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
        JLabel lblname = new JLabel();
         lblname.setBounds(200,150,150,30);
        add(lblname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname .setBounds(600,150,150,30);
        add(tffname);
        
        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress .setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleducation);
        
        
                
        tfeducation = new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);
        
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labelaadhar);
        
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);
        
        try{
             Connection con = Conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from EMPLOYEE where EMPID = '"+EMPID+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("designation"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        add = new JButton("Update Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
back.setBounds(450, 550, 150, 40);
back.addActionListener(this);
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
add(back); 
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add)
        {   
         
         String fname = tffname.getText();
         String salary = tfsalary.getText();
         String address = tfaddress.getText();
         String phone = tfphone.getText();
         String email = tfemail.getText();
         String education = tfeducation.getText();
         String designation = tfdesignation.getText();
         
         try{
             Connection con = Conn.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE EMPLOYEE SET FNAME=?, SALARY=?, ADDRESS=?, PHONE=?, EMAIL=?, EDUCATION=?, DESIGNATION=? WHERE EMPID=?");
             
             
             ps.setString(1, fname);
ps.setString(2, salary);
ps.setString(3, address);
ps.setString(4, phone);
ps.setString(5, email);
ps.setString(6, education);
ps.setString(7, designation);
ps.setString(8, EMPID);

System.out.println("SQL Query: " + ps.toString());
System.out.println("fname: " + fname);
System.out.println("salary: " + salary);
System.out.println("address: " + address);
System.out.println("phone: " + phone);
System.out.println("email: " + email);
System.out.println("education: " + education);
System.out.println("designation: " + designation);
System.out.println("EMPID: " + EMPID);



             ps.executeUpdate();
             JOptionPane.showMessageDialog(null,"Details added successfully");
             setVisible(false);
             new Home();
         }
         
         catch(Exception ee)
         {
             ee.printStackTrace();
         }
        }
        else {
        new Home();
        }
    }
    public static void main(String[] args) {
        new UpdateEmployee("");
    }
    
}
