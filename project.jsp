<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="com.college.project.dto.ProjectDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project </title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Link to external CSS -->
    <link rel="stylesheet" href="project.css">
</head>
<body>

<div class="form-container">
        <h2 class="form-title">Add Projects </h2>
        
      <form action="project" method="POST">
    <input type="text" name="name" placeholder="Enter your  name" required />
    <input type="text" name="description" placeholder="Enter your description" required />
    
                <label for="image" class="text-white"> Upload Image</label>
              <input type="file"  name="image"  class="text-white" required><br> 
              <input type="hidden" name="task" value="addproject" />
            <button type="submit">Add Project</button>
        </form>
    </div>
</div>




</body>
</html>
