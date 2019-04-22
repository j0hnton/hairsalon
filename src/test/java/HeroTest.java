import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void Hero_instantiatesCorrectly_true() {
        Hero myHero = new Hero("Superman");
        assertEquals(true, myHero instanceof Hero);
    }

    @Test
    public void Hero_instantiatesCorrectly2_true() {
        Hero myHero = new Hero("Thor");
        assertEquals(true, myHero instanceof Hero);
    }

    @Test
    public void Hero_instantiatesCorrectly3_true() {
        Hero myHero = new Hero("Hulk");
        assertEquals(true, myHero instanceof Hero);
    }

    @Test
    public void Hero_instantiatesCorrectly4_true() {
        Hero myHero = new Hero("Supergirl");
        assertEquals(true, myHero instanceof Hero);
    }

    @Test
    public void Hero_instantiatesCorrectly5_true() {
        Hero myHero = new Hero("Wonderwoman");
        assertEquals(true, myHero instanceof Hero);

    }

    @Test
    public void Hero_instantiatesCorrectly6_true() {
        Hero myHero = new Hero("Iron man");
        assertEquals(true, myHero instanceof Hero);

    }

    @Test
    public void HeroSkill_instantiatesCorrectly_true() {
        Hero myHero = new Hero("Flying");
        assertEquals(true, myHero instanceof Hero);

    }

    @Test
    public void HeroSkill_instantiatesCorrectly2_true() {
        Hero myHero = new Hero("lightning");
        assertEquals(true, myHero instanceof Hero);

    }

    @Test
    public void HeroSkill_instantiatesCorrectly3_true() {
        Hero myHero = new Hero("Smashing");
        assertEquals(true, myHero instanceof Hero);

    }
    @Test
    public void HeroSkill_instantiatesCorrectly4_true() {
        Hero myHero = new Hero("Running");
        assertEquals(true, myHero instanceof Hero);

    }
}
