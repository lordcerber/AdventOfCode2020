package adventofcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

public class Day8Test {

    @Test
    public void getTestResult () {
        List<String> input = Day8.getPuzzleTestInput();

        Long result = Day8.runCode(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 5);
    }

    @Test
    public void getResult () {
        List<String> input = Day8.getPuzzleInput();

        Long result = Day8.runCode(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result > 0);
    }

    @Test
    public void getTestResult2 () {
        List<String> input = Day8.getPuzzleTestInput();

        Long result = Day8.solveEndlessLoop(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 8);
    }

    @Test
    public void getResult2 () {
        List<String> input = Day8.getPuzzleInput();

        Long result = Day8.solveEndlessLoop(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result > 0);
    }




}
