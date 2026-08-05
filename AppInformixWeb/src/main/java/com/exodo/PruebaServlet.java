package com.exodo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/consultar")
public class PruebaServlet extends HttpServlet {

    // Aquí WebSphere inyecta la conexión automáticamente
    @Resource(name = "exodoQA")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Prueba de Conexión JNDI en WebSphere</h2>");

        try (Connection conn = dataSource.getConnection()) {
            out.println("<h3 style='color:green;'>¡Conectado a Informix exitosamente!</h3>");

            try (Statement stmt = conn.createStatement()) {
                // CAMBIA ESTO por una tabla real
                String query = "select postatus_poliza, * from POLIZA where POID in ('1C0E03000A')";
                ResultSet rs = stmt.executeQuery(query);

                out.println("<table border='1' style='border-collapse:collapse; padding:5px;'>");
                out.println("<tr style='background-color:#f2f2f2;'><th>Datos recuperados</th></tr>");

                while (rs.next()) {
                    // Extrae la primera columna como texto
                    out.println("<tr><td style='padding:5px;'>" + rs.getString(1) + "</td></tr>");
                }
                out.println("</table>");
            }

        } catch (Exception e) {
            out.println("<h3 style='color:red;'>Error al conectar o consultar:</h3>");
            out.println("<pre>" + e.getMessage() + "</pre>");
        }

        out.println("</body></html>");
    }
}