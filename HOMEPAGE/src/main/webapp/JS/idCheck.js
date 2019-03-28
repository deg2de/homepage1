function createId() {
	// userid check
	var userid = document.usercreate.userid.value;
	var userid_check = /^[a-z0-9]{4,10}$/;

	if (userid.length == 0) {
		alert("IDを入力してください。");
		document.usercreate.userid.focus();
		return false;
	}
	if (!userid_check.test(userid)) {
		alert("IDは英語（小文字）、数字で4~10桁です。");
		document.usercreate.userid.focus();
		return false;
	}

	// userpw check
	var userpw = document.usercreate.userpw.value;
	var userpw_check = /^[a-zA-Z0-9!@#$%^&*()?_~]{6,10}$/;

	if (userpw.length == 0) {
		alert("PWを入力してください。");
		document.usercreate.userpw.focus();
		return false;
	}
	if (!userpw_check.test(userpw)) {
		alert("PWは英語、数字、記号で6~10桁です。");
		document.usercreate.userpw.focus();
		return false;
	}

	// userpw2 check
	var userpw2 = document.usercreate.userpw2.value;

	if (userpw2.length = 0) {
		alert("PW checkを入力してください。");
		document.usercreate.userpw2.focus();
		return false;
	}
	if (userpw != userpw2) {
		alert("PW確認が一致しないです。");
		document.usercreate.userpw2.focus();
		return false;
	}

	// username check
	var username = document.usercreate.username.value;
	var username_check = /^[가-힣]{2,5}/;

	if (username.length == 0) {
		alert("名前を入力してください。");
		document.usercreate.username.focus();
		return false;
	}
	if (!username_check.test(username)) {
		alert("名前は韓国語で2~5桁です。");
		document.usercreate.username.focus();
		return false;
	}

	// useremail check
	var useremail = document.usercreate.useremail.value;
	var useremail_check = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;

	if (useremail.length == 0) {
		alert("メールを入力してください。");
		document.usercreate.useremail.focus();
		return false;
	}
	if (useremail.length > 20) {
		alert("メールは20byte以下で入力してください。");
		document.usercreate.useremail.focus();
		return false;
	}
	if (!useremail_check.test(useremail)) {
		alert("メールの形式が合わないです。");
		document.usercreate.useremail.focus();
		return false;
	}

	// userphone check
	var userphone = document.usercreate.userphone.value;
	var userphone_check = /^\d{2,3}-\d{3,4}-\d{4}$/;

	if (userphone.length == 0) {
		alert("携帯番号を入力してください。");
		document.usercreate.userphone.focus();
		return false;
	}
	if (!userphone_check.test(userphone)) {
		alert("携帯番号は'-'を含まって書いてください。");
		document.usercreate.userphone.focus();
		return false;
	}
	return true;

}