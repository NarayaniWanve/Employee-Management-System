
package employee_management_system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener {
    JTable table;
    Choice cemployeeId;
    JButton search, print, update, back;
    Connection conn;

    ViewEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel serachlbl = new JLabel("Search by Employee id");
        serachlbl.setBounds(20, 20, 150, 20);
        add(serachlbl);

        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);

        table = new JTable();

        try {
            Conn c = new Conn();
            conn = c.getConnection();

            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from EMPLOYEE");

            while (rs.next()) {
                cemployeeId.add(rs.getString("EMPID"));
            }
        } catch (Exception ae) {
            ae.printStackTrace();
        }

        table = new JTable();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception Fe) {
            Fe.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            try {
                PreparedStatement ps = conn.prepareStatement("select * from EMPLOYEE where EMPID = ?");

                ps.setString(1, cemployeeId.getSelectedItem());
                ResultSet rs = ps.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ne) {
                ne.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception pe) {
                pe.printStackTrace();
            }
        } else if (e.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());

        } else {
            setVisible(false);
        }
    }
}
