package com.example.Library.System.controller;


import com.example.Library.System.api.LibraryInterface;
import com.example.Library.System.entities.Book;
import com.example.Library.System.service.LibraryService;
import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LibraryController implements LibraryInterface {

    @Autowired
    LibraryService libraryService;


    @Override
    public ResponseEntity<Optional<Book>> getBookById(int libId) {
        Optional<Book> book = libraryService.getBookById(libId);

        if (book == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(book);
    }



    @Override
    public Book createBook(@RequestBody Book book){
        System.out.println(book.getTitle());
        return libraryService.create(book);

    }

    @Override
    public String deleteBookById(int libId) {
        //Optional<Book> book = libraryService.deleteBookById(libId);
        return libraryService.deleteBookById(libId);


    }

    @Override
    public ResponseEntity<Optional<Book>> updateBookById(@PathVariable int libId, @RequestBody Book book) {
        Optional<Book> updatedBook = libraryService.updateBookById(libId, book);

        if (updatedBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }
    }

}
