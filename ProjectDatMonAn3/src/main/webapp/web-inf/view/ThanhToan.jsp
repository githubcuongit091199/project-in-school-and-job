
<%@page import="ProDatMonAn.model.MatHang"%>
<%@page import="ProDatMonAn.model.giohang"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.io.*,java.util.*" %>

	<jsp:include page="./common/Header.jsp"></jsp:include>
	
 <section class="breadcrumb-section set-bg" data-setbg="/resources/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Thanh toán</h2>
                       
                    </div>
                </div>
            </div>
        </div>
    </section>

<section class="checkout spad">
     
            <div class="row">
                <div class="col-lg-12">
                    <h6><span class="icon_tag_alt"></span> Bạn có mã giảm giá không? <a href="/giohang/index">Chọn tại đây</a> để nhập mã
                    </h6>
                </div>
            </div>
            <div style="margin-left: 530px">
       
                <h4>Chi tiết thanh toán</h4>
                <form action="/giohang/themvaodb" method="get">
                    <div class="row">
                       
                          
                        <div class="col-md-6" style="ma">
                            <div class="checkout__order">
                                <h4>Đơn hàng</h4>
                                <div class="checkout__order__products">Sản phẩm<span> Tổng tiền</span><span>/</span><span>Số lượng</span></div>
                                 
                                <ul>
                                <%
                               giohang gio=new giohang();
                               gio= (giohang) session.getAttribute("cart");
                               if(gio!=null)
                               {
                            	   List<MatHang> monan=gio.getItem();
                            	   for(MatHang hang:monan)
                            	   {%>
                                   
                                    <li><%out.println(hang.getMonan().getTenmonan()); %> <span><%out.println(hang.getMonan().getGia()); %></span>
                                    <span>&nbsp&nbsp&nbsp&nbsp</span>
                                  <span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span> <span> <%out.println(hang.getSoluong()); %></span></li>
                                    <%} %>
                                </ul>
                                
                                <div class="checkout__order__subtotal">Tổng giá trị </div>
                                <%} %>
                                <div class="checkout__order__total">Tổng kết tiền <span><%out.println(gio.getGia()); %> </span></div>
                               
                                
                               
                              <button class="site-btn" type="submit"  >Thanh toán</button>
                                 
                            </div>
                        </div>
                    </div>
                </form>
            </div>
      
   
    </section>
    	<jsp:include page="./common/Footer.jsp"></jsp:include>