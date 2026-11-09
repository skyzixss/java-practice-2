package practice13;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public final class Address {
    private final String country;
    private final String region;
    private final String city;
    private final String street;
    private final String house;
    private final String building;
    private final String apartment;

    private Address(String[] parts) {
        if (parts.length != 7) throw new IllegalArgumentException("В адресе должно быть ровно 7 полей");
        for (int i = 0; i < parts.length; i++) parts[i] = parts[i].trim();
        country = parts[0]; region = parts[1]; city = parts[2]; street = parts[3];
        house = parts[4]; building = parts[5]; apartment = parts[6];
    }
    public static Address parseComma(String line) {
        return new Address(line.split(",", -1)); // -1 сохраняет пустую квартиру в конце.
    }
    public static Address parseMixed(String line) {
        // true возвращает и разделители: соседние разделители означают пустое поле.
        StringTokenizer tokenizer = new StringTokenizer(line, ",.;", true);
        List<String> parts = new ArrayList<>();
        StringBuilder field = new StringBuilder();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.equals(",") || token.equals(".") || token.equals(";")) {
                parts.add(field.toString());
                field.setLength(0);
            } else field.append(token);
        }
        parts.add(field.toString());
        return new Address(parts.toArray(new String[0]));
    }
    public String getCountry() { return country; }
    public String getRegion() { return region; }
    public String getCity() { return city; }
    public String getStreet() { return street; }
    public String getHouse() { return house; }
    public String getBuilding() { return building; }
    public String getApartment() { return apartment; }
    @Override
    public String toString() {
        return "Страна=" + country + "; регион=" + region + "; город=" + city + "; улица=" + street
                + "; дом=" + house + "; корпус=" + building + "; квартира=" + apartment;
    }
}
