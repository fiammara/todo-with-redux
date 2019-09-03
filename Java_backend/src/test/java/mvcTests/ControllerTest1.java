package mvcTests;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.todo.spring.controller.TodoController;
import com.todo.spring.model.Todo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest1 {

	private final static String REQUEST_MAPPING = "api/todos";

	@LocalServerPort
	private int port;

	@Autowired
	private TodoController todoController;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void before() {

		restTemplate.getRestTemplate().setInterceptors(Collections.singletonList((request, body, execution) -> {

			return execution.execute(request, body);
		}));
	}

	@Test
	public void contextLoads() throws Exception {
		assertThat(todoController).isNotNull();

	}

	@Test
	public void test_findAllTodos() throws Exception {
		assertThat(this.restTemplate.getForObject(link(), ArrayList.class)).hasSize(0);
	}

	@Test
	public void test_addTodo() throws Exception {
		Todo todo = new Todo();
		todo.setId(11);
		todo.setName("name0");

		ResponseEntity<String> entity = this.restTemplate.postForEntity(link() + "/addTodo", todo, String.class);
		assertThat(entity.getBody()).isNotBlank();

		assertThat(this.restTemplate.getForObject(link(), ArrayList.class)).hasSize(1);
	}

	private String link() {
		return "http://localhost:" + port + "/" + REQUEST_MAPPING;
	}

}