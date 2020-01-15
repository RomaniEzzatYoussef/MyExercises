alert("Hello")

let mysql = require('mysql');
let p = document.getElementById("p");
let con = mysql.createConnection({
    host: "localhost",
    user: "romani",
    password: "r",
    database: "MyDB" ,
    multipleStatements: true // this allow you to run multiple queries at once.
});

let sqlCommand = `
create database test;

use test;

CREATE TABLE users (
  id int(11) NOT NULL auto_increment,
  name varchar(100) NOT NULL,
  age int(3) NOT NULL,
  email varchar(100) NOT NULL,
  PRIMARY KEY (id)
); `;

con.connect(function(err) {
    if (err) {
        p.textContent = 'error connecting: ' + err.stack;
    }
    p.textContent  = ('connected as id ' + con.threadId);


    console.log("Connected yet no db is selected yet!");
    con.query("CREATE DATABASE users", function (err, result) {
        if (err) throw err;
        console.log("Database created");
    });

// OR allow multiple queries in createConnection and run
con.query(sqlCommand, function (err, result) {
   if (err) throw err;
   console.log("Database created");
 });

});
