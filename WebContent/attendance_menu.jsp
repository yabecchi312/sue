<%@page import="model.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String employeeCode = (String) session.getAttribute("employeeCode");
	if (employeeCode == null) {
		response.sendRedirect("attendance_login.jsp");
	} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員用メニュー画面</title>
<link rel="stylesheet" href="common/css/style.css">
</head>
<body>
	<div class="header">
		<span class="big_title">S</span>tart <span class="big_title">U</span>p
		<span class="big_title">E</span>ducation
	</div>
	<div class="menu">
		<div class="main_frame">
			<p>従業員用メニュー画面</p>
		</div>
	</div>
	<div class="main_wrapper">
		<div class="employee_button">
			<a href="AttendanceViewTimecard" class="regist_button">
				<button class="a_display_button">打刻する</button>
			</a> <a href="attendance_select_timesheet.jsp" class="regist_button">
				<button class="a_display_button">月次報告する</button>
			</a>
		</div>

		<div class="logout_button">
			<form action="AttendanceLogoutChk" method="post">
				<input type="submit" class="a_display_button" value="ログアウト">
			</form>
		</div>
		<div class="display_top">
			<input type="button" class="display_button"
				onclick="location.href='SendIndex'" value="Topページ">
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