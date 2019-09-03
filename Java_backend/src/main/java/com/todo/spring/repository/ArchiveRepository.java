package com.todo.spring.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.todo.spring.model.ArchiveItem;

@Repository
public interface ArchiveRepository extends CrudRepository<ArchiveItem, Long> {

	@Override
	List<ArchiveItem> findAll();

}
