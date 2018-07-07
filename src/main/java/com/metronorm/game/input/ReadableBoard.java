package com.metronorm.game.input;

import com.metronorm.game.domain.Played;

public interface ReadableBoard {
    Played readInput(String[][] board);
}
