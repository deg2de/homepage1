function userLoginCheck() {
	// userpw check
	var userpw = document.userupdatecheck.userupdatecheck_userpw.value;
	var userpw_check = /^[a-zA-Z0-9!@#$%^&*()?_~]{6,10}$/;

	if (userpw.length == 0) {
		alert("PWを入力してください。");
		document.userupdatecheck.userupdatecheck_userpw.focus();
		return false;
	}
	if (!userpw_check.test(userpw)) {
		alert("PWは英語、数字、記号で6~10桁です。");
		document.userupdatecheck.userupdatecheck_userpw.focus();
		return false;
	}
}