var wishlistContaner = $(".wishlist-container");

$(document).ready(function () {
    $(".wishlist-button").click(function () {
        $.get("wishlist", function (presents) {
            wishlistContaner.empty();
            console.log(presents);
            drawWishes(presents);
            deleteFromWishes();
        });
    })
});

function drawWishes(presents) {
    if (presents.length > 0) {
        for (var i = 0; i < presents.length; i++) {
            wishlistContaner.append("<div id=present-wish-" + presents[i].id + " class=\"row mb-5\">\n" +
                "<div class=\"col-xl-12\">\n" +
                "<div class=\"media-boxes\">\n" +
                "<div class=\"media\">\n" +
                "<div class=\"media-body tm-bg-gray a-wish\">\n" +
                "<img src=" + presents[i].imageUrl + " alt=\"Image\" class=\"mr-3\">\n" +
                "<div class=\"tm-description-box\">\n" +
                "<h5 class=\"tm-text-blue\">" + presents[i].name + "</h5>\n" +
                "<p class=\"mb-0 description\">" + presents[i].description + "<span class=\"tm-text-blue tm-price-tag\">" + presents[i].price + " Codecoin</span></p>\n" +
                "</div>\n" +
                "<div class=\"tm-buy-box\">\n" +
                "<button id=" + presents[i].id + " class=\"tm-bg-blue tm-text-white tm-buy add-to-cart\">Add to cart</button>\n" +
                "<button id=" + presents[i].id + " class=\"tm-bg-blue tm-text-white tm-buy delete-from-wishes\">Remove</button>\n" +
                "</div></div></div></div></div></div></div>")
        }
        addToCart();
    } else {
        wishlistContaner.append("<div>There are no presents you wish for!</div>");
    }
}

function addToCart() {
    $(".add-to-cart").click(function () {
        console.log("clicked");
        var params = {
            presentId: this.id
        };
        //console.log($('#present-wish-'+ params.id));
        $('#present-wish-'+ params.presentId).remove();
        console.log(params.presentId);
        $.post("add-to-cart", $.param(params), function () {
            console.log("addin to cart: " + params.presentId);
        });
        $.post("wishlist/remove", $.param(params), function () {
            console.log("deleting from wishes : " + params.presentId);
        });
    })
}

function deleteFromWishes() {
    $(".delete-from-wishes").click(function () {
        console.log("clicked");
        var params = {
            presentId: this.id
        };
        $('#present-wish-'+ params.presentId).remove();
        console.log(params.presentId);
        $.post("wishlist/remove", $.param(params), function () {
            console.log("deleting from wishes : " + params.presentId);
        });
    })

}