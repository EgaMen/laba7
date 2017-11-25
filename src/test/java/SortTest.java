import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    @Test
    void selectionSort_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.selectionSort(a);
        assertArrayEquals(a,new int[]{1, 2, 3, 13, 24, 34, 56, 56});
    }

    @Test
    void selectionSortIndex_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.selectionSort(a,2,5);
        assertArrayEquals(a,new int[]{2, 3, 1, 13, 24, 56, 34, 56});
    }

    @Test
    void selectionSortList_Default_True() {
        List a = listFabric();
        Sort sort = new Sort();
        sort.selectionSort(a);
        assertEquals(a.toString(),"[a, b, b, c, f, n]");
    }

    @Test
    void insertionSort_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.insertionSort(a);
        assertArrayEquals(a,new int[]{1, 2, 3, 13, 24, 34, 56, 56});
    }

    @Test
    void insertionSortIndex_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.insertionSort(a,2,5);
        assertArrayEquals(a,new int[]{2, 3, 1, 13, 24, 56, 34, 56});
    }

    @Test
    void insertionSortList_Default_True() {
        List a = listFabric();
        Sort sort = new Sort();
        sort.insertionSort(a);
        assertEquals(a.toString(),"[a, b, b, c, f, n]");
    }

    @Test
    void bubbleSort_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.bubbleSort(a);
        assertArrayEquals(a,new int[]{1, 2, 3, 13, 24, 34, 56, 56});
    }

    @Test
    void bubbleSortIndex_Default_True() {
        int[] a=arrayFabric();
        Sort sort = new Sort();
        sort.bubbleSort(a,2,5);
        assertArrayEquals(a,new int[]{2, 3, 1, 13, 24, 56, 34, 56});

    }

    @Test
    void bubbleSortList_Default_True() {
        List a = listFabric();
        Sort sort = new Sort();
        sort.bubbleSort(a);
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