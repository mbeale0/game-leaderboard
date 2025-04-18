package LeaderBoard.LeaderBoardAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LeaderBoard.LeaderBoardAPI.Models.Games;
import LeaderBoard.LeaderBoardAPI.Models.Score;
import LeaderBoard.LeaderBoardAPI.Models.User;
import LeaderBoard.LeaderBoardAPI.Repos.ScoreRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreRepository scoreRepository;

    final Score notFoundScore = new Score(new User("NOT FOUND"), -1);

    @GetMapping("/{id}")
    public ArrayList<Score> GetUserScores(@PathVariable int id) { 
        ArrayList<Score> userScores = (ArrayList) scoreRepository.findAllByUserId(id);     
        return userScores;
    }

    @GetMapping("/topten")
    public ArrayList<Score> GetTopTenUserScores() {
        ArrayList<Score> userScores = (ArrayList) scoreRepository.findAll();
        
        Collections.sort(userScores, new Comparator<Score>() {
            public int compare(Score scoreOne, Score scoreTwo) {
                return scoreTwo.getScore() - scoreOne.getScore();
            }
        });        

        ArrayList<Score> topTenScores = new ArrayList<>();
        for (int index = 0; index < 10; index++){
            try {
                topTenScores.add(userScores.get(index));                
            } 
            catch (Exception e) {
                topTenScores.add(notFoundScore);
            }
        }

        return topTenScores;
    }

    @GetMapping("/{id}/games")
    public Games GetTotalGames(@PathVariable int id) {
        ArrayList<Score> userScores = (ArrayList) scoreRepository.findAllByUserId(id);
        Games totalGames = new Games(userScores.size());

        System.out.println(totalGames);
        return totalGames;
    }

    @GetMapping("/{id}/topfive")
    public ArrayList<Score> GetTopFiveUserScores(@PathVariable int id) {
        ArrayList<Score> userScores = (ArrayList) scoreRepository.findAllByUserId(id);


        Collections.sort(userScores, new Comparator<Score>() {
            public int compare(Score scoreOne, Score scoreTwo) {
                return scoreTwo.getScore() - scoreOne.getScore();
            }
        });

        ArrayList<Score> topFiveScores = new ArrayList<>();
        for (int index = 0; index < 5; index++) {
            try {                
                topFiveScores.add(userScores.get(index));
            } catch (Exception e) {
                topFiveScores.add(notFoundScore);
            }
        }

        return topFiveScores;
    }

    @GetMapping("/{id}/top")
    public Score GetTopUserScore(@PathVariable int id) {
        ArrayList<Score> userScores = (ArrayList) scoreRepository.findAllByUserId(id);

        Collections.sort(userScores, new Comparator<Score>() {
            public int compare(Score scoreOne, Score scoreTwo) {
                return scoreTwo.getScore() - scoreOne.getScore();
            }
        });

        return userScores.get(0);
    }

    @GetMapping()
    public ArrayList<Score> GetAllUserScores() {
        ArrayList<Score> userScores = (ArrayList) scoreRepository.findAll();

        return userScores;
    }
}