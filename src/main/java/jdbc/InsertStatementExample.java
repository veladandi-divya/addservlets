package jdbc;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Insert Statement JDBC Example
 * @author Ramesh Fadatare
 *
 */
public class InsertStatementExample {
    private static final String INSERT_MULTIPLE_USERS_SQL = "INSERT INTO Users1 " +
    		"VALUES (3, 'venu', 'pramod@gmail.com', 'India', '123')," +
             "(5, 'Tom', 'top@gmail.com', 'India', '123');";

        public static void main(String[] argv) throws SQLException {
            InsertStatementExample createTableExample = new InsertStatementExample();
            createTableExample.insertRecord();
        }

        public void insertRecord() throws SQLException {
            // Step 1: Establishing a Connection
            try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/divya?useSSL=false", "root", "password");
            		 // Step 2:Create a statement using connection object
                    Statement statement = connection.createStatement();) {

                    // Step 3: Execute the query or update query
                    int result = statement.executeUpdate(INSERT_MULTIPLE_USERS_SQL);
                    System.out.println("No. of records affected : " + result);
                } catch (Exception e) {

                    // print SQL exception information
                   
                }
        }

        
    }