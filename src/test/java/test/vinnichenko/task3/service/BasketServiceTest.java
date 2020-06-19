package test.vinnichenko.task3.service;

import com.vinnichenko.task3.creator.BasketCreator;
import com.vinnichenko.task3.entity.Ball;
import com.vinnichenko.task3.entity.BallColor;
import com.vinnichenko.task3.entity.Basket;
import com.vinnichenko.task3.exception.ProgramException;
import com.vinnichenko.task3.service.BasketService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class BasketServiceTest {

    BasketService basketService;
    Basket basket;

    @BeforeMethod
    public void setUp() {
        basketService = new BasketService();
        BasketCreator basketCreator = new BasketCreator();
        basket = basketCreator.createTestBasket();
    }

    @Test
    public void numberOfBallsByColorTest() {
        int expected = 2;
        int actual = basketService.numberOfBallsByColor(BallColor.BLUE, basket);
        assertEquals(actual, expected);
    }

    @Test
    public void numberOfBallsByColor2Test() {
        int expected = 2;
        int actual = basketService.numberOfBallsByColor2(BallColor.BLUE, basket);
        assertEquals(actual, expected);
    }

    @Test
    public void weightOfBallsTest() {
        double expected = 32.0;
        double actual = basketService.weightOfBalls(basket);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void weightOfBalls2Test() {
        double expected = 32.0;
        double actual = basketService.weightOfBalls2(basket);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void volumeOfBallsTest() {
        double expected = 38.5;
        double actual = basketService.volumeOfBalls(basket);
        assertEquals(actual, expected, 0.001);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void putBallTestException() throws ProgramException {
        Ball ball = new Ball(BallColor.BLUE, 15.0, 15.0);
        Basket basket = new Basket(12.5, 50.0, new ArrayList<Ball>());
        basketService.putBall(basket, ball);
    }

    @Test
    public void putBallTest() {
        Ball ball = new Ball(BallColor.BLACK, 5.0, 5.0);
        Basket basket = new Basket(50.0, 50.0, new ArrayList<Ball>());
        try {
            boolean condition = basketService.putBall(basket, ball);
            assertTrue(condition);
        } catch (ProgramException e) {
            fail();
        }
    }
}