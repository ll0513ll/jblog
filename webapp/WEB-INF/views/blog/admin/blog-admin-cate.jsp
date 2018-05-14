<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li class="selected"><a href="${pageContext.request.contextPath }/${authUser.id}/admin/basic">기본설정</a></li>
					<li><a href="${pageContext.request.contextPath }/${authUser.id}/admin/category">카테고리</a></li>
					<li><a href="${pageContext.request.contextPath }/${authUser.id}/admin/write">글작성</a></li>
				</ul>
				
		      	<table class="admin-cat">
		      		<thead>
			      		<tr>
			      			<th>번호</th>
			      			<th>카테고리명</th>
			      			<th>포스트 수</th>
			      			<th>설명</th>
			      			<th>삭제</th>      			
			      		</tr>
		      		</thead>
		      		<tbody id=cateList>
		      			
					</tbody>
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
			      	<table id="admin-cat-add" >
			      		<tr>
			      			<td class="t">카테고리명</td>
			      			<td><input type="text" name="name" value=""></td>
			      		</tr>
			      		<tr>
			      			<td class="t">설명</td>
			      			<td><input type="text" name="desc"></td>
			      		</tr>
			      		<tr>
			      			<td class="s">&nbsp;</td>
			      			<td><input id="btnAddCate" type="submit" value="카테고리 추가"></td>
			      		</tr>      		      		
			      	</table> 
			</div>
		</div>
		
		<c:import url = "/WEB-INF/views/includes/footer.jsp"></c:import>
	</div>
</body>

<script type="text/javascript">
$(document).ready(function(){
	catelist();
});		

 	$("#cateList").on("click",".deleteCategory",function() {
 		
 		var $this = $(this);
 		var cateNo = $this.attr("id")
	
		$.ajax({

			url : "${pageContext.request.contextPath}/${authUser.id}/catedelete",
			type : "get",
			//contentType : "application/json",
			data : {
				cateNo : cateNo,
			},

			dataType : "json",
			success : function(result) {

				if (result != 0) {
					$("[id=deleteNo" + result + "]").remove();
				}else{
					
					alert("삭제할 수 없습니다.");
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		})
	}); 

	$("#btnAddCate").on("click", function() {
		console.log("btnAddCate");

		/* var name = $("[name='name']").val();
		var password = $("[name='password']").val();
		var content = $("[name='content']").val();
		console.log(name);
		console.log(password);
		console.log(content); */

		cateVo = {
				
			cateName : $("input[name='name']").val(),
			description : $("input[name='desc']").val(),

		};

		$.ajax({

			url : "${pageContext.request.contextPath}/${authUser.id}/cateUpload",
			type : "post",
			contentType : "application/json",
			data : JSON.stringify(cateVo),

			dataType : "json",
			success : function(catevo) {
				render(catevo, "up");
				$("[name=name]").val("");
				$("[name=desc]").val("");
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		})
	});
		


  	function catelist() {
		//리스트요청 ajax방식
		$.ajax({

			url : "${pageContext.request.contextPath}/${authUser.id}/catelist",
			type : "get",
			//contentType : "application/json",
			//data : {name: "홍길동"},

			dataType : "json",
			success : function(catelist) {
				//성공시 처리해야될 코드 작성
				//var userVo = ${requestScope.userList}

				for (var i = 0; i < catelist.length; i++) {

					render(catelist[i], "up");
				}

			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		})
	};

	function render(cateVo, updown) {
		var str = "";
		str += "<tr id='deleteNo"+cateVo.cateNo+"'>"
		str += "<td>"+cateVo.cateNo+"</td>"
		str += "<td>"+cateVo.cateName+"</td>"
		str += "<td>"+cateVo.no+"</td>"
		str += "<td>"+cateVo.description+"</td>"
		str += "<td class='deleteCategory' id="+cateVo.cateNo+"><img src='${pageContext.request.contextPath}/assets/images/delete.jpg'></td>"
		str += "</tr>"

		if (updown == "up") {
			$("#cateList").prepend(str);

		} else if (updown == "down") {
			$("#cateList").append(str);

		} else {
			console.log("오류")
		}
	};
</script>


</html>