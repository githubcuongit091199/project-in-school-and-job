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
  <jsp:include page="./Admintkcq.jsp"></jsp:include>

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
        <div><a href="/admin/themdanhmucmonan">thêm mới</a></div>
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Danh Mục</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>tên món ăn</th>
                  <th>giá</th>    
                  <th>khuyễn mãi</th>   
                  <th>thông tin</th>            
                </tr>
              </thead>
              <tbody>
              
              
              
              
              
              <c:forEach var="item" items="${dsmonan}">
                <tr class="gradeX">
                  <td>${item.tenmonan}</td>
                     <td>${item.gia}</td>
                        <td>${item.khuyenmai}</td>
                           <td>${item.thongtin}</td>
                  
                  <td class="center"><a href="/adminnhahangchuquan/chinhsuaquanlimonannhahang/${item.iddanhmuc }">chỉnh sửa</a>
                  ||<a href="/adminnhahangchuquan/xoadanhmucmonan/${item.iddanhmuc }">xóa</a></td>
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
