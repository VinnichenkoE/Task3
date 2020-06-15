package test.vinnichenko.servise;

import com.vinnichenko.entity.Ball;
import com.vinnichenko.entity.BallColor;
import com.vinnichenko.entity.Basket;
import com.vinnichenko.exception.ProgramException;
import com.vinnichenko.servise.BasketService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BasketServiceTest {

    BasketService basketService;

    @BeforeMethod
    public void setUp() {
        basketService = new BasketService();
    }

    @Test
    public void testIsFitPositive() {
        Ball ball = new Ball(BallColor.BLUE, 11.5, 13.5);
        Basket basket = new Basket(15.0, 15.0);
        boolean condition = basketService.isFit(ball, basket);
        assertTrue(condition);
    }

    @Test
    public void testIsFitNegative() {
        Ball ball = new Ball(BallColor.BLUE, 11.5, 13.5);
        Basket basket = new Basket(10.0, 15.0);
        boolean condition = basketService.isFit(ball, basket);
        assertFalse(condition);
    }

    @Test
    public void testPutBallInBasket() {
        Ball ball = new Ball(BallColor.BLUE, 11.5, 13.5);
        Basket basket = new Basket(15.0, 15.0);
        List<Ball> ballList = new ArrayList<Ball>() {{
            add(new Ball(BallColor.BLUE, 11.5, 13.5));
        }};
        try {
            basketService.putBallInBasket(ball, basket);
            assertEquals(basket.getBalls(), ballList);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void testPutBallInBasketException() throws ProgramException {
        Ball ball = new Ball(BallColor.BLUE, 11.5, 13.5);
        Basket basket = new Basket(10.0, 15.0);
        basketService.putBallInBasket(ball, basket);
    }

    @Test
    public void testNumberOfBallsByColor() {
        Ball ball1 = new Ball(BallColor.BLUE, 11.5, 13.5);
        Ball ball2 = new Ball(BallColor.BLUE, 12.0, 10.0);
        Ball ball3 = new Ball(BallColor.BLACK, 8.5, 10.5);
        Basket basket = new Basket(50.0, 50.0);

        try {
            basketService.putBallInBasket(ball1, basket);
            basketService.putBallInBasket(ball2, basket);
            basketService.putBallInBasket(ball3, basket);
            int expected = 2;
            int actual = basketService.numberOfBallsByColor(BallColor.BLUE, basket);
            assertEquals(actual, expected);
        } catch (ProgramException e) {
            fail();
        }
    }
}