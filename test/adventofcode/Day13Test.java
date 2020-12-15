package adventofcode;

import adventofcode.Day12.Cell;
import adventofcode.Day12.Solution;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

public class Day13Test {



    @Test
    public void getTestResult () {
        List<String> input = Day13.getPuzzleTestInput();
        Long result = Day13.solveTask1(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 295);
    }

    @Test
    public void getResult () {
        List<String> input = Day13.getPuzzleInput();
        Long result = Day13.solveTask1(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 2095);
    }

    //i am sure i made an awful solution
    @Test
    public void getTestResult2_1 () {
        List<String> input = List.of("17,x,13,19".split(","));
        BigDecimal result = Day13.getInstance().raceSceldue(input);

        Logger.getGlobal().info("answer is "+ result.toString());

        Assert.assertTrue(result.toString().equals("3417"));
    }

    //i am sure i made an awful solution
    @Test
    public void getTestResult2_2 () {
        List<String> input = List.of("1789,37,47,1889".split(","));
        BigDecimal result = Day13.getInstance().raceSceldue(input);

        Logger.getGlobal().info("answer is "+ result.toString());

        Assert.assertTrue(result.toString().equals("1202161486"));
    }

    @Test
    public void getResult2 () {
        List<String> input = Day13.getPuzzleInput();
        BigDecimal result = Day13.getInstance().solveTask2(input);

        Logger.getGlobal().info("answer is "+ result.toString());

        Assert.assertTrue(result.toString().equals("3417"));
    }








}
