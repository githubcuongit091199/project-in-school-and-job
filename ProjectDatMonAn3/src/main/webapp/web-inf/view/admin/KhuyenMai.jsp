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

<!--top-Header-menu-->
 <jsp:include page="./Admintk.jsp"></jsp:include>

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
    <h1>quản lý</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
       
       
      
        <div class="widget-box">
 <div><a href="/admin/themmoikhuyenmai">thêm mới</a></div>
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Khuyễn Mãi</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered ">
              <thead>
                <tr>
                  <th>Mã Khuyễn Mãi</th>
                  <th>Thời gia bắt đầu</th>  
                  <th>Thời gia kết thúc</th>
                  <th>số tiền giảm</th>      
                    <th>edit</th>        
                </tr>
              </thead>
              <tbody>
              
              
              
              
              
              <c:forEach var="item" items="${dskhuyenmai}">
                <tr class="gradeX">
                  <td>${item.tenma}</td>
             
                   <td>${item.startdate}</td> 
                   <td>${item.finishdate}</td>
                         <td>${item.money}</td> 
                <td class="center"><a href="/admin/chinhsuakhuyenmai/${item.iddiscount}">chỉnh sửa</a>
                ||<a href="/admin/xoakhuyenmai/${item.iddiscount }">xóa</a></td>
              
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
