import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    private static final int FIRST_ELEMENT = 0;

    private static <T extends Comparable<T>> List<T> merge(List<T> first, List<T> second, List<T> accumulator) {
        if (first.isEmpty()) {
            accumulator.addAll(second);
        }
        else if (second.isEmpty()) {
            accumulator.addAll(first);
        }
        else {
            if (first.get(FIRST_ELEMENT).compareTo(second.get(FIRST_ELEMENT)) <= 0) {
                accumulator.add(first.get(FIRST_ELEMENT));
                return merge(first.subList(FIRST_ELEMENT + 1, first.size()), second, accumulator);
            }
            else {
                accumulator.add(second.get(FIRST_ELEMENT));
                return merge(first, second.subList(FIRST_ELEMENT + 1, second.size()), accumulator);
            }
        }
        return accumulator;
    }

    public static <T extends Comparable<T>> List<T> sort(List<T> list) {

        int mid = list.size()/2;
        if (mid == 0) {
            return list;
        }
        return merge(
            sort(list.subList(0, mid)),
            sort(list.subList(mid, list.size())),
            new ArrayList<>()
        );
    }


    private MergeSort() {}

    public static void main(String[] args) {
        sort(Arrays.asList(4, 1, 3, 2, 5)).forEach(System.out::println);
    }
}
