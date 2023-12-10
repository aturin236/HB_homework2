package org.example.homeworks.stream.library;

public class BookInLibrary {
    private final String title;
    private final Author author;

    public BookInLibrary(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "BookInLibrary{" +
                "title='" + title + '\'' +
                ", author=" + author +
                '}';
    }
}
