<%@page
	import="model.entity.Employee, java.time.LocalDateTime, java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	LocalDateTime now = LocalDateTime.now();

	int year = now.getYear();
	int month = now.getMonthValue();
	String employeeCode = (String) session.getAttribute("employeeCode");
	if (employeeCode == null) {
		response.sendRedirect("attendance_login.jsp");
	} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>月次報告画面</title>
<link rel="stylesheet" href="common/css/style.css">
</head>
<body>
	<div class="header">
		<span class="big_title">S</span>tart <span class="big_title">U</span>p
		<span class="big_title">E</span>ducation
	</div>
	<div class="menu">
		<div class="main_frame">
			<p>月次報告画面</p>
		</div>
	</div>

	<div class="main_wrapper">
		<div class="main_admin">
			<div>表示させたい年月を選択してください</div>
			<form action="AttendanceSelectTimesheet" method="post">
				<select name="thisMonth" class="margin_r" required>
					<%
						for (int i = month; i > 0; i--) {
								if (i < 10) {
					%>
					<option><%=year%>-0<%=i%></option>

					<%
						} else {
					%>
					<option><%=year%>-<%=i%></option>

					<%
						}
							}
							for (int i = 12; i > month; i--) {
								if (i < 10) {
					%>
					<option><%=year - 1%>-0<%=i%></option>

					<%
						} else {
					%>
					<option><%=year - 1%>-<%=i%></option>

					<%
						}
							}
					%>
				</select> <input type="submit" value="タイムシートを表示する" class="attendance_select_timesheet">
			</form>
		</div>

		<div class="a_logout_button">
			<a href="attendance_login.jsp">
				<button class="display_button">メニューに戻る</button>
			</a>
		</div>
	</div>
	<div class="footer_top">
		<table class="table_format">
			<tr>
				<th>管理者情報</th>
			</tr>
			<tr>
				<td class="cel">会社名</td>
				<td>&nbsp;</td>
				<td>株式会社 Start Up Education</td>
			</tr>
			<tr>
				<td class="cel">Tell</td>
				<td>&nbsp;</td>
				<td>03-3333-3333</td>
			<tr>
				<td class="cel">Email</td>
				<td>&nbsp;</td>
				<td>startup_edu@freemail.com</td>
			</tr>
		</table>
	</div>

	<div class="footer_design">
		<footer>
			<small>© 2019 StartUpEducation.</small>
		</footer>
	</div>
</body>
</html>
<%
	}
%>