
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.io.*,java.util.*" %>
	<jsp:include page="./common/Header.jsp"></jsp:include>
	<section class="hero">
        <div class="container">
                   <div class="row">
                     <div class="col-lg-3">
                     <jsp:include  page="./common/DanhMuc.jsp"></jsp:include>
               	
                   </div>
                <div class="col-lg-9">
                
                
                   <jsp:include  page="./common/Search.jsp"></jsp:include>
                   
                   
            		<div class="hero__item set-bg" data-setbg="/resources/img/monan/picmain4.jpg">
                        <div class="hero__text">
                            <span>MÓN ĂN TRỰC TUYẾN</span>
                            <h2>Món ăn <br>ngon bổ tiện ích</h2>
                            <p>Nhận và giao hàng miễn phí*</p>
                            <a href="/home/shopping" class="primary-btn">Đặt hàng ngay</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Categories Section Begin -->
    <section class="categories">
        <div class="container">
            
             <div class="row">
                            <div class="product__discount__slider owl-carousel">
                            
                            <c:forEach var="item" items="${khuyenmai}">
                            
                                <div class="col-lg-4">
                                    <div class="product__discount__item">
                                        <div class="product__discount__item__pic set-bg"
                                            data-setbg="/resources/img/monan/${item.hinhanh}">
                                            <div class="product__discount__percent">-${item.khuyenmai}%</div>
                                            <ul class="product__item__pic__hover">
                                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                                <li><a href="/chitietmonan/chitiet/${item.mamonan }"><i class="fa fa-shopping-cart"></i></a></li>
                                            </ul>
                                        </div>
                                        <div class="product__discount__item__text">
                                            
                                            <h5><a href="/chitietmonan/chitiet/${item.mamonan }">${item.tenmonan}</a></h5>
                                            <div class="product__item__price">${item.gia-(item.gia*item.khuyenmai/100)} <span>${item.gia}</span></div>
                                        </div>
                                    </div>
                                </div>
                                
                                </c:forEach>
                                
                              </div>
                        </div>
        </div>
    </section>
    <!-- Categories Section End -->

    <!-- Featured Section Begin -->
    <section class="featured spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>Nhà hàng	</h2>
                    </div>
                    <!-- <div class="featured__controls">
                        <ul>
                            <li class="active" data-filter="*">All</li>
                            <li data-filter=".oranges">Oranges</li>
                            <li data-filter=".fresh-meat">Fresh Meat</li>
                            <li data-filter=".vegetables">Vegetables</li>
                            <li data-filter=".fastfood">Fastfood</li>
                        </ul>
                    </div> -->
                </div>
            </div>
            
            
            <div class="row featured__filter">
            
            
           
            <c:forEach var="item" items="${danhsach}" > 
                <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                    <div class="featured__item">
                        <div  class="featured__item__pic set-bg" data-setbg="/resources/img/monan/${item.hinhanh}">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="/nhahang/trangnhahang/${item.manhahang}"><i class="fa fa-shopping-cart"></i></a></li>
                             
                            </ul>
                      
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="/nhahang/trangnhahang/${item.manhahang}">${item.tennhahang}</a></h6>
                            
                            
                        </div>
                     
                    </div>
                	</div>    
                 </c:forEach> 
               
            </div>
           
        </div>
    </section>
    <!-- Featured Section End -->

    <!-- Banner Begin -->
    <div class="banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        </resources/img src="/resources	/img/banner/banner-1.jpg" alt="">
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        </resources/img src="/resources/img/banner/banner-2.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Banner End -->



	<jsp:include page="./common/Footer.jsp"></jsp:include>