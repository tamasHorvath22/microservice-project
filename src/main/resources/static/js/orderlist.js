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
            actualOrder.innerHTML = "<div>" + orders[i].id + "</div>";
            for (let presentid of orders[i].presentIds) {
                actualPresents.innerHTML += "<div>" + presentid + "</div>";
            }
        }

    }
};

orderdom.init();