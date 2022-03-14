<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/style.css"
	rel="stylesheet" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<%
	JSONArray jArr = (JSONArray) request.getAttribute("jArr");
	%>
	<h1 class="test">test</h1>
	<h2>
		공연 갯수 :
		<%=jArr.length()%></h2>


	<div class="container">
	<% for(int i =0; i<3; i++){ %>
		<div class="row" style="margin-bottom :10px;">
			<% for(int j=0; j<3; j++){ %>
			<div class="col">
				<div style="cursor: pointer;  border: 1px solid black; text-align: center;"
				>

				<h3><%=jArr.getJSONObject(3*i+j).get("prfnm")%></h3>
				<a href="showDetail?id=<%=jArr.getJSONObject(3*i+j).get("mt20id")%>"><img src="<%=jArr.getJSONObject(3*i+j).get("poster")%>" width = "300" height ="400"/></a>
				<p><%=jArr.getJSONObject(3*i+j).get("mt20id") %></p>
				<p>
					개봉일 :
					<%=jArr.getJSONObject(3*i+j).get("prfpdfrom")%></p>
				<p>
					종료일 :
					<%=jArr.getJSONObject(3*i+j).get("prfpdto")%></p>
				</div>
			</div>
			<%} %>
		</div>
		<%} %>
	</div>
	
	<div style ="text-align:center">1 2 3 4 5 6 7 8 9 10</div>
	
</body>
</html>