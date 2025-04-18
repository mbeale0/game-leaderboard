package LeaderBoard.LeaderBoardAPI.Models;

public class Games {
    private Integer totalGames;

    public Games(Integer totalGames){
        this.totalGames = totalGames;
    }
    
    public Integer getTotalGames(){
        return totalGames;
    }
    
}
