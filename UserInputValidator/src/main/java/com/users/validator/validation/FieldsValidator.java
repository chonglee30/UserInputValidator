package com.users.validator.validation;

public class FieldsValidator {

	final static int MAX_FIELD_LENGTH = 256;

	private static FieldsValidator instance = new FieldsValidator();

	private FieldsValidator() {
	}

	public static FieldsValidator getInstance() {
		return instance;
	}

	public boolean checkType(String input) {
		boolean validType = true;

		if (!(input instanceof String)) {
			System.out.println(input +" is not instance of String type.");
			validType = false;
		}
		return validType;
	}

	public boolean checkMaximumLength(String input) {
		boolean validLength = true;

		if (input.length()>MAX_FIELD_LENGTH) {
			System.out.println(input+ "contains more than Maximum allowed characters");
			validLength = false;
		}
		return validLength;
	}
}
