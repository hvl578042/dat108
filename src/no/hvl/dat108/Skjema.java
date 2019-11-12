package no.hvl.dat108;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

public class Skjema {
	private String fornavn;
	private String etternavn;
	private String mobil;
	private String kjonn;
	private String passord;
	private String passordRep;
	private String fornavnFeil;
	private String etternavnFeil;
	private String mobilFeil;
	private String kjonnFeil;
	private String passordFeil;
	private String passordRepFeil;
	private String kvinne;
	private String mann;
	private String passordHash;
	private String passordSalt;

	public Skjema(HttpServletRequest request) {
		this.fornavn = request.getParameter("fornavn");
		this.etternavn = request.getParameter("etternavn");
		this.mobil = request.getParameter("mobil");
		this.kjonn = request.getParameter("kjonn");
		this.passord = request.getParameter("passord");
		this.passordRep = request.getParameter("passordRep");
		this.kvinne = request.getParameter("kvinne");
		this.mann = request.getParameter("mann");

	}

	public String getPassordHash() {
		return passordHash;
	}

	public void setPassordHash(String passordHash) {
		this.passordHash = passordHash;
	}

	public String getPassordSalt() {
		return passordSalt;
	}

	public void setPassordSalt(String passordSalt) {
		this.passordSalt = passordSalt;
	}

	public Skjema() {

	}

	public void checker() {
		if (kjonn != null) {
			if (kjonn.equals("kvinne")) {
				kvinne = "checked";
			} else {
				mann = "checked";
			}
		}
	}

	public boolean alleErGyldig() {
		return Validate.gyldigFornavn(fornavn) && Validate.gyldigEtternavn(etternavn) && Validate.gyldigMobil(mobil)
				&& Validate.gyldigKjonn(kjonn) && Validate.gyldigPassord(passord);

	}

	public void settOppFeilmeldinger() {
		if (!Validate.gyldigFornavn(fornavn)) {
			fornavn = "";
			fornavnFeil = "Ugyldig fornavn";
		}
		if (!Validate.gyldigEtternavn(etternavn)) {
			etternavn = "";
			etternavnFeil = "Ugyldig etternavn";
		}
		if (!Validate.gyldigKjonn(kjonn)) {
			kjonn = "";
			kjonnFeil = "Ugyldig kjønn";
		}
		if (!Validate.gyldigMobil(mobil)) {
			mobil = "";
			mobilFeil = "Ugyldig mobil";
		}
		if (!Validate.gyldigPassord(passord)) {
			passord = "";
			passordFeil = "Ugyldig passord";
		}
		if (!isPassordLike()) {
			passordRepFeil = "Passordene må være like!";
		}
	}

	private boolean isPassordLike() {
		if (passord == null || passordRep == null) {
			return false;
		}

		return passord.equals(passordRep);
	}

	public Deltager lagDeltager() {
		Hashing passordh = new Hashing(Hashing.SHA256);
		byte[] passordS = passordh.getSalt();

		try {
			passordh.generateHashWithSalt(passord, passordS);
			System.out.println("hashet");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		passordSalt = passordh.getPasswordSalt();
		// (DatatypeConverter.printHexBinary(passordS));
		passordHash = passordh.getPasswordHashinHex();

		return new Deltager(fornavn, etternavn, mobil, kjonn, passordHash, passordSalt);
	}

	public String getKvinne() {
		return kvinne;
	}

	public void setKvinne(String kvinne) {
		this.kvinne = kvinne;
	}

	public String getMann() {
		return mann;
	}

	public void setMann(String mann) {
		this.mann = mann;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
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

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getPassordRep() {
		return passordRep;
	}

	public void setPassordRep(String passordRep) {
		this.passordRep = passordRep;
	}

	public String getFornavnFeil() {
		return fornavnFeil;
	}

	public void setFornavnFeil(String fornavnFeil) {
		this.fornavnFeil = fornavnFeil;
	}

	public String getEtternavnFeil() {
		return etternavnFeil;
	}

	public void setEtternavnFeil(String etternavnFeil) {
		this.etternavnFeil = etternavnFeil;
	}

	public String getMobilFeil() {
		return mobilFeil;
	}

	public void setMobilFeil(String mobilFeil) {
		this.mobilFeil = mobilFeil;
	}

	public String getKjonnFeil() {
		return kjonnFeil;
	}

	public void setKjonnFeil(String kjonnFeil) {
		this.kjonnFeil = kjonnFeil;
	}

	public String getPassordFeil() {
		return passordFeil;
	}

	public void setPassordFeil(String passordFeil) {
		this.passordFeil = passordFeil;
	}

	public String getPassordRepFeil() {
		return passordRepFeil;
	}

	public void setPassordRepFeil(String passordRepFeil) {
		this.passordRepFeil = passordRepFeil;
	}

}
