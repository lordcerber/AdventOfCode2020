package adventofcode;

import adventofcode.day7.Solution;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Day10 {
    //rather strange task
    private static volatile Day10 instance = null;

    private Day10() {
    }

    public static Day10 getInstance() {
        if (instance == null) {
            synchronized (Day10.class) {
                if (instance == null) {
                    instance = new Day10();
                }
            }
        }

        return instance;
    }

    public static List<String> getPuzzleInput() {
        return AdventureHelper.getFileByLines("Day10/Input");
    }
    public static List<String> getPuzzleTestInput() {
        return AdventureHelper.getFileByLines("Day10/TestInput");
    }

    public static List<Long> convertInput(List<String>input) {
        return (input.stream().map(s -> Long.parseLong(s)).collect(Collectors.toList()));
    }

    public static long solveTask1(List<Long> report) {
        long answer = 0;

        report.sort(Long::compareTo);
        Long val1 = 0L;
        Long val2 = 1l; //the final value always a three;
        long tick = 0;
        loop:
        for (Long tock : report) {
            long delta = tock-tick;
            if (delta == 1 ) val1++;
            if (delta == 3 )val2++;
            tick = tock;
        }
        answer = val1*val2;
        return answer;
    }

//ok task 2 is a little more interesting;
//there should be an easy math way... cant thing of one now

    public long solveTask2(List<Long> report) {
        HashMap<Long, Connector> map = new HashMap<Long, Connector>();
        List<Integer> deltas = List.of(1,2,3);

        report.sort(Long::compareTo);

        map.put(0L,new Connector(0L));

        loop:
        for (Long tock : report) {
            Connector con = new Connector(tock);
            map.put(tock, con);
            for (int d:deltas) {
                if (map.containsKey(tock-d)) map.get(tock-d).addLink(con);
            }
        }
        //last one is always a single 3 connector so no counting;
        Long answer = map.get(0L).getTree();
        return answer;
    }

    private class Connector {
        private final Long self;
        private HashMap <Connector, Long> links = new HashMap<>();

        public Connector(Long i) {
            self = i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Connector connector = (Connector) o;
            return self.equals(connector.self);
        }

        @Override
        public int hashCode() {
            return Objects.hash(self);
        }

        public void addLink(Connector tock) {
            links.put(tock, tock.self - this.self);
        }

        Long tree; //this i hope reduses calculation time;
        public Long getTree() {
            if (tree == null) {
                AtomicLong summ = new AtomicLong(links.size()>0 ? links.size():1);
                //even more crazy recursion
                links.forEach((link, b) -> {
                    summ.addAndGet(link.getTree() - 1);
                });
                tree = summ.get();
            }
            return tree;
        }
    }
}
