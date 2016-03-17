package one.support.connection;


import java.sql.*;

/**
 * Created by Pankaj Nimgade on 16-03-2016.
 */
public class TestDriveOne {

    private static Connection connect = null;
    private static Statement statement;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/my_test_data";


    public static void main(String[] args) {
       DBConnect dbConnect = new DBConnect();
        dbConnect.getData();
    }

    private static void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("ID");
            String website = resultSet.getString("Name");
            String summery = resultSet.getString("Place");
            String comment = resultSet.getString("Food");
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("Summery: " + summery);
            System.out.println("Comment: " + comment);
        }
    }

}
