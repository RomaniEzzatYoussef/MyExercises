function isValid(status) {
    var answer = status ? "You may enter" : "Access Denied";
    h2.textContent = answer;
}

var yes = document.getElementById("yes");
var no = document.getElementById("no");
var h2 = document.querySelector("h2");

var myInput = document.getElementById("myInput");

var status;
yes.addEventListener("click",function () {
    isValid(true)
});
no.addEventListener("click", function () {
    isValid(false)
});

function moveCommand(direction) {
    var whatHappens;

    switch (direction) {
        case "forward":
            whatHappens = "You encounter a monster";
            break;
        case "back":
            whatHappens = "you arrived home";
            break
        case "right":
            whatHappens = "you found a river";
            break;
        case "left":
            whatHappens = "you run into a troll";
            break;
        default:
            whatHappens = "please enter a valid direction";
    }
    return whatHappens;
}

myInput.addEventListener("input" , function () {
    h2.textContent = moveCommand(myInput.value);
})
