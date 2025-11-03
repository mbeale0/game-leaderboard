package LeaderBoard.LeaderBoardAPI.consumers;

import LeaderBoard.LeaderBoardAPI.Models.Action;
import LeaderBoard.LeaderBoardAPI.Models.GameActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service // Allows Spring To Autowire the class into our RESTController
public class TestProducer {
  @Autowired
  private KafkaTemplate<String, GameActionEvent> kafkaTemplate;

  // TODO: Adding for easy testing. This will be in unity
  public void sendMessage(String message) {
    GameActionEvent newEvent = new GameActionEvent(1, Action.WIN);
    this.kafkaTemplate.send("achievments", message, newEvent);
  }

}
