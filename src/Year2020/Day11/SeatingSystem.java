package Year2020.Day11;

import Year2020.Utils.AOCInputReader;

import java.io.IOException;

public class SeatingSystem {
    private static AOCInputReader READER = new AOCInputReader();
    private static String TEST_INPUT = "Input/day_11_test_input.txt";
    private static String PUZZLE_INPUT = "Input/day_11_puzzle_input.txt";

    public static void main(String[] args) throws IOException {

        System.out.println("----TEST----");
        System.out.println("PART 1 \nCorrect response: 37");
        System.out.println("Actual Response: "+ partOne(TEST_INPUT));
        System.out.println("PART 2 \nCorrect response: 26");
        System.out.println("Actual Response: "+ partTwo(TEST_INPUT));

        System.out.println("----PUZZLE----");
        System.out.println("Actual Response: "+ partOne(PUZZLE_INPUT));
        System.out.println("Actual Response: "+ partTwo(PUZZLE_INPUT));
    }


    private static int partOne(String file) throws IOException {
        SeatMatrix seatMatrix = new SeatMatrix(READER.getCharArrList(file), 4);
        seatMatrix.fillAllSeats();
        while (!seatMatrix.isValidSittingArrangement()) {
            seatMatrix = seatMatrix.getNewSittingArrangement();
        }

        return seatMatrix.numberOfOccupiedSeats();
    }

    private static int partTwo(String file) throws IOException {
        SeatMatrix seatMatrix = new SeatMatrix(READER.getCharArrList(file), 5);
        seatMatrix.useVisibleNeighbors();
        seatMatrix.fillAllSeats();
        while (!seatMatrix.isValidSittingArrangement()) {
            seatMatrix = seatMatrix.getNewSittingArrangement();
            seatMatrix.useVisibleNeighbors();
        }

        return seatMatrix.numberOfOccupiedSeats();
    }
}
