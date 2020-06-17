function monsterList() {
    let input, filter, ul, li, a, i, txtValue;
    input = document.getElementById("monster-search");
    filter = input.value.toUpperCase();
    ul = document.getElementById("monster-list");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

async function showPlayers() {
    let response = await fetch("/restservices/players/managed-players");
    let myJson = await response.json();
    console.log(myJson);

    let contentStr = "";

    myJson.forEach(function (o){
        console.log(o.playerName);
        contentStr += "<div style='border: 2px solid black'>" + "<b>Name: </b>" + o.playerName + "<br>" +
            "<b>Race: </b>" + o.playerRace + "<br>" +
            "<b>Class: </b>" + o.playerClass + "<br>" +
            "<b>Health: </b>" + o.playerHealth + "<br>" +
            "<b>AC: </b>" + o.playerAC + "<br>" +
            "<b>PP: </b>" + o.playerPP + "<br>" +
            "<b>Initiative: </b>" + o.playerInitiative + "<br>" +
            "</div>" + "<br>";
    });
    document.getElementById("player-container").innerHTML = contentStr;
}

async function addPlayer() {
    let data = {
        "playerName": (document.getElementById("playerName").value),
        "playerRace": (document.getElementById("playerRace").value),
        "playerClass": (document.getElementById("playerClass").value),
        "playerHealth": (document.getElementById("playerHealth").value),
        "playerAC" : (document.getElementById("playerAC").value),
        "playerPP" : (document.getElementById("playerPP").value),
        "playerInitiative" : (document.getElementById("playerInitiative").value)
    };

    const response = await fetch("/restservices/players/player", {
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
    showPlayers();
    return response;
}

function openAddPlayerDialog(){
    document.getElementById("add-player").show();
}

function closeDialog() {
    document.getElementById("add-player").close();
}

window.onload = showPlayers();