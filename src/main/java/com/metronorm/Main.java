package com.metronorm;

import com.metronorm.game.core.Playground;
import com.metronorm.game.output.ConsolePrintableBoard;
import com.metronorm.game.setup.GameSetup;

public class Main {

    public static void main(String[] args) {
        final Playground playground = new Playground();

        playground.setPlayers(GameSetup.getInstance().getPlayers());
        playground.setPrintableBoard(new ConsolePrintableBoard());

        playground.play();
    }
}
