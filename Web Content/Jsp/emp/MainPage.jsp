<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>MainPage</TITLE>
<script>
function test(){
	document.forms[0].submit();
}

var req;
function validateUserId() {
   var idField = document.getElementById("eid");
   var url = "/TestAjax/servlet/emp.servlets.TestController?action=validate&id=" + idField.value;
   
   if (window.XMLHttpRequest) {
       req = new XMLHttpRequest();
   } 
   else if (window.ActiveXObject) {
       req = new ActiveXObject("Microsoft.XMLHTTP");
   }
   req.open("GET", url, true);
   req.onreadystatechange = callback;
   req.send(null);
}

function callback()
 {
	    if (req.readyState == 4) 
	    {
	        if (req.status == 200) 
	       {
		  //  var msg =   responseXML.getElementsByTagName("valid")[0].firstChild.nodeValue;
		  	document.forms[0].ename.value=req.responseText;
		  // update the HTML DOM based on whether or not message is valid
	        }
    }
}

</script>
</HEAD>
<BODY>
<form action="/TestAjax/servlet/emp.servlets.TestController">
<input type="text" value="" name="eno" id="eid" onblur="validateUserId()">
<input type="button" value="See This!" onclick="test()">
<BR><BR><BR>
<input type="text" value="" name="ename">
<input type="hidden" value="" name="action">
</form>
</BODY>
</HTML>
