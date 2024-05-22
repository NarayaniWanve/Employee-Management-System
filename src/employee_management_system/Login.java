
package employee_management_system;

import java.sql.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class Login extends JFrame implements ActionListener{
    JTextField tfUsername,tfPass;
    

     Login()  {
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel lblusername = new JLabel("USERNAME");
         lblusername.setBounds(40,20,100,30);
         add(lblusername);
         
          tfUsername = new JTextField();
         tfUsername.setBounds(150,20,150,30);
         add(tfUsername);
         
         JLabel lblpass = new JLabel("PASSWORD");
         lblpass.setBounds(40,70,100,30);
         add(lblpass);
         
         tfPass = new JTextField();
         tfPass.setBounds(150,70,150,30);
         add(tfPass);
         
        JButton login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);

         
         setSize(600,300);
         setLocation(450,200);
         setVisible(true);
         
         
        
    }
     public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String username = tfUsername.getText();
            String Password = tfPass.getText();
            

            Connection con = Conn.getConnection();

            PreparedStatement ps=con.prepareStatement("select * from LOGIN where USERNAME=? and PASSWORD=?");
		    ps.setString(1, username);
		    ps.setString(2, Password);
		    ResultSet rs = ps.executeQuery();
		    if(rs.next())
                    {
                        setVisible(false);
                        new Home();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
       }
        catch(Exception ce)
        {
            ce.printStackTrace();
        }
        
    }
}
