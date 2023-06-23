<%--
  Created by IntelliJ IDEA.
  User: oscar
  Date: 23-06-23
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>



<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand me-5 ms-5" href="#">Asesorías PR</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse me-5" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/crearcapacitacion">Crear capacitación</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/listarcapacitaciones">Listar capacitación</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/inicio">Cerrar Sesión</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<header>


    <img src="./images/contacto2.jpeg" alt="oficina">
    <section class="container">
        <h1 class="text-center mt-5">FORMULARIO <br> DE CONTACTO</h1>
    </section>
</header>
<main class="container formulario">
    <form action="">
        <div class="row">
            <div class="form-floating col-6 mt-5 ">
                <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                <label for="floatingInput">Nombre</label>
            </div>
            <div class="form-floating col-6 mt-5">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                <label for="floatingPassword">Apellido</label>
            </div>
            <div class="form-floating col-6 mt-3">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                <label for="floatingPassword">Correo electrónico</label>
            </div>
            <div class="form-floating col-6 mt-3">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                <label for="floatingPassword">Teléfono</label>
            </div>
            <div class="form-floating mt-3">
                    <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2"
                              style="height: 100px"></textarea>
                <label for="floatingTextarea2">Mensaje</label>
            </div>
            <div class="text-center mt-5 mb-3">
                <button type="submit" class="btn btn-primary btn-lg">Enviar</button>
            </div>
        </div>
    </form>
</main>
<footer>
    <h3 class="mt-3">Búscanos en redes sociales</h3>
    <a href="http://www.facebook.com" target="_blank" class="rrss me-3"><i class="fa-brands fa-facebook fa-3x"
                                                                           style="color: rgb(159, 201, 237)"></i></a>
    <a href="http://www.instagram.com" target="_blank" class="rrss me-3"><i class="fa-brands fa-instagram fa-3x"
                                                                            style="color: rgb(159, 201, 237)"></i></a>
    <a href="http://www.twitter.com" target="_blank" class="rrss"><i class="fa-brands fa-twitter fa-3x"
                                                                     style="color: rgb(159, 201, 237)"></i></a>
    <p class="mt-1">©Copyright Tech Titans 2023</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</header>
</body>





</body>
</html>
