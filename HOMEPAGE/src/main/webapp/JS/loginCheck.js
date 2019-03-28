function loginCheck() {
	if(document.frm.userid.value.length == 0) {
		alert("IDを入力してください。");
		document.frm.userid.focus();
		return false;
	}
	if (document.frm.userpw.value == "") {
		alert("PWを入力してください。");
		document.frm.userpw.focus();
		return false;
	}
	return true;
	prom
}