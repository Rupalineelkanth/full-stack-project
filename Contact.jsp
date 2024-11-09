<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Link to external CSS -->
    <link rel="stylesheet" href="contact.css">
</head>
<body>
<div class="form-container">
        <h2>Get a Free Consultation</h2>
    <form action="user" method="POST">
    <input type="text" name="name" placeholder="Enter your full name" required />
    <input type="email" name="email" placeholder="Enter your email" required />
    <input type="text" name="mobile_number" placeholder="Enter your mobile number" required />
    <input type="text" name="city" placeholder="Enter your city" required />
    <input type="hidden" name="task" value="signup" />
    <button type="submit">Get Quick Quote</button>
</form>
 </div>


   
</body>
</html>
