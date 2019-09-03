package com.todo.spring.service;

import java.util.List;


import org.springframework.stereotype.Service;
import com.todo.spring.model.Todo;

@Service
public interface TodoService {
	List<Todo> findAllTodos();

	void addTodo(Todo todo);

	Todo findById(long id);

	void deleteTodo(long id);
}
