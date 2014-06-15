<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@page import="Model.Cancion" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    	<link rel="stylesheet" href="css/skin.css" type="text/css" media="screen"/>
    	<link rel="stylesheet" href="css/style2.css" type="text/css" media="screen"/>
<title>Insert title here</title>
</head>
<body>

<center><br><br>	

<%
             Cancion cancion=(Cancion)request.getAttribute("Cancion");

%>       

<div style="position: relative; width: 100%; ">
	    <div style="position: absolute; left: 0; width: 50%; ">
	        <center>
	        	<img src="images/logo4.png" alt="EmusicoOo">
	        <br>
	        <iframe width='640' height='390' src="<%=cancion.m_url %>" frameborder='0' ></iframe>
	        </center>
	    </div>
	    <div style="position: absolute; right: 0; width: 50%; height:600px; overflow:auto;
    						margin:auto;">
	    	<font color='black' size='6' ><%=cancion.m_nombre %> - <%=cancion.m_artista %> ( <%=cancion.m_categoria %>)</font><br>
			<br><font color='black' size='4' ><%=cancion.m_letra.replace("\n", "<br>") %>   </font>
	    </div>
</div>    


	
			

		
		
</body>
</html>