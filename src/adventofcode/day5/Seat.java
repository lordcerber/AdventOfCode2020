package adventofcode.day5;

public class Seat implements Comparable<Seat> {
    private final int row;
    private final int column;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getID() {
        return row * 8 + column; //well this is actually a whole string decoded without need to split and something
    }


    @Override
    public int compareTo(@org.jetbrains.annotations.NotNull Seat o) {
        return Integer.compare(this.getID(), o.getID());
    }
}
