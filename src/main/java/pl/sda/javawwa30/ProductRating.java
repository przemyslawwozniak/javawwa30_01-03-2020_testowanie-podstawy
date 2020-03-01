package pl.sda.javawwa30;

public class ProductRating {

    int score;

    //odkomentuj zeby test 'create' nie udal sie
    /*ProductRating() {
        score = 1/0;
    }*/

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score >= 1 && score <= 5)
            this.score = score;
        else if(score < 1)
            this.setScore(1);
        else
            this.setScore(5);
    }
}
