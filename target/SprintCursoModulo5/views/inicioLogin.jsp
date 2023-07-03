  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/views/head.jsp" %>

<body>
     <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #7952b3;">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Asesorías 0007</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </nav>

         <header>
                 <h1 class="mt-5 text-center fs-1 fw-bold">BIENVENIDO</h1>
             </header>

             <main class="container mt-5">
                 <section>
                     <h2 class="mb-5 text-center">Seleccione una opción</h2>
                 </section>
                 <section class="row justify-content-center">
                     <div class="card border-light col-4 mx-5 mb-5" style="width: 18rem;">
                         <img src="https://i.postimg.cc/wMVGHPK3/listar-Usuarios.png" class="card-img-top" alt="listar usuarios">
                         <div class="card-body text-center">
                             <a href="usuario" class="btn btn-outline-success">INGRESAR</a>
                         </div>
                     </div>
                     <div class="card border-light col-4 mx-5 mb-5" style="width: 18rem;">
                         <img src="https://i.postimg.cc/RhVkDfhk/listar-Capacitaciones.png" class="card-img-top" alt=" listar capacitaciones">
                         <div class="card-body text-center">
                             <a href="#" class="btn btn-outline-success">INGRESAR</a>
                         </div>
                     </div>
                     <div class="card border-light col-4 mx-5 mb-5" style="width: 18rem;">
                         <img src="https://i.postimg.cc/MZPNGnvG/contacto.png" class="card-img-top" alt="contacto">
                         <div class="card-body text-center">
                             <a href="#" class="btn btn-outline-success">INGRESAR</a>
                         </div>
                     </div>
                     <div class="card border-light col-4 mx-5 mb-5" style="width: 18rem;">
                         <img src="https://i.postimg.cc/qvn5QQQt/crear-Usuario.png" class="card-img-top" alt="crear usuario">
                         <div class="card-body text-center">
                             <a href="#" class="btn btn-outline-success">INGRESAR</a>
                         </div>
                     </div>
                     <%
                     int perfilUsuario = (int) session.getAttribute("tipoUsuario");
                     if (perfilUsuario == 1) {
                     %>
                     <div class="card border-light col-4 mx-5 mb-5" style="width: 18rem;">
                         <img src="https://i.postimg.cc/5NXGQfCS/crear-Capacitacion.png" class="card-img-top" alt="crear capacitacion">
                         <div class="card-body text-center">
                             <a href="SvCapacitacionCreate" class="btn btn-outline-success">INGRESAR</a>
                         </div>
                     </div>
                     <%
                     }
                     %>
             </section>
         </main>

<jsp:include page="/views/footer.jsp"/>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>