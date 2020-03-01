package pl.sda.javawwa30;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductRatingTest {

    @Test
    public void create() {
        ProductRating pr = new ProductRating();
    }

    //notacja Python zamiast camel case: tryToSetScoreBelowRangeSetsMinInRange
    @Test
    //public void try_to_set_score_below_range_sets_min_in_range() {
    public void score_below_range() {
        //given
        ProductRating pr = new ProductRating();

        //when
        pr.setScore(0);

        //then
        assertEquals("When score set to 0, score should be 1", 1, pr.getScore());
    }

    @Test
    public void score_above_range() {
        //given
        ProductRating pr = new ProductRating();

        //when
        pr.setScore(6);

        //then
        assertEquals("When score set to 6, score should be 5", 5, pr.getScore());
    }

    @Test
    public void score_in_range() {
        //given
        ProductRating pr = new ProductRating();

        //when
        pr.setScore(3);

        //then
        assertEquals("When score set to 3, score should be 3", 3, pr.getScore());
    }

    @Test
    public void score_way_below_range() {
        //given
        ProductRating pr = new ProductRating();

        //when
        pr.setScore(Integer.MIN_VALUE);

        //then
        assertEquals("When score set to Integer.MIN_VALUE, score should be 1", 1, pr.getScore());
    }

    @Test
    public void score_way_above_range() {
        //given
        ProductRating pr = new ProductRating();

        //when
        pr.setScore(Integer.MAX_VALUE);

        //then
        assertEquals("When score set to Integer.MAX_VALUE, score should be 5", 5, pr.getScore());
    }

    @Test
    public void score_way_above_plus_1_range() {
        //given
        ProductRating pr = new ProductRating();

        //when
        pr.setScore(Integer.MAX_VALUE + 1);

        //then
        assertEquals("When score set to (Integer.MAX_VALUE + 1), score should be 1", 1, pr.getScore());
    }

}
