package adventofcode;

import adventofcode.day7.Solution;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

public class Day7Test {

    @Test
    public void getTestResult () {
        List<String> input = AdventureHelper.getFileByLines("Day7/TestInput1");

        for (String line : input) {
            Solution.getInstance().parseInput(line);
        }

        Integer result = Solution.getInstance().taskOneFindContainers("shiny gold");

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 4);
    }

    @Test
    public void getResult () {
        List<String> input = Solution.getInstance().getPuzzleInput();

        for (String line : input) {
            Solution.getInstance().parseInput(line);
        }

        Integer result = Solution.getInstance().taskOneFindContainers("shiny gold");

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result > 233);
    }

    @Test
    public void getTestResult2 () {
        List<String> input = AdventureHelper.getFileByLines("Day7/TestInput2");

        for (String line : input) {
            Solution.getInstance().parseInput(line);
        }

        Integer result = Solution.getInstance().taskTwoCountTreeSize("shiny gold");

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result > 0);
    }

    @Test
    public void getResult2 () {
        List<String> input = Solution.getInstance().getPuzzleInput();

        for (String line : input) {
            Solution.getInstance().parseInput(line);
        }

        Integer result = Solution.getInstance().taskTwoCountTreeSize("shiny gold");

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 421550);
    }


}
