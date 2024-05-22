package employee_management_system;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:ORCL", "system", "123");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
    
    
