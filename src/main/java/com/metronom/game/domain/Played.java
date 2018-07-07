package com.metronom.game.domain;

public class Played {

    private Integer line;
    private Integer column;

    public Played(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public Integer getLine() {
        return line - 1;
    }

    public Integer getColumn() {
        return column - 1;
    }
}
