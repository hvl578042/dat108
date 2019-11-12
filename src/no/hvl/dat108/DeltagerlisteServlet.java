package no.hvl.dat108;

import static no.hvl.dat108.UrlMappings.LOGIN_URL;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Deltagerliste")
public class DeltagerlisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DeltagerEAO deltagerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mobil = (String) request.getSession().getAttribute("mobil");
		if (mobil != null) {
			List<Deltager> deltagere = deltagerEAO.finnAlleDeltagere().stream().collect(Collectors.toList());
			request.setAttribute("deltagere", deltagere);
			request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);
		} else {
			response.sendRedirect(LOGIN_URL + "?requiresLogin");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Deltagerliste");
	}

}
