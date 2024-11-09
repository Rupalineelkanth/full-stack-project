
package com.college.project.servlet;

import java.io.IOException;
import java.util.List;

import com.college.project.dao.UserDAO;
import com.college.project.dto.UserDTO;
import com.college.project.service.UserService;
import com.college.project.util.DBUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserService userService;
    private UserDAO userDAO;
    private DBUtil dbUtil;

    public UserServlet() {
        System.out.println("Creating UserServlet Object");
        this.dbUtil = new DBUtil();
        this.userDAO = new UserDAO(dbUtil);
        this.userService = new UserService(userDAO);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	System.out.println("UserServlet: DoGet method");

    	String task = request.getParameter("task");
    	System.out.println("task: " + task);

    	if (task.equalsIgnoreCase("findAll")) {
    		findAll(request, response);
    	}
    }
    
    	
  

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserServlet: DoPost method");

        String task = request.getParameter("task");
        System.out.println("Task: " + task);

        if (task.equalsIgnoreCase("login")) {
            login(request, response);
        } else if (task.equalsIgnoreCase("signup")) {
            saveUser(request, response);
        }
    }

    private void saveUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Saving user details...");

        // Retrieve form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobileNumber = request.getParameter("mobile_number");
        String city = request.getParameter("city");

        // Validation: Check if any field is null or empty
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("status", "Failed");
            request.setAttribute("message", "Name cannot be empty.");
            RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
            rd.forward(request, response);
            return;
        }

        // Set the data to UserDTO
        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        userDTO.setEmail(email);
        userDTO.setMobile_number(mobileNumber);
        userDTO.setCity(city);

        // Call service to save user
        try {
            int count = userService.save(userDTO);
            if (count > 0) {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                request.setAttribute("status", "Success");
                request.setAttribute("message", "User created successfully");
                request.setAttribute("redirectUrl", "index.jsp");
                rd.forward(request, response);
                System.out.println("User account created successfully.");
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
                request.setAttribute("status", "Failed");
                request.setAttribute("message", "Failed to create user account");
                request.setAttribute("redirectUrl", "Contact.jsp");
                rd.forward(request, response);
                System.out.println("Failed to create user account.");
            }
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
            request.setAttribute("status", "Failed");
            request.setAttribute("message", e.getMessage());
            request.setAttribute("redirectUrl", "Contact.jsp");
            rd.forward(request, response);
            e.printStackTrace();
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Fetching all user data ");

		try {

			List<UserDTO> userDTOList = userService.findAll();
			if (!userDTOList.isEmpty()) {
				System.out.println("User found successfully, user count: " + userDTOList.size());

				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				request.setAttribute("userDTOList", userDTOList);
				rd.forward(request, response);
			} else {

				System.out.println("Failed to find all users.");
				RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
				request.setAttribute("status", "Failed");
				request.setAttribute("message", "Failed to find all users.");
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
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implement login logic if needed
    }
}

