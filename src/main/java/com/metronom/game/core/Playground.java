package com.metronom.game.core;

import com.metronom.game.domain.Played;
import com.metronom.game.domain.Player;
import com.metronom.game.output.PrintableBoard;

import java.util.Set;

public class Playground {

    private final Board board = new Board();

    private PrintableBoard printableBoard;
    private Set<Player> players;

    public void play() {
        if (printableBoard == null) {
            throw new IllegalArgumentException("You should init the Printable Board.");
        }

        outer : while(true) {
            board.initBoard();
            System.out.println("Get Ready, Starting game!");

            print();
            //game loop
            while (true) {
                for (Player player : players) {
                    Played played = board.read(player);

                    board.insertNewSymbol(played, player.getSymbol());

                    print();

                    if (board.checkWinner(player.getSymbol())) {
                        System.out.println(player + " won. :)");
                        continue outer;
                    } else if (board.isFull()) {
                        System.out.println("No winner. :/");
                        continue outer;
                    }
                }
            }
        }
    }

    private void print(){
        board.print(this.printableBoard);
    }

    public void setPrintableBoard(PrintableBoard printableBoard) {
        this.printableBoard = printableBoard;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
