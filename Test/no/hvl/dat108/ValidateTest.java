package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import no.hvl.dat108.Validate;

public class ValidateTest {

	@Test
	public void erGyldigFornavn() {
		assertTrue(Validate.gyldigFornavn("Malin"));
		assertTrue(Validate.gyldigFornavn("Anne-Marie"));
		assertTrue(Validate.gyldigFornavn("Anne Stine"));
		assertTrue(Validate.gyldigFornavn("Jo"));

	}

	@Test
	public void erUgyldigFornavn() {
		assertFalse(Validate.gyldigFornavn("M"));
		assertFalse(Validate.gyldigFornavn("malin"));
		assertFalse(Validate.gyldigFornavn("åse"));

	}

	@Test
	public void erGyldigEtternavn() {
		assertTrue(Validate.gyldigEtternavn("Iversen"));
		assertTrue(Validate.gyldigEtternavn("Iversen-Knudsen"));
		assertTrue(Validate.gyldigEtternavn("Ås"));

	}

	@Test
	public void erUgyldigEtternavn() {
		assertFalse(Validate.gyldigEtternavn("Iversen Knudsen"));
		assertFalse(Validate.gyldigEtternavn("Iversen-knudsen"));
		assertFalse(Validate.gyldigEtternavn("ås"));
		assertFalse(Validate.gyldigEtternavn("M"));
	}

	@Test
	public void erGyldigMobil() {
		assertTrue(Validate.gyldigMobil("88988888"));
		assertTrue(Validate.gyldigMobil("12345678"));
	}

	@Test
	public void erUgyldigMobil() {
		assertFalse(Validate.gyldigMobil("1122 4444"));
		assertFalse(Validate.gyldigMobil("112 4444"));
	}
	
	@Test
	public void erGyldigPassord() {
		assertTrue(Validate.gyldigPassord("malin12"));
		assertTrue(Validate.gyldigPassord("12MALIN"));
		assertTrue(Validate.gyldigPassord("ÆØab12345"));
	}
	
	@Test
	public void erUgyldigPassord() {
		assertFalse(Validate.gyldigPassord("malin"));
		assertFalse(Validate.gyldigPassord("//1234567"));
		assertFalse(Validate.gyldigPassord("malin12..."));
		assertFalse(Validate.gyldigPassord("--malin12"));
		assertFalse(Validate.gyldigPassord("<<__//....."));
	}

}
