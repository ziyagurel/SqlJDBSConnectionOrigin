import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Select {
    private static Connection connection = null;
    private static DbHelper helper = new DbHelper();
    private static ResultSet result; //
    private static ArrayList<Country> countriesList;
    public static void SelectQuery() throws SQLException {
        Statement statement; // Select için cümcelecik.
        try{
            connection = helper.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery("Select Code, Name, Continent, Region from country");
            countriesList = new ArrayList<Country>();
            while(result.next()){
                countriesList.add(new Country(
                        result.getString("Code"),
                        result.getString("Name"),
                        result.getString("Continent"),
                        result.getString("Region"))

                );
                System.out.println(result.getString("Name"));
            }
            System.out.println("Dünyamızda toplam " + countriesList.size() + " tane ülke vardır.");
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }
        finally {
            connection.close();
        }
    }
}
