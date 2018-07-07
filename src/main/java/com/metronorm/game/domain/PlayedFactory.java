package com.metronorm.game.domain;

import com.metronorm.game.exceptions.NotAcceptedPlayed;
import com.metronorm.game.input.UserInputData;

public class PlayedFactory {
    public static Played create(UserInputData input){
        try {
            Integer line = Integer.valueOf(input.getData().substring(0, input.getData().indexOf(",")));
            Integer column = Integer.valueOf(input.getData().substring(input.getData().indexOf(",") + 1));
            return new Played(line, column);
        } catch (NumberFormatException e) {
            throw new NotAcceptedPlayed("Take it easy, too long value informed :)");
        } catch (Exception e) {
            throw new NotAcceptedPlayed("You're really trying to crash me :(");
        }

    }
}
