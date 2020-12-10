package Year2020.Day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncodingError {
    static Integer PUZZLE_LOOKBACK = 25;
    static Integer TEST_LOOKBACK = 5;

    public static void main(String[] args) {
        long part1Test = findFirstFailing(Input.TEST_INPUT, Input.TEST_LOOKBACK);
        System.out.println("TEST:");
        System.out.println("Answer to part 1: " + part1Test);
        System.out.println(part2(Input.TEST_INPUT, part1Test));
        System.out.println("\n---\n");

        System.out.println("PUZZLE:");
        long part1Puzzle = findFirstFailing(Input.PUZZLE_INPUT, Input.PUZZLE_LOOKBACK);
        System.out.println("Answer to part 1: " + part1Puzzle);
        System.out.println(part2(Input.PUZZLE_INPUT, part1Puzzle));
    }

    private static long part2(List<Long> input, long target) {
        List<Long> range = findContinuousRange(input, target);
        return Collections.min(range) + Collections.max(range);
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
    private static long findFirstFailing(List<Long> input, int lookback) {
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
