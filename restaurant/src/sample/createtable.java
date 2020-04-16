package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class createtable {


        /**
         * Create a new table in the test database
         *
         */
        public static void createNewTable() {
            // SQLite connection string
            String url = "jdbc:sqlite:SQLite.db";

            // SQL statement for creating a new table
            String sql = "CREATE TABLE IF NOT EXISTS foods (\n"
                    + "	foodname varchar(20) PRIMARY KEY,\n"
                    + "	price double NOT NULL);";

            try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {
                // create a new table
                stmt.execute(sql);
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            createNewTable();
        }

    }

