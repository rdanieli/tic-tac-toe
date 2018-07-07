package com.metronom.game.input;

import com.metronom.game.domain.Played;

public interface ReadableBoard {
    Played readInput(String[][] board);
}
