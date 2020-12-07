package adventofcode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {

    private static final Random R = new Random();

    public static long ExpenseReportCalculation(List<Integer> report, int expectation) {
        long answer = 0;


        int size = report.size();
        Integer val1 = 0;
        Integer val2 = 0;
        //simple double iteration. possibly there is a more euristic way, like sorting and then summ biggest with smallest in approaching loops

        loop:
        for (int i = 0; i < size; i++) {
            val1 = report.get(i);
            for (int j = i + 1; j < size; j++) {
                val2 = report.get(j);
                if (val1 + val2 == expectation) break loop;
            }
        }

        //a lot of unhandled error cases here... maybe fix that
        Logger.getGlobal().info("answer is " + val1 + " * " + val2 + " = " + val1*val2);
        answer = val1*val2;

        return answer;
    }

    public static long ExpenseReportCalculationTriplet(List<Integer> report, int expectation) {
        long answer = 0;


        int size = report.size();
        Integer val1 = 0;
        Integer val2 = 0;
        Integer val3 = 0;
        //simple double iteration. possibly there is a more euristic way, like sorting and then summ biggest with smallest in approaching loops

        loop:
        for (int i = 0; i < size; i++) {
            val1 = report.get(i);
            for (int j = i + 1; j < size; j++) {
                val2 = report.get(j);
                for (int k = j + 1; k < size; k++) {
                    val3 = report.get(k);
                    if (val1 + val2 + val3 == expectation) break loop;
                }
            }
        }

        //a lot of unhandled error cases here... maybe fix that
        Logger.getGlobal().info("answer is " + val1 + " * " + val2 +" * "+val3+ " = " + val1*val2*val3);
        answer = val1*val2*val3;

        return answer;
    }

    public static long ExpenseReportCalculationOneIteration(List<Integer> report, int expectation) {
        long answer = 0;

        int size = report.size();
        Integer val1 = 0;
        Integer val2 = 0;

        HashMap<Integer, Integer> rMap = new HashMap<Integer, Integer>();
        loop:
        for (int i = 0; i < size; i++) {
            val1 = report.get(i);
            if (rMap.containsKey(expectation - val1)) {
                val2 = expectation - val1;
                break loop;
            }
            else {
                rMap.put(val1,i);
            }
        }
        //a lot of unhandled error cases here... maybe fix that
        Logger.getGlobal().info("answer is " + val1 + " * " + val2 + " = " + val1*val2);
        answer = val1*val2;
        return answer;
    }

    public static long ExpenseReportCalculationOneIterationTripleFun(List<Integer> report, int expectation) {
        long answer = 0;

        int size = report.size();
        Integer val1 = 0;
        Integer val2 = 0;
        Integer val3 = 0;

        HashMap<Integer, Integer> rMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> sMap = new HashMap<Integer, Integer>();
        loop:
        for (int i = 0; i < size; i++) {
            val1 = report.get(i);
            if (rMap.containsKey(expectation - val1)) {
                val2 = expectation - val1;
                break loop;
            }
            else {
                rMap.put(val1,i);
            }
        }
        //a lot of unhandled error cases here... maybe fix that
        Logger.getGlobal().info("answer is " + val1 + " * " + val2 + " = " + val1*val2);
        answer = val1*val2;
        return answer;
    }

    public static long ExpenseReportCalculationSortedList(List<Integer> report, int expectation) {
        long answer = 0;

        int size = report.size();
        Integer val1 = 0;
        Integer val2 = 0;

        report.sort(Integer::compareTo);
        loop:
        for (int i = 0; i < size; i++) {
        val1 = report.get(i);

            for (int j = size-1; j > i; j--) {
                val2 = report.get(j);
                if (val1 + val2 < expectation) {
                    break; //stop this iteration, there wont be any more numbers that summ to 2020 here
                }
                else if (val1 + val2 == expectation) break loop;
            }
        }
        Logger.getGlobal().info("answer is " + val1 + " * " + val2 + " = " + val1*val2);
        answer = val1*val2;
        return answer;
    }


    public static List<Integer> getSavedReport () {
        return getSavedReport("Day1/Input");
    }
    public static List<Integer> getSavedReport (String filename) {
        List<Integer> result = null;
        try (Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource(filename).toURI()))) {
            result = (lines.map(s -> Integer.parseInt(s)).collect(Collectors.toList()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Integer> generateRandomReport (int expectedSize, int expectationUnequal) {
        if (expectationUnequal % 2 == 0) expectationUnequal++; //сделаем результат нечетным
        // идея такая, генерить случайные четные числа и вставить одно нечетное чтоб оно давало реультат.
        List<Integer> result = new ArrayList<Integer>();
        int trueValue1 = R.nextInt(expectationUnequal-1);
        if (trueValue1 % 2 == 1) trueValue1--;
        int trueValue2 = expectationUnequal-trueValue1;
        int position1 = R.nextInt(expectedSize-1);
        int position2 = R.nextInt(expectedSize-1);

        Logger.getGlobal().info("true values are " + trueValue1 + " and " + trueValue2 + " at positions " + position1 +" " + position2);

        while (result.size()<expectedSize) {
            if (result.size() == position1) {result.add(trueValue1);}
            else if (result.size() == position2) {result.add(trueValue2);}
            else {
                int falseValue = R.nextInt(expectationUnequal-1);
                if (falseValue % 2 == 1) falseValue--;
                if (falseValue != trueValue1) result.add(falseValue);
            }
        }
        return result;
    }


}
