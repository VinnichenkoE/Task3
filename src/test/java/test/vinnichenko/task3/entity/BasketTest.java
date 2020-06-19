package test.vinnichenko.task3.entity;

import com.vinnichenko.task3.entity.Ball;
import com.vinnichenko.task3.entity.BallColor;
import com.vinnichenko.task3.entity.Basket;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BasketTest {

    Basket basket;

    @BeforeMethod
    public void setUp() {
        basket = new Basket(10.0, 10.0, new ArrayList<>());
    }

    @Test
    public void testIsFitPositive() {
        Ball ball = new Ball(BallColor.BLACK, 5.0, 5.0);
        boolean condition = basket.addBall(ball);
        assertTrue(condition);
    }

    @Test
    public void testIsFitNegative() {
        Ball ball = new Ball(BallColor.BLACK, 15.0, 15.0);
        boolean condition = basket.addBall(ball);
        assertFalse(condition);
    }

    @Test
    public void testAddBallNull() {
        Ball ball = null;
        boolean condition = basket.addBall(ball);
        assertFalse(condition);
    }

    @Test
    public void testAddBallFit() {
        Ball ball = new Ball(BallColor.BLACK, 5.0, 5.0);
        List<Ball> balls = new ArrayList<Ball>() {{
            add(ball);
        }};
        List<Ball> expected = balls;
        basket.addBall(ball);
        List<Ball> actual = basket.getBalls();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddBallNotFit() {
        Ball ball = new Ball(BallColor.BLACK, 15.0, 15.0);
        boolean condition = basket.addBall(ball);
        assertFalse(condition);
    }
}