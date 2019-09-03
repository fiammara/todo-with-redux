package com.todo.spring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.todo.spring.model.ArchiveItem;



@Service
public interface ArchiveService {

	List<ArchiveItem> findAllArchivedItems();

	ArchiveItem findById(long id);
	
}
