package com.portfolio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.api.dto.ProjectDTO;
import com.portfolio.api.dto.ProjectInsertDTO;
import com.portfolio.api.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	public ResponseEntity<List<ProjectDTO>> listProjects() {
		return ResponseEntity.ok(projectService.listAll());
	}

	public ResponseEntity<ProjectDTO> create(@RequestPart MultipartFile file,
			@RequestPart ProjectInsertDTO productInsert) {
		return ResponseEntity.ok(projectService.save(productInsert, file));
	}

}
