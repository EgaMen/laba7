import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Sort {

    public void LSD(int[]a) {
        radixSort(a);
    }
    public void LSD(int[]a, int fromIndex, int toIndex) {
        rangeCheck(a.length,fromIndex,toIndex);
        int[] buffer1 = new int[toIndex-fromIndex];
        System.arraycopy(a,fromIndex,buffer1,0,toIndex-fromIndex);
        radixSort(buffer1);
        System.arraycopy(buffer1,0,a,fromIndex,toIndex-fromIndex);

    }
    public void MSDSort(int[]a) {
        MSD(a);
    }
    public void MSDSort(int[]a, int fromIndex, int toIndex) {
        rangeCheck(a.length,fromIndex,toIndex);
        int []b = new int[toIndex-fromIndex];
        System.arraycopy(a, fromIndex, b,0,toIndex-fromIndex);
        MSD(b);
        System.arraycopy(b,0,a,fromIndex,toIndex-fromIndex);
    }
    public void countingSort(int[] a) {
        cSort(a);


    }
    public void countingSort(int[]a, int fromIndex, int toIndex) {
        rangeCheck(a.length,fromIndex,toIndex);
        int[] buffer1 = new int[toIndex-fromIndex];
        System.arraycopy(a,fromIndex,buffer1,0,toIndex-fromIndex);
        cSort(buffer1);
        System.arraycopy(buffer1,0,a,fromIndex,toIndex-fromIndex);

    }
    public static void cSort (int[] a) {
        int max = 0;
        for (int x : a)
            max = Math.max(max, x);
        int[] cnt = new int[max + 1];
        for (int x : a)
            cnt[x]++;
        for (int i = 1; i < cnt.length; i++)
            cnt[i] += cnt[i - 1];
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++)
            b[--cnt[a[i]]] = a[i];
        System.arraycopy(b, 0, a, 0, a.length);
    }
    public static void MSD (int[] a) {
        int[] aux = new int[a.length];
        MSD(a, aux, 0, a.length - 1, 1000000000);
    }
    private static void MSD (int[] a, int[] aux, int lo, int hi, int d) {
        if (hi <= lo || d == 0)
            return;
        int[] count = new int[11];
        int[] count2 = new int[11];
        for (int i = lo; i <= hi; i++)
            count[(a[i] / d) % 10 + 1]++;
        for (int i = 1; i < 11; i++)
            count[i] += count[i - 1];
        for (int i = 0; i < 11; i++)
            count2[i] = count[i];
        for (int i = hi; i >= lo; i--)
            aux[count[(a[i] / d) % 10]++] = a[i];
        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];
        for (int i = 0; i < 10; i++)
            MSD(a, aux, lo + count2[i], lo + count2[i + 1] - 1, d / 10);
    }
    private void radixSort(int[]input) {

        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }


        boolean flag = false;
        int tmp = -1, divisor = 1;
        while (!flag) {
            flag = true;

            for (Integer i : input) {
                tmp = i / divisor;
                buckets[tmp % 10].add(i);
                if (flag && tmp > 0) {
                    flag = false;
                }
            }

            int a = 0;
            for (int b = 0; b < 10; b++) {
                for (Integer i : buckets[b]) {
                    input[a++] = i;
                }
                buckets[b].clear();
            }

            divisor *= 10;
        }
    }
    private void swap(int x[], int a, int b) {
        int temp=x[a];
        x[a]=x[b];
        x[b]=temp;
    }
    private void swap(Object[] x, int a, int b) {
        Object temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
    private void rangeCheck(int arrayLen, int fromIndex, int toIndex) {
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex+")");
        if (fromIndex < 0)
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        if (toIndex > arrayLen)
            throw new ArrayIndexOutOfBoundsException(toIndex);

    }

}
