import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Insert {
    private static Connection connection = null;
    private static DbHelper helper = new DbHelper();
    private static ResultSet result; //
    private static ArrayList<Country> countriesList;

    public static void insertQuery() throws SQLException {
        PreparedStatement statement = null; // İnsert Cümleciği...
        String sql = "insert into city (Name, CountryCode, District, Population) values (?,?,?,?)";
        try{
            connection = helper.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1,"Samsun 2");
            statement.setString(2,"TUR");
            statement.setString(3,"SAMSUN2");
            statement.setInt(4,1200000);
            int result = statement.executeUpdate();
            System.out.println(result + " - Kayit Eklendi...");
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }
        finally {
            statement.close();
            connection.close();
        }
    }

}
