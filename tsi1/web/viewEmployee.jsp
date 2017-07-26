<%@page import="model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Example Schema HR</title>
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
        ArrayList<Employee> employees = (ArrayList<Employee>)request.getAttribute("employees");
        
    %>
    
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <h4>Employee List</h4>
            <div class="bs-example">
                <a href="newEmployee" class="btn btn-success " role="button">
                    <span class="glyphicon glyphicon-file" aria-hidden="true"></span> New Employee
                </a>
                <table class="table table-bordered table-striped table table-hover">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>First Name</th>
                      <th>Last Name</th>
                      <th>E-mail</th>
                      <th>Phone</th>
                      <th>Hire Date</th>
                      <th>Job</th>
                      <th>Salary</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody >
                    <% 
                        for(Employee employee : employees) {
                    %>
                    <tr>
                      <th scope="row"><%= employee.getEmployee_id() %></th>
                      <td><%= employee.getFirst_name() %></td>
                      <td><%= employee.getLast_name() %></td>
                      <td><%= employee.getEmail() %></td>
                      <td><%= employee.getPhone_number() %></td>
                      <td><%= employee.getHire_date() %></td>
                      <td><%= employee.getJob_id() %></td>
                      <td><%= employee.getSalary() %></td>
                      <td>
                          <a href="editEmployee?employee_id=<%=employee.getEmployee_id()%>" class="btn btn-info btn-xs " role="button">
                              <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                          </a>
                          <a href="delEmployee?employee_id=<%=employee.getEmployee_id()%>" class="btn btn-danger btn-xs " role="button">
                              <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                          </a>
                      </td>
                    </tr>
                    <% 
                        }
                    %>
                  </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
