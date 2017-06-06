<%-- 
    Document   : Registrate
    Created on : 05/06/2017, 06:33:57 PM
    Author     : UPEU
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>.:Registros:.</title>
        <link href="<c:url value='recursos/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value='recursos/css/bootstrap.css'/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value='recursos/css/bootstrap-theme.css'/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value='recursos/css/bootstrap-theme.min.css'/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>
       
    
        <div class="container">
            <div class="row">
                <h1>HOLA NO CUENTAS CON UNA CUENTA EN LA BASE DE DATOS , PORFAVOR REGISTRATE</h1>
                <br>
                <br>
            </div>
            <form class="form-horizontal">
                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="nombre">Usuario : </label>  
                                <div class="col-md-4">
                                    <input id="user" name="user" type="text" placeholder="Ingrese Usuario" class="form-control input-md">
                                </div>
                            </div>
                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Clave : </label>  
                                <div class="col-md-4">
                                    <input id="user" name="pass" type="password" placeholder="Ingresa Tu clave" class="form-control input-md">
                                </div>
                            </div>

                            <!-- Button -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="nuevoImplante"></label>
                                <div class="col-md-4">
                                    <input type="submit" class="btn btn-danger"  value="Registrame"/>
                                    <a href="home" ><input  class="btn btn-primary"  value="Regresar"/></a>
                                </div>
                            </div>

                    </form>
             </div>
        
        
        <script src="<c:url value='recursos/js/jquery.js'/>" type="text/javascript"></script>
        <script src="<c:url value='recursos/js/bootstrap.js'/>" type="text/javascript"></script>
        <script src="<c:url value='recursos/js/bootstrap.min.js'/>" type="text/javascript"></script>

        
    </body>
</html>
