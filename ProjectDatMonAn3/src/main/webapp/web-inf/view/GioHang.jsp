
<%@page import="ProDatMonAn.model.MatHang"%>
<%@page import="java.util.List"%>
<%@page import="ProDatMonAn.model.giohang"%>
<%@page import="org.springframework.boot.web.servlet.server.Session"%>
<%@page import="ProDatMonAn.model.MonAnModel"%>
<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
	<jsp:include page="./common/Header.jsp"></jsp:include>

 <!-- Hero Section Begin -->
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <jsp:include page="./common/DanhMuc.jsp"></jsp:include>
                </div>
                <%-- <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <div class="hero__search__categories">
                                    All Categories
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div>
                        </div>
                    </div>
                </div> --%>
                <jsp:include page="./common/Search.jsp"></jsp:include>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="/resources/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Giỏ hàng của bạn</h2>
                       
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shoping Cart Section Begin -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th class="shoping__product"width="220" height="104.8">Sản phẩm</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                    <th>Tổng tiền</th>
                                    <th>Cập nhật</th>
                                  
                              
                                </tr>
                            </thead>
                          
                            <tbody>
                             
                               <%
                               giohang gio=new giohang();
                               gio= (giohang) session.getAttribute("cart");
                               if(gio!=null)
                               {
                            	   List<MatHang> monan=gio.getItem();
                            	   for(MatHang hang:monan)
                            	   {%>
                            	      <form method="post" action="/giohang/chinhsua/" >
                            	   <tr>
                                    <td class="shoping__cart__item">
                                   <input type="hidden" name="id" value="<%= hang.getIdmonan()%>">
                                        <img src="/resources/img/monan/<%out.println(hang.getMonan().getHinhanh()); %>" width="220" height="104.8" alt=""> 
                                        <h5><%out.println(hang.getMonan().getTenmonan()); %></h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                        <%out.println(hang.getMonan().getGia()-hang.getMonan().getGia()*hang.getMonan().getKhuyenmai()/100); %>
                                    </td>
                                    <td class="shoping__cart__quantity">
                                        <div class="quantity">
                                            <div class="pro-qty">
                                               <input type="text" value="<%out.println(hang.getSoluong());%>" 
                                                name="soluong">
                                            </div>
                                        </div>
                                    </td>
                                    <td class="shoping__cart__total">
                                      <%out.println(hang.getThanhTien()); %>
                                    </td>
                                     <td  >
                               				<button type="submit" class="btn btn-success btn-circle">
						                    <i class="fas fa-check"></i>
						                  </button>
                                    </td>
                                    <td class="shoping__cart__item__close">
                                    <a href="/giohang/xoa/<%out.println(hang.getIdmonan()); %>">
                                        <span class="icon_close"></span></a>
                                    </td>
                                    
                                </tr>
                                   </form>   
                                <% }} %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns">
                                        
                        <a href="/home/index" class="primary-btn cart-btn cart-btn-right">TIẾP TỤC MUA HÀNG</a>
                      
                     
                    </div>
                </div>
               
                <div class="col-lg-6">
                    <div class="shoping__continue">
                        <div class="shoping__discount">
                            <h5>Mã giảm giá</h5>
                            <form action="/giohang/giamgia">
                                <input type="text" placeholder="Enter your coupon code" name="magiamgia">
                                <button type="submit" class="site-btn">XÁC NHẬN MÃ</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Tổng đơn hàng</h5>
                        <ul>
                        <% 
                     //   giohang gio=new giohang();
                     //   gio= (giohang) session.getAttribute("cart");
                        if(gio!=null)
                        {
                        if(gio.getMagiamgia()!=0) %>
                          <li>Tiền được giảm khi nhập mã <span><%out.println(gio.getMagiamgia());  }%></span></li>
                             <c:if test="${thongbao != null }">
                             ${thongbao}
                         </c:if>
                         
                            <li>Tổng tiền <span>
                             <%
                                if(session.getAttribute("cart")==null)
                                {out.println("0.00");}
                                else
                                {out.println(gio.getGia());      }
                                %>
                        
                       
                            </span></li>
                        </ul>
                        <a href="/giohang/thanhtoan" class="primary-btn">Tiến hành thanh toán</a>
                        
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->

    
    	<jsp:include page="./common/Footer.jsp"></jsp:include>