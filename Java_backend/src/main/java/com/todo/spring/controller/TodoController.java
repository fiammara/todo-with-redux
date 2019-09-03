package com.todo.spring.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.todo.spring.model.Todo;
import com.todo.spring.service.TodoService;


@CrossOrigin
@RestController
@RequestMapping("/api/todos")

public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	
	@GetMapping
	public List<Todo> findAllTodos() {
		return todoService.findAllTodos();
	}
	
	@GetMapping(path = "{id}")
	public Todo getTodo(@PathVariable final long id) {
		return todoService.findById(id);
	}
	

	@RequestMapping(method = RequestMethod.POST, value="/addTodo")
	public long save(@RequestBody @Valid Todo todo) {
		todoService.addTodo(todo);

		return todo.getId();
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public String deleteTodo(@PathVariable long id) {
		todoService.deleteTodo(id);
		return "todo deleted";
	}
}
