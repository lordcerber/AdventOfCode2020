package adventofcode.day5;

import adventofcode.AdventureHelper;

import java.util.List;

public class Solution {

    //wow a binary coding
    //FFBBFFFRLL
    // so i assume FFFFFF is 0 BBBBBB is 111111 and LLL is 0 RRR is 111
    public static List<String> getPuzzleInput() {
        return AdventureHelper.getFileByLines("Day5/Input");
    }


    public static Seat decodeBinaryPlacement(String ticket) {

        String binaryRow = ticket.substring(0, ticket.length() - 3).replace("F", "0").replace("B", "1");
        String binaryColumn = ticket.substring(ticket.length() - 3).replace("R","1").replace("L","0");

        int row = Integer.parseInt(binaryRow, 2); //Supercow power
        int column = Integer.parseInt(binaryColumn, 2);

        return new Seat(row, column);
    }

    public static int getHighestSeatID(List<Seat> seats) {
        seats.sort(Seat::compareTo);
        return seats.get(seats.size()-1).getID();
    }

    public static int getEmptySeatID(List<Seat> seats) {
        seats.sort(Seat::compareTo);
        for (int i=0; i<seats.size()-1;i++) {
            if (seats.get(i+1).getID()-seats.get(i).getID()>1) return seats.get(i).getID()+1;
        }
        return 0;
    }

    //that can be actually solved without decoding and stuff, by strings sorting

}
