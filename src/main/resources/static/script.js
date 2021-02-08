function imgHider(){
	var sugar= document.getElementById("sugar").innerHTML;
	var cream= document.getElementById("cream").innerHTML;
	var div1= document.getElementsByClassName("div1");
	var div2= document.getElementsByClassName("div2");
	if(sugar==0){
		for (let index = 0; index < div1.length; ++index) {
   			div1[index].style.display ="none";
		}
	}
	if(cream==0){
		for (let index = 0; index < div2.length; ++index) {
   			div2[index].style.display ="none";
		}
	}
}
imgHider();

function listHider(){
	if(document.getElementById("tableList").style.display=="none"){
		document.getElementById("tableList").style.display="block";
	}
	else{document.getElementById("tableList").style.display="none";}
}
