package LeaderBoard.LeaderBoardAPI.Repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import LeaderBoard.LeaderBoardAPI.Models.Score;

public interface ScoreRepository extends CrudRepository<Score, Integer> {
    ArrayList<Score> findAllByUserId(Integer userId);
}