var wishlistContaner = $(".wishlist-container");

$(document).ready(function () {
    $(".wishlist-button").click(function () {
        $.get("/wishlist", function (presents) {
            wishlistContaner.empty();
            console.log(presents);
            drawWishes(presents);
        });
    })
});

function drawWishes(presents) {
    for (var i = 0; i < presents.length; i++) {
        wishlistContaner.append("<div class=\"row mb-5\">\n" +
            "<div class=\"col-xl-12\">\n" +
            "<div class=\"media-boxes\">\n" +
            "<div class=\"media\">\n" +
            "<img src=" + presents[i].imageUrl + " alt=\"Image\" class=\"mr-3\">\n" +
            "<div class=\"media-body tm-bg-gray\">\n" +
            "<div class=\"tm-description-box\">\n" +
            "<h5 class=\"tm-text-blue\">" + presents[i].name + "</h5>\n" +
            "<p class=\"mb-0 description\">" + presents[i].description + "</p>\n" +
            "</div>\n" +
            "<div class=\"tm-buy-box\">\n" +
            "<a href=\"#\" class=\"tm-bg-blue tm-text-white tm-buy\">buy</a>\n" +
            "<span class=\"tm-text-blue tm-price-tag\">"+ presents[i].price +" Codecoin</span>\n" +
            "</div></div></div></div></div></div>")
    }
}
