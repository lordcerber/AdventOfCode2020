package adventofcode;

import java.util.*;

public class Day6 {

    //looks easy. read series of lines. get unique letters
    // ill make list of maps. key is the letter, value is cout repeats (in case second question will need smth like that)

    public static List<String> getPuzzleInput() {
        return AdventureHelper.getFileByLines("Day6/Input");
    }


    public static List<Map<String, Integer>> parceInput(List<String> input) {

        List<Map<String, Integer>> result = new ArrayList();

        Map<String, Integer> answers = new HashMap<String, Integer>();

        int lines = 0;
        for (String line : input) {
            if (line.length() == 0) {
                //here i change value of each entry to lines-curent value
                //so if all answered it is 0
                //if all but one it is -1 and so on
                result.add(Map.copyOf(encodeGroupSizeDelta (answers,lines)));
                answers.clear();
                lines=0;
            } else {
                lines++;
                for (String entry : Arrays.asList(line.split("(?!^)"))) {
                    if(!answers.containsKey(entry)) answers.put(entry, 1);
                    else answers.put(entry,answers.get(entry)+1);
                }
            }
        }
        result.add(Map.copyOf(encodeGroupSizeDelta (answers,lines)));

        return result;

    }

    private static Map<String, Integer> encodeGroupSizeDelta(Map<String, Integer> answers, int lines) {
        for (String key:answers.keySet()) {
            answers.put(key,answers.get(key)-lines); //that will make question answered by all have value 0, other less then zero
        }
        return answers;
    }

    public static Integer getFirstAnswer (List<Map<String, Integer>> input) {
    //any unique answer
        Integer summ = 0;

        for (Map<String, Integer> group:input) {
            summ += group.size();
        }
        return summ;
    }

    public static Integer getSecondAnswer (List<Map<String, Integer>> input) {
        //only answer that everybody answered
        Integer summ = 0;

        for (Map<String, Integer> group:input) {
            for (String key:group.keySet()) {
                if (group.get(key)==0) summ++;
            }
        }
        return summ;
    }


}
