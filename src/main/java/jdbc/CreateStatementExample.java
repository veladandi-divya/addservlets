package jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Create Statement JDBC Example
 * @author Ramesh Fadatare
 *
 */
public class CreateStatementExample {

    private static final String createTableSQL = "create table Users1(\r\n" + "  id  int(3) primary key,\r\n" +
        "  name varchar(20),\r\n" + "  email varchar(20),\r\n" + "  country varchar(20),\r\n" +
        "  password varchar(20)\r\n" + "  );";
    public static void main(String[] argv) throws SQLException {
        CreateStatementExample createTableExample = new CreateStatementExample();
        createTableExample.createTable();
    }

    public void createTable() throws SQLException {

        System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/divya?useSSL=false", "root", "password");

            // Step 2:Create a statement using connection object
            Statement statement = connection.createStatement();) {
        	 statement.execute(createTableSQL);
        } catch (Exception e) {

            // print SQL exception information
            ;
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }

   }
