package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    HashMap<Integer, Book> bookDb= new HashMap<>();
    public BookRepository(){
        
    }

    public Book save(Book book){
        bookDb.put(book.getId(), book );
        return null;
    }

    public Book findBookById(int id){
    if(bookDb.containsKey(id)) return bookDb.get(id);
        return null;
    }

    public List<Book> findAll(){
        List<Book> books= new ArrayList<>(bookDb.values());
        return books;
    }

    public void deleteBookById(int id){
        if(bookDb.containsKey(id))bookDb.remove(id);
        return;
    }

    public void deleteAll(){
        bookDb.clear();
        return;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> books= new ArrayList<>();
        for(Book book: bookDb.values()){
            if(book.getAuthor().equals(author)) books.add(book);
        }
        return books;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> books= new ArrayList<>();
        for(Book book: bookDb.values()){
            if(book.getGenre().equals(genre)) books.add(book);
        }
        return books;
    }
}
