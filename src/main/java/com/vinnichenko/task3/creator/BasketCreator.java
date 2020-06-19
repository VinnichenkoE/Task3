package com.vinnichenko.task3.creator;

import com.vinnichenko.task3.entity.Ball;
import com.vinnichenko.task3.entity.BallColor;
import com.vinnichenko.task3.entity.Basket;
import com.vinnichenko.task3.exception.ProgramException;
import com.vinnichenko.task3.service.BasketService;
import com.vinnichenko.task3.validator.BasketValidator;

import java.util.ArrayList;
import java.util.List;

public class BasketCreator {

    public Basket createBasket(double carrying, double volume, List<Ball> balls)
            throws ProgramException {
        BasketValidator basketValidator = new BasketValidator();
        if (!basketValidator.checkCarrying(carrying)
                || !basketValidator.checkVolume(volume)) {
            throw new ProgramException("incorrect parameters");
        }
        if (balls == null) {
            throw new ProgramException("basket does not exist");
        }
        return new Basket(carrying, volume, balls);
    }

    public Basket createTestBasket() {
        BallCreator ballCreator = new BallCreator();
        BasketService basketService = new BasketService();
        Basket basket = null;
        try {
            Ball ball1 = ballCreator.createBall(BallColor.BLUE, 11.5, 13.5);
            Ball ball2 = ballCreator.createBall(BallColor.BLUE, 12.0, 10.0);
            Ball ball3 = ballCreator.createBall(BallColor.BLACK, 8.5, 15.0);
            basket = createBasket(50.0, 50.0, new ArrayList<>());
            basketService.putBall(basket, ball1);
            basketService.putBall(basket, ball2);
            basketService.putBall(basket, ball3);
        } catch (ProgramException e) {
            e.printStackTrace();
        }
        return basket;
    }
}
