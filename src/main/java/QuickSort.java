import static java.util.Collections.swap;

import java.util.Arrays;
import java.util.List;

public class QuickSort {

    public static <T extends Comparable<T>> List<T> quicksort(List<T> collection) {
        return quicksort(collection, 0, collection.size() - 1);
    }

    public static <T extends Comparable<T>> List<T> quicksort(List<T> collection, int left, int right) {
        if (left >= right) return collection;
        final T pivot = collection.get((left + right) / 2);
        int index = partition(collection, left, right, pivot);
        quicksort(collection, left, index - 1);
        quicksort(collection, index, right);
        return collection;
    }

    public static <T extends Comparable<T>> int partition(List<T> collection, int left, int right, T pivot) {
        while (left <= right) {
            while (collection.get(left).compareTo(pivot) < 0) {
                left++;
            }
            while (collection.get(right).compareTo(pivot) > 0) {
                right--;
            }

            if (left <= right) {
                if (left != right) swap(collection, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(
            quicksort(Arrays.asList(3, 2, 1, 4, 0))
        );
    }
}
