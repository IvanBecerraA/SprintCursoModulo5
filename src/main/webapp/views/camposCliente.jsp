<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>

		    <h2 class="pb-4">Crear Cliente</h2>

			<!-- Razón Social -->
			<label for="razonSocial">Nombre Empresa o Razón Social:</label>
			<div class="form-floating mb-3">
				<input
					type="text"
					id="razonSocial"
					class="form-control"
					name="razonSocial"
					required
					placeholder="Los Marines"
				/>
			</div>

			<!-- Giro Empresa -->
			<div class="form-floating mb-3">
			    <label for="giroEmpresa">Giro de la Empresa:</label>
            	<input
					type="text"
					id="giroEmpresa"
					class="form-control"
					name="giroEmpresa"
					required
					placeholder="Developers"
				/>
			</div>
				<!-- Rut Empresa -->
			<div class="form-floating mb-3">
			    <label for="rut">Rut de la Empresa:</label>
				<input
					type="text"
					id="rut"
					class="form-control"
					name="rut"
					required
					placeholder="77.123.XXX-X"
				/>
			</div>

			<!-- Teléfono del Representante -->
			<div class="form-floating mb-3">
				<label for="telefonoRepresentante">Teléfono del Representante:</label>
				<input
					type="text"
					id="telefonoRepresentante"
					class="form-control"
					name="telefonoRepresentante"
					required
					placeholder="+56987654321"
				/>
			</div>

			<!-- Dirección de la Empresa -->
			<div class="form-floating mb-3">
			    <label for="direccionEmpresa">Dirección de la Empresa:</label>
				<input
					type="text"
					id="direccionEmpresa"
					class="form-control"
					name="direccionEmpresa"
					required
					placeholder="Avenida Siempre Viva s/n"
				/>
			</div>

			<!-- Comuna de la Empresa -->
			<div class="form-floating mb-3">
				<label for="comunaEmpresa">Comuna de la Empresa:</label>
				<input
					type="text"
					id="comunaEmpresa"
					class="form-control"
					name="comunaEmpresa"
					required
					placeholder="Por algún lugar"
				/>
			</div>
