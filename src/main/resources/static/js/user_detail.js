$(document).ready(function() {
    fillUserDetailTab();
});


function fillUserDetailTab() {
    $.ajax({
        type: "POST",
        url: "/user",
        data: "userId=1",
        success: function(data, status) {
            if (status === "success") {
                showContent(data);
            } else {
                showFailure("Something went wrong!");
            }
        }
    })

}

function showContent(userData) {
    console.log(userData);
    let picturePlaceHolderParent = $('#user-detail-picture');
    let tabElement = $('#user-detail-tab');
    let div = document.createElement("div");
    let nameHeader = document.createElement("h2");
    let ul = document.createElement("ul");
    let img = document.createElement("img");

    nameHeader.classList = "mb-4 tm-text-pink-dark tm-media-2-header";
    nameHeader.innerText = userData.firstName + " " + userData.lastName;

    let headers = ["ID", "Email", "Address", "Phone"];
    let values = [userData.id, userData.email, userData.address, userData.phoneNumber];

    for (let i = 0; i < headers.length; i++) {
        let li = document.createElement("li");
        li.innerText = headers[i] + ": " + values[i];
        ul.append(li);
    }

    img.src = getPictureURL();
    picturePlaceHolderParent.prepend(img);

    div.append(nameHeader);
    div.append(ul);
    tabElement.append(div);
}

function getPictureURL() {
    return "https://www.sarahotels.in/img/default-user.png"
}

function showFailure(message) {
    alert(message);
    window.location.replace("/");
}
