package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Calculadora</title>\n");
      out.write("    <script>\n");
      out.write("        async function calcular(url) {\n");
      out.write("            const response = await fetch(url);\n");
      out.write("            const result = await response.json();\n");
      out.write("            document.getElementById(\"resultado\").innerText = `Resultado: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${result}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("`;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function sumar() {\n");
      out.write("            const num1 = document.getElementById(\"num1\").value;\n");
      out.write("            const num2 = document.getElementById(\"num2\").value;\n");
      out.write("            const url = `/calculadora/suma?num1=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${num1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&num2=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${num2}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("`;\n");
      out.write("            calcular(url);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function restar() {\n");
      out.write("            const numeroUno = document.getElementById(\"num1\").value;\n");
      out.write("            const numeroDos = document.getElementById(\"num2\").value;\n");
      out.write("            const url = `/calculadora/resta?numeroUno=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${numeroUno}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&numeroDos=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${numeroDos}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("`;\n");
      out.write("            calcular(url);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function multiplicar() {\n");
      out.write("            const numeroUno = document.getElementById(\"num1\").value;\n");
      out.write("            const numeroDos = document.getElementById(\"num2\").value;\n");
      out.write("            const url = `/calculadora/multiplicacion?numeroUno=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${numeroUno}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&numeroDos=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${numeroDos}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("`;\n");
      out.write("            calcular(url);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function dividir() {\n");
      out.write("            const numero_1 = document.getElementById(\"num1\").value;\n");
      out.write("            const numero_2 = document.getElementById(\"num2\").value;\n");
      out.write("            const url = `/calculadora/division?numero_1=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${numero_1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&numero_2=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${numero_2}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("`;\n");
      out.write("            calcular(url);\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Calculadora RESTful</h1>\n");
      out.write("    <label for=\"num1\">Número 1:</label>\n");
      out.write("    <input type=\"number\" id=\"num1\" step=\"0.01\"><br>\n");
      out.write("    <label for=\"num2\">Número 2:</label>\n");
      out.write("    <input type=\"number\" id=\"num2\" step=\"0.01\"><br>\n");
      out.write("\n");
      out.write("    <button onclick=\"sumar()\">Sumar</button>\n");
      out.write("    <button onclick=\"restar()\">Restar</button>\n");
      out.write("    <button onclick=\"multiplicar()\">Multiplicar</button>\n");
      out.write("    <button onclick=\"dividir()\">Dividir</button>\n");
      out.write("\n");
      out.write("    <p id=\"resultado\">Resultado:</p>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
