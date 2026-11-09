package practice11;

public enum BirthdayFormat {
    SHORT("dd.MM.yy"), MEDIUM("dd MMM yyyy"), FULL("EEEE, dd MMMM yyyy 'г.'");
    private final String pattern;
    BirthdayFormat(String pattern) { this.pattern = pattern; }
    public String getPattern() { return pattern; }
}
