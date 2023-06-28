<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Crear Usuario</title>
		<%@ include file='head.jsp' %>
	</head>
	<body>
		<%@ include file='header.jsp' %>

		<div class="container mx-auto" style="width: 80vw">
			<form action="/../SprintCursoModulo5/create" method="post">
				<div class="row d-flex justify-content-between mt-4">
					<h2 class="p-10">Formulario Crear Usuario</h2>
					<div class="text-center">
						<label for="floatingSelect">Tipo de Usuario</label>
						<select
							class="form-select mx-auto"
							id="floatingSelect"
							name="floatingSelect"
							onchange="camposAdicionales()"
							required
							style="width: 200px"
						>
							<option value="">Selecciona un perfil</option>
							<option value="1">Cliente</option>
							<option value="2">Profesional</option>
							<option value="3">Administrativo</option>
						</select>
					</div>
				</div>
				<div class="row gutter-2 mt-4">
					<!-- Datos basicos de usuario -->
					<!-- Nombre -->
					<div class="col-md-4 mb-3">
						<div class="form-group">
							<label for="nombre" class="form-label">Nombre</label>
							<input
								type="text"
								class="form-control form-control-sm"
								id="nombre"
								name="nombre"
								placeholder="Juan"
								required
							/>
						</div>
					</div>

					<!-- Apellido 1 -->
					<div class="col-md-4 mb-3">
						<div class="form-group">
							<label for="apellido1" class="form-label">Primer Apellido</label>
							<input
								type="text"
								class="form-control form-control-sm bb"
								id="apellido1"
								name="apellido1"
								placeholder="Perez"
								required
							/>
						</div>
					</div>

					<!-- Apellido 2 -->
					<div class="col-md-4 mb-3">
						<div class="form-group">
							<label for="apellido2" class="form-label">Segundo Apellido</label>
							<input
								type="text"
								class="form-control form-control-sm"
								id="apellido2"
								name="apellido2"
								placeholder="Pereira"
								required
							/>
						</div>
					</div>
				</div>
				<div class="row gutter-2 mt-4">
					<!-- Fecha Nacimiento -->
					<div class="col-md-4 mb-3">
						<div class="form-group">
							<label for="fechaNacimiento" class="form-label">Fecha de Nacimiento</label>
							<input
								type="date"
								class="form-control form-control-sm"
								id="fechaNacimiento"
								name="fechaNacimiento"
								required
							/>
						</div>
					</div>

					<!-- Run -->
					<div class="col-md-4 mb-3">
						<div class="form-group">
							<label for="run" class="form-label">RUN</label>
							<input
								type="text"
								class="form-control form-control-sm"
								id="run"
								name="run"
								placeholder="11222333-3"
								required
							/>
						</div>
					</div>

					<!-- Contraseña -->
					<div class="col-md-4 mb-3">
						<div class="form-group">
							<label for="contrasena" class="form-label">Contraseña</label>
							<input
								type="password"
								class="form-control form-control-sm"
								id="contrasena"
								name="contrasena"
								placeholder="1234"
								required
							/>
						</div>
					</div>
				</div>
				<%@ include file='camposCliente.jsp' %>
				<%@ include file='camposProfesional.jsp' %>
				<%@ include file='camposAdministrativo.jsp' %>

				<!-- botones, cancelar resetea form -->
				<div class="text-center">
					<button type="submit" class="btn btn-primary btn-lg">Crear Usuario</button>
					<button type="reset" class="btn btn-outline-danger">Limpiar Formulario</button>
				</div>
			</form>
		</div>
		<%@ include file='footer.jsp' %>
		<script>
            <!-- SCRIPT PARA MOSTRAR CAMPOS ADICIONALES -->
            function camposAdicionales() {
                var select = document.getElementById('floatingSelect');
                var cliente = document.getElementById('cliente');
                var profesional = document.getElementById('profesional');
                var administrativo = document.getElementById('administrativo');


                if (select.value === '1') {
                    cliente.style.display = 'block';
                    // Activa required en caso que hayan sido desactivadas
                    cliente.querySelectorAll('input').forEach(function(input) {
                        input.setAttribute('required', 'required');
                    });
                    // Desactiva los required de los perfiles no seleccionados
                    profesional.querySelectorAll('input[required]').forEach(function(input) {
                        input.removeAttribute('required');
                    });
                    administrativo.querySelectorAll('input[required]').forEach(function(input) {
                        input.removeAttribute('required');
                    });
                } else {
                    cliente.style.display = 'none';
                }

                if (select.value === '2') {
                    profesional.style.display = 'block';
                    // Activa required en caso que hayan sido desactivadas
                    profesional.querySelectorAll('input').forEach(function(input) {
                        input.setAttribute('required', 'required');
                    });
                    // Desactiva los required de los perfiles no seleccionados
                    cliente.querySelectorAll('input[required]').forEach(function(input) {
                        input.removeAttribute('required');
                    });
                    administrativo.querySelectorAll('input[required]').forEach(function(input) {
                        input.removeAttribute('required');
                    });
                } else {
                    profesional.style.display = 'none';
                }

                if (select.value === '3') {
                    administrativo.style.display = 'block';
                    // Activa required en caso que hayan sido desactivadas
                    administrativo.querySelectorAll('input').forEach(function(input) {
                        input.setAttribute('required', 'required');
                    });
                    // Desactiva los required de los perfiles no seleccionados
                    cliente.querySelectorAll('input[required]').forEach(function(input) {
                        input.removeAttribute('required');
                    });
                    profesional.querySelectorAll('input[required]').forEach(function(input) {
                        input.removeAttribute('required');
                    });
                } else {
                    administrativo.style.display = 'none';
                }
            }
		</script>
	</body>
</html>
