package com.metronorm.game.input;

import com.metronorm.game.exceptions.InputIncorrectException;

public class UserInputData {
    private String data;

    private UserInputData(){

    }

    public UserInputData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void validate() {
        if (data == null || data.trim().isEmpty()) {
            throw new InputIncorrectException("Empty played, input the text and press enter.");
        }

        if (!data.matches("^([\\d]+),([\\d]+)$")) {
            throw new InputIncorrectException("Not a valid input pattern, use e.g: 3,2 (line,column)");
        }
    }
}
