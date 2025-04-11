package LeaderBoard.LeaderBoardAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaderboardController {

    private Note note;

    @GetMapping("/note")
    public Note GetNote(){
        return note;
    }

    @PostMapping("/note")
    void CreateNote(@RequestBody String newNote) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        note = mapper.readValue(newNote, Note.class);        
    }
}
