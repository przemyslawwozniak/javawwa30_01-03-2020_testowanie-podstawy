package pl.sda.javawwa30;

public class Clock {

    private int hours, minutes, seconds;

    public Clock(int hours, int minutes) {
        seconds = 0;
        setHours(hours);
        setMinutes(minutes);
    }

    public Clock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void plusSeconds(int seconds) {
        addSeconds(this.seconds + seconds);
    }

    private void addSeconds(int seconds) {
        if(seconds >= 0) {
            if (seconds <= 59)
                this.seconds = seconds;
            else {
                addSeconds(seconds - 60);
                plusMinutes(1);
            }
        }
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

    //10:30
    //-00:31
    //30-31=-1
    //10 -> 9
    public void minusMinutes(int minutes) {
        if(minutes >= 0)
            removeMinutes(this.minutes - minutes);
    }

    private void removeMinutes(int minutes) {
        if (minutes >= 0)
            this.minutes = minutes;
        else {
            removeMinutes(60 - Math.abs(minutes));
            minusHours(1);
        }
    }

    public void minusSeconds(int seconds) {
        if(seconds >= 0)
            removeSeconds(this.seconds - seconds);
    }

    private void removeSeconds(int seconds) {
        if (seconds >= 0)
            this.seconds = seconds;
        else {
            removeSeconds(60 - Math.abs(seconds));
            minusMinutes(1);
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

    public void minusHours(int hours) {
        if(hours >= 0)
            removeHours(this.hours - hours);
    }

    private void removeHours(int hours) {
        if (hours >= 0)
            this.hours = hours;
        else {
            removeHours(24 - Math.abs(hours));
        }
    }

    public void plus(Clock other) {
        if(other != null) {
            plusHours(other.hours);
            plusMinutes(other.minutes);
            plusSeconds(other.seconds);
        }
    }

    public void minus(Clock other) {
        if(other != null) {
            minusHours(other.hours);
            minusMinutes(other.minutes);
            minusSeconds(other.seconds);
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
