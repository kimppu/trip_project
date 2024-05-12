function confirmDelete(noticeId) {
    if (confirm("정말로 삭제하시겠습니까?")) {
        document.getElementById("noticeTask").action = "/admin/notice/"+noticeId+"/delete";
        document.getElementById("noticeTask").submit();
    }
}
