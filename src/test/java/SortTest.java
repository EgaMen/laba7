import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    @Test
    void mergeSort_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.mergeSort(a);
        assertArrayEquals(a,new int[]{1, 2, 3, 13, 24, 34, 56, 56});
    }

    @Test
    void mergeSortIndex_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.mergeSort(a,2,5);
        assertArrayEquals(a,new int[]{2, 3, 1, 13, 24, 56, 34, 56});
    }

    @Test
    void mergeSortList_Default_True() {
        List a = listFabric();
        Sort sort = new Sort();
        sort.mergeSort(a);
        assertEquals(a.toString(),"[a, b, b, c, f, n]");
    }

    @Test
    void heapSort_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.heapSort(a);
        assertArrayEquals(a,new int[]{1, 2, 3, 13, 24, 34, 56, 56});
    }

    @Test
    void heapSortIndex_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.heapSort(a,2,5);
        assertArrayEquals(a,new int[]{2, 3, 1, 13, 24, 56, 34, 56});
    }

    @Test
    void heapSortList_Default_True() {
        List a = listFabric();
        Sort sort = new Sort();
        sort.heapSort(a);
        assertEquals(a.toString(),"[a, b, b, c, f, n]");
    }

    @Test
    void quickSort_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.quickSort(a);
        assertArrayEquals(a,new int[]{1, 2, 3, 13, 24, 34, 56, 56});
    }

    @Test
    void quickSortIndex_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.quickSort(a,2,5);
        assertArrayEquals(a,new int[]{2, 3, 1, 13, 24, 56, 34, 56});

    }

    @Test
    void quickSortList_Default_True() {
        List a = listFabric();
        Sort sort = new Sort();
        sort.quickSort(a);
        assertEquals(a.toString(),"[a, b, b, c, f, n]");
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