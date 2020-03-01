package pl.sda.javawwa30;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ClockTest {

    @Test
    public void create_valid_clock() {
        //when
        Clock c = new Clock(10, 30);

        //then
        assertEquals(10, c.getHours());
        assertEquals(30, c.getMinutes());
    }

    @Test
    public void create_clock_with_hours_below_boundary() {
        //when:
        Clock c = new Clock(-1, 10);

        //then:
        assertEquals(0, c.getHours());
        assertEquals(10, c.getMinutes());
    }

    @Test
    public void create_clock_with_hours_above_boundary() {
        //when:
        Clock c = new Clock(24, 10);

        //then:
        assertEquals(23, c.getHours());
        assertEquals(10, c.getMinutes());
    }

    @Test
    public void create_clock_with_minutes_below_boundary() {
        //when:
        Clock c = new Clock(1, -1);

        //then:
        assertEquals(1, c.getHours());
        assertEquals(0, c.getMinutes());
    }

    @Test
    public void create_clock_with_minutes_above_boundary() {
        //when:
        Clock c = new Clock(23, 60);

        //then:
        assertEquals(23, c.getHours());
        assertEquals(59, c.getMinutes());
    }

    @Test
    public void create_valid_min_clock() {
        //when
        Clock c = new Clock(0, 0);

        //then
        assertEquals(0, c.getHours());
        assertEquals(0, c.getMinutes());
    }

    @Test
    public void create_valid_max_clock() {
        //when
        Clock c = new Clock(23, 59);

        //then
        assertEquals(23, c.getHours());
        assertEquals(59, c.getMinutes());
    }

    @Test
    public void add_valid_minutes() {
        //given:
        Clock c = new Clock(10, 30);

        //when:
        c.plusMinutes(5);

        //then:
        assertEquals(35, c.getMinutes());
        assertEquals(10, c.getHours());
    }

    @Test
    public void add_valid_minutes_and_progress_hour() {
        //given:
        Clock c = new Clock(10, 30);

        //when:
        c.plusMinutes(31);

        //then:
        assertEquals(11, c.getHours());
        assertEquals(1, c.getMinutes());
    }

    @Test
    public void add_negative_minutes_no_change() {
        //given:
        Clock c = new Clock(10, 30);

        //when:
        c.plusMinutes(-31);

        //then:
        assertEquals(10, c.getHours());
        assertEquals(30, c.getMinutes());
    }

    @Test
    public void add_valid_minutes_and_progress_next_day() {
        //given:
        Clock c = new Clock(23, 30);

        //when:
        c.plusMinutes(31);

        //then:
        assertEquals(0, c.getHours());
        assertEquals(1, c.getMinutes());
    }

    @Test
    public void add_valid_clock() {
        //given:
        Clock c = new Clock(10, 0);
        Clock c2 = new Clock(10, 0);

        //when:
        c.plus(c2);

        //then:
        assertEquals(20, c.getHours());
        assertEquals(0, c.getMinutes());
        assertEquals(10, c2.getHours());
        assertEquals(0, c2.getMinutes());
    }

    @Test
    public void add_valid_clock_2nd_ex() {
        //given:
        Clock c = new Clock(10, 5);
        Clock c2 = new Clock(10, 25);

        //when:
        c.plus(c2);

        //then:
        assertEquals(20, c.getHours());
        assertEquals(30, c.getMinutes());
        assertEquals(10, c2.getHours());
        assertEquals(25, c2.getMinutes());
    }

    @Test
    public void add_valid_clock_progress_next_day() {
        //given:
        Clock c = new Clock(23, 0);
        Clock c2 = new Clock(23, 0);

        //when:
        c.plus(c2);

        //then:
        assertEquals(22, c.getHours());
        assertEquals(0, c.getMinutes());
        assertEquals(23, c2.getHours());
        assertEquals(0, c2.getMinutes());
    }

    @Test
    public void add_valid_clocks_00_00() {
        //given:
        Clock c = new Clock(0, 0);
        Clock c2 = new Clock(0, 0);

        //when:
        c.plus(c2);

        //then:
        assertEquals(0, c.getHours());
        assertEquals(0, c.getMinutes());
        assertEquals(0, c2.getHours());
        assertEquals(0, c2.getMinutes());
    }

    //10:30.plus(null) -> 10:30 (nie zmienia sie godzina)
    @Test
    public void add_null_clock_no_change() {
        //given:
        Clock c = new Clock(10, 20);

        //when:
        c.plus(null);

        //then:
        assertEquals(10, c.getHours());
        assertEquals(20, c.getMinutes());
    }

    @Test
    public void add_valid_clock_no_change_to_added_clock() {
        //given:
        Clock c = new Clock(7, 0);
        Clock c2 = new Clock(5, 59);

        //when:
        c.plus(c2);

        //then:
        assertEquals(12, c.getHours());
        assertEquals(59, c.getMinutes());
        assertEquals(5, c2.getHours());
        assertEquals(59, c2.getMinutes());
    }

    //Ex 4
    @Test
    public void remove_minutes() {
        //given:
        Clock c = new Clock(10, 30);

        //when:
        c.minusMinutes(31);

        //then:
        assertEquals(9, c.getHours());
        assertEquals(59, c.getMinutes());
    }

    @Test
    public void remove_hours() {
        //given:
        Clock c = new Clock(10, 30);

        //when:
        c.minusHours(9);

        //then:
        assertEquals(1, c.getHours());
        assertEquals(30, c.getMinutes());
    }

    @Test
    public void remove_minutes_previous_day() {
        //given:
        Clock c = new Clock(0, 30);

        //when:
        c.minusMinutes(31);

        //then:
        assertEquals(23, c.getHours());
        assertEquals(59, c.getMinutes());
    }

    @Test
    public void remove_hours_previous_day() {
        //given:
        Clock c = new Clock(5, 30);

        //when:
        c.minusHours(15);

        //then:
        assertEquals(14, c.getHours());
        assertEquals(30, c.getMinutes());
    }

    //seconds
    /*
    1. 10:30:11 + 01:22:09 -> 11:52:20
    2. 10:20:15 + 10:20:50 -> 20:41:05
    3. 10:30:15 + 10:30:46 -> 21:01:01

    4. 10:30:29 - 00:00:24 -> 10:30:05
    5. 10:30:29 - 00:00:31 -> 10:29:58
    6. 10:30:30 - 00:00:30 -> 10:30:00
     */

    @Test
    public void s1() {
        //given:
        Clock c = new Clock(10, 30, 11);
        Clock c2 = new Clock(1, 22, 9);

        //when:
        c.plus(c2);

        //then:
        assertEquals(11, c.getHours());
        assertEquals(52, c.getMinutes());
        assertEquals(20, c.getSeconds());
    }

    //10:20:15 + 10:20:50 -> 20:41:05
    @Test
    public void s2() {
        //given:
        Clock c = new Clock(10, 20, 15);
        Clock c2 = new Clock(10, 20, 50);

        //when:
        c.plus(c2);

        //then:
        assertEquals(20, c.getHours());
        assertEquals(41, c.getMinutes());
        assertEquals(5, c.getSeconds());
    }

    //10:30:15 + 10:30:46 -> 21:01:01
    @Test
    public void s3() {
        //given:
        Clock c = new Clock(10, 30, 15);
        Clock c2 = new Clock(10, 30, 46);

        //when:
        c.plus(c2);

        //then:
        assertEquals(21, c.getHours());
        assertEquals(1, c.getMinutes());
        assertEquals(1, c.getSeconds());
    }

    //10:30:29 - 00:00:24 -> 10:30:05
    @Test
    public void s4() {
        //given:
        Clock c = new Clock(10, 30, 29);
        Clock c2 = new Clock(0, 0, 24);

        //when:
        c.minus(c2);

        //then:
        assertEquals(10, c.getHours());
        assertEquals(30, c.getMinutes());
        assertEquals(5, c.getSeconds());
    }

    //10:30:29 - 00:00:31 -> 10:29:58
    @Test
    public void s5() {
        //given:
        Clock c = new Clock(10, 30, 29);
        Clock c2 = new Clock(0, 0, 31);

        //when:
        c.minus(c2);

        //then:
        assertEquals(10, c.getHours());
        assertEquals(29, c.getMinutes());
        assertEquals(58, c.getSeconds());
    }

    //10:30:30 - 00:00:30 -> 10:30:00
    @Test
    public void s6() {
        //given:
        Clock c = new Clock(10, 30, 30);
        Clock c2 = new Clock(0, 0, 30);

        //when:
        c.minus(c2);

        //then:
        assertEquals(10, c.getHours());
        assertEquals(30, c.getMinutes());
        assertEquals(0, c.getSeconds());
    }

}
