package com.users.validator.validation;

import com.users.validator.validation.FieldsValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

// Test for Boundary Conditions
public class FieldsValidatorTest {
	@Test()
 	public void noWarningMsgLessThanMaximumCharacters() {	// 255
		String str = new String("squaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresqu");
		//System.out.println("Length of String: "+str.length());
		Assert.assertTrue(FieldsValidator.getInstance().checkMaximumLength(str),"should be true");
	}

	@Test()
 	public void noWarningMsgEqualToMaximumCharacters() {   // 256
		String str = new String("squaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresqu1");
		//System.out.println("Length of String: "+str.length());
		Assert.assertTrue(FieldsValidator.getInstance().checkMaximumLength(str),"should be true");
	}

	@Test()
 	public void warningMsgGreaterThanMaximumCharacters() {
		String str = new String("squaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresquaresqu12");
		//System.out.println("Length of String: "+str.length());
		Assert.assertFalse(FieldsValidator.getInstance().checkMaximumLength(str),"should be false");
	}

}
