<%@page import="ProDatMonAn.model.giohang"%>
<%@page import="ProDatMonAn.model.TaiKhoanModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

    <!-- Google Font -->
   <link rel="icon" type="image/png" href="/resources/img/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/resources/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/main.css">

    <!-- /resources/css Styles -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/style.css" type="text/css">
</head>
<body>
   

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i> 
                                 <%
                                if(session.getAttribute("user")==null)
                                {%>
                                quamon@gmail.com
                                <% 
                                }
                                else
                                {
                                TaiKhoanModel taikhoan=(TaiKhoanModel)session.getAttribute("user");
                					out.println(taikhoan.getEmail()); 
                                }
                                %>
                                </li>
                                <li>Miễn phí ship khi đơn hàng hơn 100 nghìn đồng</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                            <div class="header__top__right__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                <a href="#"><i class="fa fa-pinterest-p"></i></a>
                            </div>
                            <div class="header__top__right__language">
                                <img src="/resources/img/language.png" alt="">
                                <div>English</div>
                                <span class="arrow_carrot-down"></span>
                                <ul>
                                    <li><a href="#">Tiếng việt</a></li>
                                    <li><a href="#">English</a></li>
                                </ul>
                            </div>
                            <%if(session.getAttribute("user")==null) 
                            {
                            %>
                            
                            <div class="header__top__right__auth">
                                <a href="/taikhoan/dangnhap"><i class="fa fa-user"></i> Đăng nhập</a>
                            </div>
                             <div class="header__top__right__auth">
                                <a href="/taikhoan/dangki"><i class="fa fa-user"></i>Đăng ký</a>
                            </div>
                            <%}
                            else
                            {
                            %>
                            <div class="header__top__right__auth">
                                <a href="/taikhoan/dangxuat"><i class="fa fa-user"></i> Đăng xuất</a>
                            </div>
                            <%} %>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <h2 style="color: green">3 THANH NIÊN</h2>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="/home/index">Trang chủ</a></li>
                            <li><a href="/home/shopping">Mua hàng</a></li>
                           <%
                    
                           
                           if(session.getAttribute("user") ==null)
                           {%>
                           <%}
                           else 
							{      
                               TaiKhoanModel taikhoan=(TaiKhoanModel) session.getAttribute("user");
                        	   if( taikhoan.getLoaitaikhoan().equals("nhahangchuquan"))
                        	   {
                            %>
                            <li><a href="#">manage</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="./shop-details.html">add food</a></li>
                                    <li><a href="/nhahangquanly/index">edit</a></li>
                                    <li><a href="/nhahangquanly/menu">create menu</a></li>
                                </ul>
                            </li>
                           <%}} %>
                            <li><a href="/giohang/index">Giỏ hàng</a></li>                           
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                        </ul>
                        <div class="header__cart__price">Tổng tiền: <span>
                        
                         <%
                                if(session.getAttribute("cart")==null)
                                {%>
                               0.00
                                <% 
                                }
                                else
                                {
                                giohang gio=(giohang)session.getAttribute("cart");
                                out.println(gio.getGia()); 
                                }
                                %>
                        VND
                       
                        
                        
                        
                        
                        </span></div>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <!-- Hero Section End -->
         
                   
