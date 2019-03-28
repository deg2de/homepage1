function userUpdate() {

	// userpw check
	var userpw = document.userupdate.userpw.value;
	var userpw_check = /^[a-zA-Z0-9!@#$%^&*()?_~]{6,10}$/;

	if (userpw.length == 0) {
		alert("PWを入力してください。");
		document.userupdate.userpw.focus();
		return false;
	}
	if (!userpw_check.test(userpw)) {
		alert("PWは英語、数字、記号で6~10桁です。");
		document.userupdate.userpw.focus();
		return false;
	}

	// userpw2 check
	var userpw2 = document.userupdate.userpw2.value;

	if (userpw2.length = 0) {
		alert("PW checkを入力してください。");
		document.userupdate.userpw2.focus();
		return false;
	}
	if (userpw != userpw2) {
		alert("PW確認が一致しないです。");
		document.userupdate.userpw2.focus();
		return false;
	}

	// username check
	var username = document.userupdate.username.value;
	var username_check = /^[가-힣]{2,5}/;

	if (username.length == 0) {
		alert("名前を入力してください。");
		document.userupdate.username.focus();
		return false;
	}
	if (!username_check.test(username)) {
		alert("名前は韓国語で2~5桁です。");
		document.userupdate.username.focus();
		return false;
	}

	// useremail check
	var useremail = document.userupdate.useremail.value;
	var useremail_check = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;

	if (useremail.length == 0) {
		alert("メールを入力してください。");
		document.userupdate.useremail.focus();
		return false;
	}
	if (useremail.length > 20) {
		alert("メールは20byte以下で入力してください。");
		document.userupdate.useremail.focus();
		return false;
	}
	if (!useremail_check.test(useremail)) {
		alert("メールの形式が合わないです。");
		document.userupdate.useremail.focus();
		return false;
	}

	return true;
}