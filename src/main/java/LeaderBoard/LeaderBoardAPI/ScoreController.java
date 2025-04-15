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

import LeaderBoard.LeaderBoardAPI.Models.Score;
import LeaderBoard.LeaderBoardAPI.Repos.ScoreRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreRepository scoreRepository;

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
            topTenScores.add(userScores.get(index));
        }

        return topTenScores;
    }

    @GetMapping()
    public ArrayList<Score> GetAllUserScores() {
        ArrayList<Score> userScores = (ArrayList) scoreRepository.findAll();

        return userScores;
    }
}