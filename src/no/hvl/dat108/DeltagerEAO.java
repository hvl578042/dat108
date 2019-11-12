package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeltagerEAO {

	@PersistenceContext(name = "deltagerPU")
	private EntityManager em;

	public Deltager finnDeltager(String mobil) {
		Deltager deltager = em.find(Deltager.class, mobil);
		return deltager;
	}

	public void leggTilDeltager(Deltager deltager) {
		em.persist(deltager);
	}

	public List<Deltager> finnAlleDeltagere() {
		List<Deltager> deltagere = em.createQuery(
				"SELECT deltager FROM Deltager deltager ORDER BY " + "deltager.fornavn, deltager.etternavn",
				Deltager.class).getResultList();
		return deltagere;
	}

	public boolean deltagerFinnes(String mobil) {
		return (finnDeltager(mobil) != null);

	}

}