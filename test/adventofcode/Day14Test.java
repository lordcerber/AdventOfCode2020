package adventofcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

public class Day14Test {



    @Test
    public void getTestResult () {
        List<String> input = Day14.getPuzzleTestInput();
        Long result = Day14.solveTask1(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 165);
    }

    @Test
    public void getResult () {
        List<String> input = Day14.getPuzzleInput();
        Long result = Day14.solveTask1(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 14839536808842l);
    }

    @Test
    public void getTestResult2 () {
        List<String> input = Day14.getPuzzleTestInput2();
        Long result = Day14.solveTask2(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 208);
    }

    @Test
    public void getResult2 () {
        List<String> input = Day14.getPuzzleInput();
        Long result = Day14.solveTask2(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 4215284199669l);
    }



}
