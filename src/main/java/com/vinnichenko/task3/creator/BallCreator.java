package com.vinnichenko.task3.creator;

import com.vinnichenko.task3.entity.Ball;
import com.vinnichenko.task3.entity.BallColor;
import com.vinnichenko.task3.exception.ProgramException;
import com.vinnichenko.task3.validator.BallValidator;

public class BallCreator {

    public Ball createBall(BallColor color, double weight, double volume) throws ProgramException {
        BallValidator ballValidator = new BallValidator();
        if (!ballValidator.checkVolume(volume) || !ballValidator.checkWeight(weight)) {
            throw new ProgramException("incorrect parameters");
        }
        if (color == null) {
            throw new ProgramException("color does not exist");
        }
        return new Ball(color, weight, volume);
    }
}
