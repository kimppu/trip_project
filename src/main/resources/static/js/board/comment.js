const header = {
    method: "POST",
    headers: {
        "Content-Type": "application/json",
    }
}
const main = {

    init: function () {
        const _this = this;


        $('#commentSaveBtn').on('click', function () {
            _this.commentSave();
        });
    },
    commentSave: function () {
        let data = {
            userId: $("#submitUserId").val(),
            noticeId: parseInt($("#submitNoticeId").val()),
            contents: $("#submitCommentContents").val()
        }

        let headers = { ...header };
        headers['body'] = JSON.stringify(data);

        fetch("/user/comment/save", headers).then((response) => window.location.reload());
    },

    commentUpdate: function (tag) {
        let form = $(tag).closest('.comments_panel').find('form');
        let data = {
            commentId: form.find("#uptCommentId").val(),
            userId: form.find("#uptUserId").val(),
            noticeId: parseInt(form.find("#uptNoticeId").val()),
            contents: form.find("#uptContents").val()
        }
        let headers = { ...header };
        headers['body'] = JSON.stringify(data);

        fetch("/user/comment/update", headers).then((response) => window.location.reload());
    },
    commentDelete: function (tag) {
        let form = $(tag).closest('.comments_panel').find('form');
        let data = {
            commentId: form.find("#uptCommentId").val(),
            userId: form.find("#uptUserId").val(),
            noticeId: parseInt(form.find("#uptNoticeId").val()),
            contents: form.find("#uptContents").val()
        }
        let headers = { ...header };
        headers['body'] = JSON.stringify(data);

        fetch("/user/comment/delete", headers).then((response) => window.location.reload());
    }
};
main.init();