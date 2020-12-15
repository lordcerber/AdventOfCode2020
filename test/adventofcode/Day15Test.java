package adventofcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Day15Test {



    @Test
    public void getTestResult () {
        Long result = Day15.solveTask1(List.of(0L,3L,6L),2020L);
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(436L));
    }


    @Test
    public void getTestResult2 () {
        Long result = Day15.solveTask1(List.of(1L,3L,2L),2020L);
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(1L));
    }

    @Test
    public void getTestResult3 () {
        Long result = Day15.solveTask1(List.of(2L,1L,3L),2020L);
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(10L));
    }

    @Test
    public void getTestResult4 () {
        Long result = Day15.solveTask1(List.of(1L,2L,3L),2020L);
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(27L));
    }

    @Test
    public void getTestResult5 () {
        Long result = Day15.solveTask1(List.of(2L,3L,1L),2020L);
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(78L));
    }

    @Test
    public void getTestResult6 () {
        Long result = Day15.solveTask1(List.of(3L,2L,1L),2020L);
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(438L));
    }

    @Test
    public void getTestResult7 () {
        Long result = Day15.solveTask1(List.of(3L,1L,2L),2020L);
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(852L));
    }

    @Test
    public void getResult () {
        Long result = Day15.solveTask1(List.of(0L,3L,1L,6L,7L,5L),2020L);
        Logger.getGlobal().info("answer is "+ result);
        Assert.assertTrue(result.equals(1836L));
    }


    @Test
    public void getResult2 () {
        long time = System.currentTimeMillis();
        Long result = Day15.solveTask1(List.of(0L,3L,1L,6L,7L,5L),30000000L);
        Logger.getGlobal().info("in "+(System.currentTimeMillis()-time)+"ms answer is "+ result);
        Assert.assertTrue(result.equals(6007666L));
    }



}
