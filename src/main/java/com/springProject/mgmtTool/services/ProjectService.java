package com.springProject.mgmtTool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springProject.mgmtTool.models.ProjectModel;
import com.springProject.mgmtTool.repositories.ProjectRepository;

@Service
public class ProjectService {

	public ProjectService() {}
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public ProjectModel saveOrUpdateProject(ProjectModel projectModel) {
		return projectRepository.save(projectModel);
	}

}
