package com.users.validator.validation;

import com.users.validator.validation.AddressValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailValidatorTest {

	@Test(priority=1)
 	public void testValidEmailAddress() {
		String str = new String("email@domain.com");
		Assert.assertTrue(EmailAddressValidator.getInstance().validate(str),"should be true");
	}

	@Test(priority=2)
 	public void testContainDotAddressField() {
		String str = new String("firstname.lastname@domain.com");
		Assert.assertTrue(EmailAddressValidator.getInstance().validate(str),"should be true");
	}

	@Test(priority=3)
 	public void testSubDomainAddress() {
		String str = new String("email@subdomain.domain.com");
		Assert.assertTrue(EmailAddressValidator.getInstance().validate(str),"should be true");
	}

	@Test(priority=4)
 	public void testValidPlusSign() {
		String str = new String("firstname+lastname@domain.com");
		Assert.assertTrue(EmailAddressValidator.getInstance().validate(str),"should be true");
	}

	@Test(priority=5)
 	public void testDigitAddress() {
		String str = new String("1234567890@domain.com");
		Assert.assertTrue(EmailAddressValidator.getInstance().validate(str),"should be true");
	}

	@Test(priority=6)
 	public void testDashDomain() {
		String str = new String("email@domain-one.com");
		Assert.assertTrue(EmailAddressValidator.getInstance().validate(str),"should be true");
	}


	@Test(priority=7)
 	public void testUnderscoreAddressField() {
		String str = new String("_______@domain.com");
		Assert.assertTrue(EmailAddressValidator.getInstance().validate(str),"should be true");
	}

	@Test(priority=8)
 	public void testDashAddress() {
		String str = new String("firstname-lastname@domain.com");
		Assert.assertTrue(EmailAddressValidator.getInstance().validate(str),"should be true");
	}

	@Test(priority=9)
 	public void testnameDomainName() {
		String str = new String("email@domain.name");
		Assert.assertTrue(EmailAddressValidator.getInstance().validate(str),"should be true");
	}

	@Test(priority=10)
 	public void testAsiaDomainName() {
		String str = new String("email@co.kr");
		Assert.assertTrue(EmailAddressValidator.getInstance().validate(str),"should be true");
	}

	// Negative Email:
	@Test(priority=11)
 	public void testMissingDomain() {
		String str = new String("Abc.example.com");
		Assert.assertFalse(EmailAddressValidator.getInstance().validate(str),"should be false");
	}

	@Test(priority=12)
 	public void testMissingUserName() {
		String str = new String("@domain.com");
		Assert.assertFalse(EmailAddressValidator.getInstance().validate(str),"should be false");
	}


	/*
	@Test(priority=13)
 	public void testValidLocalServer() {
		String str = new String("user@localserver");
		Assert.assertTrue(EmailAddressValidator.getInstance().validate(str),"should be true");
	}

	@Test(priority=14)
 	public void testIPAddress() {
		String str = new String("user@123.123.123.123");
		Assert.assertTrue(EmailAddressValidator.getInstance().validate(str),"should be true");
	} */
}
