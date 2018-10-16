import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static <T extends Comparable<T>> List<T> merge(List<T> first, List<T> second, List<T> accumulator) {
        if (first.isEmpty()) {
            accumulator.addAll(second);
        }
        else if (second.isEmpty()) {
            accumulator.addAll(first);
        }
        else {
            if (first.get(0).compareTo(second.get(0)) <= 0) {
                accumulator.add(first.get(0));
                return merge(first.subList(1, first.size()), second, accumulator);
            }
            else {
                accumulator.add(second.get(0));
                return merge(first, second.subList(1, second.size()), accumulator);
            }
        }
        return accumulator;
    }

    public static <T extends Comparable<T>> List<T> mergeSort(List<T> list) {

        int mid = list.size()/2;
        if (mid == 0) {
            return list;
        }
        return merge(
            mergeSort(list.subList(0, mid)),
            mergeSort(list.subList(mid, list.size())),
            new ArrayList<>()
        );
    }

    public static void main(String[] args) {
        mergeSort(Arrays.asList(4, 1, 3, 2)).forEach(System.out::println);
    }
}
