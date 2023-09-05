package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }
    @GetMapping("/get-book-by-id/{id} ")
    public Book findBookById(@PathVariable String id){
        Book book= bookService.findBookById(id);
        return book;
    }
    @GetMapping("/get-all-books")
    public List<Book> findAllBooks(){
        List<Book> books= bookService.findAllBooks();
        return books;
    }
    @GetMapping("/get-books-by-author")
    public List<Book> findBooksByAuthor(@RequestParam String author){
        List<Book> books= bookService.findBooksByAuthor(author);
        return books;
    }
    @GetMapping("/get-books-by-genre")
    public List<Book> findBooksByGenre(@RequestParam String genre){
        List<Book> books= bookService.findBooksByGenre(genre);
        return books;
    }
    @DeleteMapping("/delete-book-by-id/{id}")
    public String deleteBookById(@PathVariable String id){
        bookService.deleteBookById(id);
        return "Success";
    }
    @DeleteMapping("delete-all-books")
    public String deleteAllBooks(){
        bookService.deleteAllBooks();
        return "Success";
    }

}
