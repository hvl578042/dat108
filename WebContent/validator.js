let etternavnReg = /^[A-ZÆØÅ][a-zæøåA-ZÆØÅ-]{2,20}$/;
let fornavnReg = /^[A-ZÆØÅ][a-zæøåA-ZÆØÅ -]{2,20}$/;
let mobilReg = /^[0-9]{8}$/;
let passordReg = /^[a-zæøåA-ZÆØÅ0-9]{6,}$/;

document.getElementById("inputFornavn").addEventListener("keyup",
		validerFornavn);
document.getElementById("inputEtternavn").addEventListener("keyup",
		validerEtternavn);
document.getElementById("inputMobil").addEventListener("keyup", validerMobil);
document.getElementById("inputPassord").addEventListener("keyup",
		validerPassord);
document.getElementById("inputPassordRepetert").addEventListener("keyup",
		validerLikePassord);
let button = document.getElementById("button");



function validerFornavn() {
	if (inputFornavn.value.match(fornavnReg)) {
		
		inputFornavn.style.backgroundColor = "#98FB98";
	} else {
		inputFornavn.style.backgroundColor = "#E9967A";
	}
}
function validerEtternavn() {
	if (inputEtternavn.value.match(etternavnReg)) {
		inputEtternavn.style.backgroundColor = "#98FB98";
	} else {
		inputEtternavn.style.backgroundColor = "#E9967A";
	}
}
function validerMobil() {
	if (inputMobil.value.match(mobilReg)) {
		inputMobil.style.backgroundColor = "#98FB98";
	} else {
		inputMobil.style.backgroundColor = "#E9967A";
	}
}


function validerPassord() {
	if (inputPassord.value.length >= 6 && inputPassord.value.length <= 10) {
		inputPassord.style.backgroundColor = "#EFF542";
	} else if (inputPassord.value.length >= 11) {
		inputPassord.style.backgroundColor = "#98FB98";
	} else {
		inputPassord.style.backgroundColor = "#E9967A";
	}
}
function validerLikePassord() {
	if (inputPassordRepetert.value == inputPassord.value) {
		inputPassordRepetert.style.backgroundColor = "#98FB98";
	} else {
		inputPassordRepetert.style.backgroundColor = "#E9967A";
	}
}



button.addEventListener("click", event => {
    if(!window.confirm("Send info til tjener?")) {
        event.preventDefault();
    } else {
    }
});





