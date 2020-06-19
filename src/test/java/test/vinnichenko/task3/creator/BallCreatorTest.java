package test.vinnichenko.task3.creator;

import com.vinnichenko.task3.creator.BallCreator;
import com.vinnichenko.task3.creator.BasketCreator;
import com.vinnichenko.task3.entity.Ball;
import com.vinnichenko.task3.entity.BallColor;
import com.vinnichenko.task3.exception.ProgramException;
import com.vinnichenko.task3.service.BasketService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BallCreatorTest {

    BallCreator ballCreator;

    @BeforeMethod
    public void setUp() {
        ballCreator = new BallCreator();
    }

    @Test
    public void createBallTest() {
        Ball expected = new Ball(BallColor.BLUE, 15.0, 12.5);
        try {
            Ball actual = ballCreator.createBall(BallColor.BLUE, 15.0, 12.5);
            assertEquals(actual, expected);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void createBallTestException() throws ProgramException {
        ballCreator.createBall(BallColor.BLUE, 22.5, 15.0);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void createBallTestNull() throws ProgramException {
        ballCreator.createBall(null, 12.5, 15.0);
    }
}