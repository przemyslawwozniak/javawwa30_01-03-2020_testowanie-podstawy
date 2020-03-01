package pl.sda.javawwa30;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
Scenariusze testowe:
+++ 1. Utworzenie zegara o godz 10:30
	Clock c = new Clock(10, 30);
	assertEquals(10, c.getHours());
	assertEquals(30, c.getMinutes());
+++ 2. Utworzenie zegara z polem hours = -1 -> hours == 0
+++ 3. Utworzenie zegara z polem hours = 24 -> hours == 23
+++ 4. 2x analogiczna metoda dla minutes
+++5. Prawidlowo tworzy zegar 'minimalny' (graniczny) - 00:00
+++6. Prawidlowo tworzy zegar 'maksymalny' (graniczny) - 23:59

+++ 7. 10:30.plusMinutes(5) -> 10:35
+++ 8. 10:30.plusMinutes(31) -> 11:01
+++ 9. 10:30.plusMinutes(-31) -> 10:30 (nie mozna dodawac ujemnych minut)
+++ 10. 23:30.plusMinutes(31) -> 00:01

+++ 11. 10:00.plus(10:00) -> 20:00
+++ 12. 10:05.plus(10:25) -> 20:30
+++ 13. 23:00.plus(23:00) -> 22:00
+++14. 00:00.plus(00:00) -> 00:00
+++15. 10:30.plus(null) -> 10:30 (nie zmienia sie godzina)
16. 7:00.plus(5:59) -> 12:59 (a zegar 'dodawany' zostaje 5:59)
 */
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
}
