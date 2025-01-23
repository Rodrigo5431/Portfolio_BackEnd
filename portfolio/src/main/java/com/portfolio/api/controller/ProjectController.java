package com.portfolio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.api.dto.ProjectDTO;
import com.portfolio.api.dto.ProjectInsertDTO;
import com.portfolio.api.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping
	public ResponseEntity<List<ProjectDTO>> listProjects() {
		return ResponseEntity.ok(projectService.listAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProjectDTO> searchById(Long id) {
        return ResponseEntity.ok(projectService.getById(id));
    }

	@PostMapping
	public ResponseEntity<ProjectDTO> create(@RequestPart MultipartFile file,
			@RequestPart ProjectInsertDTO projectInsert) {
		return ResponseEntity.ok(projectService.save(projectInsert, file));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProjectDTO> update(Long id, @RequestPart MultipartFile file, @RequestPart ProjectInsertDTO productInsert) {
        return ResponseEntity.ok(projectService.update(id, productInsert, file));
    }
}
