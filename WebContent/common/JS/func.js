function chk() {
	var flg = true;

	var last_name = document.getElementById("last_name");
	var first_name = document.getElementById("first_name");
	var last_kana_name = document.getElementById("last_kana_name");
	var first_kana_name = document.getElementById("first_kana_name");
	var birth_day = document.getElementById("birth_day");
	var hire_day = document.getElementById("hire_day");

	var password = document.getElementById("password");
	var confirmation = document.getElementById("confirmation");

	var p_flg = /^[0-9a-zA-Z]+$/.test(password.value);

	if (password.value !== confirmation.value) {
		flg = false;
		confirmation.focus();
		confirmation.style.backgroundColor = "#FF9999";
		comment_confirmation.style.display = 'block';

	} else {
		confirmation.style.backgroundColor = "#ffffff";
		comment_confirmation.style.display = 'none';

	}

	var comment_password = document.getElementById("comment_password");

	if (password.value.length < 8 || password.value.length > 32) {

		flg = false;
		password.focus();
		password.style.backgroundColor = "#FF9999";
		comment_password.style.display = 'block';

	} else {

		if (p_flg) {
			password.style.backgroundColor = "#ffffff";
			comment_password.style.display = 'none';

		} else {
			flg = false;

			comment_password.style.display = 'block';
			user_id.style.backgroundColor = "#FF9999";
		}

	}

	var dt = new Date();
	var y = dt.getFullYear();
	var m = ("00" + (dt.getMonth() + 1)).slice(-2);
	var d = ("00" + dt.getDate()).slice(-2);
	var result = y + "-" + m + "-" + d;
	var comment_date = document.getElementById("comment_date");

	if (birth_day.value > result) {
		flg = false;
		birth_day.focus();
		birth_day.style.backgroundColor = "#FF9999";
		comment_date.style.display = 'block';

	} else {
		birth_day.style.backgroundColor = "#ffffff";
		comment_date.style.display = 'none';

	}

	var fk_flg = /^(?=.*[{}<>.,/&]).*$/.test(first_kana_name.value);

	if (first_kana_name.value.length < 1 || first_kana_name.value.length > 24) {

		flg = false;
		first_kana_name.focus();
		first_kana_name.style.backgroundColor = "#FF9999";
		var comment = document.getElementById("comment_show_all");
		comment.style.display = 'block';

	} else {

		if (fk_flg) {
			flg = false;
			first_kana_name.focus();
			first_kana_name.style.backgroundColor = "#FF9999";
			var comment_error = document.getElementById("comment_error");
			comment_error.style.display = 'block';

		} else {
			first_kana_name.style.backgroundColor = "#ffffff";

		}

	}

	var lk_flg = /^(?=.*[{}<>.,/&]).*$/.test(last_kana_name.value);

	if (last_kana_name.value.length < 1 || last_kana_name.value.length > 24) {
		flg = false;
		last_kana_name.focus();
		last_kana_name.style.backgroundColor = "#FF9999";
		var comment = document.getElementById("comment_show_all");
		comment.style.display = 'block';

	} else {

		if (lk_flg) {
			flg = false;
			last_kana_name.focus();
			last_kana_name.style.backgroundColor = "#FF9999";
			var comment_error = document.getElementById("comment_error");
			comment_error.style.display = 'block';

		} else {
			last_kana_name.style.backgroundColor = "#ffffff";

		}

	}

	var f_flg = /^(?=.*[{}<>.,/&]).*$/.test(first_name.value);

	if (first_name.value.length < 1 || first_name.value.length > 16) {
		flg = false;
		first_name.focus();
		first_name.style.backgroundColor = "#FF9999";
		var comment = document.getElementById("comment_show_all");
		comment.style.display = 'block';

	} else {

		if (f_flg) {
			flg = false;
			first_name.focus();
			first_name.style.backgroundColor = "#FF9999";
			var comment_error = document.getElementById("comment_error");
			comment_error.style.display = 'block';

		} else {
			first_name.style.backgroundColor = "#ffffff";

		}

	}

	var l_flg = /^(?=.*[{}<>.,/&]).*$/.test(last_name.value);

	if (last_name.value.length < 1 || last_name.value.length > 16) {
		flg = false;
		last_name.focus();
		last_name.style.backgroundColor = "#FF9999";

		var comment = document.getElementById("comment_show_all");
		comment.style.display = 'block';

	} else {

		if (l_flg) {
			flg = false;
			last_name.focus();
			last_name.style.backgroundColor = "#FF9999";
			var comment_error = document.getElementById("comment_error");
			comment_error.style.display = 'block';

		} else {
			last_name.style.backgroundColor = "	#ffffff";

		}

	}

	return flg;
}

