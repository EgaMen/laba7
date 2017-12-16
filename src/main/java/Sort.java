import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Sort {

    public void quickSort(int[]a) {
        qSort(a, 0, a.length-1);
    }
    public void quickSort(int[]a, int fromIndex, int toIndex) {
        rangeCheck(a.length,fromIndex,toIndex);
        qSort(a, fromIndex, toIndex);
    }
    public <T extends Comparable<? super T>> void quickSort(List<T> list) {

        Object[] a = list.toArray();
        qSort(a, 0 , a.length-1);
        ListIterator<T> i = list.listIterator();
        for (int j=0; j<a.length; j++) {
            i.next();
            i.set((T)a[j]);
        }

    }
    public void heapSort(int[]a) {
        hSort(a, 0, a.length);
    }
    public void heapSort(int[]a, int fromIndex, int toIndex) {
        rangeCheck(a.length,fromIndex,toIndex);
        int []b = new int[toIndex-fromIndex];
        System.arraycopy(a, fromIndex, b,0,toIndex-fromIndex);
        hSort(b, 0, b.length);
        System.arraycopy(b,0,a,fromIndex,toIndex-fromIndex);
    }
    public <T extends Comparable<? super T>> void heapSort(List<T> list) {

        Object[] a = list.toArray();
        hSort(a,0,a.length);
        ListIterator<T> i = list.listIterator();
        for (int j=0; j<a.length; j++) {
            i.next();
            i.set((T)a[j]);
        }

    }





    public void mergeSort(int[] a) {
        for (int i = 1; i<a.length; i *= 2) {
            for (int j = 0; j<a.length-i; j += 2 * i) {
                merge(a, j, j + i, Math.min(j + 2 * i, a.length));
            }
        }
    }

    public void mergeSort(int[]a, int fromIndex, int toIndex) {
        rangeCheck(a.length,fromIndex,toIndex);
        int[] buffer1 = new int[toIndex-fromIndex];
        System.arraycopy(a,fromIndex,buffer1,0,toIndex-fromIndex);
        mergeSort(buffer1);
        System.arraycopy(buffer1,0,a,fromIndex,toIndex-fromIndex);

    }
    public <T extends Comparable<? super T>> void mergeSort(List<T> list) {

        Object[] a = list.toArray();
        for (int i = 1; i<a.length; i *= 2) {
            for (int j = 0; j < a.length - i; j += 2 * i) {
                merge(a, j, j + i, Math.min(j + 2 * i, a.length));
            }
        }
        ListIterator<T> i = list.listIterator();
        for (int j=0; j<a.length; j++) {
            i.next();
            i.set((T)a[j]);
        }

    }
    private void merge(Object[] a, int left, int mid, int right) {
        int it1 = 0;
        int it2 = 0;
        Object[] result = new Object[right - left];

        while (left + it1 < mid & mid + it2 < right) {
            if (((Comparable)a[left + it1]).compareTo(a[mid + it2]) <0) {
                result[it1 + it2] = a[left + it1];
                it1 += 1;
            } else {
                result[it1 + it2] = a[mid + it2];
                it2 += 1;
            }
        }
        while (left + it1 < mid) {
            result[it1 + it2] = a[left + it1];
            it1 += 1;
        }
        while (mid + it2 < right){
            result[it1 + it2] = a[mid + it2];
            it2 += 1;
        }
        for(int i = 0;i<it1 + it2;i++)
            a[left + i] = result[i];
    }


    private void merge(int[] a, int left, int mid, int right) {
        int it1 = 0;
        int it2 = 0;
        int[] result = new int[right - left];

        while (left + it1 < mid & mid + it2 < right) {
            if (a[left + it1] < a[mid + it2]) {
                result[it1 + it2] = a[left + it1];
                it1 += 1;
            } else {
                result[it1 + it2] = a[mid + it2];
                it2 += 1;
            }
        }
        while (left + it1 < mid) {
            result[it1 + it2] = a[left + it1];
            it1 += 1;
        }
        while (mid + it2 < right){
            result[it1 + it2] = a[mid + it2];
        it2 += 1;
        }
        for(int i = 0;i<it1 + it2;i++)
        a[left + i] = result[i];
    }


    private void hSort(Object a[],int fromIndex, int toIndex) {
        for (int k = (toIndex-fromIndex) / 2; k > fromIndex; k--)
            downHeap(a, k, toIndex);
        do {
            swap(a, fromIndex, toIndex-1);
            toIndex-= 1;
            downHeap(a, 1, toIndex);
        } while (toIndex > fromIndex+1);
    }
    private void downHeap(Object a[], int k, int N) {
        Object T = a[k - 1];
        while (k <= N / 2) {
            int j = k + k;
            if ((j < N) && (((Comparable)a[j - 1]).compareTo(a[j]) <0 ))
                j++;
            if (((Comparable)T).compareTo(a[j - 1])>0||((Comparable)T).compareTo(a[j - 1])==0)
                break;
            else {
                a[k - 1] = a[j - 1];
                k = j;
            }
        }
        a[k - 1] = T;

    }
    private void hSort(int[]a, int fromIndex, int toIndex) {
        for (int k = (toIndex-fromIndex) / 2; k > fromIndex; k--)
            downHeap(a, k, toIndex);
        do {
            swap(a, fromIndex, toIndex-1);
            toIndex-= 1;
            downHeap(a, 1, toIndex);
        } while (toIndex > fromIndex+1);

    }
    private void downHeap(int a[], int k, int N) {
        int T = a[k - 1];
        while (k <= N / 2) {
            int j = k + k;
            if ((j < N) && (a[j - 1] < a[j]))
                j++;
            if (T >= a[j - 1])
                break;
            else {
                a[k - 1] = a[j - 1];
                k = j;
            }
        }
        a[k - 1] = T;

    }
    private void qSort(Object a[], int l, int r) {
        if (l < r) {
            int q = partition(a, l, r);
            qSort(a, l, q);
            qSort(a, (q + 1), r);
        }
    }
    private void qSort(int[]a, int l, int r) {
        if(l < r){
            int q = partition(a, l, r);
            qSort(a, l, q);
            qSort(a, (q + 1), r);
        }


    }
    private int partition(Object[]a, int l, int r) {
        Object v = a[(l + r+1) / 2];
        int i = l;
        int j = r;
        while (i<=j) {
            while (((Comparable)a[i]).compareTo(v) < 0)
                i++;
            while (((Comparable)a[j]).compareTo(v) > 0)
                j--;
            if (i<=j)
                swap(a,i++, j--);
        }


        return j;
    }
    private int partition(int[]a, int l, int r) {
        int v = a[(l + r+1) / 2];
        int i = l;
        int j = r;
        while (i<=j) {
            while (a[i] < v)
                i++;
            while (a[j] > v)
                j--;
            if (i<=j)
                swap(a,i++, j--);
        }


        return j;
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
