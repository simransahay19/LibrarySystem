package com.example.Library.System.api;

import com.example.Library.System.entities.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/v1/library")
public interface LibraryInterface {

    @GetMapping("/{libId}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable int libId);


    @PostMapping("/post")
    public Book createBook(@RequestBody Book book);

    @DeleteMapping("/delete/{libId}")
    public String deleteBookById(@PathVariable int libId);

    @PutMapping("/update/{libId}")
    public ResponseEntity<Optional<Book>> updateBookById(@PathVariable int libId, Book book);



}