function chkEdit() {
	var flg = true;

	var last_name = document.getElementById("last_name");
	var first_name = document.getElementById("first_name");
	var last_kana_name = document.getElementById("last_kana_name");
	var first_kana_name = document.getElementById("first_kana_name");
	var birth_day = document.getElementById("birth_day");
	var hire_day = document.getElementById("hire_day");

	var dt = new Date();
	var y = dt.getFullYear();
	var m = ("00" + (dt.getMonth() + 1)).slice(-2);
	var d = ("00" + dt.getDate()).slice(-2);
	var result = y + "-" + m + "-" + d;
	var comment_date = document.getElementById("comment_date");

	if (birth_day.value > result) {
		flg = false;
		birth_day.focus();
		birth_day.style.backgroundColor = "#FF9999";
		comment_date.style.display = 'block';

	} else {
		birth_day.style.backgroundColor = "#ffffff";
		comment_date.style.display = 'none';

	}

	var fk_flg = /^(?=.*[{}<>.,/&]).*$/.test(first_kana_name.value);

	if (first_kana_name.value.length < 1 || first_kana_name.value.length > 24) {

		flg = false;
		first_kana_name.focus();
		first_kana_name.style.backgroundColor = "#FF9999";
		var comment = document.getElementById("comment_show_all");
		comment.style.display = 'block';

	} else {

		if (fk_flg) {
			flg = false;
			first_kana_name.focus();
			first_kana_name.style.backgroundColor = "#FF9999";
			var comment_error = document.getElementById("comment_error");
			comment_error.style.display = 'block';

		} else {
			first_kana_name.style.backgroundColor = "#ffffff";

		}

	}

	var lk_flg = /^(?=.*[{}<>.,/&]).*$/.test(last_kana_name.value);

	if (last_kana_name.value.length < 1 || last_kana_name.value.length > 24) {
		flg = false;
		last_kana_name.focus();
		last_kana_name.style.backgroundColor = "#FF9999";
		var comment = document.getElementById("comment_show_all");
		comment.style.display = 'block';

	} else {

		if (lk_flg) {
			flg = false;
			last_kana_name.focus();
			last_kana_name.style.backgroundColor = "#FF9999";
			var comment_error = document.getElementById("comment_error");
			comment_error.style.display = 'block';

		} else {
			last_kana_name.style.backgroundColor = "#ffffff";

		}

	}

	var f_flg = /^(?=.*[{}<>.,/&]).*$/.test(first_name.value);

	if (first_name.value.length < 1 || first_name.value.length > 16) {
		flg = false;
		first_name.focus();
		first_name.style.backgroundColor = "#FF9999";
		var comment = document.getElementById("comment_show_all");
		comment.style.display = 'block';

	} else {

		if (f_flg) {
			flg = false;
			first_name.focus();
			first_name.style.backgroundColor = "#FF9999";
			var comment_error = document.getElementById("comment_error");
			comment_error.style.display = 'block';

		} else {
			first_name.style.backgroundColor = "#ffffff";

		}

	}

	var l_flg = /^(?=.*[{}<>.,/&]).*$/.test(last_name.value);

	if (last_name.value.length < 1 || last_name.value.length > 16) {
		flg = false;
		last_name.focus();
		last_name.style.backgroundColor = "#FF9999";

		var comment = document.getElementById("comment_show_all");
		comment.style.display = 'block';

	} else {

		if (l_flg) {
			flg = false;
			last_name.focus();
			last_name.style.backgroundColor = "#FF9999";
			var comment_error = document.getElementById("comment_error");
			comment_error.style.display = 'block';

		} else {
			last_name.style.backgroundColor = "	#ffffff";

		}

	}

	return flg;
}

function chkUser() {
	var flg = true;

	var user_id = document.getElementById("user_id");
	var password = document.getElementById("password");
	var confirmation = document.getElementById("confirmation");

	var u_flg = /^[0-9a-zA-Z]+$/.test(user_id.value);
	var p_flg = /^[0-9a-zA-Z]+$/.test(password.value);

	var comment_confirmation = document.getElementById("comment_confirmation");

	if (password.value !== confirmation.value) {

		flg = false;
		confirmation.focus();
		confirmation.style.backgroundColor = "#FF9999";
		comment_confirmation.style.display = 'block';

	} else {
		confirmation.style.backgroundColor = "#ffffff";
		comment_confirmation.style.display = 'none';

	}

	var comment_password = document.getElementById("comment_password");

	if (password.value.length < 8 || password.value.length > 32) {

		flg = false;
		password.focus();
		password.style.backgroundColor = "#FF9999";
		comment_password.style.display = 'block';

	} else {

		if (p_flg) {
			password.style.backgroundColor = "#ffffff";
			comment_password.style.display = 'none';

		} else {
			flg = false;

			comment_password.style.display = 'block';
			user_id.style.backgroundColor = "#FF9999";
		}

	}

	var comment_user_id = document.getElementById("comment_user_id");

	if (user_id.value.length < 4 || user_id.value.length > 24) {
		flg = false;
		user_id.focus();
		user_id.style.backgroundColor = "#FF9999";
		comment_user_id.style.display = 'block';

	} else {

		if (u_flg) {
			user_id.style.backgroundColor = "#ffffff";
			comment_user_id.style.display = 'none';

		} else {
			flg = false;

			comment_user_id.style.display = 'block';
			user_id.style.backgroundColor = "#FF9999";
		}

	}

	return flg;
}

function chkShowAll(btn) {
	var flg = false;
	var employeeCode = document.getElementsByName("employeeCode");

	for (var i = 0; i < employeeCode.length; i++) {
		if (employeeCode[i].checked) {
			flg = true;

			if (document.getElementsByName("chkBtn")[0].value == "delete_submit") {
				var res = confirm("本当に削除しますか？");

				flg = res;
			}

		}
	}

	if (!flg) {
		var comment_show_all = document.getElementById("comment_show_all");
		comment_show_all.style.display = 'block';
	}

	return flg;
}

function setValue(btn) {
	document.getElementsByName("chkBtn")[0].value = btn;
}

function setTime(num) {
	// 桁数が1桁だったら先頭に0を加えて2桁に調整する
	var ret;
	if (num < 10) {
		ret = "0" + num;
	} else {
		ret = num;
	}
	return ret;
}
function showClock() {
	var nowTime = new Date();
	var nowHour = setTime(nowTime.getHours());
	var nowMin = setTime(nowTime.getMinutes());
	var nowSec = setTime(nowTime.getSeconds());
	var msg = nowHour + ":" + nowMin + ":" + nowSec;
	document.getElementById("RealtimeClockArea").innerHTML = msg;
}
setInterval('showClock()', 1000);