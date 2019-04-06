<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page
	import="model.entity.Employee, java.text.SimpleDateFormat, java.util.Date, java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String employeeCode = (String) session.getAttribute("employeeCode");
	String startWork = (String) session.getAttribute("startWork");
	String finishWork = (String) session.getAttribute("finishWork");
	String startBreak = (String) session.getAttribute("startBreak");
	String finishBreak = (String) session.getAttribute("finishBreak");

	if (employeeCode == null) {
		response.sendRedirect("attendance_login.jsp");
	} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タイムカード</title>
<link rel="stylesheet" href="common/css/style.css">
<script type="text/javascript" src="common/JS/func.js"></script>

</head>
<body>
	<div class="header">
		<span class="big_title">S</span>tart <span class="big_title">U</span>p
		<span class="big_title">E</span>ducation
	</div>
	<div class="menu">
		<div class="main_frame">
			<p>タイムカード</p>
		</div>
	</div>

	<%
		LocalDateTime now = LocalDateTime.now();
	%>

	<div class="display_top">
		<p id="today_area"><%=now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"))%></p>
		<p id="RealtimeClockArea"></p>
	</div>
	<%
		if (startWork == null) {
	%>
	<form action="AttendanceTimeCard" method="POST" class="attendance_form">
		<input type="hidden" name="attendance" value="出勤処理"> <input
			type="submit" name="submit" value="出勤" id="disableStartWorkButton"
			class="attendance_timecard">
	</form>
	<%
		} else {
	%>
	<form action="AttendanceTimeCard" method="POST" class="attendance_form">
		<input type="hidden" name="attendance" value="出勤処理"> <input
			type="submit" name="submit" value="出勤" id="disableStartWorkButton"
			disabled="disabled" class="attendance_timecard2">
	</form>

	<%
		}
			//退勤時間が押せない条件
			if (finishWork != null || startWork == null ||
					startWork != null && startBreak != null && finishBreak == null) {
	%>

	<form action="AttendanceTimeCard" method="POST" class="attendance_form">
		<input type="hidden" name="attendance" value="退勤処理"> <input
			type="submit" name="submit" value="退勤" id="disableFinishWorkButton"
			disabled="disabled" class="attendance_timecard2">
	</form>

	<%
		} else {
	%>

	<form action="AttendanceTimeCard" method="POST" class="attendance_form">
		<input type="hidden" name="attendance" value="退勤処理"> <input
			type="submit" name="submit" value="退勤" id="disableFinishWorkButton"
			class="attendance_timecard">
	</form>

	<%
		}

			if (startBreak == null && finishWork == null && startWork != null) {
	%>

	<form action="AttendanceTimeCard" method="POST" class="attendance_form">
		<input type="hidden" name="attendance" value="休憩開始処理"> <input
			type="submit" name="submit" value="休憩する" id="disableStartBreakButton"
			class="attendance_timecard">
	</form>

	<%
		} else {
	%>

	<form action="AttendanceTimeCard" method="POST" class="attendance_form">
		<input type="hidden" name="attendance" value="休憩開始処理"> <input
			type="submit" name="submit" value="休憩する" id="disableStartBreakButton"
			disabled="disabled" class="attendance_timecard2">
	</form>

	<%
		}

			if (finishBreak == null && finishWork == null && startBreak != null) {
	%>

	<form action="AttendanceTimeCard" method="POST" class="attendance_form">
		<input type="hidden" name="attendance" value="休憩終了処理"> <input
			type="submit" name="submit" value="休憩終了"
			id="disableFinishBreakButton" class="attendance_timecard">
	</form>

	<%
		} else {
	%>

	<form action="AttendanceTimeCard" method="POST" class="attendance_form">
		<input type="hidden" name="attendance" value="休憩終了処理"> <input
			type="submit" name="submit" value="休憩終了"
			id="disableFinishBreakButton" disabled="disabled"
			class="attendance_timecard2">
	</form>

	<%
		}
	%>

	<div class="a_logout_button">
		<a href="attendance_login.jsp">
			<button class="display_button">メニューに戻る</button>
		</a>
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
				<td>start_up_edu@freemail.com</td>
			</tr>
		</table>
	</div>

	<div class="footer_design">
		<footer>
			<small>© 2019 StartUpEducation inc.</small>
		</footer>
	</div>
</body>
</html>
<%
	}
%>