<%--
  Created by IntelliJ IDEA.
  User: johnn
  Date: 27-06-2023
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@page import="org.apache.coyote.http11.HeadersTooLargeException"%>
<%@page import="models.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
 <jsp:include page="head.jsp"/>
 <style>
     label.error {
         color: red;
         font-style: italic;
     }
 </style>
<body>

<jsp:include page="header.jsp"/>

<div class="container" style="min-height: 750px;">
  <div class="row d-flex justify-content-center my-5 justify-content-center">
    <div class="col-lg-6 col-sm-12 rounded shadow p-3">
      <h1 class="text-center mb-3">Crear capacitación</h1>
      <form method="post" action="SvCapacitacion" id="formCrearCapacitacion">
        <input type="text" name="action" value="create" hidden>
        <div class="mb-3">
            <label for="rutCliente" class="form-label">Selecciona el RUT del cliente</label>
            <select class="form-select" id="rutCliente" name="rutCliente">
                <%
                    List<Cliente> listaClientes = (List) request.getAttribute("clientes");

                    for (Cliente cliente : listaClientes) {
                %>
                <option value="<%= cliente.getRut() %>"><%= cliente.getRut() %></option>
                <%-- Aquí puedes mostrar otros campos del cliente si lo deseas: cliente.getNombre(), cliente.getApellido(), etc. --%>
                <% } %>
            </select>
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
<script>
    $(document).ready(function() {
        $.validator.addMethod("fechaSuperiorActual", function(value) {
            var fechaIngresada = new Date(value);
            var fechaActual = new Date();
            return fechaIngresada > fechaActual;
        }, "La fecha debe ser posterior a la fecha actual.");

        $("#formCrearCapacitacion").validate({
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
