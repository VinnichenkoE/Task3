package test.vinnichenko.task3.validator;

import com.vinnichenko.task3.creator.BasketCreator;
import com.vinnichenko.task3.entity.Ball;
import com.vinnichenko.task3.entity.BallColor;
import com.vinnichenko.task3.entity.Basket;
import com.vinnichenko.task3.validator.BasketValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketValidatorTest {

    BasketValidator basketValidator;
    Basket basket;

    @BeforeMethod
    public void setUp() {
        basketValidator = new BasketValidator();
        BasketCreator basketCreator = new BasketCreator();
        basket = basketCreator.createTestBasket();

    }

    @Test
    public void checkCarryingTestPositive() {
        double carrying = 75.0;
        boolean condition = basketValidator.checkCarrying(carrying);
        assertTrue(condition);
    }

    @Test
    public void checkCarryingTestNegative() {
        double carrying = 125.0;
        boolean condition = basketValidator.checkCarrying(carrying);
        assertFalse(condition);
    }

    @Test
    public void checkVolumeTestPositive() {
        double volume = 75.0;
        boolean condition = basketValidator.checkVolume(volume);
        assertTrue(condition);
    }

    @Test
    public void checkVolumeTestNegative() {
        double volume = 125.0;
        boolean condition = basketValidator.checkVolume(volume);
        assertFalse(condition);
    }

    @Test
    public void isFitTestPositive() {
        Ball ball = new Ball(BallColor.BLUE, 10.0, 10.0);
        boolean condition = basketValidator.isFit(basket, ball);
        assertTrue(condition);
    }

    @Test
    public void isFitTestNegative() {
        Ball ball = new Ball(BallColor.BLUE, 10.0, 20.0);
        boolean condition = basketValidator.isFit(basket, ball);
        assertFalse(condition);
    }
}