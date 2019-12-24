<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>发布博客</title>

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="/libs/bootstrap/css/bootstrap.min.css" />
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/cms.css" />
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/inc/tousu_top.jsp"></jsp:include>

	<!-- 横幅 -->

	<br />
	<!-- 主体内容区 -->
	<div class="container" align="center">
		<div class="row">

			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-body">
						<h2>我要投诉</h2>
						<hr />

						<form:form action="/addMessage" modelAttribute="comMessage" method="post">
							<table>
								<tr>
									<td>投诉人姓名:</td>
									<td><form:input path="realname" class="form-control"/>
										<form:errors path="realname" cssStyle="color:red"></form:errors>
									</td>
								</tr>
								<tr>
									<td>投诉人电话:</td>
									<td><form:input  path="phone" class="form-control"/>
										<form:errors path="phone" cssStyle="color:red"></form:errors>
									</td>
								</tr>
										<tr>
									<td>投诉人邮箱:</td>
									<td><form:input path="email" class="form-control"/>
									<form:errors path="email" cssStyle="color:red"></form:errors>
									</td>
								</tr>
								<tr>
									<td>投诉类型:</td>
									<td>
									<form:select path="tid" class="form-control">
										<form:option value="-1">===请选择===</form:option>
										<form:option value="1">政治反动</form:option>
										<form:option value="2">淫秽色情</form:option>
										<form:option value="3">粗俗谩骂</form:option>
								</form:select>
								<form:errors path="tid" cssStyle="color:red"></form:errors>
                                    </td>
								</tr>
								<tr>
									<td>投诉信息:</td>
									<td><form:input  path="cominfo" class="form-control"/>
									<form:errors path="cominfo" cssStyle="color:red"></form:errors>
									</td>
								</tr>
								<tr>
									<td>文章地址:</td>
									<td><form:input  path="murl" class="form-control"/>
										<form:errors path="murl" cssStyle="color:red"></form:errors>
									</td>
								</tr>
								<tr>
							
									<td colspan="2"><input type="submit" value="投诉" class="btn btn-info btn-block"></td>
								</tr>
							</table>
						</form:form>


					</div>
				</div>

			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/inc/footer.jsp" />
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
	<link rel="stylesheet"
		href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css" />
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.js"></script>
	<link
		href="//cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css"
		rel="stylesheet">
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/lang/summernote-zh-CN.min.js"></script>

</body>
</html>