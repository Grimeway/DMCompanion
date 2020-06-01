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