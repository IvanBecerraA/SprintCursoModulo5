<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Listado de Usuarios</title>
    <%@ include file='head.jsp'  %>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
    <%@ include file='header.jsp' %>
      <div style="display: flex; flex-direction: column;">
        <h1 class="text-center mt-4">Listado de Usuarios</h1>
        <button type="button" style="width: 150px;" class="btn btn-primary m-auto">Crear Usuario</button>

      </div>
      <div class="container"style="min-height: calc(65vh - 50px); overflow-y: auto;">
        <div class="row grid gap-6 w-70 m-auto mt-5 ">
          <table class="table">
            <thead>
              <tr class="text-center">
                <th style="background-color: #7952b3" class="table-primary table-dark" scope="col">id</th>
                <th style="background-color: #7952b3" class="table-primary table-dark" scope="col">Nombre</th>
                <th style="background-color: #7952b3" class="table-primary table-dark" scope="col">Apellido 1</th>
                <th style="background-color: #7952b3" class="table-primary table-dark" scope="col">Apellido 2</th>
                <th style="background-color: #7952b3" class="table-primary table-dark" scope="col">F. Nacimiento</th>
                <th style="background-color: #7952b3" class="table-primary table-dark" scope="col">run</th>
                <!-- <th scope="col">contraseña</th> -->
                <th style="background-color: #7952b3" class="table-primary table-dark" scope="col">
                  <select class="form-select m-auto" style="width: min-content;" aria-label="Default select example">
                  <option class="text-center" selected>Tipo</option>
                  <option value="1">Administrativo</option>
                  <option value="2">Cliente</option>
                  <option value="3">Profesional</option>
                </select>
              </th>
                <th style="background-color: #7952b3" class="table-primary table-dark" scope="col">Editar</th>
                <th style="background-color: #7952b3" class="table-primary table-dark" scope="col">Eliminar</th>
              </tr>
            </thead>
            <tbody>
              <tr class="text-center">
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>juan</td>
                <td>Mark</td>
                <td>Otto</td>
                <!-- <td>juan</td> -->
                <td>Mark</td>
                <td><button type="button" class="btn btn-success"><i class="bi bi-pencil-square"></i></button></td>
                <td><button type="button" class="btn btn-danger"><i class="bi bi-trash"></i></button></td>

              </tr>
              <tr class="text-center">
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <!-- <td>@fat</td> -->
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
                <td>Thornton</td>
                <td><button type="button" class="btn btn-success"><i class="bi bi-pencil-square"></i></button></td>
                <td><button type="button" class="btn btn-danger"><i class="bi bi-trash"></i></button></td>
              </tr>
              <tr class="text-center">
                <th scope="row">3</th>
                <td>Larry</td>
                <td>The Bird</td>
                <td>@twitter</td>
                <td>Thornton</td>
                <!-- <td>Jacob</td> -->
                <td>Thornton</td>
                <td>@fat</td>
                <td><button type="button" class="btn btn-success"><i class="bi bi-pencil-square"></i></button></td>
                <td><button type="button" class="btn btn-danger"><i class="bi bi-trash"></i></button></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>


    <%@ include file='footer.jsp' %>



</body>
</html>