
## Designing a SnackLadder Game
**Problem Statement**
  
Create a snake and ladder application. The application should take as input (from the command line or a file):

1. Number of snakes (s) followed by s lines each containing 2 numbers denoting the head and tail positions of the snake.
2. Number of ladders (l) followed by l lines each containing 2 numbers denoting the start and end positions of the ladder.
3. Number of players (p) followed by p lines each containing a name.

After taking these inputs, you should print all the moves in the form of the current player's name, followed by a random number between 1 and 6 denoting the die roll and the initial and final position based on the move.
Format: <player_name> rolled a <dice_value> and moved from <initial_position> to <final_position>

**Problem Statement**

1. The board will have 100 cells numbered from 1 to 100.
2. The game will have a six sided dice numbered from 1 to 6 and will always give a random number on rolling it.
3. Each player has a piece which is initially kept outside the board (i.e., at position 0).
4. Each player rolls the dice when their turn comes.
5. Based on the dice value, the player moves their piece forward that number of cells. Ex: If the dice value is 5 and the piece is at position 21, the player will put their piece at position 26 now (21+5).
6.  A player wins if it exactly reaches the position 100 and the game ends there.
7. After the dice roll, if a piece is supposed to move outside position 100, it does not move.
8. The board also contains some snakes and ladders.
9. Each snake will have its head at some number and its tail at a smaller number.
10. Whenever a piece ends up at a position with the head of the snake, the piece should go down to the position of the tail of that snake.
11. Each ladder will have its start position at some number and end position at a larger number.
12. Whenever a piece ends up at a position with the start of the ladder, the piece should go up to the position of the end of that ladder.
13. There could be another snake/ladder at the tail of the snake or the end position of the ladder and the piece should go up/down accordingly.
  
