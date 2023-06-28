<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Campos adicionales para Profesional -->
<div id="profesional" class="cantainer" style="display: none">
	<h2 class="mt-4">Datos del usuario Profesional</h2>
	<div class="row gutter-2 mt-4">
		<div class="col-md-4 mb-3">
			<div class="form-group">
				<label for="titulo">Nombre Empresa o Raz�n Social:</label>
				<input
					type="text"
					id="titulo"
					class="form-control form-control-sm"
					name="titulo"
					placeholder="Titulo"
					required
				/>
			</div>
		</div>
		<div class="col-md-4 mb-3">
			<div class="form-group">
				<label for="fechaIngreso">Nombre Empresa o Raz�n Social:</label>
				<input
					type="date"
					class="form-control form-control-sm"
					name="fechaIngreso"
					placeholder="Fecha de Ingreso"
					required
				/>
			</div>
		</div>
	</div>
</div>
