function addArcType(){
	var reid=document.getElementById("reid").value;
	var sortrank=document.getElementById("sortrank").value;
	var defaultname=document.getElementById("defaultname").value;
	var issend=document.getElementById("issend").value;
	var corank=document.getElementById("corank").value;
	var description=document.getElementById("description").value;
	var keywords=document.getElementById("keywords").value;
	var siteurl=document.getElementById("siteurl").value;
	var sitepath=document.getElementById("sitepath").value;
	var channel=document.getElementById("channel").value;
	var url="/arctype/addArcType?random="+Math.round(Math.random()*100);
	var param={reid:reid,sortrank:sortrank,defaultname:defaultname,issend:issend,corank:corank,description:description,keywords:keywords,siteurl:siteurl,sitepath:sitepath,channel:channel};
	jQuery.post(url,param,function(data){
		if(data.ret!=0){
		}else{
			alert("add success");
		}
	});
}
