import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class HeroSalonTest {

    @Before
    public void setUp() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/herosalon_test", null, null);
    }

    @After
    public void tearDown() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM Stylists *;";
            con.createQuery(sql).executeUpdate();
        }
    }

    @Test
    public void Client_instantiatesCorrectly_true() {
        Client myClient = new Client("name", "gender", "cname");
        assertEquals(true, myClient instanceof Client);
    }
    @Test
    public void Stylist_instantiatesCorrectly_true() {
        Stylist myStylist = new Stylist("name","gender");
        assertEquals(true, myStylist instanceof Stylist);
    }
    @Test
    public void App_instantiatesCorrectly_true() {
        App myApp = new App();
        assertEquals(true, myApp instanceof App);
    }

}
