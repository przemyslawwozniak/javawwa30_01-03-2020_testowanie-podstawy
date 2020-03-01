package pl.sda.javawwa30.exceptions;

public class ScoreBelowRangeException extends Exception {

    public ScoreBelowRangeException(int score) {
        super(String.format("Given score %d is below range", score));
    }

}
