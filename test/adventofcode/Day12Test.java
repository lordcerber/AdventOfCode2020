package adventofcode;

import adventofcode.Day12.Cell;
import adventofcode.Day12.Solution;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

public class Day12Test {



    @Test
    public void getTestResult () {
        List<String> input = Solution.getPuzzleTestInput();
        Long result = Solution.getInstance().solveTask1(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 25);
    }

    @Test
    public void getResult () {
        List<String> input = Solution.getPuzzleInput();
        Long result = Solution.getInstance().solveTask1(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 1007);
    }

    @Test
    public void getTestResult2 () {
        List<String> input = Solution.getPuzzleTestInput();
        Long result = Solution.getInstance().solveTask2(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 286);
    }

    @Test
    public void getResult2 () {
        List<String> input = Solution.getPuzzleInput();
        Long result = Solution.getInstance().solveTask2(input);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result == 41212);
    }

    @Test
    public void testRotation() {
        // bacause i am not sure in my trigonometry
        Assert.assertTrue(testVectorRotation(-1,2,"L",180,1,-2));
        Assert.assertTrue(testVectorRotation(1,2,"R",180,-1,-2));
        Assert.assertTrue(testVectorRotation(1,2,"L",90,-2,1));
    }


    public boolean testVectorRotation(int c1, int r1, String operation, int rad, int c2, int r2){
        Cell test = new Cell(c1, r1);
        test.vectorRotate(operation,rad);
        Cell expect = new Cell(c2,r2);
        return test.equals(expect);
    }






}
