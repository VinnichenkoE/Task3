package test.vinnichenko.task3.servise;

import com.vinnichenko.task3.creator.BasketCreator;
import com.vinnichenko.task3.entity.BallColor;
import com.vinnichenko.task3.entity.Basket;
import com.vinnichenko.task3.servise.BasketService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketServiceTest {

    BasketService basketService;

    @BeforeClass
    public void setUp() {
        basketService = new BasketService();
    }

    @DataProvider(name = "basket")
    public Object[] createData() {
        BasketCreator basketCreator = new BasketCreator();
        Basket basket = basketCreator.createBasket();
        return new Object[]{basket};
    }

    @Test(dataProvider = "basket")
    public void testNumberOfBallsByColor(Basket basket) {
        int expected = 2;
        int actual = basketService.numberOfBallsByColor(BallColor.BLUE, basket);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "basket")
    public void testNumberOfBallsByColor2(Basket basket) {
        int expected = 2;
        int actual = basketService.numberOfBallsByColor2(BallColor.BLUE, basket);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "basket")
    public void testWeightOfBalls(Basket basket) {
        double expected = 32.0;
        double actual = basketService.weightOfBalls(basket);
        assertEquals(actual, expected, 0.001);
    }

    @Test(dataProvider = "basket")
    public void testWeightOfBalls2(Basket basket) {
        double expected = 32.0;
        double actual = basketService.weightOfBalls2(basket);
        assertEquals(actual, expected, 0.001);
    }
}