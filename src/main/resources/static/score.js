addEventListener("DOMContentLoaded", (event) => {

    var scoreText = document.createTextNode("Final Score is " + localStorage.getItem('score')+ 
    "/" + localStorage.getItem('questionCount'));
   
    var scoreResult = document.getElementById("ScoreResult");

    scoreResult.appendChild(scoreText);

    localStorage.clear();

});

const redirectTest = document.querySelector(".redirect");
 
redirectTest.addEventListener('click', e => {
    console.log("redirect");
    const currentURL = window.location.origin;
    localStorage.clear();
    window.location.replace(currentURL+"/home");


});