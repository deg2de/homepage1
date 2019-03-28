function userSearchId() {
	// username check
	var username = document.usersearchid.search_id_username.value;
	var username_check = /^[가-힣]{2,5}/;

	if (username.length == 0) {
		alert("名前を入力してください。");
		document.usersearchid.search_id_username.focus();
		return false;
	}
	if (!username_check.test(username)) {
		alert("名前は韓国語で2~5桁です。");
		document.usersearchid.search_id_username.focus();
		return false;
	}

	// userphone check
	var userphone = document.usersearchid.search_id_userphone.value;
	var userphone_check = /^\d{2,3}-\d{3,4}-\d{4}$/;

	if (userphone.length == 0) {
		alert("携帯番号を入力してください。");
		document.usersearchid.search_id_userphone.focus();
		return false;
	}
	if (!userphone_check.test(userphone)) {
		alert("携帯番号は'-'を含まって書いてください。");
		document.usersearchid.search_id_userphone.focus();
		return false;
	}
	return true;
}

function userSearchPw() {
	// userid check
	var userid = document.usersearchpw.search_pw_userid.value;
	var userid_check = /^[a-z0-9]{4,10}$/;

	if (userid.length == 0) {
		alert("IDを入力してください。");
		document.usersearchpw.search_pw_userid.focus();
		return false;
	}
	if (!userid_check.test(userid)) {
		alert("IDは英語（小文字）、数字で4~10桁です。");
		document.usersearchpw.search_pw_userid.focus();
		return false;
	}

	// userphone check
	var userphone = document.usersearchpw.search_pw_userphone.value;
	var userphone_check = /^\d{2,3}-\d{3,4}-\d{4}$/;

	if (userphone.length == 0) {
		alert("携帯番号を入力してください。");
		document.usersearchpw.search_pw_userphone.focus();
		return false;
	}
	if (!userphone_check.test(userphone)) {
		alert("携帯番号は'-'を含まって書いてください。");
		document.usersearchpw.search_pw_userphone.focus();
		return false;
	}
	return true;
}