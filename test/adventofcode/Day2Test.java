package adventofcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

public class Day2Test {

    @Test
    public void getResult () {
        Integer result = Day2.countReport();

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result>0);
    }

    @Test
    public void getResultTask2 () {
        Integer result = Day2.countReport2();

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result>0);
    }

    @Test
    public void TestMatcher () {

        Assert.assertTrue(Day2.checkPassword("1-3 a: abcde"));
        Assert.assertFalse(Day2.checkPassword("1-3 b: cdefg"));
        Assert.assertTrue(Day2.checkPassword("2-9 c: ccccccccc"));
    }

    @Test
    public void TestMatcher2 () {

        Assert.assertTrue(Day2.checkPassword2("1-3 a: abcde"));
        Assert.assertFalse(Day2.checkPassword2("1-3 b: cdefg"));
        Assert.assertFalse(Day2.checkPassword2("2-9 c: ccccccccc"));
    }
}
