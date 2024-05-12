// 아이디 비밀번호 입력 안 한 경우
function loginCheck() {
    let loginForm = document.loginForm
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    if (username == "") {
        alert("아이디를 입력해주세요.");
    } else if (password == "") {
        alert("비밀번호를 입력해주세요.")
    } else {
        loginForm.submit();
    }
}
function open_pop(flag) {
    $('#myModal').show();
};
//팝업 Close 기능
function close_pop(flag) {
    $('#myModal').hide();
};