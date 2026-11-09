package practice13;

public final class Main13 {
    public static void main(String[] args) {
        System.out.println("Задание 1. String:");
        StringTask.analyze("I like Java!!!");
        System.out.println("\nЗадание 2. Person:");
        System.out.println(new Person("Игнатов", "Антон", "Ильич"));
        System.out.println(new Person("Петров", "Иван", null));
        System.out.println(new Person("Сидорова", null, "Петровна"));
        System.out.println(new Person("Смирнов", "", null));
        String[] comma = {
            "Россия, Московская область, Химки, Молодёжная, 10, 2, 15",
            "Россия, Ленинградская область, Гатчина, Лесная, 5, , 7",
            "Россия, Татарстан, Казань, Центральная, 12, 1, 20",
            "Россия, Тульская область, Тула, Садовая, 8, ,"
        };
        String[] mixed = {
            "Россия; Московская область. Химки, Молодёжная; 10. 2, 15",
            "Россия. Ленинградская область; Гатчина, Лесная. 5; ; 7",
            "Россия, Татарстан; Казань. Центральная, 12; 1. 20",
            "Россия; Тульская область. Тула, Садовая; 8.;"
        };
        System.out.println("\nЗадание 3. Четыре адреса, каждый двумя способами:");
        for (int i = 0; i < comma.length; i++) {
            System.out.println("split: " + Address.parseComma(comma[i]));
            System.out.println("StringTokenizer: " + Address.parseMixed(mixed[i]));
        }
        String[] shirts = {
            "S001,Black Polo Shirt,Black,XL", "S002,Black Polo Shirt,Black,L",
            "S003,Blue Polo Shirt,Blue,XL", "S004,Blue Polo Shirt,Blue,M",
            "S005,Tan Polo Shirt,Tan,XL", "S006,Black T-Shirt,Black,XL",
            "S007,White T-Shirt,White,XL", "S008,White T-Shirt,White,L",
            "S009,Green T-Shirt,Green,S", "S010,Orange T -Shirt,Orange,S",
            "S011,Maroon Polo Shirt,Maroon,S"
        };
        Shirt[] objects = new Shirt[shirts.length];
        System.out.println("\nЗадание 4. Массив Shirt:");
        for (int i = 0; i < shirts.length; i++) {
            objects[i] = new Shirt(shirts[i]);
            System.out.println(objects[i] + "\n");
        }
        System.out.println("Задание 5. Телефоны:");
        for (String phone : new String[] {"+79175655655", "+104289652211", "89175655655"}) {
            System.out.println(phone + " -> " + new PhoneNumber(phone));
        }
        System.out.println("\nЗадание 6. Демонстрация getLine (чтение файла: practice13.WordChain):");
        System.out.println(WordChain.getLine("Киев", "Нью-Йорк", "Амстердам", "Вена", "Мельбурн"));
    }
}
