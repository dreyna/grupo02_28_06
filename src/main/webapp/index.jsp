<%-- 
    Document   : index
    Created on : 28 jun. 2021, 17:30:35
    Author     : dreyna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="recursos/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <div class="form-group">
                <input type="text" class="form-control" id="user">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="pass">
            </div>
            <button class="btn btn-danger" id="boton">Enviar</button>
        </div>
        <script src="recursos/js/jquery.js"></script>
        <script src="recursos/js/bootstrap.min.js"></script>
        <script>
            $("#boton").click(function (){
                    $.post("lc",{"user":$("#user").val(), "pass":$("#pass").val()}, function(data) {
                                if(parseInt(data)===1){
                                    window.location="http://localhost:9092/grupo02_28_06/main.jsp";
                                }else{
                                    window.location="index.jsp";
                                }
                });
            });
        </script>
    </body>
</html>
