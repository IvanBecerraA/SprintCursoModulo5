<%--
  Created by IntelliJ IDEA.
  User: johnn
  Date: 27-06-2023
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Capacitaciones</title>
    <link href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link href="css/estilo3.css" rel="stylesheet">
  </head>
  <body>

    <jsp:include page="header.jsp"/>

    <div class="container mt-5" style="height: 750px;">
      <div class="row mb-3">
        <h1 class="text-center mb-3">Listado de capacitaciones</h1>
        <div class="col-12 table-responsive">
          <table class="table table-striped table-hover" id="tablaCapacitaciones">
            <thead>
            <tr>
              <th>#ID</th>
              <th>Nombre</th>
              <th>RUT Cliente</th>
              <th>Asistentes</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>1</td>
              <td>1</td>
              <td>1</td>
              <td>1</td>
            </tr>
            <tr>
              <td>2</td>
              <td>2</td>
              <td>2</td>
              <td>2</td>
            </tr>
            <tr>
              <td>3</td>
              <td>3</td>
              <td>3</td>
              <td>3</td>
            </tr>
            <tr>
              <td>4</td>
              <td>4</td>
              <td>4</td>
              <td>4</td>
            </tr>
            <tr>
              <td>5</td>
              <td>5</td>
              <td>5</td>
              <td>5</td>
            </tr>
            <tr>
              <td>6</td>
              <td>6</td>
              <td>6</td>
              <td>6</td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>

      <div class="row d-flex justify-content-center">
        <div class="col-lg-6 col-sm-12">
          <div class="col d-grid mb-3">
            <button id="btnCrear" class="btn btn-primary">Crear</button>
          </div>
          <div class="col d-grid mb-3">
            <button id="btnEditar" class="btn btn-info">Editar</button>
          </div>
          <div class="col d-grid mb-3">
            <button class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#modalBorrar">Borrar</button>
          </div>
        </div>
      </div>

    </div>

    <div class="modal fade" id="modalBorrar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">Se requiere confirmación</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            Confirma la eliminación de la capacitación.
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-secondary" id="btnBorrar">Confirmar</button>
          </div>
        </div>
      </div>
    </div>

    <jsp:include page="footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <script src="."></script>
  </body>
</html>
