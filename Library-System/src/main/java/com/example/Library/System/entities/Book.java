package com.example.Library.System.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Book {

    @Id   //THIS BASICALLY TELLS THAT ID IS THE PRIMARY KEY.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This is basically
    int id;
    String title;
    String author;
    int ISBN;
}
