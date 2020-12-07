package adventofcode;

import java.util.List;

public class Day3 {

    public static List<String> getSavedReport () {
        return AdventureHelper.getFileByLines("Day3/Input");
    }

    public static Integer hereWeRide (int right, int down) {
        List<String> slope = getSavedReport();
        int slide = 0;
        int trees = 0;
        for (int i = 0; i< slope.size(); i+= down) {
            String line = slope.get(i);
            while (slide >= line.length()) {
                slide = slide - line.length(); //looping world
            }
            if (line.substring(slide, slide+1).contentEquals("#")) {
                trees++;
            }
            slide += right;
        }
        return trees;

    }



}
