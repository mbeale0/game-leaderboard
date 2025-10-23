package LeaderBoard.LeaderBoardAPI.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AchievmentProgressConsumer {

  @KafkaListener(topics = "achievments")
  public void consume() {
    
  }

}
