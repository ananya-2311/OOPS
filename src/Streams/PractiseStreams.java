package Streams;

import java.util.Map;
import java.util.stream.Collectors;


public class PractiseStreams {
    public boolean isAnagram(String s, String t) {
        Map<Character, Long> freq1 =
                s.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                c -> c,
                                Collectors.counting()
                        ));
        Map<Character, Long> freq2 =
                t.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                c -> c,
                                Collectors.counting()
                        ));
        return freq1.equals(freq2);
    }

    static void main(String[] args) {

    }
}
