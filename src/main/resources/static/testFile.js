const parent = document.querySelector(".parent");


//when page is loaded, insert question number 
addEventListener("DOMContentLoaded", (event) => {
    var questionText = "";
    var questionElement = document.createElement("questionEl");
    var parent = document.getElementById("prompt");

    //if questionCount doesnt exist, always will be question 1, else use questionCount iterator
    if(localStorage["questionCount"]==null){
         questionText = document.createTextNode("Question 1");
    }
    else{
         questionText = document.createTextNode("Question " + localStorage.getItem('questionCount'));
    }
    //add element before lyric prompt with created text
    questionElement.appendChild(questionText);
    document.body.insertBefore(questionElement, parent)

    if((localStorage.getItem('questionCount'))>= 12){
        console.log("final question");
        var finalQuestionButton = document.getElementById("SubmitButtonId");
        finalQuestionButton.value = "Submit Quiz";
       
    }
    if((localStorage.getItem('questionCount'))>= 13){
        console.log("final question");
        var finalQuestionButton = document.getElementById("SubmitButtonId");
        finalQuestionButton.value = "Submit Quiz";
        location.href = "score";
    }
});
//clear storage after user is finished with questions 
$('.clearStorage').click(function(){
    console.log("clearing");
    localStorage.clear();
});

parent.addEventListener('click', e => {
       
    console.log("in javascript event listener");

    // var attempts = (parseInt(localStorage.getItem('score'))+1);
    // localStorage.setItem("score", attempts.toString());
    console.log(localStorage.getItem("score"));
    // location.href = "quiz2";
});


$('.SubmitButton').click(function(){
    //get currently selected option 
    var playerGuess = $('#WhatToUpdate :selected').val();
    //get the correct answer for the question
    const answer = document.getElementById("AnswerName");
    //get the size of map of songs 
    const getCount = document.getElementById("MapSize");
    //get the question header
    const questionHeader = document.createElement;


    if(localStorage["questionCount"]==null){
        localStorage["questionCount"] = 2;
    }
    else{
        var question = (parseInt(localStorage.getItem('questionCount'))+1);
        localStorage.setItem("questionCount", question.toString());
    }
    console.log("current question count is " + localStorage.getItem('questionCount'));

    //create local storage only on first iteration, once null, it wont reset back to 0 when page refreshes
     if(localStorage["score"]==null){
         localStorage["score"] = 0;
     }
 
    //  console.log("current question is " + localStorage.getItem("questionCount") );
     console.log(answer.value)
      if(playerGuess === answer.value){
        var attempts = (parseInt(localStorage.getItem('score'))+1);
        localStorage.setItem("score", attempts.toString());
        console.log("in loop");
         console.log("correct answer " + localStorage.getItem('score'));
         
      }
     
     

});

