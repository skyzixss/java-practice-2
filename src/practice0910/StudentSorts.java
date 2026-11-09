package practice0910;

import java.util.Arrays;
import java.util.Comparator;

public final class StudentSorts {
    private StudentSorts() { }

    public static <T extends Comparable<? super T>> void insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(current) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public static <T> void quicksort(T[] array, Comparator<? super T> comparator) {
        quicksort(array, 0, array.length - 1, comparator);
    }

    private static <T> void quicksort(T[] a, int left, int right, Comparator<? super T> c) {
        if (left >= right) return;
        int i = left;
        int j = right;
        T pivot = a[left + (right - left) / 2];
        while (i <= j) {
            while (c.compare(a[i], pivot) < 0) i++;
            while (c.compare(a[j], pivot) > 0) j--;
            if (i <= j) {
                T temp = a[i]; a[i] = a[j]; a[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) quicksort(a, left, j, c);
        if (i < right) quicksort(a, i, right, c);
    }

    public static <T> void mergeSort(T[] a, Comparator<? super T> c) {
        if (a.length < 2) return;
        T[] buffer = Arrays.copyOf(a, a.length);
        mergeSort(a, buffer, 0, a.length, c);
    }

    private static <T> void mergeSort(T[] a, T[] buffer, int left, int right, Comparator<? super T> c) {
        if (right - left < 2) return;
        int middle = left + (right - left) / 2;
        mergeSort(a, buffer, left, middle, c);
        mergeSort(a, buffer, middle, right, c);
        int i = left;
        int j = middle;
        for (int k = left; k < right; k++) {
            if (j == right || (i < middle && c.compare(a[i], a[j]) <= 0)) buffer[k] = a[i++];
            else buffer[k] = a[j++];
        }
        System.arraycopy(buffer, left, a, left, right - left);
    }

    /** Входы могут быть неотсортированными; исходные массивы не изменяются. */
    public static Student[] combine(Student[] first, Student[] second, Comparator<Student> c) {
        Student[] a = first.clone();
        Student[] b = second.clone();
        mergeSort(a, c);
        mergeSort(b, c);
        Student[] result = new Student[a.length + b.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < result.length; k++) {
            if (j == b.length || (i < a.length && c.compare(a[i], b[j]) <= 0)) result[k] = a[i++];
            else result[k] = b[j++];
        }
        return result;
    }
}
