package com.metronom;

import com.metronom.game.core.Playground;
import com.metronom.game.output.ConsolePrintableBoard;
import com.metronom.game.setup.GameSetup;

public class Main {

    public static void main(String[] args) {
        final Playground playground = new Playground();

        playground.setPlayers(GameSetup.getInstance().getPlayers());
        playground.setPrintableBoard(new ConsolePrintableBoard());

        playground.play();
    }
}
