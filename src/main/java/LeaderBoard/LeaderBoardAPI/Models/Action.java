package LeaderBoard.LeaderBoardAPI.Models;

// TODO: how do I keep these in check between the server and the game? (If setting the prop to Action doesnt work)
public enum Action {
  WIN,
  DASH,
  THROW_AWAY,
  CHEESE_GRAB,
  MEATLESS,
  PERFECTION // TODO: understand if I should have an event for a perfect round or throw an event when there is a failure. will have to think through architecture of how it is handled in the game vs server
}
