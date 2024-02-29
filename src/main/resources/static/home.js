const redirectTest = document.querySelector(".redirect");

redirectTest.addEventListener('click', e => {
    console.log("redirect");
    const currentURL = window.location.origin;
    window.location.replace(currentURL+"/quiz2");


});