package com.example.todoapp.repositories;

import com.example.todoapp.models.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
    public Todo findByTitleIgnoreCase(String title);
    public Todo findByTickerIgnoreCase(String ticker);
    // public List<Todo> findByTitle(String title);
}