package com.metronom.game.bot;

import com.metronom.game.domain.Played;
import com.metronom.game.input.ReadableBoard;

public class AutoSuggestionPlayed implements ReadableBoard {
    @Override
    public Played readInput(String[][] board) {
        int rand1;
        int rand2;

        Played played = null;

        while(played == null){
            rand1 = (int) (Math.random() * board.length);
            rand2 = (int) (Math.random() * board.length);

            if(board[rand1][rand2] == null){
                played = new Played(rand1 + 1, rand2 + 1);
            }
        }

        return played;
    }
}
