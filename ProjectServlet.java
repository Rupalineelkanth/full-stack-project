package com.college.project.servlet;

import java.io.IOException;
import java.util.List;

import com.college.project.dao.ProjectDAO;
import com.college.project.dto.ProjectDTO;
import com.college.project.service.ProjectService;
import com.college.project.util.DBUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/project")
public class ProjectServlet extends HttpServlet {
	
	private ProjectService projectService;
	private ProjectDAO projectDAO;
	private DBUtil dbUtil;


    public ProjectServlet() {
    	System.out.println("Creating PojectServlet Object");
    	this.dbUtil = new DBUtil();
		this.projectDAO = new ProjectDAO(dbUtil);
		this.projectService = new ProjectService(projectDAO);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	System.out.println("ProjectServlet: DoGet method");

    	String task = request.getParameter("task");
    	System.out.println("task: " + task);

    	if (task.equalsIgnoreCase("findAll")) {
    		findAll(request, response);
    	} else if (task.equalsIgnoreCase("delete")) {
            deleteById(request, response);
        } 
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("ProjectServlet: DoPost method");

		String task = request.getParameter("task");
		System.out.println("Task: " + task);

		
		 if (task.equalsIgnoreCase("addproject"))
			 addProject(request, response);
		 else if (task.equalsIgnoreCase("update")) {
	            updateById(request, response);
	        }
	}




	private void addProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("addProject  detail...");

		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setImage(request.getParameter("image"));
		projectDTO.setName(request.getParameter("name"));
		projectDTO.setDescription(request.getParameter("description"));		
		
		

		try {
			int count = projectService.addProject(projectDTO);
			if (count > 0) {
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				request.setAttribute("status", "Success");
				request.setAttribute("message", "addProject successfully");
				request.setAttribute("redirectUrl", "index.jsp");
				rd.forward(request, response);

				System.out.println("addProject  successfully.");
			} else {
				

				RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
				request.setAttribute("status", "Failed");
				request.setAttribute("message", "Failed to addProject account");
				request.setAttribute("redirectUrl", "project.jsp");
				rd.forward(request, response);

				System.out.println("Failed to addProject account.");
			}
		} catch (Exception e) {
			
			RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
			request.setAttribute("status", "Failed");
			request.setAttribute("message", e.getMessage());
			request.setAttribute("redirectUrl", "project.jsp");
			rd.forward(request, response);
			response.sendRedirect("project.jsp");
			e.printStackTrace();
		}

		
	}
	 private void findAll(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			System.out.println("Fetching all project data ");

			try {

				List<ProjectDTO> projectDTOList = projectService.findAll();
				if (!projectDTOList.isEmpty()) {
					System.out.println("Project found successfully, project count: " + projectDTOList.size());

					RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
					request.setAttribute("projectDTOList", projectDTOList);
					rd.forward(request, response);
				} else {

					System.out.println("Failed to find all project.");
					RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
					request.setAttribute("status", "Failed");
					request.setAttribute("message", "Failed to find all project.");
					request.setAttribute("redirectUrl", "admin.jsp");
					rd.forward(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
				request.setAttribute("status", "Failed");
				request.setAttribute("message", e.getMessage());
				request.setAttribute("redirectUrl", "index.jsp");
				rd.forward(request, response);
				response.sendRedirect("index.jsp");
			}
		}
	
	  private void deleteById(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String id = request.getParameter("id");
	        System.out.println("Delete project by id: " + id);

	        try {
	            int count = projectService.deleteProjectById(Integer.parseInt(id));
	            if (count > 0) {
	                System.out.println("Project deleted successfully, id: " + id);
	                request.setAttribute("status", "Success");
	                request.setAttribute("message", "Project deleted successfully, id: " + id);
	                request.setAttribute("redirectUrl", "projects.jsp"); // Redirect to project list page
	                RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
	                rd.forward(request, response);
	            } else {
	                System.out.println("Failed to delete project by id: " + id);
	                request.setAttribute("status", "Failed");
	                request.setAttribute("message", "Failed to delete project by id: " + id);
	                request.setAttribute("redirectUrl", "projects.jsp");
	                RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
	                rd.forward(request, response);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("status", "Failed");
	            request.setAttribute("message", e.getMessage());
	            request.setAttribute("redirectUrl", "projects.jsp");
	            RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
	            rd.forward(request, response);
	        }
	    }

	    // Update Project by ID
	    private void updateById(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.getWriter().append("Updating project details...");

	        ProjectDTO projectDTO = new ProjectDTO();
	        projectDTO.setProjectId(Integer.parseInt(request.getParameter("id")));
	        projectDTO.setName(request.getParameter("name"));
	        projectDTO.setImage(request.getParameter("image"));
	        projectDTO.setDescription(request.getParameter("description"));

	        try {
	            int count = projectService.updateProject(projectDTO);
	            if (count > 0) {
	                request.setAttribute("status", "Success");
	                request.setAttribute("message", "Project updated successfully");
	                request.setAttribute("redirectUrl", "projects.jsp");
	                RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
	                rd.forward(request, response);
	                System.out.println("Project updated successfully.");
	            } else {
	                request.setAttribute("status", "Failed");
	                request.setAttribute("message", "Failed to update project");
	                request.setAttribute("redirectUrl", "projects.jsp");
	                RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
	                rd.forward(request, response);
	                System.out.println("Failed to update project.");
	            }
	        } catch (Exception e) {
	            request.setAttribute("status", "Failed");
	            request.setAttribute("message", e.getMessage());
	            request.setAttribute("redirectUrl", "projects.jsp");
	            RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
	            rd.forward(request, response);
	            e.printStackTrace();
	        }
	    }

	  
	
}	

