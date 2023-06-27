<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>

<!-- Campos adicionales para Profesional -->
<div id="profesional" class="cantainer" style="display: none;">

		    <h2 class="pb-4">Datos del usuario Profesional</h2>

          <div class="form-floating mb-3">
                <label for="titulo">Nombre Empresa o Razón Social:</label>
                <input
                    type="text"
                    id="titulo"
                    class="form-control"
					name="titulo"
                    placeholder="Titulo"
                    required
                >
          </div>
          <div class="form-floating mb-3">
                <label for="fechaIngreso">Nombre Empresa o Razón Social:</label>
             <input
                type="date"
                class="form-control"
			    name="fechaIngreso"
                placeholder="Fecha de Ingreso"
                required
             >
          </div>
    </div>
