package adventofcode;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class Day13 {
    //rather strange task
    private static volatile Day13 instance = null;

    private Day13() {
    }

    public static Day13 getInstance() {
        if (instance == null) {
            synchronized (Day13.class) {
                if (instance == null) {
                    instance = new Day13();
                }
            }
        }

        return instance;
    }

    public static List<String> getPuzzleInput() {
        return AdventureHelper.getFileByLines("Day13/Input");
    }

    public static List<String> getPuzzleTestInput() {
        return AdventureHelper.getFileByLines("Day13/TestInput");
    }

    public static long solveTask1(List<String> report) {
        long startTime = Long.decode(report.get(0));
        long answer = 0;
        List<String> busses = List.of(report.get(1).split(","));

        List<Integer> workingBusses = (busses.parallelStream()
                .filter(b -> !b.equals("x"))
                .map(b -> Integer.parseInt(b))
                .collect(Collectors.toList()));

        long smallestDelta = -1;
        int nearestBus = 0;
        for (int bus : workingBusses) {
            long time = 0;
            while (time < startTime) time += bus; //too direct, i cant think well
            if (smallestDelta < 0 || time - startTime < smallestDelta) {
                smallestDelta = time - startTime;
                nearestBus = bus;
            }
        }
        answer = nearestBus * smallestDelta;
        return answer;
    }

//task2 requires a very big number for answer and probably quicker way to calculate.
    //but first the stupid method

    public BigDecimal solveTask2(List<String> report) {
        long startTime = Long.decode(report.get(0));
        long answer = 0;
        List<String> busses = List.of(report.get(1).split(","));
        return raceSceldue(busses);
    }

    public BigDecimal raceSceldue(List<String> busses) {
        List<Integer> workingBusses = (busses.parallelStream()
                .filter(b -> !b.equals("x"))
                .map(b -> Integer.parseInt(b))
                .collect(Collectors.toList()));
        workingBusses.sort(Integer::compareTo);
        //Collections.reverse(workingBusses);
        HashMap<Integer, Integer> offsetMap = new HashMap<>();
        //mark up the offsets
        for (int bus : workingBusses) {
            offsetMap.put(bus, busses.indexOf(String.valueOf(bus)));
        }

        List<Bus> racers = new ArrayList<Bus>();
        for (int bus : workingBusses) {
            //make offset a negative start position
            racers.add(new Bus(bus, - busses.indexOf(String.valueOf(bus))));
        }


        return race2(racers);
    }

    //this works but takes at least 60 hours to calculate
    private BigDecimal race(List<Bus> racers) {
        long loop = racers.get(racers.size() - 1).id.longValue(); //move largest number
        BigDecimal time = BigDecimal.valueOf(racers.get(0).offset.longValue());
        long timelog = System.currentTimeMillis() + 1000;
        while (true) {
            time = time.add(BigDecimal.valueOf(loop));
            loop:
            {
                for (Bus bus : racers) {
                    if (!bus.catchUp(time)) break loop;
                }
                return time;
            }

            if (System.currentTimeMillis() > timelog) {
                timelog = System.currentTimeMillis() + 60000;
                System.out.println("racing " + time.toString());
            }
        }
    }

    private BigDecimal race2(List<Bus> racers) {
        return racers.remove(0).runWith(racers);
    }

    private BigDecimal calcDistance(BigDecimal id, BigDecimal id1) {
        Bus b1 = new Bus(id, new BigDecimal(0));
        Bus b2 = new Bus(id1, new BigDecimal(0));
        b1.advance();
        while (!b1.catchUp2(b2.pos)) b2.advance();
        return b1.pos;
    }

    private class Bus implements Comparable<Bus> {
        private BigDecimal id;
        private BigDecimal offset;
        private BigDecimal pos;

        public Bus(int bus, long indexOf) {
            offset = new BigDecimal(indexOf);
            id = new BigDecimal(bus);
            pos = new BigDecimal(indexOf);
        }

        public Bus(BigDecimal period, BigDecimal off) {
            offset = off;
            id = period;
            pos = off;
        }

        public void advance() {
            pos = pos.add(id);
        }

        public boolean catchUp(BigDecimal time) {
            BigDecimal goal = time.add(offset);
            while (pos.compareTo(goal) < 0) {
                advance();
            }
            if (pos.compareTo(goal) == 0) return true;
            return false;
        }

        public boolean catchUp2(BigDecimal time) {
            while (pos.compareTo(time) < 0) {
                if (time.subtract(pos).compareTo(id)>0) {
                BigDecimal distance = time.subtract(pos).divide(id,0, RoundingMode.DOWN);
                advance(distance);
                }
                else advance();
            }
            if (pos.compareTo(time) == 0) return true;
            return false;
        }

        private void advance(BigDecimal distance) {
            pos = pos.add(distance.multiply(id));
        }

        public BigDecimal runWith(List<Bus> others) {
            //so after first meeting up, each two busses will be meeting in equal periods of time.
            if (others.size() > 1) {
                Bus bus2 = others.remove(0);
                System.out.println("racing " + this.toString() + bus2.toString());
                long t = System.currentTimeMillis();
                while (!bus2.catchUp2(pos)) catchUp2(bus2.pos);
                System.out.println("race done at" + this.toString() + bus2.toString() + "in " + (System.currentTimeMillis()-t)+"ms");
                //here we have bus1 and bus2 on the same position pos
                BigDecimal period = calcDistance(this.id, bus2.id);
                Bus chimera = new Bus(period, this.pos);
                System.out.println(this.toString() + bus2.toString() + "formed chimera as "+chimera.toString());
                others.add(chimera);
                Collections.sort(others);
                //Collections.reverse(others);
                return others.remove(0).runWith(others);
            }
            else {
                //other.size=1
                Bus bus2 = others.remove(0);
                System.out.println("racing " + this.toString() + bus2.toString());
                long t = System.currentTimeMillis();
                while (!bus2.catchUp2(pos)) catchUp2(bus2.pos);
                System.out.println("race done at" + this.toString() + bus2.toString() + "in " + (System.currentTimeMillis()-t)+"ms");
                return pos;
            }

        }


        @Override
        public String toString() {
            return "Bus{" +
                    "id=" + id.toString() +
                    ", pos=" + pos.toString() +
                    '}';
        }

        @Override
        public int compareTo(@NotNull Bus o) {
            return this.id.compareTo(o.id);
        }
    }

}