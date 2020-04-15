import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    public static String username = "root";
    public static String password = "123456";
    public static String dbURL = "jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbURL,username,password);
    }
    public void showErrorMessage(SQLException e){
        System.out.println("Error Code: " + e.getErrorCode());
        System.out.println("Error: " + e.getMessage());
    }
}
