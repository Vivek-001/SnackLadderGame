package Game;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players;
    Player winner = null;

    public Game() {
        initialize();
    }

    public void initialize() {
        board = new Board(10, 5, 7);
        players = new LinkedList<>();
        dice = new Dice(1);
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("id1", 0);
        Player player2 = new Player("id2", 0);
        players.add(player1);
        players.add(player2);
    }

    public void start() {
        while (winner == null) {
            Player player = players.removeFirst();
           players.add(player);
            System.out.println(" player's Id : " + player.id + " current Position " + player.currentPos);
            int diceCount = dice.rollDice();

            player.currentPos = player.currentPos + diceCount;
            player.currentPos = nextLadderSnack(player.currentPos);
            System.out.println(" player's Id : " + player.id + " current Position " + player.currentPos);
            if (player.currentPos > board.cells.length * board.cells.length - 1) {
                winner = player;
                System.out.println("winner :- PLayer's Id: " + winner.id);
            }
        }
    }

    private int nextLadderSnack(int currentPos) {
        if(currentPos > board.cells.length * board.cells.length - 1) {
            return currentPos;
        }
        int rowPos = currentPos / board.cells.length;
        int colPos = currentPos % board.cells.length;
        if (board.cells[rowPos][colPos].jump == null) {
            return currentPos;
        } else {
            if (board.cells[rowPos][colPos].jump.start > board.cells[rowPos][colPos].jump.end)  // snack found
            {
                System.out.println(" Snack jump found");
                return board.cells[rowPos][colPos].jump.end;
            } else {    /// ladder found
                System.out.println("ladder jump found");
                return board.cells[rowPos][colPos].jump.end;
            }
        }
    }
}
