<%--
  Created by IntelliJ IDEA.
  User: johnn
  Date: 27-06-2023
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
  <body>

    <jsp:include page="header.jsp"/>

    <div class="container" style="height: 750px;">
      <div class="row d-flex justify-content-center my-5 justify-content-center">
        <div class="col-lg-6 col-sm-12 rounded shadow p-3">
          <h1 class="text-center mb-3">Editar capacitación</h1>
          <form method="post" action="SvCrearCapacitacion" id="formCrearCapacitacion">
            <input type="text" name="action" value="update" hidden>
            <div class="mb-3">
              <div class="mb-3">
                <label for="inputId" class="form-label">Identificador</label>
                <input type="text" class="form-control" id="inputId" name="id" disabled value="1">
              </div>
              <div class="mb-3">
                <label for="inputRutCliente" class="form-label">RUT cliente</label>
                <input type="text" class="form-control" id="inputRutCliente" name="rutCliente" disabled>
              </div>
              <div class="mb-3">
              <label for="inputDia" class="form-label">Día de la capacitación</label>
              <select class="form-select" aria-label="Default select example" id="inputDia" name="dia">
                <option value="" selected>Selecciona un día...</option>
                <option value="1">Lunes</option>
                <option value="2">Martes</option>
                <option value="3">Miercoles</option>
                <option value="4">Jueves</option>
                <option value="5">Viernes</option>
                <option value="6">Sábado</option>
                <option value="7">Domingo</option>
              </select>
            </div>
            <div class="mb-3">
              <label for="inputHora" class="form-label">Hora de la capacitación</label>
              <input type="time" class="form-control" id="inputHora" name="hora">
            </div>
            <div class="mb-3">
              <label for="inputDireccion" class="form-label">Dirección de la capacitación</label>
              <input type="text" class="form-control" id="inputDireccion" name="direccion">
            </div>
            <div class="mb-3">
              <label for="inputDuracion" class="form-label">Duración (En minutos)</label>
              <input type="number" class="form-control" id="inputDuracion" name="duracion">
            </div>
            <div class="mb-3">
              <label for="inputAsistentes" class="form-label">Cantidad de asistentes</label>
              <input type="number" class="form-control" id="inputAsistentes" name="cantidadAsistentes">
            </div>
            <div class="d-grid">
              <button type="submit" class="btn btn-success">Crear</button>
            </div>
          </form>
        </div>
      </div>
    </div>

    <jsp:include page="footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js" integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="js/validacionFormularios.js"></script>
  </body>
</html>
