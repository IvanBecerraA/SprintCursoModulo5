<%@ page import="models.Capacitacion" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: johnn
  Date: 27-06-2023
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>

<html>
 <jsp:include page="head.jsp"/>
 <style>
   label.error {
     color: red;
     font-style: italic;
   }
 </style>
<body>
<%@ include file='header.jsp' %>

<div class="container mt-5" style="min-height: 750px;">
  <div class="row mb-3">
    <h1 class="text-center mb-3">Listado de capacitaciones</h1>
    <div class="col-12 table-responsive">
      <table class="table table-striped table-hover" id="tablaCapacitaciones">
        <thead>
        <tr>
          <th hidden>ID</th>
          <th>Rut del cliente</th>
          <th>Fecha de realización</th>
          <th>Hora</th>
          <th>Lugar</th>
          <th>Duración</th>
          <th>N° Asistentes</th>
        </tr>
        </thead>
        <tbody>

        <%
          List<Capacitacion> listaCapacitaciones = (List) request.getAttribute("capacitaciones");

          for (Capacitacion capacitacion : listaCapacitaciones) {
        %>
        <tr>
          <td hidden><%= capacitacion.getId() %></td>
          <td><%= capacitacion.getRutCliente() %></td>
          <td><%= capacitacion.getFecha() %></td>
          <td><%= capacitacion.getHora() %></td>
          <td><%= capacitacion.getLugar() %></td>
          <td><%= capacitacion.getDuracion() %></td>
          <td><%= capacitacion.getCantidadAsistentes() %></td>
        </tr>
        <% } %>
        </tbody>
      </table>
    </div>
  </div>

  <div class="row">
    <div class="col-lg-4 col-sm-12">
      <form method="GET" action="SvCapacitacionCreate" id="formCrearCapacitacion">
          <div class="col d-grid mb-3">
            <button type="submit" class="btn btn-primary">Crear</button>
          </div>
      </form>
    </div>
    <div class="col-sm-12 col-lg-4 d-grid mb-3">
      <button id="btnModalEditar" class="btn btn-info" data-bs-toggle="modal" data-bs-target="">Editar</button>
    </div>
    <div class="col-sm-12 col-lg-4 d-grid mb-3">
      <button id="btnModalBorrar" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="">Borrar</button>
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
          <input type="text" name="action" value="delete" hidden>
          <input type="text" name="idDelete" id="idEliminacion" hidden>
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
              <form method="post" action="SvCapacitacion?action=update" id="formEditarCapacitacion">
                <div class="mb-3">
                  <label for="inputID" class="form-label" hidden>ID</label>
                  <input type="number" class="form-control" id="inputID" name="id" hidden>
                </div>
                <div class="mb-3">
                  <label for="inputIdCliente" class="form-label" hidden>ID Cliente</label>
                  <input type="number" class="form-control" id="inputIdCliente" name="rutCliente" hidden>
                </div>
                <div class="mb-3">
                  <label for="inputFecha" class="form-label">Fecha de la capacitación</label>
                  <input type="date" class="form-control" id="inputFecha" name="fecha">
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js" integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script>
    var table = $('#tablaCapacitaciones').DataTable()
    $(document).ready(function() {
      $('#tablaCapacitaciones tbody').on('click', 'tr', function () {
          if ($(this).hasClass('selected')) {
              $(this).removeClass('selected')
              $(this).removeClass('table-primary')
              $('#btnModalBorrar').attr('data-bs-target', '')
              $('#btnModalEditar').attr('data-bs-target', '')
          } else {
              table.$('tr.selected').removeClass('selected')
              table.$('tr.table-primary').removeClass('table-primary')
              $(this).addClass('selected')
              $(this).addClass('table-primary')
              $('#btnModalBorrar').attr('data-bs-target', '#modalBorrar')
              $('#btnModalEditar').attr('data-bs-target', '#modalEditar')
          }
      })

      $('#btnModalBorrar').click(function () {
          console.log("btnModalBorrar");
          var data = table.row('.selected').data()
          var seleccionadas = table.rows('.selected').data().length
          if (seleccionadas) {
              $('#idEliminacion').val(data[0])
          }
      })

      $('#btnModalEditar').click(function () {
          var data = table.row('.selected').data()
          var seleccionadas = table.rows('.selected').data().length
          if (seleccionadas) {
              $('#inputID').val(data[0])
              $('#inputIdCliente').val(data[1])
              $('#inputFecha').val(data[2])
              $('#inputHora').val(data[3])
              $('#inputLugar').val(data[4])
              $('#inputDuracion').val(data[5])
              $('#inputAsistentes').val(data[6])
          }
      })
      $.validator.addMethod("fechaSuperiorActual", function(value) {
        var fechaIngresada = new Date(value);
        var fechaActual = new Date();
        return fechaIngresada > fechaActual;
      }, "La fecha debe ser posterior a la fecha actual.");

      $("#formEditarCapacitacion").validate({
        rules: {
          fecha: {
            required: true,
            fechaSuperiorActual: true
          },
          hora: {
            required: true
          },
          lugar: {
            required: true,
            minlength: 5
          },
          duracion: {
            required: true,
            number: true,
            min: 1
          },
          cantidadAsistentes: {
            required: true,
            number : true,
            min: 1
          }
        }
      })

      jQuery.extend(jQuery.validator.messages, {
        required: "Este campo es obligatorio.",
        number : "Este campo debe contener solo números",
        minlength: jQuery.validator.format("Ingresa al menos {0} carácteres."),
        min: jQuery.validator.format("Ingresa un valor minimo de {0}."),
      })
    })
</script>
</body>

</html>
