<%-- 
    Document   : metodo1.jsp
    Created on : 15/07/2016, 08:39:13 AM
    Author     : sistemas-16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>Operaciones Web</title>    
    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
        <div class="row">
            <div class="col-md-4">izquierdo</div>
            <div class="col-md-4">
                
                <h3>Operaciones matemáticas</h3>    
                <form action="Sumando" method="POST">
                    <div class="form-group">
                        <label for="num1">Número 1 :</label>
                        <input type="text" class="form-control" id="num1" name="num1" placeholder="Coloque el número 1">
                    </div>
                    <div class="form-group">
                        <label for="num2">Número 2 :</label>
                        <input type="text" class="form-control" id="num2" name="num2" placeholder="Coloque el número 2">
                    </div>                    
                    <button type="submit" class="btn btn-success">Sumar</button>
                </form>
                
            </div>
            <div class="col-md-4">derecho</div>
        </div>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>