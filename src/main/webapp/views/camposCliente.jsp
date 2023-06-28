<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Campos adicionales para Cliente -->
<div id="cliente" class="cantainer" style="display: none">
	<h2 class="mt-4">Datos del usuario Cliente</h2>

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
					required
					placeholder="77.123.XXX-X"
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
				/>
			</div>
		</div>
	</div>
</div>
