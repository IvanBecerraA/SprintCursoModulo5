<<<<<<< HEAD
<%--
  Created by IntelliJ IDEA.
  User: Joaquin
  Date: 23-06-23
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
=======
>>>>>>> c395b0f986dabe5f0d8034481c991b5aa28fc24c
<!DOCTYPE html>
<html lang="es">
    <head>
        <%@ include file="head.jsp" %>
    </head>
<<<<<<< HEAD
    <body
        class="bg-primary d-flex flex-column justify-content-between vh-100"
    >
        <%@ include file="header.jsp" %>
        <div class="d-flex justify-content-center align-content-center">
            <form
                method="POST"
                class="bg-white p-5 rounded-5 text-secondary shadow"
                style="width: 25rem"
                action="login"
            >
                <div class="d-flex justify-content-center">
                    <img
                        src="../icons/login-icon.svg"
                        alt="login-icon"
                        style="height: 7rem"
                    />
=======
    <body class="bg-primary d-flex flex-column justify-content-between vh-100">
     <%@ include file="nav-inicio.jsp" %>

        <div class="d-flex justify-content-center align-content-center">
            <form method="POST" class="bg-white p-5 rounded-5 text-secondary shadow" style="width: 25rem" action="/login">
                <div class="d-flex justify-content-center">
                    <img
                        src="https://raw.githubusercontent.com/IvanBecerraA/SprintCursoModulo5/b6e4e3f531bdcca0bb1128cb4b0ba15bba8567b0/src/main/webapp/images/login-icon.svg"
                        alt="login-icon"
                        style="height: 7rem"/>
>>>>>>> c395b0f986dabe5f0d8034481c991b5aa28fc24c
                </div>
                <div class="text-center fs-1 fw-bold">Login</div>
                <div class="input-group mt-4">
                    <div class="input-group-text bg-primary">
                        <img
<<<<<<< HEAD
                            src="../icons/username-icon.svg"
                            alt="username-icon"
                            style="height: 1rem"
                        />
=======
                            src="https://raw.githubusercontent.com/IvanBecerraA/SprintCursoModulo5/b6e4e3f531bdcca0bb1128cb4b0ba15bba8567b0/src/main/webapp/images/username-icon.svg"
                            alt="username-icon"
                            style="height: 1rem"/>
>>>>>>> c395b0f986dabe5f0d8034481c991b5aa28fc24c
                    </div>
                    <input
                        class="form-control bg-light"
                        type="text"
                        placeholder="Run"
                        name="run"
                        id="run"
<<<<<<< HEAD
                        required
                    />
=======
                        required/>
>>>>>>> c395b0f986dabe5f0d8034481c991b5aa28fc24c
                </div>
                <div class="input-group mt-1">
                    <div class="input-group-text bg-primary">
                        <img
<<<<<<< HEAD
                            src="../icons/password-icon.svg"
                            alt="password-icon"
                            style="height: 1rem"
                        />
=======
                            src="https://raw.githubusercontent.com/IvanBecerraA/SprintCursoModulo5/b6e4e3f531bdcca0bb1128cb4b0ba15bba8567b0/src/main/webapp/images/password-icon.svg"
                            alt="password-icon"
                            style="height: 1rem"/>
>>>>>>> c395b0f986dabe5f0d8034481c991b5aa28fc24c
                    </div>
                    <input
                        class="form-control bg-light"
                        type="password"
                        placeholder="Password"
                        name="password"
                        id="password"
<<<<<<< HEAD
                        required
                    />
                </div>
                <button
                    class="btn btn-primary text-white w-100 mt-4 fw-semibold shadow-sm"
                    type="submit"
                >
                    Login
                </button>
=======
                        required/>
                </div>
                <button class="btn btn-primary text-white w-100 mt-4 fw-semibold shadow-sm" type="submit">Login</button>
>>>>>>> c395b0f986dabe5f0d8034481c991b5aa28fc24c
            </form>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>
