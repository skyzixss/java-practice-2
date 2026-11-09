package practice0910;

public final class Main09 {
    public static void main(String[] args) {
        Student[] iDNumber = SortingStudentsByGPA.sample();
        System.out.println("Задание 1. Исходный массив:");
        for (Student s : iDNumber) System.out.println(s);
        StudentSorts.insertionSort(iDNumber);
        System.out.println("Сортировка вставками по ID:");
        for (Student s : iDNumber) System.out.println(s);
        System.out.println("Задание 2. Быстрая сортировка по баллу, убывание:");
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();
        sorter.setArray();
        sorter.quicksort();
        sorter.outArray();
    }
}
