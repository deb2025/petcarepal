var icon=document.querySelector(".down-icon");
icon.addEventListener("click",openseconddiv);
var others=document.querySelector(".others-heading");
others.addEventListener("click",openseconddivforothers);

let state="close";
function openseconddiv(){
    var nav=document.querySelector(".nav-bar");
    var navbarin=document.querySelector(".nav-bar-inside");
    var style_of_others=document.styleSheets[0].cssRules[20];
    if(state=="close"){
        navbarin.style.height="22.6vh"
        nav.style.height="22.6vh";
        icon.style.transform="rotate(180deg)"
        style_of_others.style.transform="scale(1)"
        state="open";
    }
    else{
        navbarin.style.height="13vh"
        nav.style.height="13vh";
        icon.style.transform="rotate(360deg)"
        style_of_others.style.transform="scale(0)"
        state="close";
    }
    
}

let statusnew="close";
function openseconddivforothers(){
    var nav=document.querySelector(".nav-bar");
    var navbarin=document.querySelector(".nav-bar-inside");
    if(state=="close"){
        navbarin.style.height="22.6vh"
        nav.style.height="22.6vh";
        icon.style.transform="rotate(180deg)"
        state="open";
    }
    else{
        navbarin.style.height="13vh"
        nav.style.height="13vh";
        icon.style.transform="rotate(360deg)"
        state="close";
    }
}

function reload(){
    window.location.reload();
}