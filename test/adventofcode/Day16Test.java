package adventofcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

public class Day16Test {



    @Test
    public void getTestResult () {
        Day16.getInstance().convertInput(Day16.getPuzzleTestInput());
        Long result = Day16.getInstance().solveTask1();
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(71L));
    }

    @Test
    public void getResult1 () {
        Day16.getInstance().convertInput(Day16.getPuzzleInput());
        Long result = Day16.getInstance().solveTask1();
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(26980L));
    }

    @Test
    public void getResult2 () {
        Day16.getInstance().convertInput(Day16.getPuzzleInput());
        Long result = Day16.getInstance().solveTask2();
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(3021381607403L));
    }
    



}
