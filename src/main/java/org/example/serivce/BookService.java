package org.example.serivce;

import org.example.domain.Book;
import org.example.repository.BookRepository;

import java.util.List;
import java.util.UUID;

public class BookService {

    public BookRepository repository = new BookRepository();

    public Book create(Book book) {
        repository.add(book);
        return book;
    }
    public Book update(Book book, String id) {
        repository.update(book, id);
        return book;
    }
    public Book findById(String id) {
        return repository.get(id);
    }

    public List<Book> findAll() {
        return repository.getAll();
    }
    public void delete(String id) {
        repository.delete(id);
    }
}
