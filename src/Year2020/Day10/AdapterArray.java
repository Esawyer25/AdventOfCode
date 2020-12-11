package Year2020.Day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdapterArray {
    private static String TEST_INPUT = "Input/day_10_test_input.txt";
    private static String PUZZLE_INPUT = "Input/day_10_puzzle_input.txt";

    public static void main(String[] args) throws IOException{
        System.out.println("----TEST----");
        System.out.println("PART 1 \nCorrect response: 22");
        System.out.println("Actual Response: "+ partOne(TEST_INPUT));

        System.out.println("test 2" + partTwoRecurssive(TEST_INPUT));

        System.out.println("----PUZZLE----");
        System.out.println("PART 1");
        System.out.println("Response: "+ partOne(PUZZLE_INPUT));
        //System.out.println("test 2" + partTwoRecurssive(PUZZLE_INPUT));

    }

    private static List<Integer> getInput(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<Integer> adapators = new ArrayList<>();
        String line = br.readLine();
        while(line != null){
            adapators.add(Integer.valueOf(line));
            line = br.readLine();
        }
        return adapators;
    }

    private static int partOne(String fileName) throws IOException{
        List<Integer> adaptors = getInput(fileName);
        Collections.sort(adaptors);
        // add plug and device
        adaptors.add(0,0);
        adaptors.add(adaptors.get(adaptors.size() -1) + 3);

        return getXAway(adaptors, 1) * getXAway(adaptors, 3);
    }

    private static int getXAway(List<Integer> sortedList, int difference){
        int count = 0;
        for(int i = 1; i < sortedList.size(); i++){
            int actualDifference = sortedList.get(i) - sortedList.get(i-1);
            if(actualDifference == difference) {
                count += 1;
            }
        }
        return count;
    }


    /// this approach is not practical given the size of the input.
    private static long partTwoRecurssive(String fileName) throws IOException{
        List<Integer> adaptors = getInput(fileName);
        Collections.sort(adaptors);
        adaptors.add(0,0);
        return  getValidArrangement(adaptors, 0, 0);
    }

    private static long getValidArrangement(List<Integer> input, long count, int index){
        if(index == input.size() -1){
            System.out.println(count +1);
            return count + 1;
        }

        int currentValue = input.get(index);
        while(index + 1 < input.size() && input.get(index +1) - currentValue <= 3){
            count = getValidArrangement(input, count, index + 1);
            index +=1;
        }
        return count;
    }
}
