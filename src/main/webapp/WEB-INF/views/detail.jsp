<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	JSONObject info = (JSONObject) request.getAttribute("info");
	%>
	<h3 style="text-align: center;"><%=info.get("prfnm")%></h3>
	<div style="text-align: center;">
		<table border="1" width="1000" style="margin: auto">
			<tr>
				<td rowspan="9"><img src="<%=info.get("poster")%>" /></td>
				<th>제목</th>
				<td><%=info.get("prfnm")%></td>
			</tr>
			<tr>
				<th>출연진</th>
				<td><%=info.get("prfcast")%></td>
			</tr>
			<tr>
				<th>Running Time</th>
				<td><%=info.get("prfruntime")%></td>
			</tr>
			<tr>
				<th>공연 시작</th>
				<td><%=info.get("prfpdfrom")%></td>
			</tr>
			<tr>
				<th>공연 종료</th>
				<td><%=info.get("prfpdto")%></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><%=info.get("pcseguidance")%></td>
			</tr>

			<tr>
				<th>공연 시간</th>
				<td><%=info.get("dtguidance")%></td>
			</tr>
			<tr>
				<th>관람연령</th>
				<td><%=info.get("prfage")%></td>
			</tr>
			<tr>
				<th>상태</th>
				<td><%=info.get("prfstate")%></td>
			</tr>
		</table>
		<br />
		<%
		JSONObject arr1 = info.getJSONObject("styurls");
		if (arr1.get("styurl") instanceof JSONArray) {
			JSONArray arr2 = arr1.getJSONArray("styurl");
			for (int i = 0; i < arr2.length(); i++) {
		%>
		<img src="<%=arr2.get(i)%>" />
		<br />
		<%
			}

		} else {
		%>
		<img src="<%=arr1.get("styurl")%>" />
		<%
		}
		%>

	</div>
</body>
</html>