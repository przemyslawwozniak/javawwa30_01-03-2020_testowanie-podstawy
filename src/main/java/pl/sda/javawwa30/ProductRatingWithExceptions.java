package pl.sda.javawwa30;

import pl.sda.javawwa30.exceptions.ScoreAboveRangeException;
import pl.sda.javawwa30.exceptions.ScoreBelowRangeException;

public class ProductRatingWithExceptions {

    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) throws ScoreBelowRangeException, ScoreAboveRangeException{
        if(score >= 1 && score <= 5)
            this.score = score;
        else if(score < 1)
            throw new ScoreBelowRangeException(score);
        else
            throw new ScoreAboveRangeException();
    }
}
