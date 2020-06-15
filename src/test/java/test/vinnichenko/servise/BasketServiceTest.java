package test.vinnichenko.servise;

import com.vinnichenko.entity.Ball;
import com.vinnichenko.entity.BallColor;
import com.vinnichenko.entity.Basket;
import com.vinnichenko.exception.ProgramException;
import com.vinnichenko.servise.BasketService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BasketServiceTest {

    BasketService basketService;

    @BeforeClass
    public void setUp() {
        basketService = new BasketService();
    }

    @DataProvider(name = "basket")
    public Object[] createData() {
        Ball ball1 = new Ball(BallColor.BLUE, 11.5, 13.5);
        Ball ball2 = new Ball(BallColor.BLUE, 12.0, 10.0);
        Ball ball3 = new Ball(BallColor.BLACK, 8.5, 10.5);
        Basket basket = new Basket(50.0, 50.0);
        try {
            basketService.putBallInBasket(ball1, basket);
            basketService.putBallInBasket(ball2, basket);
            basketService.putBallInBasket(ball3, basket);
        } catch (ProgramException e) {
            e.printStackTrace();
        }
        return new Object[]{basket};
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

    @Test(dataProvider = "basket")
    public void testNumberOfBallsByColor(Basket basket) {
        int expected = 2;
        int actual = basketService.numberOfBallsByColor(BallColor.BLUE, basket);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "basket")
    public void testWeightOfBalls(Basket basket) {
        double expected = 32.0;
        double actual = basketService.weightOfBalls(basket);
        assertEquals(actual, expected);

    }
}