<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Example PLSQL Value</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <!-- BEGIN MENU -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">          
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" >
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href=".">HR</a>
          </div>
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <li><a href="ListEmployee">Employees List</a></li>                            
              <li><a href="PLSQLCursor">PLSQL cursor</a></li>
            </ul>   
            <form method="POST" action="SearchEmployee" class="navbar-form navbar-left" role="search">
                <div class="form-group">
                  <input name="employee_id" type="text" class="form-control" placeholder="Employee ID">
                </div>
                <button type="submit" class="btn btn-default">Search</button>
            </form>
            <form method="POST" action="PLSQLValue" class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input name="employee_id" type="text" class="form-control" placeholder="Employee ID">
                </div>
                <button type="submit" class="btn btn-default">Get Value</button>
            </form>
          </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
    <!-- END MENU -->
    
    <%        
        float value = Float.parseFloat(request.getAttribute("value").toString());
        
    %>
    
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <h4>Example PLSQL Value: PROCEDURE getValor</h4>
            <h5>El resultado de ejecutar el PROCEDURE es: <strong> <%= value %> </strong></h5>
        </div>
        <div class="col-md-1"></div>
    </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
