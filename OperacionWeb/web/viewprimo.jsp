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
                
                <h3>Números Primos</h3>    
                
                <div class="form-group">
                    <label for="num1">Cantidad :</label>
                    <input type="text" class="form-control" id="cantidad" name="cantidad" placeholder="Cantidad de n primos">
                </div>
                <button id="sumar" class="btn btn-success">Obtener Primos</button>
                
                
            </div>
            <div class="col-md-4">derecho</div>
        </div>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
        // Inicio de jquery
        $(document).on('ready', function() {
            // cuando el usuario hizo click en el objeto id=sumar
            $('#sumar').on('click', function(e) {
                // capturar los datos que se van a enviar al servlet
                var numero1 = $('#num1').val();
                var numero2 = $('#num2').val();
                
                // generar la variable JSON para poder enviar los datos
                // {variable1:valor1,variable2:valor2, ... }
                var dataJSON = {carlos:numero1, jose:numero2};
                
                // llamando al metodo post(ajax) que permite llamar un servlet
                // $.post(URL, data, function(respuesta)) {}
                $.post('SumandoAjax', dataJSON, function(respuesta) {
                    // mostrando la respuesta en el input id=resultado
                    $('#resultado').val(respuesta);
                });
                
                
            });
        });
    </script>
  </body>
</html>