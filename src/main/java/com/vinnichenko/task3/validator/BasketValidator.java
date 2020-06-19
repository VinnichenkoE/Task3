package com.vinnichenko.task3.validator;

import com.vinnichenko.task3.entity.Ball;
import com.vinnichenko.task3.entity.Basket;
import com.vinnichenko.task3.service.BasketService;

public class BasketValidator {

    private static final double MAX_CARRYING = 100.0;
    private static final double MAX_VOLUME = 100.0;

    public boolean checkCarrying(double carrying) {
        return carrying > 0 && carrying <= MAX_CARRYING;
    }

    public boolean checkVolume(double volume) {
        return volume > 0 && volume <= MAX_VOLUME;
    }

    public boolean isFit(Basket basket, Ball ball) {
        BasketService basketService = new BasketService();
        double weightBalls = basketService.weightOfBalls(basket);
        double volumeBalls = basketService.volumeOfBalls(basket);
        return basket.getCarrying() - weightBalls - ball.getWeight() >= 0
                && basket.getVolume() - volumeBalls - ball.getVolume() >= 0;
    }
}
