package test.vinnichenko.task3.creator;

import com.vinnichenko.task3.creator.BallCreator;
import com.vinnichenko.task3.creator.BasketCreator;
import com.vinnichenko.task3.entity.Ball;
import com.vinnichenko.task3.entity.BallColor;
import com.vinnichenko.task3.entity.Basket;
import com.vinnichenko.task3.exception.ProgramException;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class BasketCreatorTest {

    @Test
    public void createBasketTest() {
        BasketCreator basketCreator = new BasketCreator();
        Basket expected = new Basket(50.0, 50.0, new ArrayList<Ball>());
        try {
            Basket actual = basketCreator.createBasket(50.0, 50.0, new ArrayList<Ball>());
            assertEquals(actual, expected);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void createBasketTestException() throws ProgramException {
        BasketCreator basketCreator = new BasketCreator();
        basketCreator.createBasket(120.0, 50.0, new ArrayList<Ball>());
    }

    @Test(expectedExceptions = ProgramException.class)
    public void createBasketTestNull() throws ProgramException {
        BasketCreator basketCreator = new BasketCreator();
        basketCreator.createBasket(75.0, 50.0, null);
    }
}