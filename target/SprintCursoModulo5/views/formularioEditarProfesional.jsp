<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
 </head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #7952b3;">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Asesorías 0007</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse  pe-5" id="navbarNav">
                    <ul class="navbar-nav ms-md-auto">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Contacto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Crear capacitación</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Listar capacitación</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Crear usuario</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Listar usuario</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Cerrar sesión</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div class="container">
        <form class="row g-3 w-50 m-auto m-5 ">
            <div class="col-6 col-sm-12" >
                <label for="nombreInput" class="form-label">Nombre</label>
                <input type="nombre" class="form-control" id="nombre" placeholder="Ingrese su nombre">
            </div>
            <div class="col-6 col-sm-12">
                <label for="apellido1" class="form-label">Primer apellido </label>
                <input type="text" class="form-control" id="apellido1" placeholder="Ingrese su primer apellido">
            </div>
            <div class="col-6 col-sm-12">
                <label for="apellido2" class="form-label">Segundo apellido</label>
                <input type="text" class="form-control" id="apellido2" placeholder="Ingrese su segundo apellido">
            </div>
            <div class="col-6 col-sm-12">
                <label for="fechaNacimiento" class="form-label">Fecha de nacimiento </label>
                <input type="text" class="form-control" id="fechaNacimiento" placeholder="Ingrese su fecha de nacimiento">
            </div>
            <div class="col-6 col-sm-12">
                <label for="run" class="form-label">RUN</label>
                <input type="text" class="form-control" id="run" placeholder="Ingrese su run">
            </div>
            <div class="col-6 col-sm-12">
                <label for="tipoUsuario" class="form-label"> Tipo usuario </label>
                <input type="text" class="form-control" id="tipoUsuario" placeholder="Ingrese su tipo de usuario">
            </div>
            <div class="col-6 col-sm-12">
                <label for="titulo" class="form-label">Titulo</label>
                <input type="text" class="form-control" id="titulo" placeholder="Ingrese su titulo">
            </div>
            <div class="col-6 col-sm-12">
                <label for="fechaIngreso" class="form-label"> Fecha de ingreso</label>
                <input type="text" class="form-control" id="fechaIngreso" placeholder="Ingrese su fecha de ingreso">
            </div>
            <div class="col-12">
                <button type="submit" class="btn btn-primary mt-3"> Actualizar</button>
                <button type="cancelar" class="btn btn-secundary mt-3"> Cancelar</button>
            </div>

        </form>
    </div>
    <footer class="mt-3" style="background-color: #7952b3; text-align: center; padding: 20px 0;">
        <h3 class="mt-3" style="color: #fff; ">Búscanos en redes sociales</h3>
        <a href="http://www.facebook.com" target="_blank" class="rrss me-3"><i class="fa-brands fa-facebook fa-2x"
                style="color: rgb(159, 201, 237)"></i></a>
        <a href="http://www.instagram.com" target="_blank" class="rrss me-3"><i class="fa-brands fa-instagram fa-2x"
                style="color: rgb(159, 201, 237)"></i></a>
        <a href="http://www.twitter.com" target="_blank" class="rrss"><i class="fa-brands fa-twitter fa-2x"
                style="color: rgb(159, 201, 237)"></i></a>
        <p class="mt-1">©Copyright Bootcamp 0007 2023</p>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
    </footer>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"crossorigin="anonymous"></script>
</html>