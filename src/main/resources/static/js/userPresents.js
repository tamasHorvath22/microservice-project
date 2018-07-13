let userPresentsContainer = $(".userPresents-container");
$(document).ready(function () {
    $("#userPresents-button").click(function () {
        $.get("getPresents", function (presents) {
            userPresentsContainer.empty();
            listUserPresents(presents);
        });
    })
});

function listUserPresents(presents) {
    if (presents.length > 0) {
        for (var i = 0; i < presents.length; i++) {
            userPresentsContainer.append("<div id=present-wish-" + presents[i].id + " class=\"row mb-5\">\n" +
                "<div class=\"col-xl-12\">\n" +
                "<div class=\"media-boxes\">\n" +
                "<div class=\"media\">\n" +
                "<div class=\"media-body tm-bg-gray\">\n" +
                "<img src=" + presents[i].imageUrl + " alt=\"Image\" class=\"mr-3 present-img\">\n" +
                "<div class=\"tm-description-box\">\n" +
                "<h5 class=\"tm-text-blue\">" + presents[i].name + "</h5>\n" +
                "<p class=\"mb-0 description\">" + presents[i].description + "</p>\n" +
                "</div>\n" +
                "</div></div></div></div></div>")
        }
    } else {
        userPresentsContainer.append("<div>You have no presents uploaded yet!</div>");
    }
}