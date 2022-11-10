package module11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIssues<T> {
//    Задание 1
//    Метод принимает на вход список имен.
//    Вернуть строку в виде: "1. Ivan, 3. Peter ...", с именами из списка, стоящими под нечетным индексом (1, 3 и т.д.).
    public String listNotEvenElementsToString(List<String> persons){
        for (int i = 0; i < persons.size(); i++) {
            if (i % 2 == 0) {
                persons.remove(i);
            }
        }
        return persons.stream()
                      .collect(Collectors.joining(","));
    }
 //   Задание 2
 //   Метод принимает на вход список из строк (можно список из Задания 1).
 //   Возвращает список этих строк в верхнем регистре и отсортированные по убыванию (от Z до А).
    public List<String> listSortedUpperCase(List<String> persons) {
       return persons.stream()
                .sorted(Comparator.reverseOrder())
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
    }
   //  Задание 3
   //  Дан массив: ["1, 2, 0", "4, 5"]
   //  Получить из массива все числа, вернуть в отсортированном виде, разделенные запятой, то есть "0, 1, 2, 4, 5"
   public String listSortedNumbers(List<String> numbers) {
       return numbers.stream()
                     .flatMap(s -> Arrays.stream(s.split(",")))
                     .map(String::trim)
                     .sorted()
                     .collect(Collectors.joining(", "));

   }
   public static void randomGenerator(int a, int b) {
       MyRandom random = new MyRandom(a,b);
       Stream<Integer> integerStream =  Stream.iterate(1, (seed) -> random.next(seed));
       integerStream.limit(10)
               .peek(System.out::println)
               .collect(Collectors.toList());
   }
   public Stream<T> zipIterator(Stream<T> first, Stream<T> second) {
        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();
        List<T> result = new ArrayList<>();
        while(iteratorFirst.hasNext() && iteratorSecond.hasNext()){
            result.add(iteratorFirst.next());
            result.add(iteratorSecond.next());
        }
        return result.stream();
    }
}
