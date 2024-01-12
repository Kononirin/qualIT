package smoke.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDB{

    protected Connection connection;
    protected Statement statement;

    @BeforeEach
    public void beforeAllDBTests() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost:9092/mem:testdb", "user", "pass");

        statement = connection.createStatement();
    }

    @AfterEach
    public void afterAllDBTests() throws SQLException {
        String deleteQuery = "DELETE FROM food WHERE food_id > 4";

        Statement statement = connection.createStatement();

        statement.executeUpdate(deleteQuery);

        connection.close();
    }

}
