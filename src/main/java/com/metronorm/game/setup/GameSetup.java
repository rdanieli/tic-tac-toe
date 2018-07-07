package com.metronorm.game.setup;

import com.metronorm.game.bot.AutoSuggestionPlayed;
import com.metronorm.game.domain.Player;
import com.metronorm.game.input.ConsoleReaderBoard;

import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

public class GameSetup {
    private static final int MAX_SIZE = 10;
    private static final int MIN_SIZE = 3;
    private static final int MAX_HUMAN_PLAYERS = 2;

    private static GameSetup instance;

    private ResourceBundle resourceBundle = ResourceBundle.getBundle("game");

    public static GameSetup getInstance() {
        if(instance == null) {
            instance = new GameSetup();
        }

        return instance;
    }

    private Player readPlayer(int index){
        String symbol = resourceBundle.getString(String.format("player.%s.symbol", index));

        checkSymbol(symbol);

        return new Player(resourceBundle.getString(String.format("player.%s.name", index).trim()),
                new ConsoleReaderBoard(),
                symbol);
    }

    public Set<Player> getPlayers() {
        TreeSet<Player> players = new TreeSet<>();

        for (int i = 0; i < MAX_HUMAN_PLAYERS; i++) {
            players.add(readPlayer(i + 1));
        }

        players.add(new Player(resourceBundle.getString("IA.name"),
                new AutoSuggestionPlayed(),
                getBotSymbol()));

        if(players.size() != 3){
            throw new IllegalArgumentException("Use different Name and Symbols for domain.");
        }


        return players;
    }

    public String[][] getBoardGameSize() {
        Integer size = Integer.valueOf(resourceBundle.getString("playground.size"));

        if(size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException("Board size is available between 3 and 10");
        }

        return new String[size][size];
    }

    private String getBotSymbol() {
        String symbol = resourceBundle.getString("IA.symbol");
        checkSymbol(symbol);

        return symbol;
    }

    private void checkSymbol(String symbol) {
        if("-".equals(symbol)){
            throw new IllegalArgumentException("The Symbol (-) is used to show empty space during the game.");
        }
    }
}
