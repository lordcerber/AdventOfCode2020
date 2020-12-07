package adventofcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Day4Test {

    @Test
    public void getResult () {
        List<String> input = Day4.getPuzzleInput();
        List<Map> passports = Day4.decodeInputData(input);
        int count = 0;
        for (Map passport:passports) {
            if (Day4.validatePassportFieldsPresent(passport)) count++;
        }
        Logger.getGlobal().info("answer is "+ count);

        Assert.assertTrue(count > 0);
    }

    @Test
    public void getResultPart2 () {
        List<String> input = Day4.getPuzzleInput();
        List<Map> passports = Day4.decodeInputData(input);
        int count = 0;
        for (Map passport:passports) {
            if (
                    Day4.validatePassportFieldsPresent(passport) &&
            Day4.validatePassportFieldsValid(passport)) count++;
        }
        Logger.getGlobal().info("answer is "+ count);

        Assert.assertTrue(count > 0);
    }

}
