package adventofcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Day6Test {

    @Test
    public void getResult () {
        List<String> input = Day6.getPuzzleInput();

        List<Map<String, Integer>> map = Day6.parceInput(input);

        Integer result = Day6.getFirstAnswer(map);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result > 0);
    }

    @Test
    public void getResult2 () {
        List<String> input = Day6.getPuzzleInput();

        List<Map<String, Integer>> map = Day6.parceInput(input);

        Integer result = Day6.getSecondAnswer(map);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result > 0);
    }


}
