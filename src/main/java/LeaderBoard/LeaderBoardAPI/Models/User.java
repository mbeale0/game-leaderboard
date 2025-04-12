package LeaderBoard.LeaderBoardAPI.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;
    String username;

    protected User() {}

    public User(String username){
        this.username = username;
    }

    public Integer getId(){
        return id;
    }

    public String getUserName(){
        return username;
    }
}
