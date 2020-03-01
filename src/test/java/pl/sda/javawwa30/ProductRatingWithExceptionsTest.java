package pl.sda.javawwa30;

import org.junit.Test;
import pl.sda.javawwa30.exceptions.ScoreAboveRangeException;
import pl.sda.javawwa30.exceptions.ScoreBelowRangeException;

import static org.junit.Assert.assertEquals;

public class ProductRatingWithExceptionsTest {

    @Test
    public void create() {
        ProductRatingWithExceptions pr = new ProductRatingWithExceptions();
    }

    @Test(expected = ScoreBelowRangeException.class)
    public void score_below_range() throws ScoreBelowRangeException, ScoreAboveRangeException {
        //given
        ProductRatingWithExceptions pr = new ProductRatingWithExceptions();

        //when
        pr.setScore(0);

        //then
        assertEquals("When score set to 0, score should be 1", 1, pr.getScore());
    }

    @Test(expected = ScoreAboveRangeException.class)
    public void score_above_range() throws ScoreBelowRangeException, ScoreAboveRangeException {
        //given
        ProductRatingWithExceptions pr = new ProductRatingWithExceptions();

        //when
        pr.setScore(6);

        //then
        assertEquals("When score set to 6, score should be 5", 5, pr.getScore());
    }

    @Test
    public void score_in_range() throws ScoreBelowRangeException, ScoreAboveRangeException {
        //given
        ProductRatingWithExceptions pr = new ProductRatingWithExceptions();

        //when
        pr.setScore(3);

        //then
        assertEquals("When score set to 3, score should be 3", 3, pr.getScore());
    }

    @Test(expected = ScoreBelowRangeException.class)
    public void score_way_below_range() throws ScoreBelowRangeException, ScoreAboveRangeException {
        //given
        ProductRatingWithExceptions pr = new ProductRatingWithExceptions();

        //when
        pr.setScore(Integer.MIN_VALUE);

        //then
        assertEquals("When score set to Integer.MIN_VALUE, score should be 1", 1, pr.getScore());
    }

    @Test(expected = ScoreAboveRangeException.class)
    public void score_way_above_range() throws ScoreBelowRangeException, ScoreAboveRangeException {
        //given
        ProductRatingWithExceptions pr = new ProductRatingWithExceptions();

        //when
        pr.setScore(Integer.MAX_VALUE);

        //then
        assertEquals("When score set to Integer.MAX_VALUE, score should be 5", 5, pr.getScore());
    }

    @Test(expected = ScoreBelowRangeException.class)
    public void score_way_above_plus_1_range() throws ScoreBelowRangeException, ScoreAboveRangeException {
        //given
        ProductRatingWithExceptions pr = new ProductRatingWithExceptions();

        //when
        pr.setScore(Integer.MAX_VALUE + 1);

        //then
        assertEquals("When score set to (Integer.MAX_VALUE + 1), score should be 1", 1, pr.getScore());
    }

}
