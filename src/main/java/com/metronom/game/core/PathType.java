package com.metronom.game.core;

public enum PathType {
    COLUMN(){
        @Override
        String getBoardValue(String[][] board, int row, int column) {
            return board[row][column];
        }
    },
    ROW(){
        @Override
        String getBoardValue(String[][] board, int row, int column) {
            return board[column][row];
        }
    },
    DIAGONAL(){
        @Override
        String getBoardValue(String[][] board, int row, int column) {
            return board[row][row];
        }
    },
    DIAGONAL_REVERSE(){
        @Override
        String getBoardValue(String[][] board, int row, int column) {
            return board[row][board.length - (row + 1)];
        }
    };

    abstract String getBoardValue(String[][] board, int row, int column);
}
