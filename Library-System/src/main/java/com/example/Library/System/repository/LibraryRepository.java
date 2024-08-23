package com.example.Library.System.repository;

import com.example.Library.System.entities.Book;
import org.apache.tomcat.jni.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibraryRepository extends JpaRepository<Book, Integer> {

    //Here we can write custom queries if needed

}

