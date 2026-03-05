import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTester {

    GradeBook g1;
    GradeBook g2;

    @Before
    public void setUp() throws Exception {
        g1 = new GradeBook(5);
        g1.addScore(50);
        g1.addScore(75);
        g1.addScore(90);

        g2 = new GradeBook(5);
        g2.addScore(40);
        g2.addScore(60);
        g2.addScore(80);
        g2.addScore(100);
    }

    @After
    public void tearDown() throws Exception {
        g1 = null;
        g2 = null;
    }

    @Test
    public void testAddScore() {
        // Test toString matches expected scores
        assertTrue(g1.toString().equals("50.0 75.0 90.0 "));
        assertTrue(g2.toString().equals("40.0 60.0 80.0 100.0 "));

        // Test scoreSize matches number of scores added
        assertEquals(3, g1.getScoreSize());
        assertEquals(4, g2.getScoreSize());
    }

    @Test
    public void testSum() {
        assertEquals(215, g1.sum(), .0001);
        assertEquals(280, g2.sum(), .0001);
    }

    @Test
    public void testMinimum() {
        assertEquals(50, g1.minimum(), .0001);
        assertEquals(40, g2.minimum(), .0001);
    }

    @Test
    public void testFinalScore() {
        // finalScore = sum - minimum
        assertEquals(165, g1.finalScore(), .0001);
        assertEquals(240, g2.finalScore(), .0001);
    }
}
