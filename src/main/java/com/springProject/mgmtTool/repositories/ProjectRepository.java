package com.springProject.mgmtTool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springProject.mgmtTool.models.ProjectModel;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectModel, Long>{
	
	@Override
	Iterable<ProjectModel> findAllById(Iterable<Long> iterable);
}
