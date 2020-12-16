package Year2020.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Utils class for sharing methods for converting puzzle input into Lists.
public class AOCInputReader {

    public List<Integer> getIntegerList(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<Integer> input = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
            input.add(Integer.valueOf(line));
            line = br.readLine();
        }
        return input;
    }

    public List<Long> getLongList(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<Long> input = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
            input.add(Long.valueOf(line));
            line = br.readLine();
        }
        return input;
    }

    public List<String> getStringList(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<String> input = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
            input.add(line);
            line = br.readLine();
        }
        return input;
    }

    public List<char[]> getCharArrList(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<char[]> input = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
            input.add(line.toCharArray());
            line = br.readLine();
        }
        return input;
    }

    public List<Integer> getIntegerListFromCommaSeperatedString(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = br.readLine();
        List<Integer> list = Arrays.stream(line.split(",")).map(Integer::valueOf)
                .collect(Collectors.toList());
        return list;
    }
}
