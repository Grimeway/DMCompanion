async function getInfo() {
    let url = "/restservices/login/user/" + document.getElementById("login").value + "/" + document.getElementById("password").value;
    let response = await fetch(url);
    console.log(response);
    let myJson = await response.json();
    console.log(myJson);

    if (myJson) {
        window.location.href = "https://dm-companion1.herokuapp.com/mainpage/mainpage.html";
    } else {
        document.getElementById("error-message").innerHTML = "Wrong Username or password";
    }
}

async function createNewAccount() {
    let data = {
        "login": (document.getElementById("newLogin").value),
        "password": (document.getElementById("newPassword").value),
    };

    const response = await fetch("/restservices/login/managed-login", {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data) // body data type must match "Content-Type" header
    }).then(function (response) {
        console.log(typeof response);
        return response.json();
    }).then(function (body) {
        console.log(body);
    });
    closeDialog();
    document.getElementById("error-message").innerHTML = "Account created, you can login now using your new login and password";
    return response;
}

function openDialog() {
    document.getElementById("new-account-dialog").show();
}

function closeDialog() {
    document.getElementById("new-account-dialog").close();
}