package com.metronorm.game.core;

import com.metronorm.game.domain.Played;
import com.metronorm.game.domain.Player;
import com.metronorm.game.exceptions.InputIncorrectException;
import com.metronorm.game.exceptions.NotAcceptedPlayed;
import com.metronorm.game.output.PrintableBoard;
import com.metronorm.game.setup.GameSetup;

public class Board {
    private String[][] board;

    private int remainingPlays = 0;

    public void insertNewSymbol(Played played, String symbol) {
        this.board[played.getLine()][played.getColumn()] = symbol;
        remainingPlays--;
    }

    public boolean checkWinner(String symbol) {
        return checkDiagonals(symbol) || checkLines(symbol) || checkColumns(symbol);
    }

    private boolean checkColumns(String symbol) {
        return checkThroughPath(symbol, PathType.COLUMN);
    }

    private boolean checkLines(String symbol) {
        return checkThroughPath(symbol, PathType.ROW);
    }

    private boolean checkThroughPath(String symbol, PathType boardPath) {
        boolean found = false;
        for (int i = 0; i < board.length; i++) {
            found = false;
            for (int j = 0; j < board.length; j++) {
                found = symbol.equals(boardPath.getBoardValue(board, i, j));

                if (!found) {
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        return found;
    }

    private boolean checkDiagonals(String symbol) {
        boolean found = false;
        for (int i = 0; i < board.length; i++) {
            found = symbol.equals(PathType.DIAGONAL.getBoardValue(board, i, i));
            if (!found) {
                break;
            }
        }

        if (!found) {
            for (int i = 0; i < board.length; i++) {
                found = symbol.equals(PathType.DIAGONAL_REVERSE.getBoardValue(board, i, i));
                if (!found) {
                    break;
                }
            }
        }
        return found;
    }

    public void print(PrintableBoard printableBoard) {
        for (String[] column : board) {
            for (String line : column) {
                printableBoard.printSingle(line);
            }
            printableBoard.breakLine();
        }
    }

    public Played read(Player player) {
        Played played = null;
        do {
            try {
                System.out.println(player + " ("+player.getSymbol() + ") your turn:");
                played = player.getReader().readInput(board);
            } catch (InputIncorrectException | NotAcceptedPlayed e) {
                System.err.println(e.getMessage());
            }
        } while (played == null);

        return played;
    }

    public void initBoard() {
        board = GameSetup.getInstance().getBoardGameSize();
        remainingPlays = board.length * board.length;
    }

    public boolean isFull() {
        return remainingPlays == 0;
    }
}
