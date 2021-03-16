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
  <h1>Common Form Elements</h1>
</div>
<div class="container-fluid">
  <hr>
  <div class="row-fluid">
    <div class="span6">
      <div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>chỉnh sửa nhà hàng</h5>
        </div>
        <div class="widget-content nopadding">
          <form:form action="/admin/chinhsuanhahangchuquan/${nhahangchuquan.manhahang }" method="post" class="form-horizontal" modelAttribute="nhahangchuquan">
            <div class="control-group">
              <label class="control-label">tên nhà hàng chủ quán :</label>
              <div class="controls">
                <form:input type="text" class="span11" placeholder="${nhahangchuquan.tennhahang }" path="tennhahang"/>
              </div>
            </div>
              <div class="control-group">
              <label class="control-label">địa chỉ :</label>
              <div class="controls">
                <form:input type="text" class="span11" placeholder="${nhahangchuquan.diachi}" path="diachi"/>
              </div>
            </div>  
            <div class="control-group">
              <label class="control-label">số điện thoại :</label>
              <div class="controls">
                <form:input type="text" class="span11" placeholder="${nhahangchuquan.sdt }" path="sdt"/>
              </div>
            </div>
			<div class="control-group">
              <label class="control-label">trạng thái :</label>
              <div class="controls">
                <form:input type="text" class="span11" placeholder="${nhahangchuquan.trangthai }" path="trangthai"/>
              </div>
            </div>
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
<script>
	$('.textarea_editor').wysihtml5();
</script>
</body>
</html>
>