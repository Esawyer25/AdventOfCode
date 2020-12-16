package Year2020.Day12;

import Year2020.Utils.AOCInputReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Year2020.Day12.Direction.EAST;
import static Year2020.Day12.Direction.NORTH;
import static Year2020.Day12.Direction.SOUTH;
import static Year2020.Day12.Direction.WEST;

public class RainRisk {
    private static String TEST_INPUT = "Input/day_12_test_input.txt";
    private static String PUZZLE_INPUT = "Input/day_12_puzzle_input.txt";
    private static AOCInputReader READER = new AOCInputReader();
    private static char FORWARD = 'F';
    private static char RIGHT = 'R';
    private static char LEFT = 'L';
    private static char N = 'N';
    private static char S = 'S';
    private static char W = 'W';
    private static char E = 'E';

//    Action N means to move north by the given value.
//    Action S means to move south by the given value.
//    Action E means to move east by the given value.
//    Action W means to move west by the given value.
//    Action L means to updateCurrentDirection left the given number of degrees.
//    Action R means to updateCurrentDirection right the given number of degrees.
//    Action F means to move forward by the given value in the direction the ship is currently facing.

    public static void main (String[] args) throws IOException{
        System.out.println("----TEST----");
        System.out.println("PART 1 \nCorrect response: 25");
        System.out.println("Actual Response: "+ partOne(TEST_INPUT));
        System.out.println("PART 2 \nCorrect response: 286");
        System.out.println("PART 2: "+ partTwo(TEST_INPUT));

        System.out.println("----PUZZLE----");
        System.out.println("PART 1: "+ partOne(PUZZLE_INPUT));
        System.out.println("PART 2: "+ partTwo(PUZZLE_INPUT));
    }

    private static int partOne(String fileName) throws IOException{
        Map<Direction, Integer> movementMap = new HashMap<>();
        movementMap.put(EAST, 0);
        movementMap.put(NORTH, 0);
        movementMap.put(WEST, 0);
        movementMap.put(SOUTH, 0);

        List<String> commands = READER.getStringList(fileName);
        Direction currentDirection = EAST;

        for(String command : commands){
            char letter = command.charAt(0);
            Integer num = Integer.valueOf(command.substring(1, command.length()));

            if(letter == FORWARD){
                movementMap.put(currentDirection,  movementMap.get(currentDirection) + num);
            } else if(letter == RIGHT || letter == LEFT){
                currentDirection = updateCurrentDirection(num, letter, currentDirection);
            } else{
                moveDirection(movementMap, num, letter);
            }
        }
        return getYMovement(movementMap) + getXMovement(movementMap);
    }

    private static Direction updateCurrentDirection(int num, int letter, Direction currentDirection){
        if(letter == RIGHT){
            return currentDirection.turnRight(num);
        }
        return currentDirection.turnLeft(num);
    }

    private static void moveDirection(Map<Direction, Integer> movementMap, int num, int letter){
        if(letter == N){
            movementMap.put(NORTH, movementMap.get(NORTH) + num);
        } else if(letter == S) {
            movementMap.put(SOUTH, movementMap.get(SOUTH) + num);
        } else if(letter == E) {
            movementMap.put(EAST, movementMap.get(EAST) + num);
        } else if(letter == W) {
            movementMap.put(WEST, movementMap.get(WEST) + num);
        }
    }

    private static int getYMovement(Map<Direction, Integer> movementMap){
        return Math.abs(movementMap.get(NORTH) - movementMap.get(SOUTH));
    }

    private static int getXMovement(Map<Direction, Integer> movementMap){
        return Math.abs(movementMap.get(EAST) - movementMap.get(WEST));
    }

    private static int partTwo(String fileName) throws IOException{
        Map<Direction, Integer> movementMap = new HashMap<>();
        movementMap.put(EAST, 0);
        movementMap.put(NORTH, 0);
        movementMap.put(WEST, 0);
        movementMap.put(SOUTH, 0);

        List<String> commands = READER.getStringList(fileName);
        WayPoint wayPoint = new WayPoint();

        for(String command : commands) {
            char letter = command.charAt(0);
            Integer num = Integer.valueOf(command.substring(1, command.length()));

            if (letter == FORWARD) {
                moveForward(wayPoint, movementMap, num);

            } else if (letter == RIGHT || letter == LEFT) {
                wayPoint.rotate(letter, num);

            } else if (letter == N || letter == S) {
                wayPoint.incrementY(letter, num);

            } else {
                wayPoint.incrementX(letter, num);
            }
        }

        return getYMovement(movementMap) + getXMovement(movementMap);
    }

    private static void moveForward(WayPoint wayPoint, Map<Direction, Integer> movementMap, int num){
        int X = wayPoint.getX() * num;
        Direction directionX = wayPoint.getDirectionX();
        int Y = wayPoint.getY() * num;
        Direction directionY = wayPoint.getDirectionY();

        movementMap.put(directionX, movementMap.get(directionX) + X);
        movementMap.put(directionY, movementMap.get(directionY) + Y);
    }
}
