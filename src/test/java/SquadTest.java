import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

    @Test
    public void SquadAims_instantiatesCorrectly_true() {
        Hero myHero = new Hero("Fight sexism");
        assertEquals(true, myHero instanceof Hero);
    }
    @Test
    public void SquadName_instantiatesCorrectly_true() {
        Hero myHero = new Hero("Drugs");
        assertEquals(true, myHero instanceof Hero);
    }
    @Test
    public void SquadHero_instantiatesCorrectly_true() {
        Hero myHero = new Hero("Superman");
        assertEquals(true, myHero instanceof Hero);
    }
    @Test
    public void SquadMax_instantiatesCorrectly_true() {
        Hero myHero = new Hero("2");
        assertEquals(true, myHero instanceof Hero);
    }
    @Test
    public void SquadHero2_instantiatesCorrectly_true() {
        Hero myHero = new Hero("Ironman");
        assertEquals(true, myHero instanceof Hero);
    }

}
