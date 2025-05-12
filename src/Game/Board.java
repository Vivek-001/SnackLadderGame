package Game;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;

    public Board(int boardSize, int noOfSnack, int noOfLadder) {
        cells = new Cell[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                cells[i][j] = new Cell();
            }
        }
        addLadder(noOfLadder);
        addSnack(noOfSnack);
    }

    public void addSnack(int numberOfSnakes) {
        //generate random start and end of ladder
        while (numberOfSnakes > 0) {

            //use math's random fuction for generate the random number
//            int min = 1;
//            int max = cells.length * cells.length - 2;
//            int snakeHead = (int)(Math.random() * (max - min + 1)) + min;
//            int snakeTail = (int)(Math.random() * (max - min + 1)) + min;

            //// random number genearte betwenen (0 to 99  here)
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if (snakeTail >= snakeHead) {
                continue;
            }
              Jump snackObj = new Jump();
              snackObj.start = snakeHead;
              snackObj.end = snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump =   snackObj;
            numberOfSnakes--;
        }
    }

    public void addLadder(int numberOfLadder) {
        while (numberOfLadder > 0) {
            int  LadderStart = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1); // random number genearte betwenen (0 to 99  here)
            int  LadderEnd = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if ( LadderEnd <=  LadderStart) {
                continue;
            }
            Jump ladderObj = new Jump();
             ladderObj.start =  LadderStart;
             ladderObj.end =  LadderEnd;

            Cell cell = getCell( LadderStart);
            cell.jump =  ladderObj;
            numberOfLadder--;
        }
    }

    private Cell getCell(int snakeHead) {

        int  rowPos = snakeHead / cells.length;
        int colPos = snakeHead % cells.length;
        return cells[rowPos][colPos];
    }
}
