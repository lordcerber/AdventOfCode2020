package adventofcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class Day3Test {

    @Test
    public void getResult () {
        Integer result = Day3.hereWeRide(3,1);

        Logger.getGlobal().info("answer is "+ result);

        Assert.assertTrue(result>0);
    }

    @Test
    public void getResultPart2 () {
        Integer result1 = Day3.hereWeRide(1,1);
        Integer result2 = Day3.hereWeRide(3,1);
        Integer result3 = Day3.hereWeRide(5,1);
        Integer result4 = Day3.hereWeRide(7,1);
        Integer result5 = Day3.hereWeRide(1,2);
        Logger.getGlobal().info("answer is "+ result1 + " " + result2 + " " + result3 + " " + result4 + " " + result5);
BigDecimal total = BigDecimal.valueOf(result1).multiply(BigDecimal.valueOf(result2)).multiply(BigDecimal.valueOf(result3)).multiply(BigDecimal.valueOf(result4)).multiply(BigDecimal.valueOf(result5)) ;
        Logger.getGlobal().info("answer is "+ total.toPlainString());



    }

}
