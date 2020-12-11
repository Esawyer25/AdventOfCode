package Year2020.Day9;

import Year2020.Utils.AOCInputReader;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncodingError {
    static Integer PUZZLE_LOOKBACK = 25;
    static Integer TEST_LOOKBACK = 5;
    private static AOCInputReader READER = new AOCInputReader();
    private static String TEST_INPUT = "Input/day_9_test_input.txt";
    private static String PUZZLE_INPUT = "Input/day_9_puzzle_input.txt";

    public static void main(String[] args) throws IOException {
        long part1Test = findFirstFailing(TEST_INPUT, TEST_LOOKBACK);
        System.out.println("TEST:");
        System.out.println("Answer to part 1: " + part1Test);
        System.out.println("Answer to part 2: " + part2(TEST_INPUT, part1Test));
        System.out.println("\n---\n");

        System.out.println("PUZZLE:");
        long part1Puzzle = findFirstFailing(PUZZLE_INPUT, PUZZLE_LOOKBACK);
        System.out.println("Answer to part 1: " + part1Puzzle);
        System.out.println("Answer to part 2: " + part2(PUZZLE_INPUT, part1Puzzle));
    }

    private static long part2(String fileName, long target) throws IOException {
        List<Long> input = READER.getLongList(fileName);
        List<Long> range = findContinuousRange(input, target);
        return Collections.min(range) + Collections.max(range);
    }

    // n = length of input
    //Time = O n
    //Space = constant
    private static List<Long> findContinuousRange(List<Long> input, long target) {
        int left = 0;
        int right = 0;
        long sum = 0;
        while (right < input.size()) {
            if (sum < target) {
                sum += input.get(right);
                right++;
            } else if (sum > target) {
                sum -= input.get(left);
                left++;
            } else {
                return input.subList(left, right);
            }
        }
        return Collections.emptyList();
    }

    // n = length of input, m = lookback
    //Time = O n*m
    //Space = O m
    private static long findFirstFailing(String fileName, int lookback) throws IOException {
        List<Long> input = READER.getLongList(fileName);
        Map<Long, Integer> countMap = getCountMap(input, lookback);

        for (int i = lookback; i < input.size(); i++) {
            long target = input.get(i);
            boolean found = false;

            for (Long current : countMap.keySet()) {
                long compliment = target - current;

                //handles special case of current == 1/2 target
                if (compliment == current) {
                    if (countMap.get(compliment) > 1) {
                        found = true;
                        break;
                    }
                } else if (countMap.containsKey(compliment)) {
                    found = true;
                    break;
                }
            }

            if (!found) return target;
            updateCountMap(countMap, input.get(i - lookback), target);
        }
        return -1;
    }

    private static void updateCountMap(Map<Long, Integer> countMap, long toRemove, long toAdd) {
        if (countMap.get(toRemove) == 1) {
            countMap.remove(toRemove);
        } else {
            countMap.put(toRemove, countMap.get(toRemove) - 1);
        }

        int count = countMap.getOrDefault(toAdd, 0);
        count += 1;
        countMap.put(toAdd, count);
    }

    private static Map<Long, Integer> getCountMap(List<Long> input, int lookback) {
        Map<Long, Integer> countMap = new HashMap<>();
        for (int i = 0; i < lookback; i++) {
            int count = countMap.getOrDefault(input.get(i), 0);
            count += 1;
            countMap.put(input.get(i), count);
        }
        return countMap;
    }
}
