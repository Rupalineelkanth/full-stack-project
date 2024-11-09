<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>realtrust</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    /* Custom CSS */
    .navbar .contact-btn {
      background-color: orange;
      color: white;
    }

    .image-section {
      position: relative;
      text-align: center;
      color: white;
    }

    .image-section h1 {
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
    }

    .contact-form {
      background-color: #007bff;
      padding: 20px;
      border-radius: 10px;
      color: white;
    }

    .circle-img {
      border-radius: 50%;
      width: 100px;
      height: 100px;
    }

    .square-img {
      width: 150px;
      height: 150px;
    }

    .footer {
      background-color: #f8f9fa;
      padding: 20px;
      text-align: center;
    }

    .footer-icons i {
      margin: 0 10px;
      font-size: 1.5rem;
    }

    .blue-navbar {
      background-color: #007bff;
    }

    .blue-navbar a, .blue-navbar .subscribe-btn {
      color: white;
    }
  </style>
</head>
<body>

  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
      <a class="navbar-brand" href="#"><img src="images/logo.svg" alt="Logo">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <a href="index.html" class="nav-item nav-link active">Home</a>
          <a href="service.html" class="nav-item nav-link">Services</a>
          <a href="aboutpro.html" class="nav-item nav-link"> About Projects</a>
           <a href="testimonial.html" class="nav-item nav-link">Testimonial</a>
          <li class="nav-item"><a class="btn contact-btn" href="contact.jsp">Contact</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Image with Heading and Contact Form -->
  <div class="image-section" style="background-image: url('images/young-couple-examining-blueprints-with-real-estate-agent-while-buying-new-home\ 1.svg'); height: 500px; background-size: cover;">
    <h1 style="font-size: 50px; padding-right: 70%; ">Consultation,<br> Design ,<br>& Marketing</h1>
    <br><br>
    <div class="container">
      <div class="row justify-content-end">
        <div class="col-md-4 contact-form">
          <h2>Contact Us</h2>
          <form>
            <div class="mb-3">
              <input type="text" class="form-control" placeholder="Name">
            </div>
            <div class="mb-3">
              <input type="email" class="form-control" placeholder="Email">
            </div>
            <div class="mb-3">
              <input type="Mobile" class="form-control" placeholder="Mobile">
            </div>
            <div class="mb-3">
              <input type="text" class="form-control" placeholder="Area,city">
            </div>
            <button type="submit" class="btn btn-light">Submit</button>
          </form>
        </div>
      </div>
    </div>
  </div>

  <!-- Three Circle Images and Text Section -->
  <div class="container my-5">
    <div class="row">
      <div class="col-md-6">
        <h2 class="text-primary">Our Features</h2>
        <p class="text-dark">This is a paragraph explaining the features and benefits of our project. We focus on quality, reliability, and user satisfaction.</p>
      </div>
      <div class="col-md-6 text-center">
        <img src="images/Ellipse 11.svg" alt="Circle 1" class="circle-img">
        <img src="images/Ellipse 12.svg" alt="Circle 2" class="circle-img mx-3">
        <img src="images/Ellipse 13.svg" alt="Circle 3" class="circle-img">
      </div>
    </div>
  </div>

  <!-- Why Choose Us Section -->
  <div class="container text-center">
    <h2 class="text-primary">Why Choose Us</h2>
    <div class="row my-4">
      <div class="col-md-4">
        <img src="images/home.svg" alt="Icon">
        <h4>Quality</h4>
        <p>We deliver top-quality products.</p>
      </div>
      <div class="col-md-4">
        <img src="images/paintbrush-2.svg" alt="Icon">
        <h4>Support</h4>
        <p>24/7 customer support.</p>
      </div>
      <div class="col-md-4">
        <img src="images/circle-dollar-sign.svg" alt="Icon">
        <h4>Experience</h4>
        <p>Years of expertise in the industry.</p>
      </div>
    </div>
  </div>

  <!-- Shop Section with Square Images -->
  <div class="container my-5 our-project">
    <h2 class="text-primary">Our Projects</h2>
    <p class="text-dark">Here are some of the projects we've worked on.</p>
    <div class="row text-center">
      <div class="col-md-2">
        <img src="images/pexels-brett-sayles-2881232.svg" alt="Project 1" class="img-fluid">
        <h5>Consultation</h5>
        <p>Short description</p>
        <button class="btn btn-contact">View</button>
      </div>
      <div class="col-md-2">
        <img src="images/pexels-brett-sayles-2881232-1.svg" alt="Project 2" class="img-fluid">
        <h5>Design</h5>
        <p>Short description</p>
        <button class="btn btn-contact">View</button>
      </div>
      <div class="col-md-2">
        <img src="images/pexels-brett-sayles-2881232-1.svg" alt="Project 2" class="img-fluid">
        <h5>Design and marketing</h5>
        <p>Short description</p>
        <button class="btn btn-contact">View</button>
      </div>
      <div class="col-md-2">
        <img src="images/pexels-brett-sayles-2881232-1.svg" alt="Project 2" class="img-fluid">
        <h5>Design</h5>
        <p>Short description</p>
        <button class="btn btn-contact">View</button>
      </div>
      <div class="col-md-2">
        <img src="images/pexels-brett-sayles-2881232-1.svg" alt="Project 2" class="img-fluid">
        <h5>Design and marketing</h5>
        <p>Short description</p>
        <button class="btn btn-contact">View</button>
      </div>
    </div>
  </div>

  <!-- About Us Section -->
  <div class="container my-5">
    <h2 class="text-primary">About Us</h2>
    <p class="text-dark">We are a team of dedicated professionals committed to delivering excellence in everything we do. Our vision is to create solutions that make a positive impact.</p>
  </div>

  <!-- Our Project Section with Images -->
 
  <!-- Our Projects Section -->
  <div class="container my-5 our-project">
    <h2 class="text-primary">Our Projects</h2>
    <p class="text-dark">Here are some of the projects we've worked on.</p>
    <div class="row text-center">
      <div class="col-md-2">
        <img src="images/Lead Generation Landing page (Images)/pexels-brett-sayles-2881232.svg" alt="Project 1" class="img-fluid">
        <h5>Full stack</h5>
        <p>Short description</p>
        <button class="btn btn-contact">View</button>
      </div>
      <div class="col-md-2">
        <img src="images/Lead Generation Landing page (Images)/pexels-brett-sayles-2881232-1.svg" alt="Project 2" class="img-fluid">
        <h5>Project 2</h5>
        <p>Short description</p>
        <button class="btn btn-contact">View</button>
      </div>
      <div class="col-md-2">
        <img src="images/Lead Generation Landing page (Images)/pexels-brett-sayles-2881232.svg" alt="Project 1" class="img-fluid">
        <h5>Project 1</h5>
        <p>Short description</p>
        <button class="btn btn-contact">View</button>
      </div>
      <div class="col-md-2">
        <img src="images/Lead Generation Landing page (Images)/pexels-brett-sayles-2881232-1.svg" alt="Project 2" class="img-fluid">
        <h5>Project 2</h5>
        <p>Short description</p>
        <button class="btn btn-contact">View</button>
      </div>
      <!-- Repeat for other projects -->
    </div>
  </div>

  <!-- Happy Clients Section -->
  <div class="container my-5 happy-client">
    <h2 class="text-primary">Happy Clients</h2>
    <div class="row text-center">
      <div class="col-md-2">
        <img src="images/Ellipse 28.svg" alt="Client 1" class="circle-img">
        <h5>Client 1</h5>
        <p>CEO</p>
      </div>
      <div class="col-md-2">
        <img src="images/Ellipse 29.svg" alt="Client 2" class="circle-img">
        <h5>Client 2</h5>
        <p>Manager</p>
      </div>
      <!-- Repeat for other clients -->
    </div>
  </div>

  <!-- Image with Paragraph and Button -->
  <div class="image-section" style="background-image: url('images/Rectangle.svg'); height: 300px; background-size: cover;">
  
    <button class="btn btn-light">Get Started</button>
  </div>

  <!-- Blue Navbar and Subscribe Section -->
  <nav class="blue-navbar navbar navbar-expand-lg">
    <div class="container">
      <a class="navbar-brand" href="#">Home</a>
      <a class="navbar-brand" href="#">Services</a>
      <a class="navbar-brand" href="#">Projects</a>
      <div class="ms-auto">
        <h4 class="text-white">Subscribe</h4>
        <input type="email" placeholder="Enter Email" class="form-control d-inline" style="width: 200px;">
        <button class="btn btn-light subscribe-btn">Subscribe</button>
      </div>
    </div>
  </nav>

  <!-- Footer Start -->
  <div class="container-fluid footer py-5 wow fadeIn" data-wow-delay="0.2s">
    <div class="container py-5">
        <div class="row g-5">
            <div class="col-md-6 col-lg-6 col-xl-3">
                <div class="footer-item d-flex flex-column">
                    <div class="footer-item">
                        <h4 class="text-white mb-4"> Subscribe Newsletter</h4>
                        
                        <div class="position-relative mx-auto rounded-pill">
                            <input class="form-control rounded-pill w-100 py-3 ps-4 pe-5" type="text" placeholder="Enter your email">
                            <button type="button" class="btn btn-primary rounded-pill position-absolute top-0 end-0 py-2 mt-2 me-2">SignUp</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-6 col-xl-3">
                <div class="footer-item d-flex flex-column">
                    <h4 class="text-white mb-4">Explore</h4>
                    <a href="#"><i class="fas fa-angle-right me-2"></i> Home</a>
                    <a href="#"><i class="fas fa-angle-right me-2"></i> Services</a>
                    <a href="#"><i class="fas fa-angle-right me-2"></i> About Us</a>
                    
                    <a href="#"><i class="fas fa-angle-right me-2"></i> testimonial</a>
                    <a href="#"><i class="fas fa-angle-right me-2"></i> Our Team</a>
                    <a href="#"><i class="fas fa-angle-right me-2"></i> Contact Us</a>
                </div>
            </div>
            <div class="col-md-6 col-lg-6 col-xl-3">
                <div class="footer-item d-flex flex-column">
                    <h4 class="text-white mb-4">Contact Info</h4>
                    <a href=""><i class="fa fa-map-marker-alt me-2"></i> 123 bholaram, Madhaya Pradesh, India</a>
                    <a href=""><i class="fas fa-envelope me-2"></i> info@realtrust.com</a>
                    
                    <a href=""><i class="fas fa-phone me-2"></i> +91 992639826</a>
                    <a href="" class="mb-3"><i class="fas fa-print me-2"></i> +012 345 67890</a>
                    <div class="d-flex align-items-center">
                        <a class="btn btn-light btn-md-square me-2" href=""><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-light btn-md-square me-2" href=""><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-light btn-md-square me-2" href=""><i class="fab fa-instagram"></i></a>
                        <a class="btn btn-light btn-md-square me-0" href=""><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-6 col-xl-3">
                <div class="footer-item-post d-flex flex-column">
                    <h4 class="text-white mb-4">Popular Post</h4>
                    <div class="d-flex flex-column mb-3">
                        <p class="text-uppercase text-primary mb-2">Investment</p>
                        <a href="#" class="text-body">Revisiting Your Investment & Distribution Goals</a>
                    </div>
                    <div class="d-flex flex-column mb-3">
                        <p class="text-uppercase text-primary mb-2">Business</p>
                        <a href="#" class="text-body">Dimensional Fund Advisors Interview with Director</a>
                    </div>
                    <div class="footer-btn text-start">
                        <a href="#" class="btn btn-light rounded-pill px-4">View All Post <i class="fa fa-arrow-right ms-1"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer End -->


<!-- Copyright Start -->
<div class="container-fluid copyright py-4">
    <div class="container">
        <div class="row g-4 align-items-center">
            <div class="col-md-6 text-center text-md-start mb-md-0">
                <span class="text-body"><a href="#" class="border-bottom text-primary"><i class="fas fa-copyright text-light me-2"></i>Realtrust.com</a>, All right reserved.</span>
            </div>
            <div class="col-md-6 text-center text-md-end text-body">
                <!--/*** This template is free as long as you keep the below author’s credit link/attribution link/backlink. ***/-->
                <!--/*** If you'd like to use the template without the below author’s credit link/attribution link/backlink, ***/-->
                <!--/*** you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". ***/-->
               
            </div>
        </div>
    </div>
</div>
<!-- Copyright End -->

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Font Awesome -->
  <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</body>
</html>
