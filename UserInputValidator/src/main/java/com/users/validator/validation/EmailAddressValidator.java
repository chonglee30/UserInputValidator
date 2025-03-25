package com.users.validator.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.HashSet;
import java.util.Set;

public class EmailAddressValidator {


	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	private Matcher matcher;
	private static Set<String> uniqueUserEmail = new HashSet<String>();

	private static EmailAddressValidator instance = new EmailAddressValidator();

	private EmailAddressValidator() {

	}

	public static EmailAddressValidator getInstance() {
		return instance;
	}

	public boolean validate(final String email) {
		matcher = pattern.matcher(email);
		return matcher.matches();

//		boolean allowLocal = true;
//		boolean valid = EmailValidator.getInstance().isValid(email);
//		return allowLocal;
	}

	public boolean checkUniqueUserEmail(String email) {
		boolean duplicateCheck = uniqueUserEmail.add(email);

		return duplicateCheck;
	}
}
