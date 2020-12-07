package adventofcode;

import com.google.common.collect.Lists;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Day1Test {

    @Test(groups = {"fast"})
    public void TestExampleList () {
        ArrayList<Integer> example = Lists.newArrayList(
                1721,
                979,
                366,
                299,
                675,
                1456
        );

        long result = Day1.ExpenseReportCalculation(example, 2020);

        Assert.assertEquals(result, 514579);
    }

    @Test(groups = {"fast"})
    public void TestReportLocal () {
        List<Integer> report = Day1.getSavedReport();

        Logger.getGlobal().info(report.toString());

        Assert.assertNotNull(report);
    }


    @Test(groups = {"fast"})
    public void TestAnswerWithLocalReport () {
        List<Integer> report = Day1.getSavedReport();

        Logger.getGlobal().info(report.toString());

        long result = Day1.ExpenseReportCalculation(report, 2020);

        Logger.getGlobal().info("answer is = "+result);


        Assert.assertNotNull(result);
    }

    @Test(groups = {"fast"})
    public void TestAnswerTripletWithLocalReport () {
        List<Integer> report = Day1.getSavedReport();

        Logger.getGlobal().info(report.toString());

        long result = Day1.ExpenseReportCalculationTriplet(report, 2020);

        Logger.getGlobal().info("answer is = "+result);


        Assert.assertNotNull(result);
    }

    @Test(groups = {"exploration"})
    public void TestSpeedOfAlgorythm () {
        int mult = 1000;
        int size = 100*mult;
        int expectation = 50*mult+1;
        List<Integer> report = Day1.generateRandomReport(size,expectation);


        long time = System.currentTimeMillis();
        long result1 = Day1.ExpenseReportCalculationOneIteration(report, expectation);
        Logger.getGlobal().info("ExpenseReportCalculationOneIteration took " + (System.currentTimeMillis() - time) + " MS");

        time = System.currentTimeMillis();
        long result2 = Day1.ExpenseReportCalculationSortedList(report, expectation);
        Logger.getGlobal().info("ExpenseReportCalculationSortedList took " + (System.currentTimeMillis() - time) + " MS");

        time = System.currentTimeMillis();
        long result3 = Day1.ExpenseReportCalculation(report, expectation);
        Logger.getGlobal().info("ExpenseReportCalculation took " + (System.currentTimeMillis() - time) + " MS");

        Assert.assertEquals(result1, result2);
        Assert.assertEquals(result1, result3);
    }

}
