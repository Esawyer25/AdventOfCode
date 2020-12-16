package Year2020.Day12;

import static Year2020.Day12.Direction.EAST;
import static Year2020.Day12.Direction.NORTH;
import static Year2020.Day12.Direction.SOUTH;
import static Year2020.Day12.Direction.WEST;

public class WayPoint {
    private Direction directionX = EAST;
    private Direction directionY = NORTH;
    private int X = 10;
    private int Y = 1;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public Direction getDirectionX() {
        return directionX;
    }

    public Direction getDirectionY() {
        return directionY;
    }

    private void incrementX(int num){
        X += num;
    }

    private void incrementY(int num){
        Y += num;
    }

    void incrementX(char letter, int num){
        if(letter == 'W' && directionX == EAST ||
                letter == 'E' && directionX == WEST){
            incrementX(num * -1);
        } else {
            incrementX(num);
        }
    }

    void incrementY(char letter, int num){
        if (letter == 'N' && directionY == SOUTH ||
                letter == 'S' && directionY == NORTH) {
            incrementY(num * -1);
        } else {
            incrementY(num);
        }
    }

    void rotate(char letter, int degrees) {
        int turns = degrees / 90;

        for (int i = 0; i < turns; i++){
            if (letter == 'R') {
                rotateRight90();
            } else {
                rotateLeft90();
            }
        }
    }

    private void rotateRight90(){
        if(directionY == NORTH){
            if(directionX == EAST){
                directionY = directionY.turnRight(180);
            } else {
                directionX = directionX.turnRight(180);
            }
        } else {
            if(directionX == EAST){
                directionX = directionX.turnRight(180);
            } else {
                directionY = directionY.turnRight(180);
            }
        }
        int temp = X;
        X = Y;
        Y = temp;
    }

    private void rotateLeft90(){
        if(directionY == NORTH){
            if(directionX == EAST){
                directionX = directionX.turnRight(180);
            } else {
                directionY = directionY.turnRight(180);
            }
        } else {
            if(directionX == EAST){
                directionY = directionY.turnRight(180);
            } else {
                directionX = directionX.turnRight(180);
            }
        }
        int temp = X;
        X = Y;
        Y = temp;
    }
}
