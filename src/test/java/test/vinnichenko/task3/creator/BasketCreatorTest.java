package test.vinnichenko.task3.creator;

import com.vinnichenko.task3.creator.BallCreator;
import com.vinnichenko.task3.creator.BasketCreator;
import com.vinnichenko.task3.entity.Ball;
import com.vinnichenko.task3.entity.BallColor;
import com.vinnichenko.task3.entity.Basket;
import com.vinnichenko.task3.exception.ProgramException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class BasketCreatorTest {

    BasketCreator basketCreator;

    @BeforeMethod
    public void setUp() {
        basketCreator = new BasketCreator();
    }

    @Test
    public void createBasketTest() {
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
        basketCreator.createBasket(120.0, 50.0, new ArrayList<Ball>());
    }

    @Test(expectedExceptions = ProgramException.class)
    public void createBasketTestNull() throws ProgramException {
        basketCreator.createBasket(75.0, 50.0, null);
    }
}