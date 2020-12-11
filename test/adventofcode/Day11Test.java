package adventofcode;

import adventofcode.Day11.Solution;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

public class Day11Test {



    @Test
    public void getTestResult () {
        List<String> input = Solution.getPuzzleTestInput();
        Long result = Solution.getInstance().solveTask1(input);

        Logger.getGlobal().info(Solution.getInstance().field.toString());

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 37);
    }

    @Test
    public void getResult () {
        List<String> input = Solution.getPuzzleInput();
        Long result = Solution.getInstance().solveTask1(input);

        Logger.getGlobal().info(Solution.getInstance().field.toString());

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 2289);
    }

    @Test
    public void getTestResult2 () {
        List<String> input = Solution.getPuzzleTestInput();
        Long result = Solution.getInstance().solveTask2(input);

        Logger.getGlobal().info(Solution.getInstance().field.toString());

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 26);
    }


    @Test
    public void getResult2 () {
        List<String> input = Solution.getPuzzleInput();
        Long result = Solution.getInstance().solveTask2(input);

        Logger.getGlobal().info(Solution.getInstance().field.toString());

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 2738);
    }






}
