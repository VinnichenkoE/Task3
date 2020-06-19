package test.vinnichenko.task3.servise;

import com.vinnichenko.task3.creator.BasketCreator;
import com.vinnichenko.task3.entity.BallColor;
import com.vinnichenko.task3.entity.Basket;
import com.vinnichenko.task3.service.BasketService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BasketServiceTest {

    BasketService basketService;
    Basket basket;

    @BeforeMethod
    public void setUp() {
        basketService = new BasketService();
        BasketCreator basketCreator = new BasketCreator();
        basket = basketCreator.createBasket();
    }

    @Test
    public void testNumberOfBallsByColor() {
        int expected = 2;
        int actual = basketService.numberOfBallsByColor(BallColor.BLUE, basket);
        assertEquals(actual, expected);
    }

    @Test
    public void testNumberOfBallsByColor2() {
        int expected = 2;
        int actual = basketService.numberOfBallsByColor2(BallColor.BLUE, basket);
        assertEquals(actual, expected);
    }

    @Test
    public void testWeightOfBalls() {
        double expected = 32.0;
        double actual = basketService.weightOfBalls(basket);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testWeightOfBalls2() {
        double expected = 32.0;
        double actual = basketService.weightOfBalls2(basket);
        assertEquals(actual, expected, 0.001);
    }
}