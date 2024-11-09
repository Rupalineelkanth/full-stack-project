package com.college.project.servlet;

import java.io.IOException;
import java.util.List;

import com.college.project.dao.ClientDAO;
import com.college.project.dto.ClientDTO;

import com.college.project.service.ClientService;
import com.college.project.util.DBUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Client")
public class ClientServlet extends HttpServlet {

	private ClientService clientService;
	private ClientDAO clientDAO;
	private DBUtil dbUtil;


    public ClientServlet() {
    	System.out.println("Creating  ClientServlet Object");
    	this.dbUtil = new DBUtil();
		this.clientDAO = new ClientDAO(dbUtil);
		this.clientService = new ClientService(clientDAO);
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	System.out.println("ClientServlet: DoGet method");

    	String task = request.getParameter("task");
    	System.out.println("task: " + task);

    	if (task.equalsIgnoreCase("findAll")) {
    		findAll(request, response);
    	}else if (task.equalsIgnoreCase("delete")) {
            deleteById(request, response);
        } 
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("ClientServlet: DoPost method");

		String task = request.getParameter("task");
		System.out.println("Task: " + task);

		
		 if (task.equalsIgnoreCase("addClient"))
			addClient(request, response);
		 else if (task.equalsIgnoreCase("updateById"))
				updateById(request, response);
	}


	private void addClient(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.getWriter().append("addClient  detail...");

		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setImage(request.getParameter("image"));
		clientDTO.setName(request.getParameter("name"));
		clientDTO.setDescription(request.getParameter("description"));		
		clientDTO.setDesignation(request.getParameter("designation"));
		

		try {
			int count = clientService.addClient(clientDTO);
			if (count > 0) {
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				request.setAttribute("status", "Success");
				request.setAttribute("message", "addClient successfully");
				request.setAttribute("redirectUrl", "index.jsp");
				rd.forward(request, response);

				System.out.println("addClient  successfully.");
			} else {
				

				RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
				request.setAttribute("status", "Failed");
				request.setAttribute("message", "Failed to addClient account");
				request.setAttribute("redirectUrl", "client.jsp");
				rd.forward(request, response);

				System.out.println("Failed to addClient account.");
			}
		} catch (Exception e) {
			
			RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
			request.setAttribute("status", "Failed");
			request.setAttribute("message", e.getMessage());
			request.setAttribute("redirectUrl", "client.jsp");
			rd.forward(request, response);
			response.sendRedirect("client.jsp");
			e.printStackTrace();
		}

		
	}
	
	 private void findAll(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			System.out.println("Fetching all client data ");

			try {

				List<ClientDTO> clientDTOList = clientService.findAll();
				if (!clientDTOList.isEmpty()) {
					System.out.println("Client found successfully, client count: " + clientDTOList.size());

					RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
					request.setAttribute("clientDTOList", clientDTOList);
					rd.forward(request, response);
				} else {

					System.out.println("Failed to find all client.");
					RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
					request.setAttribute("status", "Failed");
					request.setAttribute("message", "Failed to find all client.");
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
	        System.out.println("Delete client by id: " + id);

	        try {
	            int count = clientService.deleteClientById(Integer.parseInt(id));
	            if (count > 0) {
	                System.out.println("Client deleted successfully, id: " + id);
	                request.setAttribute("status", "Success");
	                request.setAttribute("message", "Client deleted successfully, id: " + id);
	                request.setAttribute("redirectUrl", "clients.jsp"); // Redirect to client list page
	                RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
	                rd.forward(request, response);
	            } else {
	                System.out.println("Failed to delete client by id: " + id);
	                request.setAttribute("status", "Failed");
	                request.setAttribute("message", "Failed to delete client by id: " + id);
	                request.setAttribute("redirectUrl", "clients.jsp");
	                RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
	                rd.forward(request, response);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("status", "Failed");
	            request.setAttribute("message", e.getMessage());
	            request.setAttribute("redirectUrl", "clients.jsp");
	            RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
	            rd.forward(request, response);
	        }
	    }

	    // Update Client by ID
	    private void updateById(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.getWriter().append("Updating client details...");

	        ClientDTO clientDTO = new ClientDTO();
	        clientDTO.setClientId(Integer.parseInt(request.getParameter("id")));
	        clientDTO.setName(request.getParameter("name"));
	        clientDTO.setImage(request.getParameter("image"));
	        clientDTO.setDescription(request.getParameter("description"));
	        clientDTO.setDesignation(request.getParameter("designation"));

	        try {
	            int count = clientService.updateClient(clientDTO);
	            if (count > 0) {
	                request.setAttribute("status", "Success");
	                request.setAttribute("message", "Client updated successfully");
	                request.setAttribute("redirectUrl", "clients.jsp");
	                RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
	                rd.forward(request, response);
	                System.out.println("Client updated successfully.");
	            } else {
	                request.setAttribute("status", "Failed");
	                request.setAttribute("message", "Failed to update client");
	                request.setAttribute("redirectUrl", "clients.jsp");
	                RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
	                rd.forward(request, response);
	                System.out.println("Failed to update client.");
	            }
	        } catch (Exception e) {
	            request.setAttribute("status", "Failed");
	            request.setAttribute("message", e.getMessage());
	            request.setAttribute("redirectUrl", "clients.jsp");
	            RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
	            rd.forward(request, response);
	            e.printStackTrace();
	        }
	    }

	   
}
