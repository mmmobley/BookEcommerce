package com.tts.ECommerce.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.ECommerce.Models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
    Book findById(long id);
    List<Book> findByAuthor(String author);
    List<Book> findByGenre(String genre);
    List<Book> findByAuthorAndGenre(String author, String genre);

    @Query("SELECT DISTINCT b.author FROM Book b")
    List<String> findDistinctAuthors();

    @Query("SELECT DISTINCT b.genre FROM Book b")
    List<String> findDistinctGenres();
}