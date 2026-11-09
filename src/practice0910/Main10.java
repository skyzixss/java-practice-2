package practice0910;

public final class Main10 {
    public static void main(String[] args) {
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();
        sorter.setArray();
        System.out.println("Задание 1. Объекты Student:");
        sorter.outArray();
        System.out.println("Задание 2. Быстрая сортировка по баллу:");
        sorter.quicksort();
        sorter.outArray();
        System.out.println("Сортировка слиянием по баллу:");
        sorter.setArray();
        sorter.mergeSort();
        sorter.outArray();
        System.out.println("Сортировка по фамилии и имени:");
        sorter.sortByLastName();
        sorter.outArray();
        System.out.println("Задание 3. Объединение двух массивов по баллу:");
        Student[] all = SortingStudentsByGPA.sample();
        Student[] first = {all[0], all[1]};
        Student[] second = {all[2], all[3]};
        for (Student s : StudentSorts.combine(first, second, sorter)) System.out.println(s);
    }
}
