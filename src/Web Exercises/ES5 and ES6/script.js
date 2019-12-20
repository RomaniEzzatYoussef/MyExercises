const player = "magdi";
let romani = "Romani Ezzat";
var sarah = "Sarah Ashraf";

let experience = 100;

if (experience > 90)
{
    var sarah = "Meine Soso";
    let romani = "Meine Selbst";

    console.log('inside ' + sarah);
    console.log('inside ' + romani);
}

// changeNames();

console.log('out ' + sarah);
console.log('out ' + romani);

function changeNames() {
    let romani = "roma";
    var sarah = "soso";
    console.log('inside changeNames function : ' , romani);
    console.log('inside changeNames function : ' , sarah);
}

const aa = 0;
// aa = 10;

const obj = {
    id : 12,
    name: "romani",
    height: 175,
    weight: 79
}

obj.name = "samy";

const {id , name} = obj;
let {height , weight} = obj;
const age = 34;
const pet = "horse";
const a = "Simon";
const b = 15;
let c = true;

const o = {
    [name]: "john snow",
    [1 + 2]: "welcome" ,
    a ,
    b ,
    c
};

// const {[1 + 2] , [name]} = o;

const greeting = "Hello " + name + " you seem to be " + age + " years old!";
console.log(greeting);

const greetingBest = `Hello ${name} you seem to be ${age - 10}. What a lovely ${pet} you have.`;
console.log(greetingBest);

function greet(name='' , age=30, pet='cat')
{
    return `Hello ${name} you seem to be ${age - 10}. What a lovely ${pet} you have.`;
}
greet();
greet("john" , 50 , "monkey");

let sym1 = Symbol();
let sym2 = Symbol("foo");
let sym3 = Symbol("foo");
let sym4 = Symbol("poo poo poo");

console.log(sym1);
console.log(sym2);
console.log(sym2 === sym3); // false --> Symbol() is a unique type.
console.log(sym4);


function add1(a , b) {
    return a + b;
}

const add2 = (a, b) => a+b;

add1(3 , 5);
add2(5 , 5);