package LeaderBoard.LeaderBoardAPI.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "playerNumber",
  "action"
})
public class GameActionEvent {

  @JsonProperty("playerNumber")
  private int playerNumber;

  @JsonProperty("action")
  private Action action;

  public GameActionEvent() {
  }

  public GameActionEvent(int playerNumber, Action action) {
    this.playerNumber = playerNumber;
    this.action = action;
  }

  @JsonProperty("playerNumber")
  public int getPlayerNumber() {
    return playerNumber;
  }

  @JsonProperty("action")
  public Action getAction() {
    return action;
  }
}

