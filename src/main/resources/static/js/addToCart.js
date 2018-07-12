$(document).ready(function () {
    $(".add-to-cart").click(function () {
        var params = {
            id: this.id
        };
        //$.post("/add-to-cart", $.params(params), function () {
            $('#present-wish-'+ params.id).remove();
        //});
    })
});