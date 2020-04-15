import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        try{
            connection = helper.getConnection();
            System.out.println("Bağlantı oluştu.");
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }
        finally {
            connection.close();
        }
    }
}
