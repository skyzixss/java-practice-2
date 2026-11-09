package practice0910;

import java.util.Comparator;

/** Общая реализация для №9.2 и №10.2. */
public final class SortingStudentsByGPA implements Comparator<Student> {
    private Student[] iDNumber = new Student[0];

    @Override
    public int compare(Student a, Student b) {
        return Double.compare(b.getGpa(), a.getGpa());
    }

    public void setArray() { setArray(sample()); }
    public void setArray(Student[] students) { iDNumber = students.clone(); }
    public Student[] getArray() { return iDNumber.clone(); }
    public void quicksort() { StudentSorts.quicksort(iDNumber, this); }
    public void mergeSort() { StudentSorts.mergeSort(iDNumber, this); }
    public void sortByLastName() {
        StudentSorts.mergeSort(iDNumber, Comparator.comparing(Student::getLastName)
                .thenComparing(Student::getFirstName));
    }
    public void outArray() {
        for (Student student : iDNumber) System.out.println(student);
    }

    public static Student[] sample() {
        return new Student[] {
            new Student(105, "Анна", "Петрова", "Информатика", 2, "КВБО-12-25", 4.60),
            new Student(102, "Иван", "Сидоров", "Информатика", 1, "КВБО-12-25", 4.20),
            new Student(104, "Ольга", "Иванова", "Математика", 2, "КВБО-11-25", 4.90),
            new Student(101, "Павел", "Смирнов", "Информатика", 1, "КВБО-12-25", 4.60)
        };
    }
}
