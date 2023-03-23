package com.patternJava.behavioral.iterator.iterator_3;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Kobzar", "Taras Shevchenko", 1840));
        books.add(new Book("The Forest Song", "Lesya Ukrainka", 1893));
        books.add(new Book("Eneida", "Ivan Kotliarevsky", 1798));
        
        BookIterator iterator = new BookIterator(books);
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " (" + book.getPublicationYear() + ")");
        }
    }
}

/*
Let's say we have a collection of books and we want to iterate over the collection to perform certain operations on each 
book. We can use the Iterator pattern to achieve this.

First, we define an Iterator interface with two methods: hasNext() and next(). The hasNext() method returns true if there 
are more elements in the collection to iterate over, and the next() method returns the next element in the collection:
 */
interface Iterator<T> {
    boolean hasNext();

    T next();
}

/*
Next, we define a concrete implementation of the Iterator interface for our collection of books. We'll call this 
implementation BookIterator:
 */
class BookIterator implements Iterator<Book> {
    private List<Book> books;
    private int position;

    public BookIterator(List<Book> books) {
        this.books = books;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Collection is empty");
        }
        Book book = books.get(position);
        position++;
        
        return book;
    }
}

class Book {
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}