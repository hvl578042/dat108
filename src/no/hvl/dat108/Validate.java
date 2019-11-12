package no.hvl.dat108;

public class Validate {

	public static final String ANY_DIGIT = "^[0-9]{8}$";
	public static final String ETTERNAVN = "^[A-ZÆØÅ][a-zæøåA-ZÆØÅ-]{1,20}$";
	public static final String FORNAVN = "^[A-ZÆØÅ][a-zæøåA-ZÆØÅ -]{1,20}$";
	public static final String ANY_LETTER_OR_DIGIT = "^[a-zæøåA-ZÆØÅ0-9]{6,}$";

	public static boolean gyldigFornavn(String fornavn) {
		if (fornavn == null) {
			return false;
		}

		return fornavn.matches(FORNAVN);

	}

	public static boolean gyldigEtternavn(String etternavn) {
		if (etternavn == null) {
			return false;
		}

		return etternavn.matches(ETTERNAVN);
	}

	public static boolean gyldigMobil(String mobil) {
		if (mobil == null) {
			return false;
		}
		return mobil.matches(ANY_DIGIT);
	}

	public static boolean gyldigKjonn(String kjonn) {
		if (kjonn == null) {
			return false;
		}

		return kjonn.equals("mann") || kjonn.equals("kvinne");
	}

	// Kan bestå av alle tall og bokstaver. Minimumlengde 6.
	public static boolean gyldigPassord(String passord) {
		if (passord == null) {
			return false;
		}

		return passord.matches(ANY_LETTER_OR_DIGIT);
	}

}
