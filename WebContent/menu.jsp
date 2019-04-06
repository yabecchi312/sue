<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	if (session.getAttribute("loginUserId") == null) {
		response.sendRedirect("login.jsp");
	} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者用メニュー</title>
<link rel="stylesheet" href="common/css/style.css">
</head>
<body>
	<div class="header">
		<span class="big_title">S</span>tart <span class="big_title">U</span>p
		<span class="big_title">E</span>ducation
	</div>
	<div class="menu">
		<div class="main_frame">
			<p>管理者用メニュー画面</p>
		</div>
	</div>

	<div class="main_wrapper">
		<div class="employee_button">

			<a href="GetSectionEmployee" class="regist_button">
				<button class="display_button">従業員登録</button>
			</a> <a href="DisplayEmployeeList">
				<button class="display_button">従業員情報一覧</button>
			</a>
		</div>
		<div class="logout_button">
			<a href="regist_adminuser.jsp">
				<button class="display_button">管理者権限を付与する</button>
			</a>
		</div>
		<div class="link_main_button">
			<form action="LogoutChk" method="post">
				<button class="display_button">ログアウト</button>
			</form>
		</div>
		<div class=link_main_button>
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