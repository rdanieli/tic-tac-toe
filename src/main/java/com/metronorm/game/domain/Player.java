package com.metronorm.game.domain;

import com.metronorm.game.input.ReadableBoard;

import java.util.Objects;

public class Player implements Comparable<Player> {
    private final String name;
    private final ReadableBoard reader;
    private final String symbol;

    public Player(final String name, final ReadableBoard reader, String symbol){
        this.name = name;
        this.reader = reader;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public ReadableBoard getReader() {
        return reader;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(symbol, player.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symbol);
    }

    @Override
    public int compareTo(Player o) {
        if(this.name.compareToIgnoreCase(o.getName()) == 0 ||
           this.symbol.compareTo(o.getSymbol()) == 0){
            return 0;
        } else {
            return 1;
        }
    }
}
