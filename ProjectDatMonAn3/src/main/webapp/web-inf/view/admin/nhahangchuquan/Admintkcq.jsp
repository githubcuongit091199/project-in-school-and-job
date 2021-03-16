<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="ProDatMonAn.model.TaiKhoanModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page import="java.io.*,java.util.*" %>

<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text"> <%
                                if(session.getAttribute("cq")==null)
                                {%>
                                Welcom user
                                <% 
                                }
                                else
                                {
                                TaiKhoanModel taikhoan=(TaiKhoanModel)session.getAttribute("cq");
                					out.println(taikhoan.getEmail()); 
                                }
                                %></span><b class="caret"></b></a>
      <ul class="dropdown-menu">

        <li><a href="/adminnhahangchuquan/dangxuat"><i class="icon-key"></i> 
         <%if(session.getAttribute("cq")!=null)
                                {%>
                                	Log out
                                <% 
                                }
                                %>
        </a></li>
      </ul>
    </li>
    

  </ul>
</div>