package adventofcode.Day12;

import java.util.Objects;

public class Cell {

    private long row;
    private long col;
    private String direction = "E";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return row == cell.row &&
                col == cell.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    public Cell(long r, long c) {
        row = r;
        col = c;
    }

    public long getRow() {
        return row;
    }

    public long getCol() {
        return col;
    }

    public void move(String operation, int value) {
        if (value == 0) return;
        else if (operation.equals("N")) {row++; move(operation,value-1);}
        else if (operation.equals("S")) {row--; move(operation,value-1);}
        else if (operation.equals("E")) {col++; move(operation,value-1);}
        else if (operation.equals("W")) {col--; move(operation,value-1);}

        else if (operation.equals("F")) {move(direction,value);}

        else if (operation.equals("L")) {turn(1); move(operation,value-90);}
        // 90 right is 270 left
        else if (operation.equals("R")) {turn(3); move(operation,value-90);}
    }

    public void move(Cell vector, int value) {
        if (value == 0) return;
        row+= vector.row;
        col+=vector.col;
        move(vector, value -1);
    }

    private void turn(int i) {
        if (i==0) return;
        //counter clockwise is positive as in math
        else if (direction.equals("N")) {direction="W"; turn(i-1);}
        else if (direction.equals("E")) {direction="N"; turn(i-1);}
        else if (direction.equals("S")) {direction="E"; turn(i-1);}
        else if (direction.equals("W")) {direction="S"; turn(i-1);}
    }

    public void vectorRotate(String operation, int value) {
        if (value==0) return;
        else {
            long dc = col;
            long dr = row;
            if (operation.equals("R")) dc = -1 * dc;
            if (operation.equals("L")) dr = -1 * dr;
            row = dc;
            col = dr;
            vectorRotate(operation,value - 90);
        }
    }
}
