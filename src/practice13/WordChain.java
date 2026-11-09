package practice13;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public final class WordChain {
    private WordChain() { }
    private static char first(String word) { return Character.toLowerCase(word.charAt(0)); }
    private static char last(String word) { return Character.toLowerCase(word.charAt(word.length() - 1)); }

    /** Слова — рёбра графа; первая и последняя буквы — вершины. Ищем эйлеров путь. */
    public static StringBuilder getLine(String... words) {
        if (words.length == 0) return new StringBuilder();
        Map<Character, Deque<Integer>> edges = new HashMap<>();
        Map<Character, Integer> balance = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i] == null || words[i].isEmpty()) throw new IllegalArgumentException("Пустое слово");
            char from = first(words[i]);
            char to = last(words[i]);
            edges.computeIfAbsent(from, key -> new ArrayDeque<>()).addLast(i);
            balance.merge(from, 1, Integer::sum);
            balance.merge(to, -1, Integer::sum);
        }
        char start = first(words[0]);
        int starts = 0;
        int ends = 0;
        for (Map.Entry<Character, Integer> entry : balance.entrySet()) {
            int degree = entry.getValue();
            if (degree == 1) { starts++; start = entry.getKey(); }
            else if (degree == -1) ends++;
            else if (degree != 0) throw noChain();
        }
        if (!((starts == 0 && ends == 0) || (starts == 1 && ends == 1))) throw noChain();
        Deque<Character> vertices = new ArrayDeque<>();
        Deque<Integer> incoming = new ArrayDeque<>();
        List<Integer> reversed = new ArrayList<>();
        vertices.push(start);
        incoming.push(-1);
        while (!vertices.isEmpty()) {
            Deque<Integer> next = edges.get(vertices.peek());
            if (next != null && !next.isEmpty()) {
                int edge = next.removeFirst();
                vertices.push(last(words[edge]));
                incoming.push(edge);
            } else {
                vertices.pop();
                int edge = incoming.pop();
                if (edge != -1) reversed.add(edge);
            }
        }
        if (reversed.size() != words.length) throw noChain(); // Несвязные компоненты.
        Collections.reverse(reversed);
        StringBuilder result = new StringBuilder();
        for (int edge : reversed) {
            if (result.length() > 0) result.append(' ');
            result.append(words[edge]);
        }
        return result;
    }
    private static IllegalArgumentException noChain() {
        return new IllegalArgumentException("Цепочку из всех слов построить невозможно");
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Введите путь к текстовому файлу UTF-8:");
        String filename = new Scanner(System.in).nextLine();
        String text = Files.readString(Path.of(filename), StandardCharsets.UTF_8).trim();
        String[] words = text.isEmpty() ? new String[0] : text.split("\\s+");
        try {
            System.out.println(getLine(words));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
