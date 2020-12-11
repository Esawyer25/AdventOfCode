package Year2020.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
}
