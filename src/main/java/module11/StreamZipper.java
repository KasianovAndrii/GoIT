package module11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamZipper<T> {
    // Напишите метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
    // который "перемешивает" элементы из стримов first и second,
    // останавливается тогда, когда у одного из стримов закончатся элементы.
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
