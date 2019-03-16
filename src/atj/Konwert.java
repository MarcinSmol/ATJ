package atj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Konwert")
public class Konwert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Double war1 = Double.parseDouble(request.getParameter("war1"));
		String oper = request.getParameter("oper");

		double result = calc(war1, oper);
		response.getWriter().println("<h1>" + result + "</h1>");

		request.getSession().setAttribute("result", new Double(result));

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("res.jsp");
		requestDispatcher.forward(request, response);

	}

	protected double calc(double war1, String oper) {
		double result = 0;
		if (oper.equals("Fahrenheit")) {
			result = (war1 * 1.8) + 32;
		} else if (oper.equals("Celcjusz")) {
			result = (war1 - 32) / 1.8;
		}
		return result;

	}
}
