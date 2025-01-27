package org.example.serivce;

import org.example.domain.Author;
import org.example.repository.AuthorRepository;
import org.example.util.Utils;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AuthorService {

    public AuthorRepository repository = new AuthorRepository();

    public void create() {
          repository.add(requestAuthor());
        Utils.println("Author created");
        Utils.println("""
                =
                =
                =
                =
                """);
    }

    public void update () {
        Utils.print("author id'sini kiriting:");
        String id = Utils.scanner().nextLine();
        repository.update(requestAuthor(), id);
        Utils.println("""
                =
                =
                =
                =
                """);

    }
    public Author findById() {
        Utils.print("author id'sini kiriting:");
        String id = Utils.scanner().nextLine();
        return repository.get(id);
    }
    public List<Author> findAll() {
        return repository.getAll();
    }
    public void delete() {
        Utils.print("author id'sini kiriting:");
        String id = Utils.scanner().nextLine();
        repository.delete(id);
        Utils.println("""
                Author deleted successfully
                """);
    }

    private Author requestAuthor() {
        Utils.print("author full name ni kiriting: ");
        String fullName = Utils.scanner().nextLine();
        Utils.print("author birthdate ni kiriting(yyyy-MM-dd): ");
        LocalDate birthdate = LocalDate.parse(new Scanner(System.in).next());
        Utils.print("author death date ni kiriting(yyyy-MM-dd): ");
        LocalDate deathDate = LocalDate.parse(new Scanner(System.in).next());
        Utils.print("author country ni kiriting: ");
        String country = new Scanner(System.in).nextLine();
        Utils.print("author biography ni kiriting: ");
        String biography = new Scanner(System.in).nextLine();
        return new Author(fullName, birthdate, deathDate, country, biography);

    }
}
