package adventofcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class Day18Test {


    @Test
    public void getTestResult () {

        Assert.assertEquals(26, Day18.getInstance().calculateLine("2 * 3 + (4 * 5)"));
        Day18.getInstance().reset();
        Assert.assertEquals(437, Day18.getInstance().calculateLine("5 + (8 * 3 + 9 + 3 * 4 * 3)"));
        Day18.getInstance().reset();
        Assert.assertEquals(12240, Day18.getInstance().calculateLine("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"));
        Day18.getInstance().reset();
        Assert.assertEquals(13632, Day18.getInstance().calculateLine("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"));
    }

    @Test
    public void getResult1 () {
        Long result = Day18.getInstance().solveTask1(Day18.getPuzzleInput());
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(7293529867931L));
    }

    @Test
    public void getResult2 () {
        Long result = Day18.getInstance().solveTask2(Day18.getPuzzleInput());
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(60807587180737L));
    }

    @Test
    public void getTestResult2 () {

        Assert.assertEquals(testLine2("1 + (2 * 3) + (4 * (5 + 6))"),51);
        Day18.getInstance().reset();
        Assert.assertEquals(46, testLine2("2 * 3 + (4 * 5)"));
        Day18.getInstance().reset();
        Assert.assertEquals(1445, testLine2("5 + (8 * 3 + 9 + 3 * 4 * 3)"));
        Day18.getInstance().reset();
        Assert.assertEquals(669060, testLine2("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"));
        Day18.getInstance().reset();
        Assert.assertEquals(23340, testLine2("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"));
    }

    public long testLine2 (String line) {
        line =Day18.getInstance().calculateLine2(line);
        Day18.getInstance().reset();
        return Day18.getInstance().calculateLine(line);
    }


    



}
