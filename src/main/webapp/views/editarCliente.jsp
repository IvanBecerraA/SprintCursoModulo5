<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="models.Cliente" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Editar Usuario</title>
		<%@ include file='head.jsp' %>
		<style>
            /* add a red border to invalid input fields */
            input:focus:invalid {
                border: 2px solid red;
            }
            input:valid {
                border: 2px solid green;
            }
        </style>
	</head>
	<body>
	<%--
		<%@ include file='header.jsp' %>
    --%>
		<div class="container mx-auto" style="width: 80vw; min-height: 78vh;">
			<form action="update" method="post" id="formEditarUsuario">

				<%
				    Cliente cli = new Cliente();
				    cli = (Cliente) request.getAttribute("editarCliente");
				%>

				<div class="row d-flex justify-content-between mt-4">
					<h2 class="p-10">Formulario Editar Usuario</h2>

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
								value="<%= cli != null ? cli.getNombre() : "" %>"
								pattern="[a-zA-Z\s]+"
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
								value="<%= cli != null ? cli.getApellido1() : "" %>"
								pattern="[a-zA-Z\s]+"
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
								value="<%= cli != null ? cli.getApellido2() : "" %>"
								pattern="[a-zA-Z\s]+"
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
								value="<%= cli != null ? cli.getFechaNacimiento() : "" %>"
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
								value="<%= cli != null ? cli.getRun() : "" %>"
								pattern="\d{1,9}"
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
								value="<%= cli != null ? cli.getContrasenia() : "" %>"
								required
							/>
						</div>
					</div>
				</div>

				<!-- Campos adicionales para Cliente -->
                <div id="cliente" class="cantainer"">

                	<!-- Razón Social -->
                	<div class="row gutter-2 mt-4">
                		<div class="col-md-4 mb-3">
                			<div class="form-group">
                				<label for="razonSocial">Nombre Empresa o Razón Social</label>
                				<input
                					type="text"
                					id="razonSocial"
                					class="form-control form-control-sm"
                					name="razonSocial"
                					placeholder="Los Marines"
                					value="<%= cli != null ? cli.getRazonSocial() : "" %>"
                					required
                				/>
                			</div>
                		</div>

                		<!-- Giro Empresa -->
                		<div class="col-md-4 mb-3">
                			<div class="form-group">
                				<label for="giroEmpresa">Giro de la Empresa</label>
                				<input
                					type="text"
                					id="giroEmpresa"
                					class="form-control form-control-sm"
                					name="giroEmpresa"
                					required
                					placeholder="Developers"
                					value="<%= cli != null ? cli.getGiroEmpresa() : "" %>"
                				/>
                			</div>
                		</div>

                		<!-- Rut Empresa -->
                		<div class="col-md-4 mb-3">
                			<div class="form-group">
                				<label for="rut">Rut de la Empresa</label>
                				<input
                					type="text"
                					id="rut"
                					class="form-control form-control-sm"
                					name="rut"
                					pattern="\d{1,8}"
                					required
                					placeholder="77123456"
                					value="<%= cli != null ? cli.getRut() : "" %>"
                				/>
                			</div>
                		</div>

                		<!-- Teléfono del Representante -->
                		<div class="col-md-4 mb-3">
                			<div class="form-group">
                				<label for="telefonoRepresentante">Teléfono del Representante</label>
                				<input
                					type="text"
                					id="telefonoRepresentante"
                					class="form-control form-control-sm"
                					name="telefonoRepresentante"
                					required
                					placeholder="+56987654321"
                					value="<%= cli != null ? cli.getTelefonoRepresentante() : "" %>"
                				/>
                			</div>
                		</div>

                		<!-- Dirección de la Empresa -->
                		<div class="col-md-4 mb-3">
                			<div class="form-group">
                				<label for="direccionEmpresa">Dirección de la Empresa</label>
                				<input
                					type="text"
                					id="direccionEmpresa"
                					class="form-control form-control-sm"
                					name="direccionEmpresa"
                					required
                					placeholder="Avenida Siempre Viva s/n"
                					value="<%= cli != null ? cli.getDireccionEmpresa() : "" %>"
                				/>
                			</div>
                		</div>

                		<!-- Comuna de la Empresa -->
                		<div class="col-md-4 mb-3">
                			<div class="form-group">
                				<label for="comunaEmpresa">Comuna de la Empresa</label>
                				<input
                					type="text"
                					id="comunaEmpresa"
                					class="form-control form-control-sm"
                					name="comunaEmpresa"
                					required
                					placeholder="Por algún lugar"
                					value="<%= cli != null ? cli.getComunaEmpresa() : "" %>"
                				/>
                			</div>
                		</div>

                		<!-- Id Usuario -->
                        <input type="hidden" name="idUsuario" value="<%= cli != null ? cli.getId_usuario() : "" %>"/>
                        <input type="hidden" name="idTipo" value="<%= cli != null ? cli.getId_usuario() : "" %>"/>

                	</div>
                </div>


				<!-- botones, cancelar resetea form -->
				<div class="text-center">
					<button type="submit" class="btn btn-primary btn-lg">Editar Usuario</button>
					<button type="reset" class="btn btn-outline-danger">Limpiar Formulario</button>
				</div>
			</form>
		</div>


		<%@ include file='footer.jsp' %>
		<script>
            // Asigna el form a una constante
            const form = document.querySelector('formCrearUsuario');
            // Agrega un evento Listener al evento submit del form
            form.addEventListener('submit', (event) => {
                // Verifica que el form tenga todos los inputs validos
                if (!form.checkValidity()) {
                    // Evita que se envíe formulario a servlet en caso que un campo no esté validado
                    event.preventDefault();
                }
            });
		</script>
	</body>
</html>