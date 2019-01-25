package bookApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookApplication {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> bookTexts = fileReader.asList("bookApplication/alice.txt");
        System.out.println(bookTexts);
        bookTexts.stream()
                .map(e -> e.replaceAll(",", " "))
                .map(e -> e.replaceAll(";", " "))
                .map(e -> e.replaceAll("’s", " "))
                .map(e -> e.replaceAll("’", " "))
                .map(e -> e.replaceAll("‘", " "))
                .map(e -> e.replaceAll(":", " "))
                .map(e -> e.replaceAll("#", " "))
                .map(e -> e.replaceAll("/", " "))
                .map(e -> e.replaceAll("-", " "))
                .map(e -> e.replaceAll(".", " "))
                .map(e -> e.replaceAll("*", " "))
                .map(e -> e.replaceAll("(", " "))
                .map(e -> e.replaceAll(")", " "))
                .map(e -> e.replaceAll("[", " "))
                .map(e -> e.replaceAll("]", " "))
                .count();

        long count = bookTexts
                .stream()
                .count();
        System.out.println("Number of words: " + count);
        long c = bookTexts.stream()
                .distinct()
                .count();
        System.out.println("Number of distinct words: " + c);
        List<String> three = bookTexts.stream().map(word -> word.split("")).flatMap(e -> Stream.of(e)).collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(1).map(e -> e.getKey() + " | " + e.getValue()).collect(Collectors.toList());
        System.out.println("Most appearing word: " );
        three.forEach(e -> System.out.println());

    }
}
