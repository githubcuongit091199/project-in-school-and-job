<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page import="java.io.*,java.util.*" %>
         
            
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>Danh mục</span>
                        </div>
                         <ul >
                         <c:forEach var="item" items="${danhsachloaimonan}">
                            <li><a href="/home/nhomhang/${item.iddanhmuc}">${item.loaimonan}</a></li>
                                    </c:forEach>     
                        </ul>
                    </div>
       
              
                    