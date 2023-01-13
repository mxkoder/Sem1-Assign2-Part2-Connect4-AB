# Connect4 Console Game 

## About
This is a two player Connect 4 console game made with Java. The project was made for an assignment as part of the MSc Software Engineering at the School of Computing, UWTSD. 
Module: ACCA7000 - Programming and Software Testing                 

## Dependencies
Junit is used to implement unit tests. 

## Running the project
The project runs from Main.java, which will initiate a game of Connect4 with the option to replay when the game is complete. 

## Game Play

When the program is first run, players are prompted to choose who will start. Players will then take turns making moves until the game is complete. 
The game ends when the winning player gets four of their counters in a vertical, horizontal, or diagonal row, or is a draw if the game grid is filled without a matching four in a row of counters. 

### Normal game turn
In a normal turn, a message prompts a player to select a column to drop their counter (O or X) into. The player's counter is then placed in the top available space in the column if the column is not full. 

![normal game play](/readme-images/normal-game-play.png)

### Special Moves
Players have one Blitz and Time Bomb optional special move available per game of Connect 4. These special moves are accessed by typing a letter command into the turn prompt:
'T' - Time Bomb
'B' - Blitz

#### Blitz
The Blitz special move clears an entire vertical column on the game grid, leaving an empty column.
After entering the 'B' command, the player will be prompted to select a column to clear. 

#### Time Bomb
The time bomb special move lets a player drop a '*' counter into a column, which will 'explode'. When the time bomb goes off it clears all counters directly surrounding it by one space vertically, horizontally and diagonally. 

Order of play for a time bomb special move:
1. Player A enters the 'T' command for their turn. They will then be prompted to choose a column for the time bomb.
2. Player B takes a turn
3. Player A takes a turn
4. Player B takes a turn
5. The time bomb goes of, clearing counters around it. 
6. Normal game play resumes.  

Setting a time bomb:
![setting a time bomb](/readme-images/time-bomb-set.png)

Time bomb clearing counters:
![time bomb exploding](/readme-images/time-bomb-exp.png)

### Validation and prompts
There are several criteria validation and prompts to re-enter values within the project. If a user enters an invalid value, they will be prompted to select again with a message highlighting the error. 

Examples of validation and error prompts:
* Selecting a column
    * Column number entered needs to be within range of columns in the game grid
    * Column needs to have space for a counter
* Special move:
    * command needs to be one of the valid commands 'T' or 'B'
    * If the player has used up their special move, they will not be allowed to retake it. 
* When choosing a player to start the game, the value entered needs to be '1' or'2'

### Game end and replay option
When the win or draw conditions have been met, and end game message is printed to the console with an option to replay the game. 
![game end with replay option](/readme-images/game-win-replay.png)

## Learning and research for project

This project has been completed alongside an essay on the software engineering design principles of high cohesion, low coupling, information hiding, and data hiding. An attempt has been made to apply these principles in the Connect 4 console game, with aspects of OOP applied. 

Learning and links used to learn new concepts:
* [Classes and contructors in Java] (https://www.javatpoint.com/java-constructor) [1]
* [Using 'this' keyword in Java] (https://www.w3schools.com/java/ref_keyword_this.asp) [2]
* [Learning how to use regular expressions and syntax] (https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Regular_Expressions/Cheatsheet) [3]
* [Public vs Private access modifiers in Java] (https://www.geeksforgeeks.org/public-vs-private-access-modifiers-in-java/) [4]
* [Creating objects in Java] (https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html) [5]


## Further work
To improve this project with more time, I would:
* Add a game play option to choose a custom grid size and custom number for the length of row to win a game. 
* Work on the test and replace method calls with stubs or mocks. Currently, there are some interdependencies.
* Refactor some longer methods, and improve the logic in particular in the timeBombExplosion method. 
* add an AI opponent. 


## Author

Agnes Beviz


## References

[1] JavaTpoint. (2021). Constructors in Java. Available:  https://www.javatpoint.com/java-constructor

[2] W3Schools. (2023). Java this Keyword. Available: https://www.w3schools.com/java/ref_keyword_this.asp

[3] MDN Web Docs. (2023). Regular expression syntax cheat sheet. Available: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Regular_Expressions/Cheatsheet

[4] GeeksForGeeks. (2021). Available: https://www.geeksforgeeks.org/public-vs-private-access-modifiers-in-java/

[5] Oracle Java Documentation. (2022). Available: https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html