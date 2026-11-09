package practice13;

public final class Person {
    private final String lastName;
    private final String firstName;
    private final String middleName;

    public Person(String lastName, String firstName, String middleName) {
        if (lastName == null || lastName.trim().isEmpty()) throw new IllegalArgumentException("Нет фамилии");
        this.lastName = lastName.trim();
        this.firstName = firstName == null ? "" : firstName.trim();
        this.middleName = middleName == null ? "" : middleName.trim();
    }
    public String getShortName() {
        StringBuilder result = new StringBuilder(lastName);
        if (!firstName.isEmpty() || !middleName.isEmpty()) result.append(' ');
        if (!firstName.isEmpty()) result.append(firstName.charAt(0)).append('.');
        if (!middleName.isEmpty()) result.append(middleName.charAt(0)).append('.');
        return result.toString();
    }
    @Override
    public String toString() { return getShortName(); }
}
