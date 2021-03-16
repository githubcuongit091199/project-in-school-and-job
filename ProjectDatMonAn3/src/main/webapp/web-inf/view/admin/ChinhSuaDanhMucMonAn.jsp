<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
  

<!--close-left-menu-stats-sidebar-->

<div id="content">
<div id="content-header">
  <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="tip-bottom">Form elements</a> <a href="#" class="current">Common elements</a> </div>
  <h1>Thêm mới loại món ăn</h1>
</div>
<div class="container-fluid">
  <hr>
  <div class="row-fluid">
    <div class="span6">
      <div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>danh mục</h5>
        </div>
        <div class="widget-content nopadding">
          <form:form action="/admin/chinhsuadanhmucmonan" method="post" class="form-horizontal" modelAttribute="danhmucmonan">
            <div class="control-group">
              <label class="control-label">loại món ăn :</label>
              <div class="controls">
                <form:input type="text" class="span11" placeholder="loại món ăn" path="loaimonan"/>
              </div>
            </div>
        
              <label class="control-label">trạng thái :</label>
             
           	<form:checkbox  name="loaitk"  path="trangthai" value="an" style="opacity: 40;"/>
			<label for="quanan">Ẩn</label>


            <div class="form-actions">
              <button type="submit" class="btn btn-success">Save</button>
            </div>
          </form:form>
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
<script src="/resources/admin/js/jquery.ui.custom.js"></script> 
<script src="/resources/admin/js/bootstrap.min.js"></script> 
<script src="/resources/admin/js/bootstrap-colorpicker.js"></script> 
<script src="/resources/admin/js/bootstrap-datepicker.js"></script> 
<script src="/resources/admin/js/jquery.toggle.buttons.js"></script> 
<script src="/resources/admin/js/masked.js"></script> 
<script src="/resources/admin/js/jquery.uniform.js"></script> 
<script src="/resources/admin/js/select2.min.js"></script> 
<script src="/resources/admin/js/matrix.js"></script> 
<script src="/resources/admin/js/matrix.form_common.js"></script> 
<script src="/resources/admin/js/wysihtml5-0.3.0.js"></script> 
<script src="/resources/admin/js/jquery.peity.min.js"></script> 
<script src="/resources/admin/js/bootstrap-wysihtml5.js"></script> 

</body>
</html>
>