import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class MergeSortTest {


    @Test
    public void mergeSort() {
        List<Integer> elements = asList(1, 22, 21, 16, 15);

        List<Integer> results = MergeSort.sort(elements);

        assertEquals(asList(1, 15, 16, 21, 22), results);

    }
}