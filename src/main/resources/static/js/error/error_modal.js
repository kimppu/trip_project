$(document).ready(function(){
    function showErrorModal(errorMessage) {
    $('#errorMessage').text(errorMessage); // 에러 메시지 설정
    $('#errorModal').modal('show'); // 모달 창 열기
}
    $("#contact_form").submit(function(event){
        event.preventDefault();

        let formData = {
                userNm: $('#contact_form_name').val(),
                userEmail: $('#contact_form_email').val()
        };

        $.ajax({
                type: 'POST',
                url: '/auth/find-id', // 실제 요청을 보낼 엔드포인트
                data: formData,
                dataType: 'json',
                encode: true,
                success: function (response) {
                    console.log("success");
                    // if(!response.ok){
                    //     console.log("error : "+formData);
                    //     var errorMessage = xhr.responseJSON.message; // 서버에서 전달된 한글 에러 메시지 가져오기
                    //     showErrorModal(errorMessage); // 에러 메시지 모달로 출력
                    // }else{
                    //     console.log("success : " + response);
                    // }
                    // console.log("success : " + response);
                    // window.location = response;
                }
                ,
                error: function (xhr, status, error) {
                    
                    if(xhr.responseJSON.message != undefined){
                        showErrorModal(xhr.responseJSON.message);
                    }
                }
        });
});
});