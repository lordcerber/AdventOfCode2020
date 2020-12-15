package adventofcode;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day15 {
    //bitmasks. i have no idea how to work with core bitmasks
    private static volatile Day15 instance = null;

    private Day15() {
    }

    public static Day15 getInstance() {
        if (instance == null) {
            synchronized (Day15.class) {
                if (instance == null) {
                    instance = new Day15();
                }
            }
        }
        return instance;
    }

    public static long solveTask1(List<Long> report, Long limit) {
        HashMap<Long,Long> gameLog = new HashMap();
        Long turn = 0L;
        Long lastNumber=0L;
        Long nextNumber=0L;
        for (;turn < report.size();turn++) {
            nextNumber = report.get(turn.intValue());
            if (turn>0) gameLog.put(lastNumber, turn);
            lastNumber=nextNumber;
        }

        while (turn < limit) {
            if (gameLog.containsKey(lastNumber)) nextNumber=turn-gameLog.get(lastNumber);
            else nextNumber=0L;
            gameLog.put(lastNumber, turn);
            //System.out.println("turn:"+turn + " we say:"+nextNumber);
            lastNumber=nextNumber;
            turn++;
        }
        return nextNumber;
    }

}