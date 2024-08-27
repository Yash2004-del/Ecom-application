<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Registration</title>
    <!-- plug ins:c s s -->
    <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="assets/vendors/font-awesome/css/font-awesome.min.css">
    <!-- end inject -->
    <!-- Plug in c s s for this page -->
    <!-- End plug in c s s for this page -->
    <!-- inject:c s s -->
    <!-- end inject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="assets/images/favicon.png" />
  </head>
  <body>
    <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="row w-100">
          <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg">
            <div class="card col-lg-4 mx-auto">
              <div class="card-body px-5 py-5">
                <h3 class="card-title text-start mb-3">Register</h3>
                <form action="SignUpServlet" method="post">
                  <div class="form-group">
                    <label>FirstName</label><br>
                    <input type="text" class="form-control p_input" name="FirstName" placeholder="Please enter your name"><span style="color:red">${NError}</span>
                  </div>
                  <div class="form-group">
                    <label>Email</label>
                    <input type="email" class="form-control p_input" name="Email" placeholder="Please enter your email"><span style="color:red">${EError}</span>
                  </div>
                  <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control p_input" name="Password" placeholder="Please enter your password">
                     <span style="color:red">${PError}</span><br>
                     <span style="color:yellow">
                    <h6>*Should contain length upto 8 characters.</h6>
                    <h6>*Should contain one Uppercase character.</h6>
                    <h6>*Should contain @ character followed by 4 digits.</h6><span style="color:red">${PError}</span>
                  </span>
                  </div>
                 <div >
                    <label>Gender</label>:
                    Male:<input type="radio"  name="Gender" value="Male">
                    Female:<input type="radio"  name="Gender" value="Female"><span style="color:red">${GError}</span>
                  </div><br>
                   
                  <div class="text-center d-grid gap-2">
                    <button type="submit" class="btn btn-primary btn-block enter-btn">Create Account</button>
                  </div>
                 
                  <p class="sign-up text-center">Already have an Account?<a href="Login.jsp">Login</a></p>
               
                </form>
              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
        </div>
        <!-- row ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plug ins:j s -->
    <script src="assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- end inject -->
    <!-- Plug in j s for this page -->
    <!-- End plug in j s for this page -->
    <!-- inject:j s -->
    <script src="assets/js/off-canvas.js"></script>
    <script src="assets/js/misc.js"></script>
    <script src="assets/js/settings.js"></script>
    <script src="assets/js/todolist.js"></script>
    <!-- end inject -->
  </body>
</html>