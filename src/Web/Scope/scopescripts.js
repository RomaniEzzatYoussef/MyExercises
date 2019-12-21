var h2 = document.querySelector("h2");
var funInput = document.getElementById("funInput");
var array = ["romani", "nana", "ereny", "engy"];

function funFunction(name) {
    h2.textContent = "We have fun with " + name;
}

function funerFunction(name) {
    h2.textContent = "The funer one is " + name;
}

function funestFunction(name) {
    h2.textContent = "You are the funest one, " + name + " Schatz";
}

funInput.addEventListener("input", function () {
    var status = false;
    for (var i = 0; i < array.length; i++) {
        if (funInput.value == array[i])
            status = true;
    }

    console.log("status is " + status);

    if (status) {
        if (funInput.value == "nana")
            funFunction(funInput.value);
        else if (funInput.value == "romani")
            funerFunction(funInput.value);
        else if (funInput.value == "ereny" || funInput.value === "engy")
            funestFunction(funInput.value);
        else
            h2.textContent = "Something is wrong";
    }
    if(!status)
        h2.textContent = "Your are not Funny!";


})
