package com.todo.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.todo.spring.model.ArchiveItem;
import com.todo.spring.service.ArchiveService;

@CrossOrigin
@RestController
@RequestMapping("/api/archive")
public class ArchiveController {

	@Autowired
	private ArchiveService archiveService;

	@GetMapping
	public List<ArchiveItem> findAllTodos() {
		return archiveService.findAllArchivedItems();
	}
	
}
