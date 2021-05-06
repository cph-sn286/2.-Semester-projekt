package business.persistence;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class OrderMapperTest {

    private final static String DATABASE = "fogdb";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "fog";
    private final static String PASSWORD = "fog";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static OrderMapper orderMapper;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            orderMapper = new OrderMapper(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    public void setUp() {

        // reset test database
        try ( Statement stmt = database.connect().createStatement() ) {
            stmt.execute("drop table if exists orders" );
            stmt.execute("create table " + TESTDATABASE + ".orders LIKE " + DATABASE + ".orders;" );
            stmt.execute(
                    "insert into orders values " +
                            "(1,1,1,420,'2021-04-29 10:20:00',1), " +
                            "(2,2,2,570,'2021-04-29 10:20:00',2), " +
                            "(3,3,3,1050,'2021-04-29 10:20:00',1)");
        } catch (SQLException ex) {
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull(database);
    }

    @Test
    public void testInsertOrder() throws UserException {
        Order original = new Order(4,4,5,12750,"2021-04-29 10:20:00",3);
        orderMapper.insertOrder( original );
        Order retrived = orderMapper.getOrderByUserId(4);
        assertEquals( original.getOrder_id(), retrived.getOrder_id()  );
    }



}
