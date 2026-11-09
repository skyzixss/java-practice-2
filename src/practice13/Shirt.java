package practice13;

public final class Shirt {
    private final String id;
    private final String description;
    private final String color;
    private final String size;

    public Shirt(String line) {
        String[] parts = line.split(",", -1);
        if (parts.length != 4) throw new IllegalArgumentException("В записи рубашки должно быть 4 поля");
        id = parts[0].trim(); description = parts[1].trim();
        color = parts[2].trim(); size = parts[3].trim();
    }
    public String getId() { return id; }
    public String getDescription() { return description; }
    public String getColor() { return color; }
    public String getSize() { return size; }
    @Override
    public String toString() {
        return "Артикул: " + id + "\nОписание: " + description + "\nЦвет: " + color + "\nРазмер: " + size;
    }
}
