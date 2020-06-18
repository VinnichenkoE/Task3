package com.vinnichenko.creator;

import com.vinnichenko.entity.Ball;
import com.vinnichenko.entity.BallColor;
import com.vinnichenko.entity.Basket;

import java.util.ArrayList;

public class BasketCreator {

    public Basket createBasket() {
        Ball ball1 = new Ball(BallColor.BLUE, 11.5, 13.5);
        Ball ball2 = new Ball(BallColor.BLUE, 12.0, 10.0);
        Ball ball3 = new Ball(BallColor.BLACK, 8.5, 15.0);
        Basket basket = new Basket(50.0, 50.0, new ArrayList<>());
        basket.add(ball1);
        basket.add(ball2);
        basket.add(ball3);
        return basket;
    }
}
