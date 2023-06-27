<%--
  Created by IntelliJ IDEA.
  User: Joaquin
  Date: 23-06-23
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%@ include file="head.jsp" %>
    </head>
    <body
        class="bg-primary d-flex justify-content-center align-items-center vh-100"
    >
        <%--<%@ include file="nav.jsp" %>--%>
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
            </div>
            <div class="text-center fs-1 fw-bold">Login</div>
            <div class="input-group mt-4">
                <div class="input-group-text bg-primary">
                    <img
                        src="../icons/username-icon.svg"
                        alt="username-icon"
                        style="height: 1rem"
                    />
                </div>
                <input
                    class="form-control bg-light"
                    type="text"
                    placeholder="Run"
                    name="run"
                    id="run"
                    required
                />
            </div>
            <div class="input-group mt-1">
                <div class="input-group-text bg-primary">
                    <img
                        src="../icons/password-icon.svg"
                        alt="password-icon"
                        style="height: 1rem"
                    />
                </div>
                <input
                    class="form-control bg-light"
                    type="password"
                    placeholder="Password"
                    name="password"
                    id="password"
                    required
                />
            </div>
            <button
                class="btn btn-primary text-white w-100 mt-4 fw-semibold shadow-sm"
                type="submit"
            >
                Login
            </button>
        </form>
        <%--<%@ include file="footer.jsp" %>--%>
    </body>
</html>
