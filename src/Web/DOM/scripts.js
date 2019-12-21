
/*
window.alert("Check Check");
window;
document;
document.write("Hello");
window.document;
document.getElementsByTagName("h1");
document.getElementsByClassName("second");
document.getElementsByClassName("second")[1];
document.getElementById("first");
document.querySelector("h1");
document.querySelector("li");
document.querySelectorAll("li");
document.querySelectorAll("li , h1");
document.querySelector("h1");
document.querySelector("h1").style;
window.alert("Check Check");

document.getElementById("header1").textContent = "Romani Shoping List";

var li = document.querySelector("li");
var liAttr = document.querySelector("li").getAttribute("random");
var setlIAttr = document.querySelector("li").setAttribute("random" , "1000");
var txt = document.querySelector("li").textContent;
var h1 = document.querySelector("h1");
var h1Style = document.querySelector("h1").style;
var h1StyleColor = document.querySelector("h1").style.color = "red";
h1.className = "coolTitle";

var liClassList = document.querySelector("li").classList;
document.querySelector("li").classList.add("coolTitle");
document.querySelector("li").classList.remove("coolTitle");
document.querySelector("li").classList.add("done");
// var toggleLI = document.querySelector("li").classList.toggle("done");
// document.querySelector("h1").innerHTML = "<strong>!!!!!!!</strong>";
document.querySelectorAll("li")[1].parentElement;
*/


var changeTitleViewButton = document.getElementById("changeTitleView");
changeTitleViewButton.addEventListener("click" , function () {
    if (document.querySelector("h1").classList.contains("coolTitle")) {
        document.querySelector("h1").classList.remove("coolTitle");
    } else
    {
        document.querySelector("h1").classList.add("coolTitle");
    }

    console.log("Clicked!");
});

var button = document.getElementById("addNewItemButton");
var input = document.getElementById("userInput");
var ul = document.querySelector("ul");
button.addEventListener("click" , function ()
{
    if (input.value.length > 0)
    {
        var li = document.createElement("Li");
        var textNode = document.createTextNode(input.value);
        li.appendChild(textNode);
        ul.appendChild(li);
        input.value = "";
    }

});

input.addEventListener("keypress" , function (event)
{
    if (input.value.length > 0 && event.keyCode === 13)
    {
        var li = document.createElement("Li");
        var textNode = document.createTextNode(input.value);
        li.appendChild(textNode);
        ul.appendChild(li);
        input.value = "";
    }

});

var myName = "Romani Ezzat" ,
    age = 24;
document.getElementById("myDiv").innerHTML = "Hello My Name is " +
    myName + " and my Age is " + age;
