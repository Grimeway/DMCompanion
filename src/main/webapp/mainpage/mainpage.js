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

    let contentStr = "";


    myJson.forEach(function (o){
        contentStr += "<div style='border: 2px solid black'>" + "<b>Name: </b>" + o.playerName + "<br>" +
            "<b>Race: </b>" + o.playerRace + "<br>" +
            "<b>Class: </b>" + o.playerClass + "<br>" +
            "<b>Health: </b>" + o.playerHealth + "<br>" +
            "<b>AC: </b>" + o.playerAC + "<br>" +
            "<b>PP: </b>" + o.playerPP + "<br>" +
            "<b>Initiative: </b>" + o.playerInitiative + "<br>" +
            "<button onclick='deletePlayer(\"" + o.playerName + "\")'>Delete Player</button>" +
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


async function showMonster(monsterName) {

    let url = "/restservices/monsters/monster/" + monsterName;

    let monster;
    fetch(url).then(function (response) {
        return response.json();
    }).then(function (data) {
        monster = data;

        let contentStr = "";

        contentStr += "<div style='border: 2px solid black' id=\'" + monster.name + "\'>" + "<b>Name: </b>" + monster.name + "<br>" +
            "<b>Size: </b>" + monster.size + "<br>" +
            "<b>Type: </b>" + monster.type + "<br>" +
            "<b>Sub Type: </b>" + monster.subtype + "<br>" +
            "<b>Alignment: </b>" + monster.alignment + "<br>" +
            "<b>Armor Class: </b>" + monster.armor_class + "<br>" +
            "<b>Hit Points: </b>" + "<input type='number' value='" + monster.hit_points + "'>" + "<br>" +            "<b>Hit Dice: </b>" + monster.hit_dice + "<br>" +
            "<b>Speed: </b>" + monster.speed + "<br>" +
            "<b>Strength: </b>" + monster.strength + "<br>" +
            "<b>Dexterity: </b>" + monster.dexterity + "<br>" +
            "<b>Constitution: </b>" + monster.constitution + "<br>" +
            "<b>Intelligence: </b>" + monster.intelligence + "<br>" +
            "<b>Wisdom: </b>" + monster.wisdom + "<br>" +
            "<b>Charisma: </b>" + monster.charisma + "<br>" +
            "<b>Strenght save: </b>" + monster.strength_save + "<br>" +
            "<b>Dexterity save: </b>" + monster.dexterity_save + "<br>" +
            "<b>Constitution save: </b>" + monster.constitution_save + "<br>" +
            "<b>Intelligence save: </b>" + monster.intelligence_save + "<br>" +
            "<b>Wisdom save: </b>" + monster.wisdom_save + "<br>" +
            "<b>Charisma save: </b>" + monster.charisma_save + "<br>" +
            "<b>Damage vulnerabilities: </b>" + monster.damage_vulnerabilities + "<br>" +
            "<b>Damage resistances: </b>" + monster.damage_resistances + "<br>" +
            "<b>Damage immunities: </b>" + monster.damage_immunities + "<br>" +
            "<b>Condition immunities: </b>" + monster.condition_immunities + "<br>" +
            "<b>Senses: </b>" + monster.senses + "<br>" +
            "<b>Languages: </b>" + monster.languages + "<br>" +
            "<b>Challenge Rating: </b>" + monster.challenge_rating + "<br>" +
            "<button onclick='deleteMonster(\"" + monster.name + "\")'>Delete Monster</button>" +
            "</div>";
    document.getElementById("monster-container").innerHTML += contentStr;
    });
}

async function showMonsters() {
    let response = await fetch("/restservices/monsters/managed-monsters");
    let myJson = await response.json();
    console.log(myJson);

    let contentStr = "";

    myJson.forEach(function (o){
        contentStr += "<li>" + "<a onclick=\"showMonster(\'" + o + "\')\">" + o + "</a>" + "</li>"
    });
    document.getElementById("monster-list").innerHTML = contentStr;
}

function deletePlayer(playerName) {
    let url = "/restservices/players/" + playerName;
    fetch(url, {
        method: 'DELETE'
    });
    showPlayers();
}

function deleteMonster(monsterName) {
    let element = document.getElementById(monsterName);
    element.parentNode.removeChild(element);

    // let url = "/restservices/monsters/" + monsterName;
    // fetch(url, {
    //     method: 'DELETE'
    // });
}

function openAddPlayerDialog(){
    document.getElementById("add-player").show();
}

function closeDialog() {
    document.getElementById("add-player").close();
}

window.onload = showPlayers();
window.onload = showMonsters();