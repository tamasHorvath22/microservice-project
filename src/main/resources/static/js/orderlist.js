let orderContainer = document.getElementsByClassName("order-container")[0];
orderdom = {
    init: function () {
        orderdom.addEventListenerOrderButton();
    },

    addEventListenerOrderButton: function () {
        let orderButton = document.getElementById("order-button");
        orderButton.addEventListener("click", function () {
            $.get("/order", function (orders) {
                console.log(orders);
                console.log(orderContainer);
                orderdom.drawWishes(orders);
            });
        })
    },

    drawWishes: function (orders) {
        for (let i = 0; i < orders.length; i++) {
            orderContainer.innerHTML += "<div class=\"order-wrapper" + i + "\">\n" +
                "<div class=\"order\"></div>\n" +
                "<div class=\"presents\"></div>\n" +
                "</div>";
            let actualOrderWrapper = document.getElementsByClassName("order-wrapper" + i)[0];
            let actualOrder = actualOrderWrapper.getElementsByClassName("order")[0];
            let actualPresents = actualOrderWrapper.getElementsByClassName("presents")[0];
            actualOrder.innerHTML = "<div><h3>Order " + orders[i].id +
                " Ordered time: " + orders[i].timestamp.toString() + "</h3></div>";
            for (let order of orders[i].order) {
                actualPresents.innerHTML += "<div id=present-wish-" + order.id + " class=\"row mb-5\">\n" +
                    "<div class=\"col-xl-12\">\n" +
                    "<div class=\"media-boxes\">\n" +
                    "<div class=\"media\">\n" +
                    "<div class=\"media-body tm-bg-gray\">\n" +
                    "<img src=" + order.imageUrl + " alt=\"Image\" class=\"mr-3\">\n" +
                    "<div class=\"tm-description-box\">\n" +
                    "<h5 class=\"tm-text-blue\">" + order.name + "</h5>\n" +
                    "<p class=\"mb-0 description\">" + order.description + "</p>\n" +
                    "</div>\n" +
                    "<div class=\"tm-buy-box\">\n" +
                    "<span class=\"tm-text-blue tm-price-tag\">" + order.price + " Codecoin</span>\n" +
                    "</div></div></div></div></div></div>";
            }
        }

    }
};

orderdom.init();