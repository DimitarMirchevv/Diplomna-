
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static Connection conn;

    static Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/D:\\Uni\\Втори семестър_2к\\Практикум/newDB",
                    "sa", "1234");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conn;
    }

}

