
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.io.*,java.util.*" %>
<jsp:include page="./common/Header.jsp"></jsp:include>

    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    
                        <jsp:include  page="./common/DanhMuc.jsp"></jsp:include>
                    
                </div>
          
                <jsp:include  page="./common/Search.jsp"></jsp:include>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="/resources/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="bre	adcrumb__text">
                        <h2 style="color: white">${thongtinnhahang.tennhahang}</h2>
                       
                    </div>
                </div>
            </div>
        </div>
    </section>
<section class="blog spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-5">
                    <div class="blog__sidebar">
                        <div class="blog__sidebar__search">
                            <form action="#">
                                <input type="text" placeholder="Search...">
                                <button type="submit"><span class="icon_search"></span></button>
                            </form>
                        </div>
                        
                        <div class="blog__sidebar__item">
                            <h4>Thực đơn ${thongtinnhahang.tennhahang }</h4>
                            
                            
                            <c:forEach var="item" items="${thongtinthucdon}">
                            <ul>
                            
                                <li><a href="/nhahang/trangnhahang1/${item.mathucdon}">${item.tenthucdon}</a></li>
                  
                            </ul>
                         </c:forEach>
                        </div>
                         
                        <div class="blog__sidebar__item">
                            <h4>Recent News</h4>
                            <div class="blog__sidebar__recent">
                                <a href="#" class="blog__sidebar__recent__item">
                                    <div class="blog__sidebar__recent__item__pic">
                               <!--          <img src="img/blog/sidebar/sr-1.jpg" alt=""> -->
                                    </div>
                                    <div class="blog__sidebar__recent__item__text">
                                        <h6>09 Kinds Of Vegetables<br> Protect The Liver</h6>
                                        <span>MAR 05, 2019</span>
                                    </div>
                                </a>
                                <a href="#" class="blog__sidebar__recent__item">
                                    <div class="blog__sidebar__recent__item__pic">
                                  <!--       <img src="img/blog/sidebar/sr-2.jpg" alt=""> -->
                                    </div>
                                    <div class="blog__sidebar__recent__item__text">
                                        <h6>Tips You To Balance<br> Nutrition Meal Day</h6>
                                        <span>MAR 05, 2019</span>
                                    </div>
                                </a>
                                <a href="#" class="blog__sidebar__recent__item">
                                    <div class="blog__sidebar__recent__item__pic">
                                        <!-- <img src="img/blog/sidebar/sr-3.jpg" alt=""> -->
                                    </div>
                                    <div class="blog__sidebar__recent__item__text">
                                        <h6>4 Principles Help You Lose <br>Weight With Vegetables</h6>
                                        <span>MAR 05, 2019</span>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="blog__sidebar__item">
                            <h4>Search By</h4>
                            <div class="blog__sidebar__item__tags">
                                <a href="#">Apple</a>
                                <a href="#">Beauty</a>
                                <a href="#">Vegetables</a>
                                <a href="#">Fruit</a>
                                <a href="#">Healthy Food</a>
                                <a href="#">Lifestyle</a>
                            </div>
                        </div>
                    </div>
                </div>
                
                
                
              
                <div class="col-lg-8 col-md-7">
                    <div class="row">
                        <c:forEach var="item" items="${monannhahang}">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                      
                            <div class="blog__item">
                                <div class="blog__item__pic">
                                    <img src="/resources/img/monan/${item.hinhanh}" alt="">
                                </div>
                                <div class="blog__item__text">
                                    <ul>
                                        <li><i class="fa fa-calendar-o"></i> May 4,2019</li>
                                        <li><i class="fa fa-comment-o"></i> 5</li>
                                    </ul>
                                    <h5><a href="/chitietmonan/chitiet/${item.mamonan }">${item.tenmonan}</a></h5>
                                    <p>${item.thongtin }
                                        
                                        
                                         </p>
                                        
                                        
                                        
                                    <a href="/chitietmonan/chitiet/${item.mamonan }" class="blog__btn">đến trang chi tiết<span class="arrow_right"></span></a>
                                </div>
                            </div>
                            
                         
                        </div>
                                                   </c:forEach>
                        
                   
                        
                    </div>
                </div>
            	
            </div>
        </div>
    </section>
     
    
    	<jsp:include page="./common/Footer.jsp"></jsp:include>