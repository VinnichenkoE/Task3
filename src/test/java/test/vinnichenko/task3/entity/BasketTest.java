package test.vinnichenko.task3.entity;

import com.vinnichenko.task3.entity.Ball;
import com.vinnichenko.task3.entity.BallColor;
import com.vinnichenko.task3.entity.Basket;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BasketTest {

    Basket basket;

    @BeforeMethod
    public void setUp() {
        basket = new Basket(10.0, 10.0, new ArrayList<>());
    }

    @Test
    public void addTestNull() {
        Ball ball = null;
        boolean condition = basket.add(ball);
        assertFalse(condition);
    }

    @Test
    public void addTest() {
        Ball ball = new Ball(BallColor.BLACK, 5.0, 5.0);
        boolean condition = basket.add(ball);
        assertTrue(condition);
    }
}