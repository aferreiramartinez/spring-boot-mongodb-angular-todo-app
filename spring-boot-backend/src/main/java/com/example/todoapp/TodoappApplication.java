package com.example.todoapp;

import com.example.todoapp.repositories.TodoRepository;
import com.example.todoapp.models.*;
import com.example.todoapp.controllers.TodoController;

import java.util.HashMap;
import java.util.Map;
import org.bson.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoappApplication implements CommandLineRunner {
	
	@Autowired
	private TodoRepository repository;
	@Autowired
	private TodoController controller;


	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Document masterDoc = new Document();
		System.out.println("start");
		// 1) Add title title
		masterDoc.put("title", "foo");

		// 2) Add completed
		masterDoc.put("completed",(Boolean)true);

		// 3) Add a document
		Document aDoc = new Document("myKey", "myValue");
		masterDoc.put("finantials",aDoc);

		Todo aTodo = new Todo(masterDoc);

		//STORE IN DB
		// controller.createTodo(aTodo);

		//TEST DATA
		System.out.println("before");
		for (Todo customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println("after");
		System.out.println(repository.findById("5b0e3b90373aa12848760a66"));
		System.out.println("after2");
		System.out.println(repository.findByTickerIgnoreCase("AAPL"));
		// Todo customer = repository.findByTicker("AAPL");
		// 	System.out.println(customer);
		System.out.println("after3");
	}
	
	// @Override
	// public void run(String... args) throws Exception {
	// 	Document masterDoc = new Document();
	// 	System.out.println("start");
	// 	// 1) Add title title
	// 	masterDoc.put("title", "foo");

	// 	// 2) Add completed
	// 	masterDoc.put("completed",(Boolean)true);

	// 	// 3) Add a document
	// 	Document aDoc = new Document("myKey", "myValue");
	// 	masterDoc.put("finantials",aDoc);

	// 	Todo aTodo = new Todo(masterDoc);

	// 	//STORE IN DB
	// 	controller.createTodo(aTodo);

	// 	//TEST DATA
	// 	System.out.println("before");
	// 	for (Todo customer : repository.findAll()) {
	// 		System.out.println(customer);
	// 	}
	// 	System.out.println("after");
	// 	System.out.println(repository.findById("5ba7b8b934236265b4184db5"));
	// 	System.out.println("after2");
	// 	System.out.println(repository.findByTitle("foo"));
	// 	// Todo customer = repository.findByTicker("AAPL");
	// 	// 	System.out.println(customer);
	// 	System.out.println("after3");
	// }
}
