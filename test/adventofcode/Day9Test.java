package adventofcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

public class Day9Test {

    @Test
    public void getTestResult () {
        List<Long> input = Day9.convertInput(Day9.getPuzzleTestInput());
        Long result = Day9.solveTask1(input,5);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 127);
    }

    @Test
    public void getResult () {
        List<Long> input = Day9.convertInput(Day9.getPuzzleInput());
        Long result = Day9.solveTask1(input,25);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 1930745883);
    }

    @Test
    public void getTestResult2 () {
        List<Long> input = Day9.convertInput(Day9.getPuzzleTestInput());
        Long preresult = Day9.solveTask1(input,5);
        Long result = Day9.solveTask2(input,preresult);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 62);
    }

    @Test
    public void getResult2 () {
        List<Long> input = Day9.convertInput(Day9.getPuzzleInput());
        Long preresult = Day9.solveTask1(input,25);
        Long result = Day9.solveTask2(input,preresult);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result >0);
    }




}
