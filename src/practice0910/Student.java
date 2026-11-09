package practice0910;

import java.util.Locale;

public class Student implements Comparable<Student> {
    private int id;
    private String firstName;
    private String lastName;
    private String specialty;
    private int course;
    private String group;
    private double gpa;

    public Student(int id, String firstName, String lastName, String specialty,
                   int course, String group, double gpa) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setSpecialty(specialty);
        setCourse(course);
        setGroup(group);
        setGpa(gpa);
    }

    public int getId() { return id; }
    public final void setId(int id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public final void setFirstName(String value) { firstName = value; }
    public String getLastName() { return lastName; }
    public final void setLastName(String value) { lastName = value; }
    public String getSpecialty() { return specialty; }
    public final void setSpecialty(String value) { specialty = value; }
    public int getCourse() { return course; }
    public final void setCourse(int value) {
        if (value < 1) throw new IllegalArgumentException("Курс должен быть положительным");
        course = value;
    }
    public String getGroup() { return group; }
    public final void setGroup(String value) { group = value; }
    public double getGpa() { return gpa; }
    public final void setGpa(double value) {
        if (!Double.isFinite(value) || value < 0) throw new IllegalArgumentException("Некорректный балл");
        gpa = value;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(id, other.id);
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "%d | %s %s | %s | курс %d | %s | балл %.2f",
                id, lastName, firstName, specialty, course, group, gpa);
    }
}
