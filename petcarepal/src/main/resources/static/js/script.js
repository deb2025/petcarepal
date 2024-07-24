let navbar=document.querySelector(".nav-bar");
window.addEventListener("scroll",function(){
    if(window.scrollY>600){
        navbar.style.height="13vh";
        navbar.style.borderBottom="1px solid white"
    }
    if(window.scrollY<500){
        navbar.style.height="10vh"
        navbar.style.borderBottom="none"
    }
});

let onelink=document.querySelector(".onelink")
var style_of_onelink=document.styleSheets[0].cssRules[12];

let twolink=document.querySelector(".twolink");
let style_of_twolink=document.styleSheets[0].cssRules[14];

let threelink=document.querySelector(".threelink");
let style_of_threelink=document.styleSheets[0].cssRules[16];
let statusoflink=0 ;

onelink.addEventListener("click",function(){
    lineconnection(onelink,style_of_onelink,statusoflink);
});

twolink.addEventListener("click",function(){
    lineconnection(twolink,style_of_twolink,statusoflink);
});

threelink.addEventListener("click",function(){
    lineconnection(threelink,style_of_threelink,statusoflink);
});

function lineconnection(link,pseudo,status){
    if(status==0){
        pseudo.style.transform="scale(1)";
        status=1;
        link.classList.add("active");
    }
    if(status==1){
        setTimeout(function(){
            pseudo.style.transform="scale(0)";
        },2000);
        link.classList.remove("active");
    }
}


let firstpara=document.querySelector(".pfpara");
let secondpara=document.querySelector(".pspara");
let thirdpara=document.querySelector(".ptpara");

let s1="PetCarePal is now open here in Kolkata!";
let s2="Any issues with your beloved ones and we are here to solve all of your problems."
let s3="Give your dogs the best treatment that they deserve!"

let objfile=[[firstpara,s1],[secondpara,s2],[thirdpara,s3]];

objfile.forEach((item)=>{
    let sel=item[0];
    let text=item[1];
    callprinter(sel,text);
});

function callprinter(sel,text){
var typed = new Typed(sel, {
    strings: [text],
    typeSpeed: 50,
  });
}

// To reload the Page
function reload(){
    window.location.reload();
}

let start=document.querySelector(".Start_today");
let register=document.querySelector(".registration");

start.addEventListener("mouseover",()=>{
    start.style.backgroundColor="#301F47";
    start.style.color="#ffffff";
    register.style.backgroundColor="#D9D9D9";
    register.style.color="#111111";
})
start.addEventListener("mouseleave",()=>{
    start.style.backgroundColor="#D9D9D9";
    start.style.color="#111111";
    register.style.backgroundColor="#301F47";
    register.style.color="#ffffff";
})

register.addEventListener("mouseover",()=>{
    start.style.backgroundColor="#301F47";
    start.style.color="#ffffff";
    register.style.backgroundColor="#D9D9D9";
    register.style.color="#111111";
})
register.addEventListener("mouseleave",()=>{
    start.style.backgroundColor="#D9D9D9";
    start.style.color="#111111";
    register.style.backgroundColor="#301F47";
    register.style.color="#ffffff";
})