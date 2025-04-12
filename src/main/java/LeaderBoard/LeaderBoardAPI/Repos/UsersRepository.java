package LeaderBoard.LeaderBoardAPI.Repos;

import org.springframework.data.repository.CrudRepository;

import LeaderBoard.LeaderBoardAPI.Models.User;

public interface UsersRepository extends CrudRepository<User, Integer> {
}