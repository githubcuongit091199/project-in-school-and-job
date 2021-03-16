<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="ProDatMonAn.model.TaiKhoanModel"%>
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
<!--close-top-Header-menu-->
<!--start-top-serch-->
<div id="search">
  <input type="text" placeholder="Search here..."/>
  <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-serch-->
<!--sidebar-menu-->
  
  
  <jsp:include page="./AdminSidebar.jsp"></jsp:include>
  
  
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
  </div>
<!--End-breadcrumbs-->

<!--Action boxes-->
  <div class="container-fluid">
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_lb"> <a href="#"> <i class="icon-dashboard"></i> My Dashboard </a> </li>
        <li class="bg_lg span3"> <a href="#"> <i class="icon-signal"></i> Charts</a> </li>
        <li class="bg_ly"> <a href="#"> <i class="icon-inbox"></i>	 Widgets </a> </li>
        <li class="bg_lo"> <a href="#"> <i class="icon-th"></i> Tables</a> </li>
        <li class="bg_ls"> <a href="#"> <i class="icon-fullscreen"></i> Full width</a> </li>
        <li class="bg_lo span3"> <a href="#"> <i class="icon-th-list"></i> Forms</a> </li>
        <li class="bg_ls"> <a href="#"> <i class="icon-tint"></i> Buttons</a> </li>
        <li class="bg_lb"> <a href="#"> <i class="icon-pencil"></i>Elements</a> </li>
        <li class="bg_lg"> <a href="#"> <i class="icon-calendar"></i> Calendar</a> </li>
        <li class="bg_lr"> <a href="#"> <i class="icon-info-sign"></i> Error</a> </li>

      </ul>
    </div>
<!--End-Action boxes-->    

<!--Chart-box-->    

<!--End-Chart-box--> 
 
        </div>
      </div>


<!--end-main-container-part-->

<!--Footer-part-->

<div class="row-fluid">
  <div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by <a href="http://themedesigner.in">Themedesigner.in</a> </div>
</div>

<!--end-Footer-part-->

<script src="/resources/admin/js/excanvas.min.js"></script> 
<script src="/resources/admin/js/jquery.min.js"></script> 
<script src="/resources/admin/js/jquery.ui.custom.js"></script> 
<script src="/resources/admin/js/bootstrap.min.js"></script> 
<script src="/resources/admin/js/jquery.flot.min.js"></script> 
<script src="/resources/admin/js/jquery.flot.resize.min.js"></script> 
<script src="/resources/admin/js/jquery.peity.min.js"></script> 
<script src="/resources/admin/js/fullcalendar.min.js"></script> 
<script src="/resources/admin/js/matrix.js"></script> 
<script src="/resources/admin/js/matrix.dashboard.js"></script> 
<script src="/resources/admin/js/jquery.gritter.min.js"></script> 
<script src="/resources/admin/js/matrix.interface.js"></script> 
<script src="/resources/admin/js/matrix.chat.js"></script> 
<script src="/resources/admin/js/jquery.validate.js"></script> 
<script src="/resources/admin/js/matrix.form_validation.js"></script> 
<script src="/resources/admin/js/jquery.wizard.js"></script> 
<script src="/resources/admin/js/jquery.uniform.js"></script> 
<script src="/resources/admin/js/select2.min.js"></script> 
<script src="/resources/admin/js/matrix.popover.js"></script> 
<script src="/resources/admin/js/jquery.dataTables.min.js"></script> 
<script src="/resources/admin/js/matrix.tables.js"></script> 

<script type="text/javascript">
  // This function is called from the pop-up menus to transfer to
  // a different page. Ignore if the value returned is a null string:
  function goPage (newURL) {

      // if url is empty, skip the menu dividers and reset the menu selection to default
      if (newURL != "") {
      
          // if url is "-", it is this page -- reset the menu:
          if (newURL == "-" ) {
              resetMenu();            
          } 
          // else, send page to designated URL            
          else {  
            document.location.href = newURL;
          }
      }
  }

// resets the menu selection upon entry to this page:
function resetMenu() {
   document.gomenu.selector.selectedIndex = 2;
}
</script>
</body>
</html>
