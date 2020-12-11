package Year2020.Day1;

import Year2020.Utils.AOCInputReader;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReportRepair {
    private static String TEST_INPUT = "Input/day_1_test_input.txt";
    private static String PUZZLE_INPUT = "Input/day_1_puzzle_input.txt";
    private static int TARGET = 2020;
    private static AOCInputReader READER = new AOCInputReader();

    public static void main(String[] args) throws IOException {

        System.out.println("TEST:");
        System.out.println("Answer to part 1: " + part1(TEST_INPUT, TARGET));
        System.out.println("Answer to part 2: " + part2(TEST_INPUT, TARGET));
        System.out.println("\n---\n");

        System.out.println("PUZZLE:");
        System.out.println("Answer to part 1: " + part1(PUZZLE_INPUT, TARGET));
        System.out.println("Answer to part 2: " + part2(PUZZLE_INPUT, TARGET));

    }

    private static int part1(String fileName, int target) throws IOException {
        List<Integer> input = READER.getIntegerList(fileName);

        Set<Integer> set = new HashSet<>();
        for (Integer num : input) {
            if (set.contains(num)) {
                return num * (target - num);
            } else {
                set.add(target - num);
            }
        }
        // this should not happen give constraints of the problem.
        // alternatively we could throw an exception here.
        return -1;
    }

    private static long part2(String fileName, int target) throws IOException {
        List<Integer> input = READER.getIntegerList(fileName);

        for (int i = 0; i < input.size(); i++) {
            int goal = target - input.get(i);
            long potentialAnswer = findProductOfPair(input, i, goal);
            if (potentialAnswer != -1) {
                return potentialAnswer * input.get(i);
            }
        }
        // this should not happen give constraints of the problem.
        // alternatively we could throw an exception here.
        return -1;
    }

    private static long findProductOfPair(List<Integer> list, int index, int goal) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (i == index) continue;

            if (set.contains(num)) {
                return num * (goal - num);
            }
            set.add(goal - num);
        }
        return -1;
    }
}
