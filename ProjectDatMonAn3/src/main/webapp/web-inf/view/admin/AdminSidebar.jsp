
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page import="java.io.*,java.util.*" %>


<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
  <ul>

    <li class="submenu open"> <a href="#"><i class="icon icon-th-list"></i> <span>Danh mục món ăn</span> </a>
      <ul>
      <li><a href="/admin/quanlidanhmucmonan">Quản lí danh mục món ăn</a></li>
   		 <li><a href="/admin/themmoidanhmucmonan">Thêm mới danh mục món ăn</a></li>
      </ul>
    </li>
   
    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Nhà hàng</span> </a>
      <ul>
        <li><a href="/admin/nhahangchuquan">Chỉnh sửa quyền nhà hàng</a></li>


      </ul>
    </li>
       <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Khuyến mãi</span> </a>
      <ul>
        <li><a href="/admin/khuyenmai">Chỉnh sửa khuyến mãi</a></li>
             <li><a href="/admin/themmoikhuyenmai">Thêm mới khuyến mãi</a></li>

      </ul>
    </li>
    
  </ul>
</div>
