package com.college.project.service;

import java.sql.SQLException;
import java.util.List;

import com.college.project.dao.ProjectDAO;
import com.college.project.dto.ProjectDTO;



public class ProjectService {
	
	 private ProjectDAO projectDAO;

     public ProjectService(ProjectDAO projectDAO) {
 		this.projectDAO = projectDAO;
 	}
     

 	public int addProject(ProjectDTO projectDTO) throws Exception {
		int count =projectDAO.addProject(projectDTO);
		if(count != 0 ) {
			
		}
		return count;
	}
 	 public List<ProjectDTO> findAll() throws ClassNotFoundException, SQLException {
 		return projectDAO.findAll();
 	}
 	 public int updateProject(ProjectDTO projectDTO) throws Exception {
         return projectDAO.updateProject(projectDTO);
     }

     // Delete Project by ID
     public int deleteProjectById(int id) throws ClassNotFoundException, SQLException {
         int count = projectDAO.deleteProjectById(id);
         if (count != 0) {
             // Perform any additional logic if needed (like logging, etc.)
         }
         return count;
     }


	
	

}
