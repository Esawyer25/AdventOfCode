package Year2020.Day11;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SeatMatrix {
    // should make into immutable list
    private static  List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{+1, 0},
            new int[]{-1, 0},
            new int[]{0, +1},
            new int[]{0, -1},
            new int[]{+1, +1},
            new int[]{+1, -1},
            new int[]{-1, +1},
            new int[]{-1, -1});

    static char EMPTY_SEAT = 'L';
    static char FLOOR = '.';
    static char OCCUPIED_SEAT = '#';

    private int height;
    private int width;
    private int maxNeighbors;
    private List<List<Seat>> seatMatrix = new ArrayList<>();
    private boolean useDirectNeighbors = true; // defaults to use direct neighbors

    SeatMatrix(List<char[]> input, int maxNeighbors) {
        this.height = input.size();
        this.width = input.get(0).length;
        this.maxNeighbors = maxNeighbors;
        initializeSeatMatrix(input);
    }

    void useVisibleNeighbors(){
        useDirectNeighbors = false;
    }

    private void initializeSeatMatrix(List<char[]> input) {
        for (char[] row : input) {
            List<Seat> seatRow = new ArrayList<>();
            CharBuffer.wrap(row).chars().forEach(c -> seatRow.add(new Seat((char) c)));
            this.seatMatrix.add(seatRow);
        }
    }

    private Seat getSeat(int row, int column) throws IllegalArgumentException {
        if (isValidRow(row) && isValidColumn(column)) {
            return seatMatrix.get(row).get(column);
        } else {
            throw new IllegalArgumentException(String.format("Row %d or column %d does not exist.", row, column));
        }
    }

    private boolean isValidRow(int row) {
        return row < height && row >= 0;
    }

    private boolean isValidColumn(int column) {
        return column < width && column >= 0;
    }

    int numberOfOccupiedSeats() {
        int count = 0;
        for (List<Seat> row : seatMatrix) {
            for (Seat seat : row) {
                if (seat.getIsOccupied()) {
                    count += 1;
                }
            }
        }
        return count;
    }

    void fillAllSeats() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Seat seat = getSeat(i, j);
                if (seat.getIsEmptySeat()) {
                    seat.sitDown();
                }
            }
        }
    }

    boolean isValidSittingArrangement() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Seat seat = getSeat(i, j);
                int count =  getNeighbors(i, j);

                //If a seat is empty (L) and there are no occupied seats adjacent to it, the seat becomes occupied.
                if (seat.getIsEmptySeat() && count == 0) {
                    return false;
                    //If a seat is occupied (#) and four or more seats adjacent to it are also occupied, the seat becomes empty.
                } else if (seat.getIsOccupied() && count >= maxNeighbors) {
                    return false;
                }
            }
        }
        return true;
    }

    public SeatMatrix getNewSittingArrangement() {
        List<char[]> newArrangement = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            char[] newRow = new char[width];
            for (int j = 0; j < width; j++) {
                Seat seat = getSeat(i, j);
                int count = getNeighbors(i, j);

                if (seat.getIsFloor()) {
                    newRow[j] = FLOOR;

                    //If a seat is occupied (#) and four or more seats adjacent to it are also occupied, the seat becomes empty.
                } else if (seat.getIsOccupied()) {
                    if (count >= maxNeighbors) {
                        newRow[j] = EMPTY_SEAT;
                    } else {
                        newRow[j] = OCCUPIED_SEAT;
                    }

                    //If a seat is empty (L) and there are no occupied seats adjacent to it, the seat becomes occupied.
                } else {
                    if (count == 0) {
                        newRow[j] = OCCUPIED_SEAT;
                    } else {
                        newRow[j] = EMPTY_SEAT;
                    }
                }
            }
            newArrangement.add(newRow);
        }
        return new SeatMatrix(newArrangement, maxNeighbors);
    }

    void print() {
        System.out.println("--------------------");
        for (List<Seat> row : seatMatrix) {
            for(Seat seat : row){
                System.out.print(String.format("%c, ", seat.getCharacter()));
            }
            System.out.println("");
        }
    }

    private int getNeighbors(int row, int column){
        return useDirectNeighbors ? getNumberOfDirectNeighbors(row, column) : getNumberOfVisibleNeighbors(row, column);
    }

    private int getNumberOfDirectNeighbors(int rowIndex, int columnIndex) {
        int occupied = 0;

        for(int[] direction: DIRECTIONS){
            Optional<Seat> optionalSeat = getDirectNeighbor( rowIndex, columnIndex, direction[0], direction[1]);
            if (optionalSeat.isPresent()){
                if(optionalSeat.get().getIsOccupied()){
                    occupied +=1;
                }
            }
        }
        return occupied;
    }

    private int getNumberOfVisibleNeighbors(int rowIndex, int columnIndex) {
        int occupied = 0;

        for(int[] direction: DIRECTIONS){
            Optional<Seat> optionalSeat = getVisibleNeighbor( rowIndex, columnIndex, direction[0], direction[1]);
            if (optionalSeat.isPresent()){
                if(optionalSeat.get().getIsOccupied()){
                    occupied +=1;
                }
            }
        }
        return occupied;
    }

    private Optional<Seat> getVisibleNeighbor(int row, int column, int verticalIncrement, int horizontalIncrement){
        row += verticalIncrement;
        column += horizontalIncrement;
        while(isValidRow(row) && isValidColumn(column)){
            if(!getSeat(row, column).getIsFloor()){
                return Optional.of(getSeat(row, column));
            }
            row += verticalIncrement;
            column += horizontalIncrement;
        }
        return Optional.empty();
    }

    private Optional<Seat> getDirectNeighbor(int row, int column, int verticalIncrement, int horizontalIncrement){
        row += verticalIncrement;
        column += horizontalIncrement;
        if(isValidRow(row) && isValidColumn(column)){
            if(!getSeat(row, column).getIsFloor()){
                return Optional.of(getSeat(row, column));
            }
        }
        return Optional.empty();
    }
}
