package one.support.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Pankaj Nimgade on 17-03-2016.
 */
public class DBConnect {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DBConnect() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test_data","my_root","pass");
            statement = connection.createStatement();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void  getData(){
        try{
            String query = "select * from bird";
            resultSet = statement.executeQuery(query);
            System.out.println("Records from the database");

            while (resultSet.next()){
                String id = resultSet.getString("ID");
                String name = resultSet.getString("Name");
                String place = resultSet.getString("Place");
                String food = resultSet.getString("Food");

                System.out.println("ID: "+id+"\tName: "+name+"\t"+"Place: "+place+"\tFood: "+food);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
