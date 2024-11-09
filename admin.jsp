<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.college.project.dto.ClientDTO" %>
<%@ page import="com.college.project.dto.ProjectDTO" %>
<%@ page import="com.college.project.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel</title>
    <link rel="stylesheet" href="admin.css">

    <!-- Font Awesome Icons -->
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

    <!-- Add some custom CSS -->
    <style>
        .nav-buttons1 {
            display: flex;
            gap: 20px; /* Space between buttons */
            margin-left: 65%;
        }
        .btn-nav {
            padding: 10px 15px;       
            color: white;
            text-decoration: none;
            border-radius: 4px;
            border: none;
            cursor: pointer;
        }
        .client-table, .project-table, .user-table {
            margin-top: 20px; /* Add some space between the buttons and the table */
            width: 100%;
            border-collapse: collapse;
        }
        .client-table th, .client-table td,
        .project-table th, .project-table td,
        .user-table th, .user-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        .client-table th, .project-table th, .user-table th {
            background-color: #f2f2f2;
        }
    </style>

</head>
<body>

    <div class="container">
        <!-- Header Section -->
        <header>
            <!-- Logo Section -->
            <img src="images/Lead Generation Landing page (Images)/logo.svg" alt="Logo">
            <div class="logo">
                <h1>Admin Panel</h1>
            </div>
            <div class="welcome-msg">
                Welcome, Admin Panel
            </div>
        </header>

        <!-- Form Section for Navigation -->
        <form action="project" method="post">
            <div class="nav-buttons" >
                <!-- Home, Add Project, and Add Client buttons together -->
                <a href="index.jsp" class="btn-nav" >Home</a>
                <a href="project.jsp" class="btn-nav" >Add Project</a>
                <a href="Client.jsp" class="btn-nav">Add Client</a>
            </div>
        </form>

        <!-- View Buttons Section -->
        <div class="nav-buttons1" >
            <!-- View All Clients -->
            <form action="Client" method="get" style="display: inline;">
                <input type="hidden" name="task" value="findAll">
                <input type="submit" value="View Clients" class="btn-nav">
            </form>
            <!-- View All Projects -->
            <form action="project" method="get" style="display: inline;">
                <input type="hidden" name="task" value="findAll">
                <input type="submit" value="View Projects" class="btn-nav">
            </form>
            <!-- View All Users -->
            <form action="user" method="get" style="display: inline;">
                <input type="hidden" name="task" value="findAll">
                <input type="submit" value="View Users" class="btn-nav">
            </form>
        </div>

        <!-- Client Table Section -->
        <%
        // Check if the clientDTOList is available
        if (request.getAttribute("clientDTOList") != null) {
            List<ClientDTO> clientDTOList = (List<ClientDTO>) request.getAttribute("clientDTOList");
        %>
        
        <!-- Display Client Data Table -->
        <h2>Client Data</h2>
        <table class="client-table">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Designation</th>
                <th>Image</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>

            <%
            int index = 1;
            for (ClientDTO clientDTO : clientDTOList) {
            %>
            <tr>
                <td><%= index++ %></td>
                <td><%= clientDTO.getName() %></td>
                <td><%= clientDTO.getDesignation() %></td>
                <td><img src="<%= clientDTO.getImage() %>" alt="<%= clientDTO.getName() %>" width="100"></td>
                <td><%= clientDTO.getDescription() %></td>
                <td>
                    <!-- Edit Button -->
                    <form action="Client" method="get" style="display: inline;">
                        <input type="hidden" name="task" value="findById">
                        <input type="hidden" name="id" value="<%= clientDTO.getClientId() %>">
                        <button type="submit" class="btn-nav">Edit</button>
                    </form>

                    <!-- Delete Button -->
                    <form action="Client" method="get" style="display: inline;">
                        <input type="hidden" name="task" value="deleteById">
                        <input type="hidden" name="id" value="<%= clientDTO.getClientId() %>">
                        <button type="submit" class="btn-nav" onclick="return confirm('Are you sure you want to delete this client?');">Delete</button>
                    </form>
                </td>
            </tr>
            <%
            }
            %>
        </table>

        <%
        } else {
        %>
        <!-- Message when no clients found -->
        <p>No clients found.</p>
        <%
        }
        %>

        <!-- Project Table Section -->
        <%
        // Check if the projectDTOList is available
        if (request.getAttribute("projectDTOList") != null) {
            List<ProjectDTO> projectDTOList = (List<ProjectDTO>) request.getAttribute("projectDTOList");
        %>
        
        <!-- Display Project Data Table -->
        <h2>Project Data</h2>
        <table class="project-table">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Image</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>

            <%
            int index = 1;
            for (ProjectDTO projectDTO : projectDTOList) {
            %>
            <tr>
                <td><%= index++ %></td>
                <td><%= projectDTO.getName() %></td>
                <td><img src="<%= projectDTO.getImage() %>" alt="<%= projectDTO.getName() %>" width="100"></td>
                <td><%= projectDTO.getDescription() %></td>
                <td>
                    <!-- Edit Button -->
                    <form action="project" method="get" style="display: inline;">
                        <input type="hidden" name="task" value="findById">
                        <input type="hidden" name="id" value="<%= projectDTO.getProjectId() %>">
                        <button type="submit" class="btn-nav">Edit</button>
                    </form>

                    <!-- Delete Button -->
                    <form action="project" method="get" style="display: inline;">
                        <input type="hidden" name="task" value="deleteById">
                        <input type="hidden" name="id" value="<%= projectDTO.getProjectId() %>">
                        <button type="submit" class="btn-nav" onclick="return confirm('Are you sure you want to delete this project?');">Delete</button>
                    </form>
                </td>
            </tr>
            <%
            }
            %>
        </table>

        <%
        } else {
        %>
        <!-- Message when no projects found -->
        <p>No projects found.</p>
        <%
        }
        %>

        <!-- User Table Section -->
        <%
        // Check if the userDTOList is available
        if (request.getAttribute("userDTOList") != null) {
            List<UserDTO> userDTOList = (List<UserDTO>) request.getAttribute("userDTOList");
        %>
        
        <!-- Display User Data Table -->
        <h2>User Data</h2>
        <table class="user-table">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Email</th>
                <th>Mobile Number</th>
                <th>City</th>
            </tr>

            <%
            int index = 1;
            for (UserDTO userDTO : userDTOList) {
            %>
            <tr>
                <td><%= index++ %></td>
                <td><%= userDTO.getName() %></td>
                <td><%= userDTO.getEmail() %></td>
                <td><%= userDTO.getMobile_number() %></td>
                <td><%= userDTO.getCity() %></td>
            </tr>
            <%
            }
            %>
        </table>

        <%
        } else {
        %>
        <!-- Message when no users found -->
        <p>No users found.</p>
        <%
        }
        %>

    </div>
</body>
</html>
