package pl.sda.javawwa30;

public class Clock {

    private int hours, minutes;

    public Clock(int hours, int minutes) {
        setHours(hours);
        setMinutes(minutes);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void plusMinutes(int minutes) {
        addMinutes(this.minutes + minutes);
    }

    //200 = 3h20min
    //200-60=140    +1h
    //140-60=80     +1h
    //80-60=20      +1h
    //set(20)
    private void addMinutes(int minutes) {
        if(minutes >= 0) {
            if (minutes <= 59)
                this.minutes = minutes;
            else {
                addMinutes(minutes - 60);
                plusHours(1);
            }
        }
    }

    private void plusHours(int hours) {
        addHours(this.hours + hours);
    }

    private void addHours(int hours) {
        if(hours >= 0) {
            if(hours <= 23)
                this.hours = hours;
            else {
                addHours(hours - 24);
            }
        }
    }

    public void plus(Clock other) {
        if(other != null) {
            plusHours(other.hours);
            plusMinutes(other.minutes);
        }
    }

    private void setHours(int hours) {
        if(hours >= 0 && hours <= 23)
            this.hours = hours;
        else if(hours < 0)
            this.hours = 0;
        else
            this.hours = 23;
    }

    private void setMinutes(int minutes) {
        if(minutes >= 0 && minutes <= 59)
            this.minutes = minutes;
        else if(minutes < 0)
            this.minutes = 0;
        else
            this.minutes = 59;
    }
}
