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
    public void save_returnsTrueIfDescriptionsAretheSame() {
         myTask = new Task("Mow the lawn");
        myTask.save();
        assertTrue(Task.all().get(0).equals(myTask));
    }
}