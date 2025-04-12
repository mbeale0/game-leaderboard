package LeaderBoard.LeaderBoardAPI;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class LeaderboardController {
    @Autowired
    private UsersRepository userRepository;
    private Note note;

    @GetMapping("/notes")
    public Note GetNote(){
        return note;
    }

    @GetMapping("/users")
    public User GetUser() { // @PathVariable int id
        Integer id = 1;
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return new User("NotFound");
        
    }
    @PostMapping("/note")
    void CreateNote(@RequestBody String newNote) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        note = mapper.readValue(newNote, Note.class);        
    }
}
