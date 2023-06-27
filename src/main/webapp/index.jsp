<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/views/head.jsp" %>

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
                        <a class="nav-link active" href="#">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active ms-2" href="#">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

    <main class="container">
         <main class="container">
                <section>
                    <div class="card mb-3" style="max-width: 100%;">
                        <div class="row g-0">
                            <div class="col-s-12 col-md-5">
                                <img src="images/oficina1.jpeg" class="img-fluid rounded-start ps-5 my-5" alt="oficina">
                            </div>
                            <div class="col-s-12 col-md-7">
                                <div class="card-body">
                                    <h5 class="card-title text-center mt-5">Acerca de nosotros</h5>
                                    <p class="card-text px-5">Somos una empresa especializada en brindar servicios de asesoría
                                        en prevención
                                        de riesgos.
                                        Nuestro objetivo es ayudar a las organizaciones a identificar, evaluar y controlar los
                                        riesgos laborales, promoviendo ambientes de trabajo seguros y saludables.<br>
                                        Contamos con un equipo altamente capacitado de profesionales en prevención de riesgos,
                                        quienes
                                        ofrecen soluciones personalizadas adaptadas a las necesidades específicas de cada
                                        cliente.
                                        Nos enfocamos en establecer una relación cercana y de confianza con nuestros clientes,
                                        brindando un servicio integral y de calidad.<br>
                                        Además de nuestros servicios de asesoría, también ofrecemos capacitaciones y
                                        entrenamientos
                                        especializados para mejorar la conciencia y el conocimiento en prevención de riesgos en
                                        los entornos laborales.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

                <section>
                    <div id="carouselExample" class="carousel  slide">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExample" data-bs-slide-to="0" class="active"
                                aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExample" data-bs-slide-to="1"
                                aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExample" data-bs-slide-to="2"
                                aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active" data-bs-interval="5000">
                                <img src="images/ambiente-laboral.jpeg" class="d-block w-100" alt="oficina">
                                <div class="carousel-caption d-none d-md-block" style="background-color: #3e2e5774;">
                                    <h5>Ambientes seguros, trabajadores protegidos</h5>
                                    <p>Confía en nuestra compañía para una prevención de riesgos laborales efectiva.</p>
                                </div>
                            </div>
                            <div class="carousel-item" data-bs-interval="5000">
                                <img src="images/normativa.jpeg" class="d-block w-100" alt="...">
                                <div class="carousel-caption d-none d-md-block" style="background-color: #2d1c47ac;">
                                    <h5>Cumple con la normativa y optimiza costos</h5>
                                    <p>Nuestro servicio tecnológico en prevención de riesgos te ofrece una solución completa y
                                        rentable.</p>
                                </div>
                            </div>
                            <div class="carousel-item" data-bs-interval="5000">
                                <img src="images/productividad.jpeg" class="d-block w-100" alt="...">
                                <div class="carousel-caption d-none d-md-block" style="background-color: #3e2e5774;">
                                    <h5>Mejora la productividad y reduce accidentes</h5>
                                    <p>Descubre cómo nuestra asesoría en prevención de riesgos transforma tu lugar de trabajo.
                                    </p>
                                </div>
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample"
                            data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExample"
                            data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </section>

                <section class="row my-5">
                    <div class="col-4 text-center">
                        <i class="fa-solid fa-user-shield fa-5x" style="color: #523184;"></i>
                        <h3 class="mt-3">Seguridad</h3>
                    </div>
                    <div class="col-4 text-center">
                        <i class="fa-solid fa-microchip fa-5x" style="color: #523184;"></i>
                        <h3 class="mt-3">Tecnología</h3>
                    </div>
                    <div class="col-4 text-center">
                        <i class="fa-solid fa-users fa-5x" style="color: #523184;"></i>
                        <h3 class="mt-3">Asesorías</h3>
                    </div>
                </section>
    </main>

<%@ include file="/views/footer.jsp" %>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>