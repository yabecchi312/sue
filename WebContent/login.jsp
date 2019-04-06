<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("loginUserId") != null) {
		response.sendRedirect("menu.jsp");
	} else {
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者用ログイン</title>
<link rel="stylesheet" href="common/css/style.css">
</head>
<body>
	<div class="header">
		<span class="big_title">S</span>tart <span class="big_title">U</span>p
		<span class="big_title">E</span>ducation
	</div>
	<div class="menu">
		<div class="main_frame">
			<p>管理者用ログイン画面</p>
		</div>
	</div>
	<div class="main_wrapper">
		<form action="LoginChk" method="post">
			<div class="regist_table">
				<table>
					<tr>
						<td>ユーザID</td>
						<td>：</td>
						<td><input type="text" name="userId"></td>
					</tr>
					<tr>
						<td>パスワード</td>
						<td>：</td>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
			</div>

			<div class="admin_user_button">
				<input type="submit" class="login_button" value="ログイン"> <input
					type="reset" class="clear_button">
			</div>
		</form>
	</div>
	<div class="admin_user_button">
		<input type="button" class="display_button"
			onclick="location.href='SendIndex'" value="Topページ">
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
