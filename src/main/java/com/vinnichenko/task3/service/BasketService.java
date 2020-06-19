package com.vinnichenko.task3.service;

import com.vinnichenko.task3.entity.Ball;
import com.vinnichenko.task3.entity.BallColor;
import com.vinnichenko.task3.entity.Basket;
import com.vinnichenko.task3.exception.ProgramException;
import com.vinnichenko.task3.validator.BasketValidator;

import java.util.List;

public class BasketService {

    public int numberOfBallsByColor(BallColor color, Basket basket) {
        int count = 0;
        List<Ball> balls = basket.getBalls();
        for (Ball ball : balls) {
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
        List<Ball> balls = basket.getBalls();
        for (Ball ball : balls) {
            weight += ball.getWeight();
        }
        return weight;
    }

    public double weightOfBalls2(Basket basket) {
        return basket.getBalls().stream().mapToDouble(Ball::getWeight).sum();
    }

    public double volumeOfBalls(Basket basket) {
        double volume = 0;
        List<Ball> balls = basket.getBalls();
        for (Ball ball : balls) {
            volume += ball.getVolume();
        }
        return volume;
    }

    public boolean putBall(Basket basket, Ball ball) throws ProgramException {
        BasketValidator basketValidator = new BasketValidator();
        if (!basketValidator.isFit(basket, ball)) {
            throw new ProgramException("the ball cannot be placed in the basket");
        }
        return basket.add(ball);
    }
}
