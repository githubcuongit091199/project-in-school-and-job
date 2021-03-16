
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<jsp:include page="./common/Header.jsp"></jsp:include>
<div class="checkout__form">
    
                <form:form method="post" action="/taikhoan/dangki" modelAttribute="user">
                  <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				
				
					<span class="login100-form-title">
						Đăng kí tài khoản
					</span>
					<div class="wrap-input100 validate-input" >
						<form:input class="input100" type="text" path="tenkhachhang"  placeholder="Tên của bạn"/>
						 <form:errors path="tenkhachhang" cssClass="text-danger"/>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
					</div>
					<div class="wrap-input100 validate-input" >
						<form:input class="input100" type="text" path="email"  placeholder="Email"/>
						<form:errors path="email" cssClass="text-danger"/>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" >
						<form:input class="input100" type="password"  path="password" placeholder="Password"/>
						<form:errors path="password" cssClass="text-danger"/>
                        
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					<div class="wrap-input100 validate-input" >
						<form:input class="input100" type="password"  path="confirmPassword" placeholder="Confirm Password"/>
						<form:errors path="confirmPassword" cssClass="text-danger"/>
                    
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-unlock-alt" aria-hidden="true"></i>
						</span>
					</div>					
					
						<div class="wrap-input100 validate-input" >
						<form:input class="input100" type="text"  path="diachi" placeholder="Địa chỉ"/>
						 <form:errors path="diachi" cssClass="text-danger"/>
				
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-address-book" aria-hidden="true"></i>
						</span>
					</div>
						<div class="wrap-input100 validate-input" >
						<form:input class="input100" type="text"  path="sdt" placeholder="Số điện thoại"/>
						  <form:errors path="sdt" cssClass="text-danger"/>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-phone" aria-hidden="true"></i>
						</span>
					</div>	
					<div>
					<label>Chọn vào đây để làm đối tác với chúng tôi
					 </label>
						<form:checkbox id="quanan"  name="loaitk"  path="loaitaikhoan" value="nhà hàng/ chủ quán"/>
						 <label for="quanan">Quán ăn</label>
						 		 
					</div>				
					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">
							Đăng kí
						</button>
					</div>

					
					 
					  </div>
					  </div>
					  </div>
          		
                </form:form>
           

<jsp:include page="./common/Footer.jsp"></jsp:include>