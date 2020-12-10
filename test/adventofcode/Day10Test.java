package adventofcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

public class Day10Test {



    @Test
    public void getResult () {
        List<Long> input = Day10.convertInput(Day10.getPuzzleInput());
        Long result = Day10.solveTask1(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 2738);
    }



    @Test
    public void getResult2 () {
        List<Long> input = Day10.convertInput(Day10.getPuzzleInput());
        Long result = Day10.getInstance().solveTask2(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 2738);
    }




}
