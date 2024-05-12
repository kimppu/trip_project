$(function(){		
    if($("#pwForm").submit(function(){

/*			if($("#userPw").val() !== $("#old_pw").val()){
            alert("기존 비밀번호가 다릅니다.");
            $("#userPw").val("").focus();
            $("#old_pw").val("");
            return false;
        }			
*/

        if($("#userPw").val() !== $("#userPw2").val()){
            alert("비밀번호가 다릅니다.");
            $("#userPw").val("").focus();
            $("#userPw2").val("");
            return false;
/*			}else if ($("#pw").val().length < 8) {
            alert("비밀번호는 8자 이상으로 설정해야 합니다.");
            $("#pw").val("").focus();
            return false; 
*/
        }else if($.trim($("#userPw").val()) !== $("#userPw").val()){
            alert("공백은 입력이 불가능합니다.");
            return false;
        }
    }));
});

function open_pop(flag) {
    $('#myModal').show();
};
//팝업 Close 기능
function close_pop(flag) {
    $('#myModal').hide();
};