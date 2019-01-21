package com.wildcodeschool.myImaginaryLibrary.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wildcodeschool.myImaginaryLibrary.entities.Book;
import com.wildcodeschool.myImaginaryLibrary.repositories.BookRepository;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> index(){
        return bookRepository.findAll();
    }
    
    @GetMapping("/books/{id}")
    public Book show(@PathVariable Long id){
        return bookRepository.findById(id).get();
    }
    
    @PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return bookRepository.findByTitleContainingOrAuthorContainingOrDescriptionContaining(searchTerm, searchTerm, searchTerm);
    }
    
    @PostMapping("/books")
    public Book create(@RequestBody Book book){
        return bookRepository.save(book);
    }
    
    @PutMapping("/books/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book){
        Book bookToUpdate = bookRepository.findById(id).get();
        if(book.getTitle()!=null) {
        	bookToUpdate.setTitle(book.getTitle());
        }
        if(book.getAuthor()!=null) {
        	bookToUpdate.setAuthor(book.getAuthor());
        }
        if(book.getDescription()!=null) {
        	bookToUpdate.setDescription(book.getDescription());
        }
        return bookRepository.save(bookToUpdate);
    }
    
    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable Long id){
        bookRepository.deleteById(id);
        return true;
    }
}
