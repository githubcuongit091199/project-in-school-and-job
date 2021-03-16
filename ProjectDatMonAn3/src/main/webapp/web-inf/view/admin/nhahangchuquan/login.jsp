<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*" %>

<!DOCTYPE html>
<html lang="en">
    
<head>
        <title>Matrix Admin</title><meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="/resources/admin/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/resources/admin/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="/resources/admin/css/matrix-login.css" />
        <link href="/resources/admin/font-awesome/css/font-awesome.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>

    </head>


<body>
        <div id="loginbox">            
          <form:form class="form-vertical" method="post" action="/adminnhahangchuquan/dangnhap" modelAttribute="user">
				 <div class="control-group normal_text"> <h3>Đăng nhập nhà hàng chủ quán</h3></div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                             <span class="add-on bg_ly"><i class="icon-envelope"></i></span><form:input class="input100" type="text" path="email" name="email" placeholder="Email"/>
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_ly"><i class="icon-lock"></i></span><form:input class="input100" type="password" name="pass" path="password" placeholder="Password"/>
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-right"><button type="submit" class="btn btn-success" /> Login</button></span>
                </div>
               </form:form>
            <form id="recoverform" action="#" class="form-vertical">
				<p class="normal_text">Enter your e-mail address below and we will send you instructions how to recover a password.</p>
				
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_lo"><i class="icon-envelope"></i></span><input type="text" placeholder="E-mail address" />
                        </div>
                    </div>
               
                <div class="form-actions">
                    <span class="pull-left"><a href="#" class="flip-link btn btn-success" id="to-login">&laquo; Back to login</a></span>
                    <span class="pull-right"><a class="btn btn-info"/>Reecover</a></span>
                </div>
            </form>
        </div>
        
        <script src="/resources/admin/js/jquery.min.js"></script>  
        <script src="/resources/admin/js/matrix.login.js"></script> 
    </body>

</html>
