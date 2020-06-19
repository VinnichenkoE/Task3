package test.vinnichenko.task3.validator;

import com.vinnichenko.task3.creator.BasketCreator;
import com.vinnichenko.task3.entity.Basket;
import com.vinnichenko.task3.service.BasketService;
import com.vinnichenko.task3.validator.BallValidator;
import com.vinnichenko.task3.validator.BasketValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BallValidatorTest {

    BallValidator ballValidator;

    @BeforeMethod
    public void setUp() {
        ballValidator = new BallValidator();
    }

    @Test
    public void checkVolumeTestPositive() {
        double volume = 15.0;
        boolean condition = ballValidator.checkVolume(volume);
        assertTrue(condition);
    }

    @Test
    public void checkVolumeTestNegative() {
        double volume = 25.0;
        boolean condition = ballValidator.checkVolume(volume);
        assertFalse(condition);
    }

    @Test
    public void checkWeightTestPositive() {
        double weight = 15.0;
        boolean condition = ballValidator.checkWeight(weight);
        assertTrue(condition);
    }

    @Test
    public void checkWeightTestNegative() {
        double weight = 25.0;
        boolean condition = ballValidator.checkWeight(weight);
        assertFalse(condition);
    }
}