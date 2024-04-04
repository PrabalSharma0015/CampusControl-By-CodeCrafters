package University.UniversityManagementSystem;
import java.sql.*;

public class Conn {

    Connection c;
    public Statement s;

    public Conn(){
        // Registration for jdbc
        try {Class.forName("com.mysql.cj.jdbc.Driver");

        // creating connection string
        c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem","root","Pksharma@1509");
        // creating ststements
        s = c.createStatement();
        

            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        
    }
}
