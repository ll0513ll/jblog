<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
</head>
<body>

	<div id="container">

		<c:import url = "/WEB-INF/views/includes/bheader.jsp"></c:import>
		
		<div id="wrapper">
			<div id="content">
			
				<div class="blog-content">
			<c:choose>
				<c:when test="${empty PostOne}">
					<!-- 등록된 글이 없는경우 -->
					<h4>등록된 글이 없습니다.</h4>
					
				</c:when>
				<c:otherwise>
					<%-- <c:forEach items="${postlist}" var="postVo">
						<h4>${postVo.postTitle}</h4>
						<p>${postVo.postContent}</p>
					</c:forEach> --%>
					<h4>${PostOne.postTitle}</h4>
					<p>${PostOne.postContent}</p>
				</c:otherwise>
			</c:choose>
				</div>
				
				<ul class="blog-list">
				<c:forEach items="${postlist}" var="postVo">
					<li>
						<a href="${pageContext.request.contextPath }/${authUser.id}?postNo=${postVo.postNo}&cateNo=${postVo.cateNo}">${postVo.postTitle}</a> 
						<span>${postVo.regDate}</span>
					</li>
				</c:forEach>	
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/upload/${blogVo.logoFile}">				
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${cateList}" var="cateVo">
					<li><a href="${pageContext.request.contextPath }/${authUser.id}?cateNo=${cateVo.cateNo}">${cateVo.cateName}</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<c:import url = "/WEB-INF/views/includes/footer.jsp"></c:import>
		
	</div>
</body>
</html>