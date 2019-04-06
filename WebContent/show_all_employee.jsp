<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, model.entity.ViewListDisplay"%>

<%
	if (session.getAttribute("loginUserId") == null) {
		response.sendRedirect("login.jsp");
	} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員一覧</title>
<link rel="stylesheet" href="common/css/style.css">
<script type="text/javascript" src="common/JS/func.js"></script>

</head>
<body>
	<%
		List<ViewListDisplay> vldlist = (List<ViewListDisplay>) session.getAttribute("vldlist");
			if (vldlist != null) {
	%>
	<div class="header">
		<span class="big_title">S</span>tart <span class="big_title">U</span>p
		<span class="big_title">E</span>ducation
	</div>
	<div class="menu">
		<div class="main_frame">
			<p>従業員一覧</p>
		</div>
	</div>
	<div class="main_wrapper">
		<form action="CheckEditDelete" method="post"
			onsubmit="return chkShowAll(this.name)">
			<div class="show_all_table">
				<table class="border_table">
					<tr class="top_table">
						<td></td>
						<td>従業員コード</td>
						<td>氏名</td>
						<td>氏名かな</td>
						<td>性別</td>
						<td>生年月日</td>
						<td>所属部署</td>
						<td>入社日</td>
					</tr>

					<%
						for (ViewListDisplay vld : vldlist) {
					%>
					<tr class="main_table">
						<td><input type="radio" name="employeeCode"
							value="<%=vld.getEmployeeCode()%>"></td>
						<td><%=vld.getEmployeeCode()%></td>
						<td><%=vld.getEmployeeName()%></td>
						<td><%=vld.getEmployeeKanaName()%></td>
						<td><%=vld.getGender()%></td>
						<td><%=vld.getBirthDay()%></td>
						<td><%=vld.getSectionName()%></td>
						<td><%=vld.getHireDate()%></td>
					</tr>

					<%
						}
							} else {
								response.sendRedirect("DisplayEmployeeList");
							}
					%>
				</table>
			</div>

			<div class="comment_show_all" id="comment_show_all">編集・削除したい従業員にチェックを入れてください</div>
			<div class="employee_button">
				<input type="submit" class="edit_button" name="submit"
					value="従業員を編集する" onclick="setValue('edit_submit')"> <input
					type="submit" name="submit" value="従業員を削除する"
					onclick="setValue('delete_submit')"> <input type="hidden"
					name="chkBtn">
			</div>
		</form>
		<div class="link_main_button">
			<a href="menu.jsp">
				<button class="display_button">メニュー画面に戻る</button>
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