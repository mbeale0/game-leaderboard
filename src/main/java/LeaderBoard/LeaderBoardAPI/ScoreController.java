package LeaderBoard.LeaderBoardAPI;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LeaderBoard.LeaderBoardAPI.Models.Score;
import LeaderBoard.LeaderBoardAPI.Repos.ScoreRepository;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreRepository scoreRepository;

    @GetMapping("/{id}")
    public ArrayList<Score> GetUserScores(@PathVariable int id) { 
        ArrayList<Score> userScores = (ArrayList) scoreRepository.findAllByUserId(id);     
        return userScores;
    }

}
