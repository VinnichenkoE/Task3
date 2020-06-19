package test.vinnichenko.task3.creator;

import com.vinnichenko.task3.creator.BallCreator;
import com.vinnichenko.task3.entity.Ball;
import com.vinnichenko.task3.entity.BallColor;
import com.vinnichenko.task3.exception.ProgramException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BallCreatorTest {

    @Test
    public void createBallTest() {
        BallCreator ballCreator = new BallCreator();
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
        BallCreator ballCreator = new BallCreator();
        ballCreator.createBall(BallColor.BLUE, 22.5, 15.0);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void createBallTestNull() throws ProgramException {
        BallCreator ballCreator = new BallCreator();
        ballCreator.createBall(null, 12.5, 15.0);
    }
}