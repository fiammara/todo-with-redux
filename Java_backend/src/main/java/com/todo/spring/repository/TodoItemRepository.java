package com.todo.spring.repository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.todo.spring.model.Todo;

@Repository
public interface TodoItemRepository extends CrudRepository<Todo, Long>{
	
	@Override
    List<Todo> findAll();
	
}
