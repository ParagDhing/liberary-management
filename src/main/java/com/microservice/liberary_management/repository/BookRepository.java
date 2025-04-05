package com.microservice.liberary_management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.liberary_management.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer>{

}
