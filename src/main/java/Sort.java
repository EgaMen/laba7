import java.util.List;
import java.util.ListIterator;

public class Sort {

    public void bubbleSort(int[]a) {
        sortB(a, 0, a.length);
    }
    public void bubbleSort(int[]a, int fromIndex, int toIndex) {
        rangeCheck(a.length,fromIndex,toIndex);
        sortB(a, fromIndex, toIndex);
    }
    public <T extends Comparable<? super T>> void bubbleSort(List<T> list) {

        Object[] a = list.toArray();
        sortB(a);
        ListIterator<T> i = list.listIterator();
        for (int j=0; j<a.length; j++) {
            i.next();
            i.set((T)a[j]);
        }

    }


    public void insertionSort(int[]a) {
        sortI(a, 0, a.length);
    }
    public void insertionSort(int[]a, int fromIndex, int toIndex) {
        rangeCheck(a.length,fromIndex,toIndex);
        sortI(a, fromIndex, toIndex);
    }
    public <T extends Comparable<? super T>> void insertionSort(List<T> list) {

        Object[] a = list.toArray();
        sortI(a);
        ListIterator<T> i = list.listIterator();
        for (int j=0; j<a.length; j++) {
            i.next();
            i.set((T)a[j]);
        }

    }
    public void selectionSort(int[]a) {
        sortI(a, 0, a.length);
    }
    public void selectionSort(int[]a, int fromIndex, int toIndex) {
        rangeCheck(a.length,fromIndex,toIndex);
        sortI(a, fromIndex, toIndex);
    }
    public <T extends Comparable<? super T>> void selectionSort(List<T> list) {

        Object[] a = list.toArray();
        sortI(a);
        ListIterator<T> i = list.listIterator();
        for (int j=0; j<a.length; j++) {
            i.next();
            i.set((T)a[j]);
        }

    }
    private void sortS(Object a[]) {
        for(int i = 0;i<a.length-1;i++) {
            int min = i;
            for(int j = i + 1; j<a.length;j++) {
                if (((Comparable) a[j]).compareTo(a[min]) <0)
                    min = j;
            }
            swap(a, i,min);

        }

    }
    private void sortS(int[]a, int fromIndex, int toIndex) {
        for(int i = fromIndex;i<toIndex-1;i++) {
            int min = i;
            for(int j = i + 1; j<toIndex;j++) {
                if (a[j] < a[min])
                    min = j;
            }
            swap(a, i,min);

        }
    }

    private void sortI(Object a[]) {
        for (int i = 0; i < a.length; i++) {
            int j = i - 1;
            while (j >= 0 && ((Comparable) a[j]).compareTo(a[j + 1]) > 0) {
                swap(a, j, j + 1);
                j--;
            }

        }
    }


    private void sortI(int[]a, int fromIndex, int toIndex) {
        for(int i = fromIndex+1; i<toIndex; i++) {
            int j = i - 1;
            while (j>=fromIndex&&a[j] >a[j + 1]) {
                swap(a, j, j+1);
                j--;
            }
        }

    }


    private void sortB(Object a[]) {
        int i = 0;
        boolean t = true;
        while (t) {
            t = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (((Comparable) a[j]).compareTo(a[j + 1]) > 0) {
                    swap(a, j, j + 1);
                    t = true;
                }
            }
            i = i + 1;
        }
    }
    private void sortB(int[]a, int fromIndex, int toIndex) {
        int i =0;
        boolean t = true;
        while (t) {
            t=false;
            for(int j=fromIndex; j<toIndex-i-1;j++) {
                if(a[j]>a[j+1]) {
                    swap(a, j,j+1);
                    t=true;
                }
            }
            i=i+1;
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
