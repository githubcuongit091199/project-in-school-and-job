
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<jsp:include page="./common/Header.jsp"></jsp:include>
<div class="checkout__form">
               
                <form:form method="post" action="/taikhoan/dangnhap" modelAttribute="user">
        
               <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				
				<form class="login100-form validate-form">
					<span class="login100-form-title">
						Đăng nhập
					</span>

					<div class="wrap-input100 validate-input" >
						<form:input class="input100" type="text" path="email" name="email" placeholder="Email"/>
						 <form:errors path="email" cssClass="text-danger"/>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" >
						<form:input class="input100" type="password" name="pass" path="password" placeholder="Password"/>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="container-login100-form-btn">
						<button type="submit"class="login100-form-btn">
							Login
						</button>
					</div>

					<div class="text-center p-t-136">
						<a class="txt2" href="/taikhoan/dangki">
							Đăng ký tài khoản mới
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
					  </form>
					  </div>
					  </div>
					  </div>
					 
				</form:form>
		
              
            </div>

<jsp:include page="./common/Footer.jsp"></jsp:include>