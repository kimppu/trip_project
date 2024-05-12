function autoHypenPhone(str){
    str = str.replace(/[^0-9]/g, '');
    var tmp = '';
    if( str.length < 4){
        return str;
    }else if(str.length < 7){
        tmp += str.substr(0, 3);
        tmp += '-';
        tmp += str.substr(3);
        return tmp;
    }else if(str.length < 11){
        tmp += str.substr(0, 3);
        tmp += '-';
        tmp += str.substr(3, 3);
        tmp += '-';
        tmp += str.substr(6);
        return tmp;
    }else{              
        tmp += str.substr(0, 3);
        tmp += '-';
        tmp += str.substr(3, 4);
        tmp += '-';
        tmp += str.substr(7);
        return tmp;
    }
    return str;
}

document.addEventListener("DOMContentLoaded", function() {
var cellPhone = document.getElementById('userPhNmb');
if (cellPhone) {
    cellPhone.onkeyup = function(event) {
        event = event || window.event;
        var _val = this.value.trim();
        this.value = autoHypenPhone(_val);
    }
}
});

// $(function(result){		
//     if($("#joinForm").submit(function(result){
//         var id = $("#userId").val();
//         if (id.match(/\s/g) || id.length == 0) {
//             alert("공백은 ID로 사용할 수 없습니다.");
//             $("#userId").val("").focus();
//             return false;
//         } else if ($("#userPw").val() !== $("#userPw2").val()){
//             alert("PW가 서로 다릅니다.");
//             $("#userPw").val("").focus();
//             $("#userPw2").val("");
//             return false;
//         } else if($.trim($("#userPw").val()) !== $("#userPw").val()){
//             alert("공백은 PW로 사용할 수 없습니다.");
//             $("#userPw").val("").focus();
//             $("#userPw2").val("");
//             return false;
//         } else if ($("#userPw").val().length <= 4) {
//             alert("PW가 4자리 이하입니다.");
//             $("#userPw").val("").focus();
//             $("#userPw2").val("");
//             return false;
//         } else if (!!($("#userPhNmb").val().match(/^01(?:0|1|[6-9])-?\\d{3,4}-?\\d{4}$/))) {
//             alert("올바른 전화번호 형식이 아닙니다.");
//             $("#userPhNmb").val("").focus();
//             return false;
//         }
//     }));
// })

// $(document).ready(function() {
//     $("#userPw2").on("focusout", function() {
//     if($("#userPw").val() !== $("#userPw2").val()) {
//         $("#label2").css("color", "red").text("PW가 서로 다릅니다.");
//         return false;
//     } else if ($("#userPw").val().match(/\s/g)) {
//         $("#label2").css("color", "red").text("공백은 PW로 사용할 수 없습니다.");
//         return false;
//     } else if ($("#userPw").val().length <= 4) {
//         $("#label2").css("color", "red").text("PW가 4자리 이하입니다.");
//         return false;
//     } else if($("#userPw").val() == $("#userPw2").val()) {
//         $("#label2").css("color", "black").text("사용 가능한 PW 입니다.");
//         return true;
//     }
// })})

// $(document).ready(function() {
//     //ID 중복 확인
//     //id를 입력할 수 있는 input text 영역을 벗어나면 동작한다.
//     $("#userId").on("focusout", function() {
        
//         var id = $("#userId").val();
        
//         if(id.match(/\s/g) || id.length == 0) {
//             $("#label1").css("color", "red").text("공백은 ID로 사용할 수 없습니다.");
//             return false;
//             }

//         //Ajax로 전송
//         $.ajax({
//             url : '/auth/confirm-id',
//             data : {
//                 id : id
//             },
//             type : 'POST',
//             dataType : 'json',
//             success : function(result) {
//                 if (result == true) {
//                     $("#label1").css("color", "black").text("사용 가능한 ID 입니다.");
//                 } else {
//                     $("#label1").css("color", "red").text("사용 불가능한 ID 입니다.");
//                     $("#userId").focus();
//                 }
//             }
//         }); //End Ajax
//     });
// })

// $(document).ready(function() {
//     // Email 중복 확인
//     $("#userEmail").on("focusout", function() {
        
//         var email = $("#userEmail").val();

//         if(!email.match(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/)) {
//             $("#label3").css("color", "red").text("올바른 Email 형식이 아닙니다.");
//             return false;
//             }

//         //Ajax로 전송
//         $.ajax({
//             url : '/auth/confirm-email',
//             data : {
//                 email : email
//             },
//             type : 'POST',
//             dataType : 'json',
//             success : function(result) {
//                 if (result == true) {
//                     $("#label3").css("color", "black").text("사용 가능한 Email 입니다.");
//                 } else {
//                     $("#label3").css("color", "red").text("사용 불가능한 Email 입니다.");
//                 }
//             }
//         }); //End Ajax
//     });
// })