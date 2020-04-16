import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Update {

    private static Connection connection = null;
    private static DbHelper helper = new DbHelper();
    private static ResultSet result; //
    private static ArrayList<Country> countriesList;

    public static void updateQuery() throws SQLException {
        PreparedStatement statement = null; // İnsert Cümleciği...
        String sql = "update city set population = 1100000 where id = ?";
        statement.setInt(1,4088);
        try{
            connection = helper.getConnection();
            statement = connection.prepareStatement(sql);
            int result = statement.executeUpdate();
            System.out.println(result + " - Kayit Güncellendi...");
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }
        finally {
            statement.close();
            connection.close();
        }
    }
}
