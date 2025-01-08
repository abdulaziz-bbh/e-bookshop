package org.example.domain.repository;

import org.example.domain.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    public List<Author> authors = new ArrayList<>();


    public void save(Author author) {
        authors.add(author);
    }

    public void update(Author newAuthor, Long id) {
        int index = 0;
        for (Author author : authors) {
            if (author.getId().equals(id)) {
                index = authors.indexOf(author);
                break;
            }
        }
        authors.set(index, newAuthor);
    }

}
