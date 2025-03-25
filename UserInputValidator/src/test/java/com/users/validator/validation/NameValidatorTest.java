package com.users.validator.validation;

import com.users.validator.validation.NameValidator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NameValidatorTest {

	@Test(priority=1)
 	public void testCheckForOneAlphabet() {
		String str = new String("t");
		Assert.assertTrue(NameValidator.getInstance().containsAtLeastOneAlphabet(str),"should be true");
	}

	@Test(priority=2)
 	public void testCheckForOneNonAlphabet() {
		String str = new String(" ");
		Assert.assertFalse(NameValidator.getInstance().containsAtLeastOneAlphabet(str),"should be false");
	}

	@Test(priority=3)
 	public void testCheckForLetter() {
		String str = new String("t");
		Assert.assertTrue(NameValidator.getInstance().isLetter(str),"should be true");
	}

	@Test(priority=4)
 	public void testCheckForNumbers() {
		String str = new String("33");
		Assert.assertFalse(NameValidator.getInstance().isLetter(str),"should be false");
	}

	@Test(priority=5)
 	public void testCheckForNonLetters() {
		String str = new String("!$%");
		Assert.assertFalse(NameValidator.getInstance().isLetter(str),"should be false");
	}

	@Test(priority=6)
 	public void testCheckForWhiteSpace() {
		String str = new String("Ter 0 9");
		Assert.assertTrue(NameValidator.getInstance().containsWhitespace(str),"should be true");
	}

	@Test(priority=7)
 	public void testCheckForPunctuation() {
		String str = new String(".,test!");
		Assert.assertTrue(NameValidator.getInstance().containsPunctuation(str),"should be true");
	}

	@Test(priority=8)
 	public void testCheckForNonASCII() {
		String str = new String("Müller");
		Assert.assertFalse(NameValidator.getInstance().isASCIIOnly(str),"should be false");
	}

	@Test(priority=9)
 	public void testCheckForOtherNonASCII() {
		String str = new String("Éfo");
		Assert.assertFalse(NameValidator.getInstance().isASCIIOnly(str),"should be false");
	}

	@Test(priority=10)
 	public void testCheckForOtherNonLetters() {
		String str = new String("Sarah-Shannon");
		Assert.assertFalse(NameValidator.getInstance().isLetter(str),"should be false");
	}

}
