console.log("Scripted Loaded");

let currentTheme=getTheme();
document.addEventListener("DOMContentLoaded",()=>{
	changeTheme()
})


//TOD:
function changeTheme(){
	
	//seet to web page

     changePageTheme(currentTheme,currentTheme);
	
	//set the listener to change themne
	const changeThemeButton=document.querySelector('#theme_change_button');

 const oldTheme=currentTheme;
	//change theme
	
	

	changeThemeButton.addEventListener("click",(event)=>{
		console.log("Change theme")
		
		
		
		if(currentTheme==="dark"){
			//theme to light
			currentTheme="light"
			}else{
				currentTheme="dark"
				
			}
			
			//changeTheme
			changePageTheme(currentTheme,oldTheme);
			
							
			
			
	})
}
//set theme to localstorage

function setTheme(theme){
	const oldTheme=currentTheme

	
	localStorage.setItem("theme",theme);
}



//get theme from localstorage

function getTheme(){
	
	let theme= localStorage.getItem('theme')
	
	//if(theme)return theme
	//else return"light"

       return theme ? theme :"light";
	
	
	
}



//Change currnet page theme

function changePageTheme(theme,oldTheme){
	//local storage change
				setTheme(currentTheme)
				
				//remove the current theme
						
						document.querySelector("html").classList.remove(oldTheme)
				
				//set the current theme
				document.querySelector("html").classList.add(theme)
				
				
				//Text change
				document.querySelector('#theme_change_button').querySelector("span").textContent=
								theme=="light"? "Dark" :"Light";
	
}