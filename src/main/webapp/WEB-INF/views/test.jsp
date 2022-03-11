<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<%
	JSONArray jArr = (JSONArray) request.getAttribute("jArr");
	%>
	<h1 class = "test">test</h1>
	<div class = "parent">
		<div style="cursor: pointer;" onclick="location.href='detail.action?id=${jArr.getJSONObject(0).get("mt20id")}';">

			<h3><%=jArr.getJSONObject(0).get("prfnm")%></h3>
			<img src="<%=jArr.getJSONObject(0).get("poster")%>" />
			<p>
				개봉일 :
				<%=jArr.getJSONObject(0).get("prfpdfrom")%></p>
			<p>
				종료일 :
				<%=jArr.getJSONObject(0).get("prfpdto")%></p>
		</div>
		
		<div style="cursor: pointer;" onclick="location.href='detail.action?id=${jArr.getJSONObject(1).get("mt20id")}';">
			<h3><%=jArr.getJSONObject(1).get("prfnm")%></h3>
			<img src="<%=jArr.getJSONObject(1).get("poster")%>" />
			<p>
				개봉일 :
				<%=jArr.getJSONObject(1).get("prfpdfrom")%></p>
			<p>
				종료일 :
				<%=jArr.getJSONObject(1).get("prfpdto")%></p>
		</div>
		
		<div style="cursor: pointer;" onclick="location.href='detail.action?id=${jArr.getJSONObject(2).get("mt20id")}';"> 
			<h3><%=jArr.getJSONObject(2).get("prfnm")%></h3>
			<img src="<%=jArr.getJSONObject(2).get("poster")%>" />
			<p>
				개봉일 :
				<%=jArr.getJSONObject(2).get("prfpdfrom")%></p>
			<p>
				종료일 :
				<%=jArr.getJSONObject(2).get("prfpdto")%></p>
		</div>
	</div>
</body>
</html>