package pl.sda.javawwa30;

public class Clock {

    private int hours, minutes;

    public Clock(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void plusMinutes(int minutes) {
        this.minutes += minutes;
    }

    public void plus(Clock other) {
        this.hours += other.hours;
        this.minutes += other.minutes;
    }
}
