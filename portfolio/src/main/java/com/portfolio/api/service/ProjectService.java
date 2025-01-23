package com.portfolio.api.service;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.portfolio.api.dto.ProjectDTO;
import com.portfolio.api.dto.ProjectInsertDTO;
import com.portfolio.api.entity.Project;
import com.portfolio.api.exception.NotFoundException;
import com.portfolio.api.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private PhotoService photoService;

	public List<ProjectDTO> listAll() {
	   
	        return projectRepository.findAll()
	            .stream()
	            .map(ProjectDTO::new)
	            .collect(Collectors.toList());
	    
	}


	public ProjectDTO getById(Long id) {
		Optional<Project> projectOpt = projectRepository.findById(id);
		if (projectOpt.isPresent()) {
			return new ProjectDTO(projectOpt.get());
		}
		throw new NotFoundException("Projeto não encontrado");
	}

	public ProjectDTO save(ProjectInsertDTO projectInsert, MultipartFile file) {
		Project project = new Project();
		try {
			project.setTitle(projectInsert.getTitle());
			project.setDescription(projectInsert.getDescription());
			project.setTechnologies(projectInsert.getTechnologies());
			project.setLink(projectInsert.getLink());
			project.setGithubLink(projectInsert.getGithubLink());
			projectRepository.save(project);
			project.setImage(projectInsert.getImage());
			photoService.inserir(project, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return addPhotoUri(project);

	}

	public ProjectDTO addPhotoUri(Project project) {

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/projects/photo/{id}")
				.buildAndExpand(project.getId()).toUri();

		ProjectDTO projectDto = new ProjectDTO();

		projectDto.setId(project.getId());
		projectDto.setTitle(project.getTitle());
		projectDto.setDescription(project.getDescription());
		projectDto.setTechnologies(project.getTechnologies());
		projectDto.setLink(project.getLink());
		projectDto.setGithubLink(project.getGithubLink());
		projectDto.setImage(uri.toString());
		projectRepository.save(project);
		return projectDto;
	}
	
	public ProjectDTO update(Long id, ProjectInsertDTO projectInsert, MultipartFile file) {
		return null;
	}
}
