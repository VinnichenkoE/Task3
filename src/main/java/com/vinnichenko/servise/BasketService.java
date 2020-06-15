package com.vinnichenko.servise;

import com.vinnichenko.entity.Ball;
import com.vinnichenko.entity.BallColor;
import com.vinnichenko.entity.Basket;
import com.vinnichenko.exception.ProgramException;

import java.util.List;

public class BasketService {

    public boolean isFit(Ball ball, Basket basket) {
        return basket.getCarrying() - ball.getWeight() >= 0 && basket.getCapacity() - ball.getVolume() >= 0;
    }

    public void putBallInBasket(Ball ball, Basket basket) throws ProgramException {
        if (isFit(ball, basket)) {
            List<Ball> ballList = basket.getBalls();
            ballList.add(ball);
            Double carrying = basket.getCarrying();
            carrying -= ball.getWeight();
            Double capacity = basket.getCapacity();
            capacity -= ball.getVolume();
            basket.setCarrying(carrying);
            basket.setCapacity(capacity);
            basket.setBalls(ballList);
        } else {
            throw new ProgramException("the ball does not fit in the basket");
        }
    }

    public int numberOfBallsByColor(final BallColor color, Basket basket) {
        return (int) basket.getBalls().stream().filter(o -> o.getColor().equals(color)).count();
    }

    public double weightOfBalls (Basket basket) {
        return basket.getBalls().stream().mapToDouble(Ball::getWeight).sum();
    }
}
