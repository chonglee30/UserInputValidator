package com.users.validator.validation;

import com.users.validator.validation.AddressValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
Format A1A 1A1, where A is a letter and 1 is a digit, with a space separating the third and fourth characters.
Postal codes do not include the letters D, F, I, O, Q or U, and
the first position also does not make use of the letters W or Z.
*/
public class AddressValidatorTest {

	//containSevenCharacterStringPostalCode(String code)

	@Test(priority=1)
 	public void testSevenCharacterPostalCode() {
		String str = new String("A1A 1A1");
		Assert.assertTrue(AddressValidator.getInstance().validatePostalCode(str),"should be true");
	}

	@Test(priority=2)
 	public void testMoreThanSevenCharacterPostalCode() {
		String str = new String("A1A  1A1");
		Assert.assertFalse(AddressValidator.getInstance().validatePostalCode(str),"should be false");
	}

	@Test(priority=3)
 	public void testNotStartWCharacterPostalCode() {
		String str = new String("W1A 1A1");
		Assert.assertFalse(AddressValidator.getInstance().validatePostalCode(str),"should be false");
	}

	@Test(priority=4)
 	public void testNotStartZCharacterPostalCode() {
		String str = new String("Z1A 1A1");
		Assert.assertFalse(AddressValidator.getInstance().validatePostalCode(str),"should be false");
	}

	//D, F, I, O, Q or U
	@Test(priority=5)
 	public void testNotIncludeDCharacterPostalCode() {
		String str = new String("A1D 1A1");
		Assert.assertFalse(AddressValidator.getInstance().validatePostalCode(str),"should be false");
	}

	@Test(priority=6)
 	public void testNotIncludeFCharacterPostalCode() {
		String str = new String("A1A 1F1");
		Assert.assertFalse(AddressValidator.getInstance().validatePostalCode(str),"should be false");
	}

	@Test(priority=7)
 	public void testNotIncludeICharacterPostalCode() {
		String str = new String("A1I 1A1");
		Assert.assertFalse(AddressValidator.getInstance().validatePostalCode(str),"should be false");
	}

	@Test(priority=8)
 	public void testNotIncludeOCharacterPostalCode() {
		String str = new String("A1A 1O1");
		Assert.assertFalse(AddressValidator.getInstance().validatePostalCode(str),"should be false");
	}


	@Test(priority=9)
 	public void testNotIncludeQCharacterPostalCode() {
		String str = new String("A1Q 1A1");
		Assert.assertFalse(AddressValidator.getInstance().validatePostalCode(str),"should be false");
	}

	@Test(priority=10)
 	public void testNotIncludeUCharacterPostalCode() {
		String str = new String("A1A 1U1");
		Assert.assertFalse(AddressValidator.getInstance().validatePostalCode(str),"should be false");
	}

	@Test(priority=11)
 	public void testSpaceFirstSecondPostalCode() {
		String str = new String("A 1A1A1");
		Assert.assertFalse(AddressValidator.getInstance().validatePostalCode(str),"should be false");
	}

	@Test(priority=12)
 	public void testSpaceSecondThirdPostalCode() {
		String str = new String("A1 A1A1");
		Assert.assertFalse(AddressValidator.getInstance().validatePostalCode(str),"should be false");
	}

	@Test(priority=13)
 	public void testSpaceFourthFifthPostalCode() {
		String str = new String("A1A1 A1");
		Assert.assertFalse(AddressValidator.getInstance().validatePostalCode(str),"should be false");
	}

	@Test(priority=13)
 	public void testSpaceFifthSixthPostalCode() {
		String str = new String("A1A1A 1");
		Assert.assertFalse(AddressValidator.getInstance().validatePostalCode(str),"should be false");
	}

	@Test(priority=14)
 	public void testVancouverPostalCode() {
		String str = new String("V5G 3H6");
		Assert.assertTrue(AddressValidator.getInstance().validatePostalCode(str),"should be true");
	}


}
