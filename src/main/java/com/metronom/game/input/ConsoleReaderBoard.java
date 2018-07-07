package com.metronom.game.input;

import com.metronom.game.domain.Played;
import com.metronom.game.domain.PlayedFactory;
import com.metronom.game.exceptions.NotAcceptedPlayed;

import java.util.Scanner;

public class ConsoleReaderBoard implements ReadableBoard {

    @Override
    public Played readInput(String[][] board) {
        UserInputData userInputData = new UserInputData(new Scanner(System.in).next());
        userInputData.validate();
        Played played = PlayedFactory.create(userInputData);
        checkNotExceedBoardSize(played, board);
        return played;
    }

    private void checkNotExceedBoardSize(Played played, String[][] board) {
        int boardSize = board.length - 1;

        if(played.getColumn() > boardSize) {
            throw new NotAcceptedPlayed("Column informed is greater than board column size.");
        }

        if(played.getColumn() < 0) {
            throw new NotAcceptedPlayed("Column informed is lower than board column size.");
        }

        if(played.getLine() > boardSize) {
            throw new NotAcceptedPlayed("Line informed is greater than board line size.");
        }

        if(played.getLine() < 0) {
            throw new NotAcceptedPlayed("Line informed is lower than board line size.");
        }

        if(board[played.getLine()][played.getColumn()] != null){
            throw new NotAcceptedPlayed("This place is already taken.");
        }
    }

}
