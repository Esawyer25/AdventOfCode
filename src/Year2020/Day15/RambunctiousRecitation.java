package Year2020.Day15;

import Year2020.Utils.AOCInputReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RambunctiousRecitation {
    private static AOCInputReader READER = new AOCInputReader();
    private static String TEST_INPUT = "Input/day_15_test_input.txt";
    private static String PUZZLE_INPUT = "Input/day_15_puzzle_input.txt";

    public static void main(String[] args) throws IOException{
        System.out.println(day15(TEST_INPUT, 2020));

        System.out.println("----TEST----");
        System.out.println("PART 1 \nCorrect response: 1836");
        System.out.println("Actual Response: "+ day15(TEST_INPUT, 2020));
        System.out.println("PART 2 \nCorrect response: 362");
        System.out.println("Actual Response: "+ day15(TEST_INPUT, 30000000));

        System.out.println("----PUZZLE----");
        System.out.println("PART 1: Actual Response: "+ day15(PUZZLE_INPUT, 2020));
        System.out.println("Actual Response: "+ day15(PUZZLE_INPUT, 30000000));
    }

    // solves both part 1 and 2
    private static int day15(String fileName, int turns) throws IOException{
        List<Integer> input = READER.getIntegerListFromCommaSeperatedString(fileName);

        //Map<NumberSpoken, IndexLastSpoken>
        Map<Integer, Integer> map = new HashMap<>();
        initMap(map, input);

        int lastNumSpoken = input.get(input.size() -1);
        for(int i = input.size(); i < turns; i ++){
            if(map.containsKey(lastNumSpoken)){
                int temp  = map.get(lastNumSpoken);
                map.put(lastNumSpoken, i);
                lastNumSpoken = (i) - temp;
            } else {
                map.put(lastNumSpoken, i);
                lastNumSpoken = 0;
            }

        }
        return lastNumSpoken;
    }

    private static void initMap(Map<Integer, Integer> map, List<Integer> input){
        for(int i = 0; i < input.size() -1; i ++){
            map.put(input.get(i), i +1);
        }
    }
}
