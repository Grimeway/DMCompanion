let objPeople = [
    {
        username: "sam",
        password: "codify"
    },
    {
        username: "michel",
        password: "kaas"
    },
    {
        username: "jeroen",
        password: "worst"
    }
];

function getInfo() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    for (let i = 0; i < objPeople.length; i++) {
        if (username == objPeople[i].username && password == objPeople[i].password) {
            console.log(username + " is logged in!!");
            window.location.href = "http://localhost:8080/mainpage/mainpage.html";
            break;
        } else  {
            console.log("login failed try again")
        }
    }
}

function createNewAccount() {
    let newUsername = document.getElementById("newUsername").value;
    let newPassword = document.getElementById("newPassword").value;

    objPeople.username = newUsername;
    objPeople.password = newPassword;
    console.log(objPeople);
}

/* Open when someone clicks on the span element */
function openNav() {
    document.getElementById("createAccount").style.width = "100%";
}

/* Close when someone clicks on the "x" symbol inside the overlay */
function closeNav() {
    document.getElementById("createAccount").style.width = "0%";
}