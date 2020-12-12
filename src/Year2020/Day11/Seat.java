package Year2020.Day11;

import static Year2020.Day11.SeatMatrix.EMPTY_SEAT;
import static Year2020.Day11.SeatMatrix.FLOOR;
import static Year2020.Day11.SeatMatrix.OCCUPIED_SEAT;

public class Seat {
    private Character character;

    Seat(char c) {
        character = c;
    }

    boolean getIsFloor() {
        return character == FLOOR;
    }

    boolean getIsOccupied() {
        return character == OCCUPIED_SEAT;
    }

    boolean getIsEmptySeat() {
        return character == EMPTY_SEAT;
    }

    Character getCharacter() {
        return character;
    }

    void sitDown() {
        if (character == EMPTY_SEAT) {
            character = OCCUPIED_SEAT;
        } else if (character == OCCUPIED_SEAT) {
            throw new IllegalArgumentException("Seat is taken");
        } else {
            throw new IllegalArgumentException("Can't sit on floor!");
        }
    }
}
