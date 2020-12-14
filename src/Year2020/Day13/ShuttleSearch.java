package Year2020.Day13;

import Year2020.Utils.AOCInputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShuttleSearch {
    private static AOCInputReader READER = new AOCInputReader();
    private static String TEST_INPUT = "Input/day_13_test_input.txt";
    private static String PUZZLE_INPUT = "Input/day_13_puzzle_input.txt";

    public static void main(String[] args) throws IOException{
        System.out.println("----TEST----");
        System.out.println("PART 1 \nCorrect response: 295");
        System.out.println("Actual Response: "+ partOne(TEST_INPUT));


        System.out.println("----PUZZLE----");
        System.out.println("Actual Response: "+ partOne(PUZZLE_INPUT));
    }

    private static int partOne(String filename) throws IOException{
        int timeStamp = getTimestamp(filename);
        List<Integer> buses = getBuses(filename);
        Integer minWaitTime = Integer.MAX_VALUE;
        int waitTime;
        int bestbus = buses.get(0);

        for(Integer bus : buses){
            waitTime = bus - (timeStamp % bus);
            if(waitTime < minWaitTime){
                minWaitTime = waitTime;
                bestbus = bus;
            }
        }
        return bestbus * minWaitTime;
    }

    private static int getTimestamp(String filename)throws IOException {
        return Integer.valueOf(READER.getStringList(filename).get(0));
    }

    private static List<Integer> getBuses(String filename) throws IOException{
        String[] busNames = READER.getStringList(filename).get(1).split(",");
        List<Integer> buses = new ArrayList<>();
        for(String bus : busNames){
            if(!bus.equals("x")){
              buses.add(Integer.valueOf(bus));
            }
        }
        return buses;
    }
}
