package com.wildcodeschool.myImaginaryLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.myImaginaryLibrary.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
