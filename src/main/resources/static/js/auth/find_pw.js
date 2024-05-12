$(function(result){		
    if($("#joinForm").submit(function(result){
        if ($("#userPw").val() !== $("#userPw2").val()){
            alert("PW가 서로 다릅니다.");
            $("#userPw").val("").focus();
            $("#userPw2").val("");
            return false;
        } else if($.trim($("#userPw").val()) !== $("#userPw").val()){
            alert("공백은 PW로 사용할 수 없습니다.");
            $("#userPw").val("").focus();
            $("#userPw2").val("");
            return false;
        } else if ($("#userPw").val().length <= 4) {
            alert("PW가 4자리 이하입니다.");
            $("#userPw").val("").focus();
            $("#userPw2").val("");
            return false;
        }
    }));
})