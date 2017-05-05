import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BowlingGameTest {

    @Test
    public void test_normal_round() throws Exception {
        String bowlingCode = "12|23|34|45|54|43|32|21|11|11||";           //52
        assertEquals(new BowlingGame().getBowlingScore(bowlingCode), 52);
    }

    @Test
    public void test_all_miss() throws Exception {
        String bowlingCode = "--|--|--|--|--|--|--|--|--|--||";           //0
        assertEquals(new BowlingGame().getBowlingScore(bowlingCode), 0);
    }

    @Test
    public void test_extra_round() throws Exception {
        String bowlingCode = "12|23|34|45|54|43|32|21|11|1/||5";           //65
        assertEquals(new BowlingGame().getBowlingScore(bowlingCode), 65);
    }

    @Test
    public void test_all_strike() throws Exception {
        String bowlingCode = "X|X|X|X|X|X|X|X|X|X||XX";           //300
        assertEquals(new BowlingGame().getBowlingScore(bowlingCode), 300);
    }

    @Test
    public void test_second_spare() throws Exception {
        String bowlingCode = "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5";  //150
        assertEquals(new BowlingGame().getBowlingScore(bowlingCode), 150);
    }

    @Test
    public void test_second_miss() throws Exception {
        String bowlingCode = "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||";   //90
        assertEquals(new BowlingGame().getBowlingScore(bowlingCode), 90);

    }

    @Test
    public void test_other_situation() throws Exception {
        String bowlingCode = "X|7/|9-|X|-8|8/|-6|X|X|X||81";      //167
        assertEquals(new BowlingGame().getBowlingScore(bowlingCode), 167);

    }
}

