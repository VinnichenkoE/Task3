package com.vinnichenko.task3.entity;

import java.util.Collections;
import java.util.List;

public class Basket {
    private double currentCarrying;
    private double currentVolume;
    private List<Ball> balls;

    public Basket(double carrying, double volume, List<Ball> balls) {
        this.currentCarrying = carrying;
        this.currentVolume = volume;
        this.balls = balls;
    }

    public double getCurrentCarrying() {
        return currentCarrying;
    }

    public double getCurrentVolume() {
        return currentVolume;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public boolean isFit(Ball ball) {
        return getCurrentCarrying() - ball.getWeight() >= 0
                && getCurrentVolume() - ball.getVolume() >= 0;
    }

    public boolean addBall(Ball ball) {
        if (ball == null) {
            return false;
        }
        if (isFit(ball)) {
            currentVolume -= ball.getVolume();
            currentCarrying -= ball.getWeight();
            return balls.add(ball);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Basket basket = (Basket) o;
        if (Double.compare(basket.currentCarrying, currentCarrying) != 0) {
            return false;
        }
        if (Double.compare(basket.currentVolume, currentVolume) != 0) {
            return false;
        }
        return balls != null ? balls.equals(basket.balls) : basket.balls == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(currentCarrying);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(currentVolume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (balls != null ? balls.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");
        sb.append("currentCarrying=").append(currentCarrying);
        sb.append(", currentVolume=").append(currentVolume);
        sb.append(", balls=").append(balls);
        sb.append('}');
        return sb.toString();
    }
}
