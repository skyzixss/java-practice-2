package practice13;

public final class PhoneNumber {
    private final String formatted;

    public PhoneNumber(String input) {
        String normalized;
        if (input.matches("8[0-9]{10}")) normalized = "+7" + input.substring(1);
        else if (input.matches("\\+[1-9][0-9]{10,12}")) normalized = input;
        else throw new IllegalArgumentException("Нужен +код и 10 цифр либо 8 и 10 цифр");
        int start = normalized.length() - 10;
        formatted = normalized.substring(0, start) + normalized.substring(start, start + 3)
                + "-" + normalized.substring(start + 3, start + 6) + "-" + normalized.substring(start + 6);
    }
    @Override
    public String toString() { return formatted; }
}
