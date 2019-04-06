<%@page
	import="model.entity.Employee, model.entity.Section, java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	if (session.getAttribute("loginUserId") == null) {
		response.sendRedirect("login.jsp");
	} else {

		List<Section> sections = (List<Section>) session.getAttribute("sections");
		if (sections != null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員登録</title>
<link rel="stylesheet" href="common/css/style.css">
<script type="text/javascript" src="common/JS/func.js"></script>
</head>
<body>
	<div class="header">
		<span class="big_title">S</span>tart <span class="big_title">U</span>p
		<span class="big_title">E</span>ducation
	</div>
	<div class="main_wrapper">


		<div class="menu">
			<div class="main_frame">
				<p>従業員登録</p>
			</div>
		</div>

		<form action="RegistEmployee" method="post" onsubmit="return chk()">
			<div class="comment_show_all" id="comment_show_all">
				文字の入力、もしくは氏・名は16文字以下、<br>氏かな・名かなは24文字以下で入力してください
			</div>
			<div class="comment_error" id="comment_error">{&lt;&gt;&amp;.,/}の入力はできません</div>
			<div class="regist_table">
				<table>
					<tr>
						<td>氏</td>
						<td>：</td>
						<td><input type="text" name="lastName" id="last_name">
						</td>
					</tr>
					<tr>
						<td>名</td>
						<td>：</td>
						<td><input type="text" name="firstName" id="first_name"></td>
					</tr>
					<tr>
						<td>氏かな</td>
						<td>：</td>
						<td><input type="text" name="lastKanaName"
							id="last_kana_name"></td>
					</tr>
					<tr>
						<td>名かな</td>
						<td>：</td>
						<td><input type="text" name="firstKanaName"
							id="first_kana_name"></td>
					</tr>
					<tr>
						<td>性別</td>
						<td>：</td>
						<td><input type="radio" name="gender" value="0"
							checked="checked">男性 <input type="radio" name="gender"
							value="1">女性</td>
					</tr>
					<tr>
						<td>部署名</td>
						<td>：</td>
						<td><select name="sectionCode">
								<%
									for (Section s : sections) {
								%>
								<option value="<%=s.getSectionCode()%>"><%=s.getSectionName()%></option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td>生年月日</td>
						<td>：</td>
						<td><input type="date" name="birthDay" id="birth_day"
							required></td>
						<td><div id="comment_date">本日より前の日付を入力してください</div></td>
					</tr>
					<tr>
						<td>入社日</td>
						<td>：</td>
						<td><input type="date" name="hireDate" id="hire_date"
							required></td>
					</tr>
					<tr>
						<td>パスワード</td>
						<td>：</td>
						<td><input type="password" name="password" id="password"></td>
						<td><div id="comment_password">半角英数8文字以上32文字以下で入力してください</div></td>
					</tr>
					<tr>
						<td>もう一度</td>
						<td>：</td>
						<td><input type="password" name="confirmation"
							id="confirmation"></td>
						<td>
							<div id="comment_confirmation">パスワードと違います</div>
						</td>
					</tr>
				</table>

				<div class="tomenu_button">
					<div class="admin_user_button">
						<input type="submit" class="admin_user_submit" value="登録する">

						<a href="menu.jsp"> <input type="button" class="clear_button"
							value="キャンセル">
						</a>
					</div>
				</div>
			</div>
		</form>

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
	} else {
			response.sendRedirect("GetSectionEmployee");
		}
	}
%>