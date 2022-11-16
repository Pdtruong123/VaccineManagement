const captcha = document.querySelector(".captcha"),
    reloadBtn = document.querySelector(".reload-btn"),
    inputField = document.querySelector(".inputCaptcha"),
    checkBtn = document.querySelector(".check-btn"),
    statusTxt = document.querySelector(".status-txt");

let allChar = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

function getCaptcha(){
    for(let i = 0; i<5 ; i++){
        let randomChar = allChar[Math.floor(Math.random()* allChar.length)];
        captcha.innerText += `${randomChar}`;
    }
}
getCaptcha();

function removeContent(){
    captcha.innerText = "";
    inputField.value = "";
}

reloadBtn.addEventListener("click", ()=>{
     removeContent();
});



