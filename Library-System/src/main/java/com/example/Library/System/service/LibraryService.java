package com.example.Library.System.service;


import com.example.Library.System.entities.Book;
import com.example.Library.System.repository.LibraryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    public Book create(Book book) {
        return libraryRepository.save(book);
    }


    public Optional<Book> getBookById(int libId) {
        return libraryRepository.findById(libId);
    }

    public String deleteBookById(int libId) {
        libraryRepository.deleteById(libId);
        return "Done";


    }


    public Optional<Book> updateBookById(int libId, Book newBookDetails) {

        Optional<Book> existingBook = libraryRepository.findById(libId);

        if (existingBook.isPresent()) {
            Book bookToUpdate = existingBook.get();
            // Update the fields with newBookDetails
            bookToUpdate.setTitle(newBookDetails.getTitle());
            bookToUpdate.setAuthor(newBookDetails.getAuthor());
            bookToUpdate.setISBN(newBookDetails.getISBN());
            // ... set other fields as needed

            // Save the updated book
            libraryRepository.save(bookToUpdate);
            return Optional.of(bookToUpdate);
        } else {
            return Optional.empty();
        }
        }

    }


