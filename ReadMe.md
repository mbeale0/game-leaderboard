# LeaderBoard API
This is the backend (and Database) for my full stack Spring Boot / Angular App.

The goal of this project is to develop both the front and back end, refreshing myself on Spring Boot, and as a first dive in Angular.

## What the App Does:
(same on both FE and BE Readmes)
I also enjoy developing video games, and had recently made a small two player competitive one titled "Sandwich King", where players compete to make the most sandwiches. This app takes inspiration from old arcade leaderboards, and displays the top ten scores, which is the most sandwiches made. At the time of writing, these are just manual data.

To add a second layer of complexity, I also wanted to add a simple user stats window. This allowed for some exporation of routes and additional endpoints. This page will show a users number of games played, top score, and top 5 scores overall.

Overall this app is fairly simple, but has allowed me to learn about several new front end concepts, and reinforce my Spring Boot skills, and has given me a much better picture of Full Stack Development

## The Back End
The backend consists of two main controllers. The User controller, and the more fleshed out Score controller.

Several of the endpoints or typical database calls, but for Scores, I got to think through things like pagination, returned limited sets of data such as the top ten score, which was not overly complicated, but allowed for more complicated endpoints than "return this object"