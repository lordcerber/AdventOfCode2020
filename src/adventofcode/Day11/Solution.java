package adventofcode.Day11;

import adventofcode.AdventureHelper;

import java.util.List;
import java.util.logging.Logger;

public class Solution {
    //hey this task ihas a rules of "LIFE" game popular at DOS times among coders.
    //unfortunately java as awful to work with string
    //i have an idea how to cantain a object level of life
    private static volatile Solution instance = null;
    public Field field;

    private Solution() {
    }

    public static Solution getInstance() {
        if (instance == null) {
            synchronized (Solution.class) {
                if (instance == null) {
                    instance = new Solution();
                }
            }
        }

        return instance;
    }

    public static List<String> getPuzzleInput() {
        return AdventureHelper.getFileByLines("Day11/Input");
    }
    public static List<String> getPuzzleTestInput() {
        return AdventureHelper.getFileByLines("Day11/TestInput");
    }

    public long solveTask1 (List<String> input) {
        field = new Field(input, "L");
            //Logger.getGlobal().info(Solution.getInstance().field.toString());
        while (field.advanceTimeRule1()>0L) {
            //Logger.getGlobal().info(Solution.getInstance().field.toString());
        }

        return field.countActiveCells();
    }

    public long solveTask2 (List<String> input) {
        field = new Field(input, "L");
            //Logger.getGlobal().info(Solution.getInstance().field.toString());
        while (field.advanceTimeRule2()>0L) {
            //Logger.getGlobal().info(Solution.getInstance().field.toString());
        }

        return field.countActiveCells();
    }


}
