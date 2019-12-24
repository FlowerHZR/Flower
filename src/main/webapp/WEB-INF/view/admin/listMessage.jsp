<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 后台文章管理页面 -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>CMS后台管理系统</title>
     <!-- Bootstrap core CSS-->
    <link href="/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="/libs/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="/libs/sb-admin/sb-admin.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
<!--     <link href="/libs/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<!--     <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css"> -->
	<link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="/libs/sb-admin/sb-admin.css" rel="stylesheet">
	<script type="text/javascript">
		function fenye(cpage){
			location="/admin/listMessage?pageNum="+cpage;
		}
		
	</script>
  </head>

  <body id="page-top">

    <!-- 后台管理系统顶部 -->
 	<jsp:include page="_inc_top.jsp"/>

    <div id="wrapper">

      	<!-- 后台管理系统左部菜单 -->
 		<jsp:include page="_inc_left.jsp"/>

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- 面包屑 -->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="index.html">后台首页</a>
            </li>
            <li class="breadcrumb-item active">文章管理</li>
          </ol>

          <!-- Page Content -->
          <h1>文章管理</h1>
          <hr>
        <!-- /.container-fluid -->
			<table class="table table-bordered">
				<tr>
					<td>投诉编号</td>
					<td>投诉人姓名</td>
					<td>投诉电话</td>
					<td>投诉人邮箱</td>
					<td>投诉信息</td>
					<td>文章地址</td>
					<td>投诉类型</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${plist.list}" var="a">
						<tr>
							<td>${a.aid }</td>
							<td>${a.realname }</td>
							<td>${a.phone }</td>
							<td>${a.email}</td>
							<td>${a.cominfo }</td>
							<td>${a.murl }</td>
							<td><c:if test="${a.tid==1}">政治反动</c:if>
							<c:if test="${a.tid==2}">淫秽色情</c:if>
							<c:if test="${a.tid==3}">粗俗谩骂</c:if>
							 </td>
							<td>
								<a href="/admin/updMessage?id=${a.aid }">
							 	<c:if test="${a.status==1 }">
							 	<i class="fa fa-check" aria-hidden="true"></i>
							 	</c:if>
								<c:if test="${a.status==0 }">
								<i class="fa fa-times" aria-hidden="true"></i> 
								</c:if>
								</a>
							</td>
						<%-- 	
							<td>
								<a href="/admin/updStatus?id=${a.id }">
							 	<c:if test="${a.status==1 }">
							 	<i class="fa fa-check" aria-hidden="true"></i>
							 	</c:if>
								<c:if test="${a.status==0 }">
								<i class="fa fa-times" aria-hidden="true"></i> 
								</c:if>
								</a>
							</td> --%>
						</tr>
					
				</c:forEach>
				<tr>
				    				<td colspan="11">
				    					<!-- 分页的样式  bootstrap -->
				    					<nav aria-label="Page navigation">
										  <ul class="pagination pagination-lg">
										    <li>
										      <a href="#" aria-label="Previous" onclick="fenye(${plist.isIsFirstPage()?1:plist.getPrePage()})">
										        <span aria-hidden="true">&laquo;</span>
										      </a>
										    </li>
										    <c:forEach items="${plist.getNavigatepageNums() }" var="nav">
										    	
										    	<li 
										    		<c:if test="${plist.getPageNum()==nav}">class="active"</c:if>
										    	><a href="#" onclick="fenye(${nav})">${nav}</a></li>
										    </c:forEach>
										    <li>
										      <a href="#" aria-label="Next" onclick="fenye(${plist.isIsLastPage()?plist.getPages():plist.getNextPage()})">
										        <span aria-hidden="true">&raquo;</span>
										      </a>
										    </li>
										  </ul>
										</nav>
				    				</td>
				    			</tr>
			</table>
        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright © Your Website 2018</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/libs/jquery/jquery.min.js"></script>
    <script src="/libs/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/libs/sb-admin/sb-admin.min.js"></script>
  </body>
</html>
