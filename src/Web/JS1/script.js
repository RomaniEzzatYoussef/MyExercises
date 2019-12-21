
var checkDriverByAge = function() {
    var age = prompt("What is your age?");

    if (Number(age) < 18) {
        alert("Sorry, you are too yound to drive this car. Powering off");
    } else if (Number(age) > 18) {
        alert("Powering On. Enjoy the ride!");
    } else if (Number(age) === 18) {
        alert("Congratulations on your first year of driving. Enjoy the ride!");
    }
}

function checkDriver() {
    var age = prompt("What is your age?");

    if (Number(age) < 18) {
        alert("Sorry, you are too yound to drive this car. Powering off");
    } else if (Number(age) > 18) {
        alert("Powering On. Enjoy the ride!");
    } else if (Number(age) === 18) {
        alert("Congratulations on your first year of driving. Enjoy the ride!");
    }
}

function checkDriverAge(age)
{
    if (Number(age) < 18) {
        return "Sorry, you are too yound to drive this car. Powering off";
    } else if (Number(age) > 18) {
        return "Powering On. Enjoy the ride!";
    } else if (Number(age) === 18) {
        return "Congratulations on your first year of driving. Enjoy the ride!";
    }
}


function multiplyMe()
{
    var a = prompt("Enter a value for a:");
    var b = prompt("Enter a value for b:");

    var total = multiply(a, b);
    alert("(" + a + " * " + b + ") = " + total);
}

function multiply(a , b)
{
    return a * b;
}

function startMe(title , message)
{
    console.log("Title is " + title +  ", and Message:  " + message);
}

startMe("GreenWay" , "you have been accepted");

console.log("Arrays");

var listOfAnimals = ["tiger", "cat", "bear", "bird"];

for (i = 0; i < listOfAnimals.length; i++)
{
    console.log(listOfAnimals[i]);
}
console.log("listOfAnimals[0] = " + listOfAnimals[0]);

// using this array,
var array = ["Banana", "Apples", "Oranges", "Blueberries"];

// 1. Remove the Banana from the array.
array.shift();

// 2. Sort the array in order.
array.sort();

// 3. Put "Kiwi" at the end of the array.
array.push("Kiwi");

// 4. Remove "Apples" from the array.
array.splice(0, 1);

// 5. Sort the array in reverse order.
array.reverse();

// using this array,
var array2 = ["Banana", ["Apples", ["Oranges"], "Blueberries"]];
// access "Oranges".
array2[1][1][0];







