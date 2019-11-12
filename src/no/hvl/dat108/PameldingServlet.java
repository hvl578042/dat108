package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static no.hvl.dat108.UrlMappings.PAAMELDING_URL;
import static no.hvl.dat108.UrlMappings.BEKREFTELSE_URL;
import static no.hvl.dat108.UrlMappings.DELTAGERLISTE_URL;
import static no.hvl.dat108.UrlMappings.LOGIN_URL;

@WebServlet("/Paamelding")
public class PameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerEAO paameldingEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);

		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Skjema skjema = new Skjema(request);
		if (skjema.alleErGyldig() && !paameldingEAO.deltagerFinnes(request.getParameter("mobil"))) { // Ikke registrert
																										// fra før,
																										// bruke
																										// mobil(unik
																										// id)
			HttpSession sesjon = request.getSession(false);

			Deltager deltager = skjema.lagDeltager();
			paameldingEAO.leggTilDeltager(deltager);
			if (sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession(true);

			request.getSession().setAttribute("fornavn", skjema.getFornavn());
			request.getSession().setAttribute("etternavn", skjema.getEtternavn());
			request.getSession().setAttribute("mobil", skjema.getMobil());
			request.getSession().setAttribute("kjonn", skjema.getKjonn());
			request.getSession().removeAttribute("Skjema");
			response.sendRedirect(BEKREFTELSE_URL);

		} else {
			skjema.settOppFeilmeldinger();
			request.getSession().setAttribute("Skjema", skjema);
			response.sendRedirect(PAAMELDING_URL);

		}
	}

}
