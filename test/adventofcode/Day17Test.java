package adventofcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class Day17Test {



    @Test
    public void getTestResult () {
        Day17.getInstance().convertInput(Day17.getPuzzleTestInput());
        Long result = Day17.getInstance().solveTask1(6);
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(112));
    }

    @Test
    public void getResult1 () {
        Day17.getInstance().convertInput(Day17.getPuzzleInput());
        Long result = Day17.getInstance().solveTask1(6);
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(353));
    }

    @Test
    public void getTestResult2 () {
        Day17.getInstance().convertInput2(Day17.getPuzzleTestInput());
        Long result = Day17.getInstance().solveTask1(6);
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(848));
    }

    @Test
    public void getResult2 () {
        Day17.getInstance().convertInput2(Day17.getPuzzleInput());
        Long result = Day17.getInstance().solveTask1(6);
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(848));
    }
    



}
