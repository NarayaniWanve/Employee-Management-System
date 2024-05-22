
package employee_management_system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;  
import java.sql.Connection;
public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tfname,tffname,tfaddress,tfphone,tfaadhar,tfemail,tfsalary,tfdesignation;
    JDateChooser dcdob;
    JComboBox ceducation;
    JLabel lblempId;
    JButton add,back;
    public AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
        tfname = new JTextField();
        tfname .setBounds(200,150,150,30);
        add(tfname);
        
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
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
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
        
        String Courses[] = {"BBA","BSC","MCA","BTECH","MTECH","MBA","PHD","BCOM","BA","BCCA",};
                
        ceducation = new JComboBox(Courses);
        ceducation.setBackground(Color.WHITE);
        ceducation.setBounds(600,300,150,30);
        add(ceducation);
        
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
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempId);
        
        lblempId = new JLabel(""+number);
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);
        
        add = new JButton("Add Details");
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
    public static void main(String[] args) {
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add)
        {   
         String name = tfname.getText();
         String fname = tffname.getText();
         String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
         String salary = tfsalary.getText();
         String address = tfaddress.getText();
         String phone = tfphone.getText();
         String email = tfemail.getText();
         String education = (String) ceducation.getSelectedItem();
         String designation = tfdesignation.getText();
         String aadhar = tfaadhar.getText();
         String empId = lblempId.getText();
         try{
             Connection con = Conn.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE (NAME,FNAME,DOB,SALARY,ADDRESS,PHONE,EMAIL,EDUCATION,DESIGNATION,EMPID,AADHAR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");

             ps.setString(1,name);
ps.setString(2,fname);
ps.setString(3,dob);
ps.setString(4,salary);
ps.setString(5,address);
ps.setString(6,phone);
ps.setString(7,email);
ps.setString(8,education);
ps.setString(9,designation);
ps.setString(10,empId);
ps.setString(11,aadhar);
System.out.println(ps.toString());

             ps.executeUpdate();
             JOptionPane.showMessageDialog(null,"Details added successfully");
             
         }
         
         catch(Exception ee)
         {
             ee.printStackTrace();
         }
        }
        else if (e.getSource() == back) {
        setVisible(false);
        new Home();
        }
    }
    
    
}
