import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortTest {
    @Test
    void countingSort_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.countingSort(a);
        assertArrayEquals(a,new int[]{1, 2, 3, 13, 24, 34, 56, 56});
    }

    @Test
    void countingSortIndex_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.countingSort(a,2,5);
        assertArrayEquals(a,new int[]{2, 3, 1, 13, 24, 56, 34, 56});
    }


    @Test
    void MSDSort_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.MSDSort(a);
        assertArrayEquals(a,new int[]{1, 2, 3, 13, 24, 34, 56, 56});
    }

    @Test
    void MSDSort_Index_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.MSDSort(a,2,5);
        assertArrayEquals(a,new int[]{2, 3, 1, 13, 24, 56, 34, 56});
    }


    @Test
    void LSD_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.LSD(a);
        assertArrayEquals(a,new int[]{1, 2, 3, 13, 24, 34, 56, 56});
    }

    @Test
    void LSD_Index_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.LSD(a,2,5);
        assertArrayEquals(a,new int[]{2, 3, 1, 13, 24, 56, 34, 56});

    }













    private int[] arrayFabric() {
        int[] a = {2, 3, 13, 24, 1, 56, 34, 56};
        return a;
    }

    private List listFabric() {
        List<String> list = new LinkedList<>();
        list.add("b");
        list.add("c");
        list.add("b");
        list.add("f");
        list.add("a");
        list.add("n");
        return list;
    }
}