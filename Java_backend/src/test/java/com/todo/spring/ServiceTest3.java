package com.todo.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.todo.spring.model.ArchiveItem;
import com.todo.spring.model.Todo;
import com.todo.spring.repository.TodoItemRepository;
import com.todo.spring.service.ArchiveService;
import com.todo.spring.service.TodoService;
import contexts.RepositoriesContextConfig;
import contexts.ServicesContextConfig;
import static org.junit.Assert.assertNull;

@EnableAutoConfiguration
@ContextConfiguration(classes = { RepositoriesContextConfig.class, ServicesContextConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceTest3 {

	private static final long ID = 123;
	private static final String NAME = "Name 123";

	@Autowired
	private TodoService todoService;

	@Autowired
	private TodoItemRepository todoRepository;

	@Autowired
	private ArchiveService archiveService;

	@After
	@Before
	public void afterEachCase() {
		todoRepository.deleteAll();
	}

	@Test
	public void test_AddTodo() {

		Todo todo = createDummy();
		todoService.addTodo(todo);

		Assert.assertEquals(1, todoService.findAllTodos().size());
	}

	@Test
	public void test_findById() {
		Todo todo = createDummy();
		todoService.addTodo(todo);
		long id = todo.getId();

		Todo loaded = todoService.findById(id);

		assertNotNull(todo);
		assertEquals(ID, loaded.getId());

	}

	@Test
	public void test_deleteById() {
		Todo todo = createDummy();
		todoService.addTodo(todo);
		long id = todo.getId();

		Todo loaded = todoService.findById(id);
		todoService.deleteTodo(id);
		Todo loaded2 = todoService.findById(id);
		assertNull(loaded2);
		assertEquals(ID, loaded.getId());
		ArchiveItem loaded3 = archiveService.findById(todo.getId());
		assertNotNull(loaded3);

	}

	private Todo createDummy() {
		Todo todo = new Todo();
		todo.setId(ID);
		todo.setName(NAME);

		return todo;
	}

}