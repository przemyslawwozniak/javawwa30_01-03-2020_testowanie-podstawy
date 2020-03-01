package pl.sda.javawwa30;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
Scenariusze testowe:
+++ 1. Utworzenie zegara o godz 10:30
	Clock c = new Clock(10, 30);
	assertEquals(10, c.getHours());
	assertEquals(30, c.getMinutes());
2. Utworzenie zegara z polem hours = -1 -> hours == 0
3. Utworzenie zegara z polem hours = 24 -> hours == 23
4. 2x analogiczna metoda dla minutes
5. 00:00
6. 23:59

+++ 7. 10:30.plusMinutes(5) -> 10:35
8. 10:30.plusMinutes(31) -> 11:01
9. 10:30.plusMinutes(-31) -> 10:30 (nie mozna dodawac ujemnych minut)
10. 23:30.plusMinutes(31) -> 00:01

+++ 11. 10:00.plus(10:00) -> 20:00
12. 10:05.plus(10:25) -> 20:30
13. 23:00.plus(23:00) -> 22:00
14. 00:00.plus(00:00) -> 00:00
15. 10:30.plus(null) -> 10:30 (nie zmienia sie godzina)
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

}
