<%--
  Created by IntelliJ IDEA.
  User: johnn
  Date: 27-06-2023
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>

<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Capacitaciones</title>
  <link href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>

<body>

<%@ include file='header.jsp' %>

<div class="container mt-5" style="height: 750px;">
  <div class="row mb-3">
    <h1 class="text-center mb-3">Listado de capacitaciones</h1>
    <div class="col-12 table-responsive">
      <table class="table table-striped table-hover" id="tablaCapacitaciones">
        <thead>
        <tr>
          <th>#ID</th>
          <th>#ID Cliente</th>
          <th>Fecha de realización</th>
          <th>Hora</th>
          <th>Lugar</th>
          <th>Duración</th>
          <th>N° Asistentes</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>1</td>
          <td>3</td>
          <td>2023-01-01</td>
          <td>20:20</td>
          <td>Calle 1</td>
          <td>90</td>
          <td>10</td>
        </tr>
        <tr>
          <td>2</td>
          <td>2</td>
          <td>2</td>
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
          <td>3</td>
          <td>3</td>
          <td>3</td>
        </tr>
        <tr>
          <td>4</td>
          <td>4</td>
          <td>4</td>
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
          <td>5</td>
          <td>5</td>
          <td>5</td>
        </tr>
        <tr>
          <td>6</td>
          <td>6</td>
          <td>6</td>
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
        <button id="btnModalEditar" class="btn btn-info" data-bs-toggle="modal" data-bs-target="">Editar</button>
      </div>
      <div class="col d-grid mb-3">
        <button id="btnModalBorrar" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="">Borrar</button>
      </div>
    </div>
  </div>

</div>

<div class="modal fade" id="modalBorrar" tabindex="-1" aria-labelledby="etiquetaModal1" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="etiquetaModal1">Se requiere confirmación</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Confirma la eliminación de la capacitación.
      </div>
      <div class="modal-footer">
        <form method="post" action="SvCapacitacion" id="formEliminarCapacitacion">
          <input type="text" name="action" id="idEliminacion" hidden>
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" aria-label="Close">Cancelar</button>
          <button type="submit" class="btn btn-danger" id="btnConfirmarBorrar">Confirmar</button>
        </form>
      </div>
    </div>
  </div>
</div>

<div class="modal fade " id="modalEditar" tabindex="-1" aria-labelledby="etiquetaModal2" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="etiquetaModal2">Editar capacitación</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="container" style="height: 750px;">
          <div class="row d-flex justify-content-center justify-content-center">
            <div class="col-lg-6 col-sm-12 rounded shadow p-3">
              <form method="post" action="SvCapacitacion" id="formEditarCapacitacion">
                <div class="mb-3">
                  <label for="inputID" class="form-label" >ID</label>
                  <input type="number" class="form-control" id="inputID" name="ID" disabled>
                </div>
                <div class="mb-3">
                  <label for="inputIdCliente" class="form-label">ID Cliente</label>
                  <input type="number" class="form-control" id="inputIdCliente" name="idCliente" disabled>
                </div>
                <div class="mb-3">
                  <label for="inputFecha" class="form-label">Fecha de la capacitación</label>
                  <input type="date" class="form-control" id="inputFecha" name="fecha" value="">
                </div>
                <div class="mb-3">
                  <label for="inputHora" class="form-label">Hora de la capacitación</label>
                  <input type="time" class="form-control" id="inputHora" name="hora">
                </div>
                <div class="mb-3">
                  <label for="inputLugar" class="form-label">Dirección de la capacitación</label>
                  <input type="text" class="form-control" id="inputLugar" name="lugar">
                </div>
                <div class="mb-3">
                  <label for="inputDuracion" class="form-label">Duración (En minutos)</label>
                  <input type="number" class="form-control" id="inputDuracion" name="duracion">
                </div>
                <div class="mb-3">
                  <label for="inputAsistentes" class="form-label">Cantidad de asistentes</label>
                  <input type="number" class="form-control" id="inputAsistentes" name="cantidadAsistentes">
                </div>
                <div class="d-grid mb-3">
                  <button type="submit" id="btnConfirmarEditar" class="btn btn-success">Guardar</button>
                </div>
                <div class="d-grid">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" aria-label="Close">Cancelar</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script src="../js/scriptListarCapacitaciones.js"></script>
</body>

</html>
