package org.example.homeworks.stream;

import org.example.homeworks.algoritms.Service;
import org.example.homeworks.stream.library.Author;
import org.example.homeworks.stream.library.BookInLibrary;
import org.example.homeworks.stream.library.Library;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Homework5 {
    public static void runHomework() {
        System.out.println("Задание №1");
        task1();
        System.out.print("\n");
        System.out.println("Задание №2");
        task2();
        System.out.print("\n");
        System.out.println("Задание №3");
        task3();
        System.out.print("\n");
        System.out.println("Задание №4");
        task4();
        System.out.print("\n");
        System.out.println("Задание №5");
        task5();
        System.out.print("\n");
        System.out.println("Задание №6");
        task6();
        System.out.print("\n");
        System.out.println("Задание №7");
        task7();
    }

    private static void task1() {
        int[] array = new int[200];
        Arrays.setAll(array, i -> i + 1);

        int result = Arrays.stream(array)
                .filter(i -> i % 2 == 0)
                .sum();

        System.out.println("Сумма четных чисел в диапазоне от 1 до 200 = " + result);
    }

    private static void task2() {
        List<Integer> list = Arrays.asList(
                Arrays.stream(Service.getRandomArray(20, 100))
                        .boxed()
                        .toArray(Integer[]::new)
        );

        System.out.println("Исходная коллекция: " + list);
        System.out.println("Уникальная коллекция: " + getUniqueFromCollection(list));
    }

    private static void task3() {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1, "book", "king", 5));

        Map<Integer, Book> map = convertListToMap(list);

        System.out.println("Исходная коллекция: " + list);
        System.out.println("Новая коллекция: " + map);
    }

    private static void task4() {
        List<String> list = List.of("car", "book", "apple");

        System.out.println("Исходная коллекция: " + list);
        System.out.println("Объединение в строку: " + list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","))
        );
    }

    private static void task5() {
        List<Product> list = new ArrayList<>();
        list.add(new Product("product1", 10.05, 20L));
        list.add(new Product("product2", 20.45, 10L));

        System.out.println("Исходная коллекция: " + list);
        System.out.println("Общая стоимость всех продуктов = : " + list.stream()
                .mapToDouble(i -> i.getPrice() * i.getVolume())
                .sum()
        );
    }

    private static void task6() {
        Author author1 = new Author("author1");
        Author author2 = new Author("author2");

        List<BookInLibrary> books = new ArrayList<>();
        books.add(new BookInLibrary("book 1", author1));
        books.add(new BookInLibrary("book 2", author1));
        books.add(new BookInLibrary("book 3", author2));
        books.add(new BookInLibrary("book 4", author2));
        books.add(new BookInLibrary("book 5", author2));

        Library library = new Library(books);

        System.out.println("Исходная коллекция: " + books);
        System.out.println("Самый производительный автор: " + library.findAuthorWithMostBooks());
    }

    private static void task7() {
        List<String> list = List.of(
                "Hello world.",
                "The World is mine",
                "This is a simple text",
                "Hello world again!",
                "this Is"
        );

        System.out.println("Исходная коллекция: " + list);

        List<String> result = list.stream()
                .map(i -> i.replaceAll("\\p{Punct}", ""))
                .map(String::toLowerCase)
                .flatMap(i -> Stream.of(i.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long> comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Новая коллекция: " + result);

    }

    private static Map<Integer, Book> convertListToMap(List<Book> list) {
        return list.stream()
                .collect(Collectors.toMap(Book::getId, Function.identity()));
    }

    private static <T> List<T> getUniqueFromCollection(List<T> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
