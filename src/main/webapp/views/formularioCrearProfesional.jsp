<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous"/>
    <title>Create Professional</title>
  </head>
  <body>
    <header>
      <nav
        class="navbar navbar-expand-lg navbar-dark"
        style="background-color: #7952b3"
      >
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Asesorías 0007</a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse pe-5" id="navbarNav">
            <ul class="navbar-nav ms-md-auto">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#"
                  >Inicio</a
                >
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

    <div class="container ">
      <div class="row grid gap-6 w-50 m-auto mt-5 ">
        <form action="">
          <div class="p-2 g-col-6 col-sm-12" >
            <input type="text" class="form-control" placeholder="Nombre" aria-label="First name" />
          </div>
          <div class="p-2 g-col-6 col-sm-12">
            <input type="text" class="form-control" placeholder="Primer Apellido" aria-label="First name"/>
          </div>
          <div class="p-2 g-col-6 col-sm-12">
            <input type="text" class="form-control" placeholder="Segundo Apellido" aria-label="First name"/>
          </div>
          <div class="p-2 g-col-6 col-sm-12">
            <input type="text" class="form-control" placeholder="Fecha de Nacimiento" aria-label="First name"/>
          </div>
          <div class="p-2 g-col-6 col-sm-12">
            <input type="text" class="form-control" placeholder="Run" aria-label="First name" />
          </div>
          <div class="p-2 g-col-6 col-sm-12">
            <input type="text" class="form-control" placeholder="Titulo" aria-label="First name"/>
          </div>
          <div class="p-2 g-col-6 col-sm-12">
            <input type="text" class="form-control" placeholder="Fecha de Ingreso" aria-label="First name"/>
          </div>
          <button type="button" class="btn btn-secondary mt-5">Cancelar</button>
          <button type="button" class="btn btn-primary mt-5">Crear</button>
        </form>
      </div>
    </div>
    <footer
      class="mt-3"
      style="background-color: #7952b3; text-align: center; padding: 20px 0"
    >
      <h3 class="mt-3" style="color: #fff">Búscanos en redes sociales</h3>
      <a href="http://www.facebook.com" target="_blank" class="rrss me-3"
        ><i
          class="fa-brands fa-facebook fa-2x"
          style="color: rgb(159, 201, 237)"
        ></i
      ></a>
      <a href="http://www.instagram.com" target="_blank" class="rrss me-3"
        ><i
          class="fa-brands fa-instagram fa-2x"
          style="color: rgb(159, 201, 237)"
        ></i
      ></a>
      <a href="http://www.twitter.com" target="_blank" class="rrss"
        ><i
          class="fa-brands fa-twitter fa-2x"
          style="color: rgb(159, 201, 237)"
        ></i
      ></a>
      <p class="mt-1">©Copyright Bootcamp 0007 2023</p>
      <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"
      ></script>
    </footer>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
