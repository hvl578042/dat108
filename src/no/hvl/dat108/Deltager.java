package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

@Entity
@Table(schema="dat108_oblig3", name="deltager")
public class Deltager {
	private String fornavn;
	private String etternavn;
	
	@Id
	private String mobil;
	private String kjonn;
	private String passordHash;
	private String passordSalt;



	public Deltager(String fornavn, String etternavn, String mobil, String kjonn, String passordHash, String passordSalt) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.kjonn = kjonn;
		this.passordHash = passordHash;
		this.passordSalt = passordSalt;

	}

	public Deltager() {

	}

	
	

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getPassordHash() {
		return passordHash;
	}

	public void setPassordHash(String passordHash) {
		this.passordHash = passordHash;
	}

	@Override
	public String toString() {
		return "Deltager [fornavn=" + fornavn + ", etternavn=" + etternavn + ", mobil=" + mobil + ", kjonn=" + kjonn
				+ ", passordHash=" + passordHash + ", passordSalt=" + passordSalt + "]";
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	
	public String getPassordSalt() {
		return passordSalt;
	}

	public void setPassordSalt(String passordSalt) {
		this.passordSalt = passordSalt;
	}

}
