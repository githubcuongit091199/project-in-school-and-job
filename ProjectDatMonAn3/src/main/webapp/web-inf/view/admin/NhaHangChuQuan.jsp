<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page import="java.io.*,java.util.*" %>

  <jsp:include page="./AdminHeader.jsp"></jsp:include>
  <body>
<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">Matrix Admin</a></h1>
</div>
<!--close-Header-part--> 
 <jsp:include page="./Admintk.jsp"></jsp:include>

<!--top-Header-menu-->


<!--start-top-serch-->
<div id="search">
  <input type="text" placeholder="Search here..."/>
  <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-serch--> 

<!--sidebar-menu-->


  <jsp:include page="./AdminSidebar.jsp"></jsp:include>
  



<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Tables</a> </div>
    <h1>Chỉnh sửa quyền nhà hàng</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
       
       
      
        <div class="widget-box">
     
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>NHÀ HÀNG /QUÁN ĂN</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>tên quán/nhà hàng</th>
                  <th>địa chỉ</th>
                  <th>số điện thoại</th>
                  <th>trạng thái</th>
                  <th>thao tác</th>                 
                </tr>
              </thead>
              <tbody>
              
              
              
              
              
              <c:forEach var="item" items="${dskhachhang}">
                <tr class="gradeX">
                  <td>${item.tennhahang}</td>
                   <td>${item.diachi}</td>
                    <td>${item.sdt}</td>
                     <td>${item.trangthai}</td>
                  <td class="center">
                  <a href="/admin/chinhsuanhahangchuquan/${item.manhahang }">chỉnh sửa</a>
                  ||
          <a href="/admin/xoanhahangchuquan/${item.manhahang }">xóa</a> 
                  </td>
                  
                </tr>
         	</c:forEach>
         	
         	
         	
         	
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by <a href="http://themedesigner.in">Themedesigner.in</a> </div>
</div>
<!--end-Footer-part-->
<script src="/resources/admin/js/jquery.min.js"></script> 
<script src="/resources/admin/js/jquery/resources/admin//resources/admin//resources/admin/.ui.custom.js"></script> 
<script src="/resources/admin/js/bootstrap.min.js"></script> 
<script src="/resources/admin/js/jquery.uniform.js"></script> 
<script src="/resources/admin/js/select2.min.js"></script> 
<script src="/resources/admin/js/jquery.dataTables.min.js"></script> 
<script src="/resources/admin/js/matrix.js"></script> 
<script src="/resources/admin/js/matrix.tables.js"></script>
</body>
</html>
