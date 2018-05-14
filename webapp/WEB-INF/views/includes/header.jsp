<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<a href="${pageContext.request.contextPath}/"> <img class="logo"
			src="${pageContext.request.contextPath}/assets/images/logo.jpg">
		</a>

	<div class="menu">
		<ul>
			<c:choose>
				<c:when test="${authUser eq null }">
					<li><a
						href=" ${pageContext.request.contextPath }/user/loginForm">로그인</a></li>
					<li><a href="${pageContext.request.contextPath }/user/joinForm">회원가입</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a></li>
					<li><a href="${pageContext.request.contextPath }/${authUser.id}/">내블로그</a></li>
					<li>${authUser.userName}님 안녕하세요♥</li>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>
	<!-- /header -->

</body>
</html>