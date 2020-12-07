package adventofcode;

import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class Day2 {

    public static List<String> getSavedReport () {
        return AdventureHelper.getFileByLines("Day2/Input");
    }

    public static Boolean checkPassword(String line) {
        Pattern pattern = Pattern.compile("(?<min>\\d+)(-)(?<max>\\d+)(\\s)(?<symbol>\\w+)(:)(\\s)(?<string>\\w+)");
        Matcher matcher = pattern.matcher(line);
        matcher.matches();
        int min = Integer.parseInt(matcher.group("min"));
        int max = Integer.parseInt(matcher.group("max"));
        String symbol = matcher.group("symbol");
        String password = matcher.group("string");

        int count = StringUtils.countMatches(password, symbol);

        if (count >= min && count <= max) return true;
        return false;
    }

    public static Boolean checkPassword2(String line) {
        Pattern pattern = Pattern.compile("(?<min>\\d+)(-)(?<max>\\d+)(\\s)(?<symbol>\\w+)(:)(\\s)(?<string>\\w+)");
        Matcher matcher = pattern.matcher(line);
        matcher.matches();
        int min = Integer.parseInt(matcher.group("min"));
        int max = Integer.parseInt(matcher.group("max"));
        String symbol = matcher.group("symbol");
        String password = matcher.group("string");

        if (min>password.length() || max > password.length()) return false; //index out of bounds failsafe
        String s1 = password.substring(min-1,min);
        String s2 = password.substring(max-1,max);

        String debug = "for password "+line+ " symbols are " + s1 + " " +s2 + " result is " + ((StringUtils.countMatches(s1+s2,symbol) == 1)?"true":"false");
        Logger.getGlobal().info(debug);
        if (StringUtils.countMatches(s1+s2,symbol) == 1) return true; //instead of huge logic

        return false;
    }

    public static Integer countReport () {
        List<String> report = getSavedReport();

        int counter = 0;
        for (String line : report) {
            if (checkPassword(line)) counter++;
        }
        return counter;
    }

    public static Integer countReport2 () {
        List<String> report = getSavedReport();

        int counter = 0;
        for (String line : report) {
            if (checkPassword2(line)) counter++;
        }
        return counter;
    }

}
