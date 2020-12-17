package adventofcode;

import adventofcode.Day11.Cell;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day17 {
    //a 3d life sim... ez
    private static volatile Day17 instance = null;

    private Day17() {
    }

    public static Day17 getInstance() {
        if (instance == null) {
            synchronized (Day17.class) {
                if (instance == null) {
                    instance = new Day17();
                }
            }
        }
        return instance;
    }

    public HashSet<Cell>cells = new HashSet<Cell>();

    public static List<String> getPuzzleInput() {
        return AdventureHelper.getFileByLines("Day17/Input");
    }

    public static List<String> getPuzzleTestInput() {
        return AdventureHelper.getFileByLines("Day17/TestInput");
    }

    public void convertInput(List<String> input) {
        int index = 0;
        for (String line: input) {
            for (int i = 0; i<line.length(); i++) {
                if (String.valueOf(line.charAt(i)).equals("#")) cells.add(new Cell3(index,i,0));

            }
            index++;
        }
        System.out.println("after creation there is "+cells.size()+" cells alive");
    }

    public void convertInput2(List<String> input) {
        int index = 0;
        for (String line: input) {
            for (int i = 0; i<line.length(); i++) {
                if (String.valueOf(line.charAt(i)).equals("#")) cells.add(new Cell4(index,i,0,0));

            }
            index++;
        }
        System.out.println("after creation there is "+cells.size()+" cells alive");
    }

    public long solveTask1 (int cycles) {
        HashSet<Cell>cellsDie = new HashSet<Cell>();
        HashSet<Cell>cellsToBeBorn = new HashSet<Cell>();
        HashSet<Cell>cellsBorn = new HashSet<Cell>();
        for (int i=0; i<cycles;i++){
            for (Cell cell:cells) {
                //check what cells will die
                long count = cells.stream().filter(c -> cell.getNeigbours().contains(c)).count();
                if (count>3 || count<2) cellsDie.add(cell);
                //create a field of potential "new" cells
                cellsToBeBorn.addAll(cell.getNeigbours());
            }
            //exclude existing cells from field.
            cellsToBeBorn.removeAll(cells);
            for (Cell cell:cellsToBeBorn) {
                //check what cells will die
                if (cells.stream().filter(c -> cell.getNeigbours().contains(c)).count() == 3l) cellsBorn.add(cell);
            }

            cells.removeAll(cellsDie);
            cells.addAll(cellsBorn);
            cellsDie.clear();
            cellsBorn.clear();
            cellsToBeBorn.clear();
            System.out.println("after cycle "+i+" there is "+cells.size()+" cells alive");
        }
        return cells.size();
    }

    abstract class Cell {
        HashSet<Cell> neigbours=new HashSet<>();
        abstract HashSet<Cell>  getNeigbours();
    }

    class Cell3 extends Cell {
        private final int X;
        private final int Y;
        private final int Z;


        public Cell3(int x, int y, int z) {
            X=x;
            Y=y;
            Z=z;
        }

        public HashSet<Cell> getNeigbours() {
            if (neigbours.isEmpty()) {
                //initialisation, ugly;
                HashSet<Cell> lookup = new HashSet<>();
                for (int x = X-1; x<=X+1;x++){
                    for (int y = Y-1; y<=Y+1;y++){
                        for (int z = Z-1; z<=Z+1;z++){
                            lookup.add(new Cell3(x,y,z));
                        }
                    }
                }
                lookup.remove(this);
                neigbours.addAll(lookup);
            }
            return neigbours;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell3 cell = (Cell3) o;
            return X == cell.X &&
                    Y == cell.Y &&
                    Z == cell.Z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(X, Y, Z);
        }
    }

    class Cell4 extends Cell {
        private final int X;
        private final int Y;
        private final int Z;
        private final int T;


        public Cell4(int x, int y, int z, int t) {
            X=x;
            Y=y;
            Z=z;
            T=t;
        }

        public HashSet<Cell> getNeigbours() {
            if (neigbours.isEmpty()) {
                //initialisation, ugly;
                HashSet<Cell> lookup = new HashSet<>();
                for (int x = X-1; x<=X+1;x++){
                    for (int y = Y-1; y<=Y+1;y++){
                        for (int z = Z-1; z<=Z+1;z++){
                            for (int t = T-1; t<=T+1;t++){
                                lookup.add(new Cell4(x,y,z,t));
                            }
                        }
                    }
                }
                lookup.remove(this);
                neigbours.addAll(lookup);
            }
            return neigbours;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell4 cell = (Cell4) o;
            return X == cell.X &&
                    Y == cell.Y &&
                    Z == cell.Z &&
                    T == cell.T;
        }

        @Override
        public int hashCode() {
            return Objects.hash(X, Y, Z, T);
        }
    }


}