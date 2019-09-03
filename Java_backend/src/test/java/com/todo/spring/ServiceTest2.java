package com.todo.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.todo.spring.model.Todo;
import com.todo.spring.repository.TodoItemRepository;
import com.todo.spring.service.TodoService;
import contexts.ServicesContextConfig;
import static org.junit.Assert.assertNull;

@EnableAutoConfiguration
@ContextConfiguration(classes = { ServicesContextConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceTest2 {

	private static final long ID = 123;
	private static final String NAME = "Name 123";

	@Autowired
	private TodoService todoService;

	@MockBean
	private TodoItemRepository todoRepository;

	@Test
	public void test_AddItem() {

		Todo todo = createDummy();
		todoService.addTodo(todo);

		verify(todoRepository, times(1)).save(todo);

	}

	@Test
	public void test_findById() {
		Todo todo = createDummy();
		todoService.addTodo(todo);
		long id = todo.getId();

		when(todoRepository.findById(id)).thenReturn(Optional.of(todo));
		Todo loaded = todoService.findById(id);
		assertEquals(ID, loaded.getId());
		assertNotNull(todo);

	}

	@Test
	public void test_delete() {
		Todo todo = createDummy();
		todoService.addTodo(todo);
		long id = todo.getId();

		when(todoRepository.findById(id)).thenReturn(Optional.of(todo));
		Todo loaded = todoService.findById(id);
		assertEquals(ID, loaded.getId());
		assertNotNull(todo);
		todoService.deleteTodo(id);
		assertNull(todo);

	}

	private Todo createDummy() {
		Todo todo = new Todo();
		todo.setId(ID);
		todo.setName(NAME);

		return todo;
	}

}