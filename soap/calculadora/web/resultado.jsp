<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado</title>
</head>
<body>
    <h1>Resultado</h1>
    <%
        // Obtener los parámetros de la solicitud
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operacion = request.getParameter("operacion");
        
        // Construir la URL del servicio RESTful
        String baseURL = "http://localhost:8080/tu-aplicacion-web/calculadora/";
        String url = baseURL + operacion + "?num1=" + num1 + "&num2=" + num2;
        
        // Realizar la solicitud HTTP al servicio RESTful
        URL restURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) restURL.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        
        // Leer la respuesta del servicio RESTful
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();
        
        // Mostrar el resultado en la página
        out.println("<p>El resultado de la operación " + operacion + " es: " + response.toString() + "</p>");
    %>
</body>
</html>
