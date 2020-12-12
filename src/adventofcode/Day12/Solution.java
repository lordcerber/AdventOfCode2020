package adventofcode.Day12;

import adventofcode.AdventureHelper;
import adventofcode.Day11.Field;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    //a tortoise emulation.
    //i have played that as a kid

    private static volatile Solution instance = null;

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
        return AdventureHelper.getFileByLines("Day12/Input");
    }
    public static List<String> getPuzzleTestInput() {
        return AdventureHelper.getFileByLines("Day12/TestInput");
    }

    public long solveTask1 (List<String> input) {
        Cell ship = new Cell(0,0);

        for (String comand: input) {
            Pattern pattern = Pattern.compile("(?<operation>\\w)(?<value>\\d+)");
            Matcher matcher = pattern.matcher(comand);
            matcher.matches();
            String operation = matcher.group("operation");
            int value = Integer.parseInt(matcher.group("value"));
            ship.move(operation, value);
        }

        return Math.abs(ship.getCol())+Math.abs(ship.getRow());

    }

    public long solveTask2 (List<String> input) {
        Cell ship = new Cell(0,0);
        Cell vector = new Cell(0,0);
        vector.move("E",10);
        vector.move("N",1);

        for (String comand: input) {
            Pattern pattern = Pattern.compile("(?<operation>\\w)(?<value>\\d+)");
            Matcher matcher = pattern.matcher(comand);
            matcher.matches();
            String operation = matcher.group("operation");
            int value = Integer.parseInt(matcher.group("value"));
            if("SNEW".contains(operation))
                vector.move(operation, value);
            else if("LR".contains(operation))
                vector.vectorRotate(operation,value);
            else if(operation.equals("F"))
                ship.move(vector,value);
        }
        return Math.abs(ship.getCol())+Math.abs(ship.getRow());
    }


}
