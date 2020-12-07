package adventofcode;

import adventofcode.day5.Seat;
import adventofcode.day5.Solution;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Day5Test {

    @Test
    public void getResult () {
        List<String> input = Solution.getPuzzleInput();
        List<Seat> plane = input.stream().map(s -> Solution.decodeBinaryPlacement(s)).collect(Collectors.toList());

        Logger.getGlobal().info("answer is "+ Solution.getHighestSeatID(plane));

        Assert.assertTrue(Solution.getHighestSeatID(plane) > 0);
    }

    @Test
    public void getResult2 () {
        List<String> input = Solution.getPuzzleInput();
        List<Seat> plane = input.stream().map(s -> Solution.decodeBinaryPlacement(s)).collect(Collectors.toList());

        Logger.getGlobal().info("answer is "+ Solution.getEmptySeatID(plane));

        Assert.assertTrue(Solution.getEmptySeatID(plane) > 0);
    }


}
