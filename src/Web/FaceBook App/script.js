var database = [
    {
        username: "andrie",
        password: "super" ,
        timeline: "So tired from all that learning!"

    } ,
    {
        username: "romani",
        password: "r" ,
        timeline: "So tired from all that learning!"

    } ,
    {
        username: "besho",
        password: "b",
        timeline: "So tired from all that learning!"

    } ,
    {
        username: "silly",
        password: "s" ,
        timeline: "So tired from all that learning!"
    } ,
    {
        username: "nana",
        password: "n" ,
        timeline: "So tired from all that learning!"

    }
];

function signIn(database)
{
    var usernameInput = prompt("Enter your username: ");
    var passwordInput  = prompt("Enter your password: ");

    if (isUserValid(usernameInput , passwordInput) > 0)
    {
        var i = isUserValid(usernameInput , passwordInput);
        var m = ("Hello " + database[i].username + " newsfeed " + database[i].timeline);
        alert(m)
    } else
    {
        alert("Sorry, wrong username and password");
    }

}

function isUserValid (username , password)
{
    for (var i = 0; i < database.length; i++)
    {
        if (username === database[i].username && password === database[i].password)
        {
            return i;
        }
    }

    return 0;
}

signIn(database);
