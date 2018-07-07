package com.metronom.game.output;

public class ConsolePrintableBoard implements PrintableBoard {

    @Override
    public void printSingle(String value) {
        System.out.print(" " + (value == null ? "-" : value) + " ");
    }

    @Override
    public void breakLine() {
        System.out.println();
    }
}
