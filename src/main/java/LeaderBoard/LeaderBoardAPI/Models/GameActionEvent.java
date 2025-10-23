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

// TODO: how do I keep these in check between the server and the game? (If setting the prop to Action doesnt work)
enum Action {
  WIN,
  DASH,
  THROW_AWAY,
  CHEESE_GRAB,
  MEATLESS,
  PERFECTION // TODO: understand if I should have an event for a perfect round or throw an event when there is a failure. will have to think through architecture of how it is handled in the game vs server
}
