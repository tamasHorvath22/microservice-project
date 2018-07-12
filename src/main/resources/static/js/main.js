$(document).ready(function () {
    console.log("betöltött");
    $(".add-to-wishlist").click(function () {
        var params = {
            presentId: this.id
        };
        console.log(params.presentId);
        $.post("wishlist/add", $.param(params),function (resp) {
        });
        $('#main-present-'+ params.presentId).remove();
        console.log("present added to wishlist SHIT: " + params.presentId);

    });
    $(".add-to-wishlist-featured").click(function () {
        console.log("képpppp");
        var params = {
            presentId: this.id
        };
        console.log(params.presentId);
        $.post("wishlist/add", $.param(params),function (resp) {
        });
        $('#featured-present-'+ params.presentId).attr('class', 'disabled');
        console.log("present added to wishlist SHIT: " + params.presentId);
    })

});
