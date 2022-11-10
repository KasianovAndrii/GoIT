package module11;

import java.util.*;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        // 1
        List<String> persons = new ArrayList<>(
                Arrays.asList("Ivan",
                              "Petro",
                              "Yan",
                              "Amigo",
                              "Grisha"

                ));
        StreamIssues streamIssue = new StreamIssues();
        String str = streamIssue.listNotEvenElementsToString(persons);
        System.out.println(str);
        // 2
        List<String> sortedPersons = streamIssue.listSortedUpperCase(persons);

        for (int i = 0; i < sortedPersons.size(); i++) {
            System.out.println(sortedPersons.get(i));
        }
        // 3
        List<String> numbers = Arrays.asList("1, 2, 0", "4, 5");
        String sortedString = streamIssue.listSortedNumbers(numbers);
        System.out.println(sortedString);
        // 4
        streamIssue.randomGenerator(5, 6);
        // 5
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> stream2 = Stream.of(10, 20, 30, 40);
        Stream<Integer> streamResult = streamIssue.zipIterator(stream1, stream2);
        streamResult.forEach(System.out::println);

    }
}
