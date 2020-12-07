package adventofcode.day7;

import adventofcode.AdventureHelper;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

//    light red bags contain 1 bright white bag, 2 muted yellow bags.
//    dark orange bags contain 3 bright white bags, 4 muted yellow bags.
//    bright white bags contain 1 shiny gold bag.
//    muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
//    shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
//    dark olive bags contain 3 faded blue bags, 4 dotted black bags.
//    vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
//    faded blue bags contain no other bags.
//    dotted black bags contain no other bags.

    //so how does that look like
    //a tree no less. unique key is 2-word color. then "bags contain" than multiple choises.
    //the outer key may contain multiple inner keys.

    //i need an object @bag
    //and class will be non-static. let it be singletone

    public static List<String> getPuzzleInput() {
        return AdventureHelper.getFileByLines("Day7/Input");
    }

    private HashMap<String, Bag> Bags = new HashMap<>();

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

    public void parseInput(String input) {

        Pattern pattern = Pattern.compile("(?<color>\\w+ \\w+)( bags contain )(?<tail>.+)");
        Matcher matcher = pattern.matcher(input);
        matcher.matches();
        String color = matcher.group("color");
        String tail = matcher.group("tail");

        Bag bag = getBag(color);

        //skip ending bags
        if (!tail.contains("no other bags")) {
            for (String Tails : tail.split(", ")) {
                Pattern tailPattern = Pattern.compile("(?<count>\\d+)(\\s)(?<color>\\w+ \\w+)(.+)");
                Matcher tailMatcher = tailPattern.matcher(Tails);
                tailMatcher.matches();
                int count = Integer.parseInt(tailMatcher.group("count"));
                String tailColor = tailMatcher.group("color");
                bag.add(tailColor, count);
            }
        }

    }

    public Bag getBag(String color) {
        if (Bags.containsKey(color)) return Bags.get(color);
        else {
            Bags.put(color, new Bag(color));
            return getBag(color);
        }
    }

    //если я не накосячил то все готово, теперь решать задачку

    public int taskOneFindContainers(String color) {
        int count = 0;
        for (Bag bag : Bags.values()) {
            if (!bag.isColor(color) && bag.containsAnyDepth(color)) count++;
        }
        return count;
    }

    public int taskTwoCountTreeSize(String color) {
        return getBag(color).countInnerTree() - 1;

    }
}
