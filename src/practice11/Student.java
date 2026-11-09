package practice11;

import java.util.Date;
import java.util.Objects;

/** Расширение Student из практик 9–10 полем даты рождения. */
public final class Student extends practice0910.Student {
    private Date birthday;
    private BirthdayFormat birthdayFormat = BirthdayFormat.SHORT;

    public Student(int id, String firstName, String lastName, String specialty, int course,
                   String group, double gpa, Date birthday) {
        super(id, firstName, lastName, specialty, course, group, gpa);
        setBirthday(birthday);
    }
    public Date getBirthday() { return new Date(birthday.getTime()); }
    public void setBirthday(Date value) { birthday = new Date(Objects.requireNonNull(value).getTime()); }
    public String formatBirthday(BirthdayFormat format) {
        return Dates.formatter(Objects.requireNonNull(format).getPattern()).format(birthday);
    }
    public void setBirthdayFormat(BirthdayFormat value) { birthdayFormat = Objects.requireNonNull(value); }
    public String toString(BirthdayFormat format) {
        return super.toString() + " | дата рождения: " + formatBirthday(format);
    }
    @Override
    public String toString() { return toString(birthdayFormat); }
}
