<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Calculadora</title>
    <script>
        async function calcular(url) {
            const response = await fetch(url);
            const result = await response.json();
            document.getElementById("resultado").innerText = `Resultado: ${result}`;
        }

        function sumar() {
            const num1 = document.getElementById("num1").value;
            const num2 = document.getElementById("num2").value;
            const url = `/calculadora/suma?num1=${num1}&num2=${num2}`;
            calcular(url);
        }

        function restar() {
            const numeroUno = document.getElementById("num1").value;
            const numeroDos = document.getElementById("num2").value;
            const url = `/calculadora/resta?numeroUno=${numeroUno}&numeroDos=${numeroDos}`;
            calcular(url);
        }

        function multiplicar() {
            const numeroUno = document.getElementById("num1").value;
            const numeroDos = document.getElementById("num2").value;
            const url = `/calculadora/multiplicacion?numeroUno=${numeroUno}&numeroDos=${numeroDos}`;
            calcular(url);
        }

        function dividir() {
            const numero_1 = document.getElementById("num1").value;
            const numero_2 = document.getElementById("num2").value;
            const url = `/calculadora/division?numero_1=${numero_1}&numero_2=${numero_2}`;
            calcular(url);
        }
    </script>
</head>
<body>
    <h1>Calculadora RESTful</h1>
    <label for="num1">Número 1:</label>
    <input type="number" id="num1" step="0.01"><br>
    <label for="num2">Número 2:</label>
    <input type="number" id="num2" step="0.01"><br>

    <button onclick="sumar()">Sumar</button>
    <button onclick="restar()">Restar</button>
    <button onclick="multiplicar()">Multiplicar</button>
    <button onclick="dividir()">Dividir</button>

    <p id="resultado">Resultado:</p>
</body>
</html>
