package LeaderBoard.LeaderBoardAPI;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LeaderBoard.LeaderBoardAPI.Models.User;
import LeaderBoard.LeaderBoardAPI.Repos.UsersRepository;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersRepository userRepository;

    @GetMapping
    public ArrayList<User> GetUsers() { 
        ArrayList<User> users = (ArrayList) userRepository.findAll();     
        return users;
    }

    @GetMapping("/{id}")
    public User GetUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        System.out.println(id);
        if(user.isPresent()){
            return user.get();
        }
        return new User("NotFound");
        
    }
}
