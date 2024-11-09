<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.college.project.dto.ClientDTO" %>
<%@ page import="com.college.project.dto.ProjectDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Projects, and Clients</title>
    <style>
        .button1 {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
 <div class="nav-buttons1">
    <!-- View All Clients -->
    <form action="Client" method="get" style="display: inline;">
        <input type="hidden" name="task" value="findAll">
        <button type="submit" class="btn-nav">View Clients</button>
    </form>
    <!-- View All Projects -->
    <form action="project" method="get" style="display: inline;">
        <input type="hidden" name="task" value="findAll">
        <button type="submit" class="btn-nav">View Projects</button>
    </form>
    
</div>

<!-- Client Table Section -->
<%
    if (request.getAttribute("clientDTOList") != null) {
        List<ClientDTO> clientDTOList = (List<ClientDTO>) request.getAttribute("clientDTOList");
%>

<h2>Client Data</h2>
<table class="client-table" style="width: 100%; border-collapse: collapse;">
    <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Designation</th>
            <th>Image</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
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
    </tbody>
</table>

<%
    } else {
%>
<p>No clients found.</p>
<%
    }
%>

<!-- Project Table Section -->
<%
    if (request.getAttribute("projectDTOList") != null) {
        List<ProjectDTO> projectDTOList = (List<ProjectDTO>) request.getAttribute("projectDTOList");
%>

<h2>Project Data</h2>
<table class="project-table" style="width: 100%; border-collapse: collapse;">
    <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Image</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
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
    </tbody>
</table>

<%
    } else {
%>
<p>No projects found.</p>
<%
    }
%>


</div>



</body>
</html>
