package LeaderBoard.LeaderBoardAPI.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;
    @ManyToOne
    User user;
    Integer score;

    protected Score() {}

    public Score(User user, Integer score){
        this.user = user;
        this.score = score;
    }

    public User getUser(){
        return user;
    }

    public Integer getScore(){
        return score;
    }
}
