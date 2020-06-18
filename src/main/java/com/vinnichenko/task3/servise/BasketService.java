package com.vinnichenko.task3.servise;

import com.vinnichenko.task3.entity.Ball;
import com.vinnichenko.task3.entity.BallColor;
import com.vinnichenko.task3.entity.Basket;

public class BasketService {

    public int numberOfBallsByColor(BallColor color, Basket basket) {
        int count = 0;
        for (Ball ball : basket.getBalls()) {
            if (ball.getColor().equals(color)) {
                count++;
            }
        }
        return count;
    }

    public int numberOfBallsByColor2(BallColor color, Basket basket) {
        return (int) basket.getBalls().stream().filter(o -> o.getColor().equals(color)).count();
    }

    public double weightOfBalls(Basket basket) {
        double weight = 0;
        for (Ball ball : basket.getBalls()) {
            weight += ball.getWeight();
        }
        return weight;
    }

    public double weightOfBalls2(Basket basket) {
        return basket.getBalls().stream().mapToDouble(Ball::getWeight).sum();
    }
}
