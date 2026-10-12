import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrianguloServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double base = Double.parseDouble(request.getParameter("base"));
        double altura = Double.parseDouble(request.getParameter("altura"));

        Triangulo triangulo = new Triangulo(base, altura);
        double area = triangulo.calcularArea();
        double perimetro = triangulo.calcularPerimetro();

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<h1>Resultados:</h1>");
            out.println("<p>Área del triángulo: " + area + "</p>");
            out.println("<p>Perímetro del triángulo: " + perimetro + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
