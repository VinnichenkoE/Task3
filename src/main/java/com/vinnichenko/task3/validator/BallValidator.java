package com.vinnichenko.task3.validator;

public class BallValidator {

    private static final double MAX_VOLUME = 20.0;
    private static final double MAX_WEIGHT = 20.0;

    public boolean checkVolume(double volume) {
        return volume > 0 && volume <= MAX_VOLUME;
    }

    public boolean checkWeight(double weight) {
        return weight > 0 && weight <= MAX_WEIGHT;
    }
}
