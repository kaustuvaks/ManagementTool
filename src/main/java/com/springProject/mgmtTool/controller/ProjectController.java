package com.springProject.mgmtTool.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springProject.mgmtTool.models.ProjectModel;
import com.springProject.mgmtTool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody ProjectModel projectModel, BindingResult result){
		
		if(result.hasErrors()) {
			
			Map<String, String> errormap = new HashMap<String, String>();
			
			for(FieldError error: result.getFieldErrors()) {
				errormap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errormap, HttpStatus.BAD_REQUEST);
		}
		ProjectModel pm1 = projectService.saveOrUpdateProject(projectModel);
		return new ResponseEntity<ProjectModel>(pm1, HttpStatus.CREATED);
	}
}
