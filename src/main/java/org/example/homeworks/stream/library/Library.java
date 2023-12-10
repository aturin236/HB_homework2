package org.example.homeworks.stream.library;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {
    private final List<BookInLibrary> books;

    public Library(List<BookInLibrary> books) {
        this.books = books;
    }

    public Author findAuthorWithMostBooks() {
        return books.stream()
                .collect(Collectors.groupingBy(BookInLibrary::getAuthor, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
