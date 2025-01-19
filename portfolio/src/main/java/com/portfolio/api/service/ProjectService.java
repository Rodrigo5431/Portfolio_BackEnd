package com.portfolio.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.api.dto.ProjectDTO;
import com.portfolio.api.dto.ProjectInsertDTO;
import com.portfolio.api.entity.Project;
import com.portfolio.api.exception.NotFoundException;
import com.portfolio.api.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public List<ProjectDTO> listAll() {
		return projectRepository.findAll().stream().map(ProjectDTO::new).toList();

	}
	
	public ProjectDTO getById(Long id) {
		Optional<Project>projectOpt = projectRepository.findById(id);
		if (projectOpt.isPresent()) {
			return new ProjectDTO(projectOpt.get());
		}
        throw new NotFoundException("Projeto não encontrado");
    }
	
	public ProjectDTO save(ProjectInsertDTO projectInsert) {
		Project project = new Project();
		project.setTitle(projectInsert.getTitle());
		project.setDescription(projectInsert.getDescription());
		project.setTechnologies(projectInsert.getTechnologies());
		project.setImage(projectInsert.getImage());
		project.setLink(projectInsert.getLink());
		project.setGithubLink(projectInsert.getGithubLink());
		
		return new ProjectDTO(projectRepository.save(project));
    }
}
